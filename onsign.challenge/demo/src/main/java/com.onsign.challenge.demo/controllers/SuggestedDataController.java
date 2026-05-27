package com.onsign.challenge.demo.controllers;

import com.onsign.challenge.demo.models.DTOS.UserSuggestedResponseDTO;
import com.onsign.challenge.demo.services.ApiClientService;
import com.onsign.challenge.demo.services.SuggestedDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class SuggestedDataController {

    public final ApiClientService apiClientService;
    public final SuggestedDataService suggestedDataService;

    public SuggestedDataController(ApiClientService apiClientService, SuggestedDataService suggestedDataService) {
        this.apiClientService = apiClientService;
        this.suggestedDataService = suggestedDataService;
    }

    @GetMapping("/datas")
    public ResponseEntity<List<UserSuggestedResponseDTO>> getUsersSuggestedDatas(){
        return ResponseEntity.ok().body(suggestedDataService.getUserSuggestions());
    }

}
