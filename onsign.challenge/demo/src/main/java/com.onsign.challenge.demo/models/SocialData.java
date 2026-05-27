package com.onsign.challenge.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialData {

    private List<User> users;

    private List<List<Long>> friends;

    private Map<String, Set<Long>> interests;
    
}
