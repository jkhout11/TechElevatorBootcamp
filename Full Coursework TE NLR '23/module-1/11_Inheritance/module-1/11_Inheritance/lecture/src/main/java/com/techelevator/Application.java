package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Neo", 1));
        generalAuction.placeBid(new Bid("Trinity", 23));
        generalAuction.placeBid(new Bid("Morpheus", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

    }
}
