package com.techelevator;

/**
 * This class models an auction in which the seller has set a minimum sale price
 *  in advance (the 'reserve' price) and the final bid does not reach that price
 *  the item remains unsold.
 */
public class ReserveAuction extends Auction {

    // properties
    private int reservePrice;


    //constructors
    /**
     * @param itemForSale the description of the auction
     * @param reservePrice the minimum sale price
     */
    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    // Getters
    public int getReservePrice(){
        return reservePrice;
    }


    //This class overrides the default placeBid behavior of the parent class.
    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid); // invokes placeBid method on super class
        }
        return isCurrentWinningBid;
    }
}
