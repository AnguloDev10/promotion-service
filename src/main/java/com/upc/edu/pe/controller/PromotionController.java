package com.upc.edu.pe.controller;

import com.upc.edu.pe.entity.Promotion;
import com.upc.edu.pe.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController

@RequestMapping("/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promotion> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Promotion> optionalIngredients = promotionService.findById(id);
            if (optionalIngredients.isPresent()) {
                return new ResponseEntity<Promotion>(optionalIngredients.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping
    public ResponseEntity<Promotion> save(@Valid @RequestBody Promotion ingredients, BindingResult result) {

        try {
            Promotion ingredientsCreate = promotionService.save(ingredients);
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredientsCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Promotion> update(@PathVariable("id") Long id, @RequestBody Promotion ingredients) {

        try {
            Optional<Promotion> optionalIngredients = promotionService.findById(id);
            if (optionalIngredients.isPresent()) {
                Promotion ingredientsCreate = promotionService.save(ingredients);
                return ResponseEntity.status(HttpStatus.CREATED).body(ingredientsCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Promotion> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<Promotion> optionalIngredients = promotionService.findById(id);
            if (optionalIngredients.isPresent()) {
                promotionService.deleteById(id);
                return new ResponseEntity<Promotion>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
