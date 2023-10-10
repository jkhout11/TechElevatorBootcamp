package com.techelevator.auctions.services;

import com.techelevator.auctions.model.CredentialsDto;
import com.techelevator.auctions.model.TokenDto;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AuthenticationService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    public String login(String username, String password) {
        CredentialsDto credentialsDto = new CredentialsDto();
        credentialsDto.setUsername(username);
        credentialsDto.setPassword(password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CredentialsDto> entity = new HttpEntity<>(credentialsDto, headers);
        String token = null;
        try {
            ResponseEntity<TokenDto> response = restTemplate.postForEntity(API_BASE_URL + "login", entity, TokenDto.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                TokenDto tokenDto = response.getBody();
                if (tokenDto != null) {
                    token = tokenDto.getToken();
                }
            }
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return token;
    }

    private void handleException(RestClientResponseException e) {
        System.out.println("API Request Failed. Status Code: " + e.getRawStatusCode());
        System.out.println("Response Body: " + e.getResponseBodyAsString());
    }
}
