package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
//        System.out.println("Starting a general auction");
//        System.out.println("-----------------");
//
//        Auction generalAuction = new Auction("Tech Elevator t-shirt");
//
//        generalAuction.placeBid(new Bid("Neo", 1));
//        generalAuction.placeBid(new Bid("Trinity", 23));
//        generalAuction.placeBid(new Bid("Morpheus", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids


        // Create a new buyout auction
//        System.out.println("Starting a buyout auction");
//        System.out.println("-----------------");
//
//        BuyoutAuction buyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug", 55);
//
//        buyoutAuction.placeBid(new Bid("Susan Storm", 20));
//        buyoutAuction.placeBid(new Bid("Ben Grimm", 56));
//        buyoutAuction.placeBid(new Bid("Reed Richards", 30));

        System.out.println();
        System.out.println("--------------");
        System.out.println("Reserve Auction");
        System.out.println();
        System.out.println();

        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Hat",80);

        reserveAuction.placeBid(new Bid("Bruce Wayne", 35));
        reserveAuction.placeBid(new Bid("Diana Prince", 55));
        reserveAuction.placeBid(new Bid("Billy Batson", 80));
        reserveAuction.placeBid(new Bid("Barbara Gordon", 60));
        reserveAuction.placeBid(new Bid("Selina Kyle", 85));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

    }



}
