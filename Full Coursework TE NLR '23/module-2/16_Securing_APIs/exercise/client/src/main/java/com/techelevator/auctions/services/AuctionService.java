package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:8080/auctions/";
    private RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            ResponseEntity<Auction[]> response =
                    restTemplate.exchange(API_BASE_URL, HttpMethod.GET, makeAuthEntity(), Auction[].class);
            auctions = response.getBody();
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            ResponseEntity<Auction> response =
                    restTemplate.exchange(API_BASE_URL + id, HttpMethod.GET, makeAuthEntity(), Auction.class);
            auction = response.getBody();
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            ResponseEntity<Auction[]> response =
                    restTemplate.exchange(API_BASE_URL + "?title_like=" + title, HttpMethod.GET,
                            makeAuthEntity(), Auction[].class);
            auctions = response.getBody();
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            ResponseEntity<Auction[]> response =
                    restTemplate.exchange(API_BASE_URL + "?currentBid_lte=" + price, HttpMethod.GET,
                            makeAuthEntity(), Auction[].class);
            auctions = response.getBody();
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return auctions;
    }

    public Auction add(Auction newAuction) {
        HttpEntity<Auction> entity = makeAuctionEntity(newAuction);
        Auction returnedAuction = null;
        try {
            returnedAuction = restTemplate.postForObject(API_BASE_URL, entity, Auction.class);
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return returnedAuction;
    }

    public boolean update(Auction updatedAuction) {
        HttpEntity<Auction> entity = makeAuctionEntity(updatedAuction);
        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + updatedAuction.getId(), entity);
            success = true;
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return success;
    }

    public boolean delete(int auctionId) {
        boolean success = false;
        try {
            restTemplate.exchange(API_BASE_URL + auctionId, HttpMethod.DELETE, makeAuthEntity(), Void.class);
            success = true;
        } catch (RestClientResponseException e) {
            handleException(e);
        }
        return success;
    }

    private HttpEntity<Auction> makeAuctionEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(auction, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

    private void handleException(RestClientResponseException e) {
        System.out.println("API Request Failed. Status Code: " + e.getRawStatusCode());
        System.out.println("Response Body: " + e.getResponseBodyAsString());
    }
}
