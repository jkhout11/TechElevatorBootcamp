package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private final CatCardDao catCardDao;
    private final CatFactService catFactService;
    private final CatPicService catPicService;

    @Autowired
    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @GetMapping
    public List<CatCard> getAllCatCards() {
        return catCardDao.getCatCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatCard> getCatCardById(@PathVariable int id) {
        CatCard catCard = catCardDao.getCatCardById(id);
        if (catCard != null) {
            return ResponseEntity.ok(catCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CatCard> createCatCard(@RequestBody CatCard catCard) {
        CatCard createdCatCard = catCardDao.createCatCard(catCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCatCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatCard> updateCatCard(@PathVariable int id, @RequestBody CatCard catCard) {
        CatCard existingCatCard = catCardDao.getCatCardById(id);
        if (existingCatCard != null) {
            catCard.setCatCardId(id);
            CatCard updatedCatCard = catCardDao.updateCatCard(catCard);
            return ResponseEntity.ok(updatedCatCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatCard(@PathVariable int id) {
        int rowsAffected = catCardDao.deleteCatCardById(id);
        if (rowsAffected > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/random")
    public CatCard getRandomCatCard() {
        CatCard catCard = new CatCard();
        catCard.setCatFact(catFactService.getFact().getText());
        catCard.setImgUrl(catPicService.getPic().getFile());
        return catCard;
    }
}
s