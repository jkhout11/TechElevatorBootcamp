package com.techelevator.auctions.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.model.Auction;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like,
                              @RequestParam(defaultValue = "0") double currentBid_lte) {

        if (!title_like.equals("")) {
            return auctionDao.getAuctionsByTitle(title_like);
        }
        if (currentBid_lte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        }

        return auctionDao.getAuctions();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = auctionDao.getAuctionById(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return auction;
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Auction create(@RequestBody @Valid Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@PathVariable int id, @RequestBody @Valid Auction auction) {
        Auction existingAuction = auctionDao.getAuctionById(id);
        if (existingAuction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        }

        auction.setId(id);
        return auctionDao.updateAuction(auction);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        int rowsAffected = auctionDao.deleteAuctionById(id);
        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        }
    }
}
