package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "") String title_like,
                              @RequestParam(required = false, defaultValue = "0.0") double currentBid_lte) {
        if (!title_like.isEmpty() && currentBid_lte > 0) {
            return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBid_lte);
        } else if (!title_like.isEmpty()) {
            return auctionDao.getAuctionsByTitle(title_like);
        } else if (currentBid_lte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        } else {
            return auctionDao.getAuctions();
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Auction create(@RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }
}