package com.upc.edu.pe.controller;

import com.upc.edu.pe.entity.Disccount;
import com.upc.edu.pe.service.DisccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/disccount")
public class DisccountController {

    @Autowired
    private DisccountService disccountService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disccount> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Disccount> optionalDisccount = disccountService.findById(id);
            if (optionalDisccount.isPresent()) {
                return new ResponseEntity<Disccount>(optionalDisccount.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Disccount> save(@Valid @RequestBody Disccount menu, BindingResult result) {

        try {
            Disccount menuCreate = disccountService.save(menu);
            return ResponseEntity.status(HttpStatus.CREATED).body(menuCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disccount> update(@PathVariable("id") Long id, @RequestBody Disccount menu) {

        try {
            Optional<Disccount> optionalMenu = disccountService.findById(id);
            if (optionalMenu.isPresent()) {
                Disccount menuCreate = disccountService.save(menu);
                return ResponseEntity.status(HttpStatus.CREATED).body(menuCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Disccount> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<Disccount> optionalMenu = disccountService.findById(id);
            if (optionalMenu.isPresent()) {
                disccountService.deleteById(id);
                return new ResponseEntity<Disccount>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
