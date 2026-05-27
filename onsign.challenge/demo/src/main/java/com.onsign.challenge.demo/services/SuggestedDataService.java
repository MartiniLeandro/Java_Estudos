package com.onsign.challenge.demo.services;

import com.onsign.challenge.demo.models.DTOS.UserSuggestedResponseDTO;
import com.onsign.challenge.demo.models.SocialData;
import com.onsign.challenge.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SuggestedDataService {

    private final ApiClientService apiClientService;

    public SuggestedDataService(ApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    //-----------------------------------------SUGGESTED_FRIENDS---------------------------------------

    public Set<String> getSuggestedFriends(SocialData data, Long userId){

        Set<Long> directFriends = findDirectFriends(data,userId);

        Set<Long> suggestedFriendsIds = findSuggestedFriends(data,directFriends,userId);

        return findUserNamesByIds(data, suggestedFriendsIds);
    }

    public Set<Long> findDirectFriends(SocialData socialData, Long userId) {

        Set<Long> directedFriends = new HashSet<>();
            for (List<Long> friends : socialData.getFriends()) {
                Long firstUser = friends.get(0);
                Long secondUser = friends.get(1);

                if (firstUser.equals(userId)) {
                    directedFriends.add(secondUser);
                }

                if (secondUser.equals(userId)) {
                    directedFriends.add(firstUser);
                }
            }
            return directedFriends;
    }

    public Set<Long> findSuggestedFriends(SocialData socialData, Set<Long> directFriends, Long userId) {

        Set<Long> result = new HashSet<>();

        for(Long friendId : directFriends) {
            for(List<Long> friendship : socialData.getFriends()) {

                Long firstUser = friendship.get(0);
                Long secondUser = friendship.get(1);

                if (firstUser.equals(friendId)) {
                    Long candidate = secondUser;
                    addIfValid(result, userId, directFriends, candidate);
                }

                if (secondUser.equals(friendId)) {
                    Long candidate = firstUser;
                    addIfValid(result, userId, directFriends, candidate);
                }
            }
        }
        return result;
    }

    public void addIfValid(Set<Long> result, Long userId, Set<Long> directFriends, Long candidate) {
        if(!candidate.equals(userId) && !directFriends.contains(candidate)) {
            result.add(candidate);
        }
    }

    public Set<String> findUserNamesByIds(SocialData data, Set<Long> ids){
        Set<String> result = new TreeSet<>();
        for(User user : data.getUsers()){
            if(ids.contains(user.getId())){
                result.add(user.getName());
            }
        }
        return result;
    }

    //-----------------------------------------SUGGESTED_INTERESTS---------------------------------------

    public Set<String> getSuggestedInterests(SocialData data, Long userId) {

        Set<String> result = new HashSet<>();

        Set<Long> directFriends = findDirectFriends(data, userId);

        Set<String> interestsFriends = findInterestsByFriends(data, directFriends);

        Set<String> interestsUser = findInterestsByUser(data,userId);

        Set<String> suggestedInterests = findSuggestedInterests(interestsFriends, interestsUser);

        result.addAll(suggestedInterests);

        return result;

    }

    public Set<String> findInterestsByFriends(SocialData data, Set<Long> directFriends) {
        Set<String> result = new HashSet<>();
        for(Long friendId : directFriends){
            Set<String> interests = findInterestsByUser(data, friendId);
            result.addAll(interests);
        }
        return result;
    }

    public Set<String> findInterestsByUser(SocialData data, Long userId) {
        Set<String> result = new HashSet<>();
        for(Map.Entry<String, Set<Long>> entry : data.getInterests().entrySet()){

            String interestName = entry.getKey();

            Set<Long> users = entry.getValue();

            if(users.contains(userId)){
                result.add(interestName);
            }
        }
        return result;
    }

    public Set<String> findSuggestedInterests(Set<String> interestsFriends, Set<String> interests) {
        Set<String> result = new TreeSet<>(interestsFriends);
        result.removeAll(interests);
        return result;
    }

    //-----------------------------------------GET_USER_SUGGESTIONS---------------------------------------

    public List<UserSuggestedResponseDTO> getUserSuggestions(){
        SocialData data = apiClientService.getSocialData();

        List<UserSuggestedResponseDTO> result = new ArrayList<>();
        for(User user : data.getUsers()){
            Set<String> suggestedFriends = getSuggestedFriends(data, user.getId());
            Set<String> suggestedInterests = getSuggestedInterests(data, user.getId());
            UserSuggestedResponseDTO userSuggestedResponseDTO = new UserSuggestedResponseDTO(user.getId(), user.getName(), suggestedFriends, suggestedInterests);
            result.add(userSuggestedResponseDTO);
        }
        result.sort(Comparator.comparing(UserSuggestedResponseDTO::name));

        return result;
    }
}


