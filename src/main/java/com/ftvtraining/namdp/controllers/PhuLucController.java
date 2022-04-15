package com.ftvtraining.namdp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.ftvtraining.namdp.models.PhuLuc;
import com.ftvtraining.namdp.payload.RecordsRequestPayload;
import com.ftvtraining.namdp.payload.ResponsePayload;
import com.ftvtraining.namdp.services.PhuLucService;

@RestController
@RequestMapping("/api/phuluc")
public class PhuLucController {

  @Autowired
  PhuLucService pLucService;

  @GetMapping
  public List<PhuLuc> getAllPhuluc(@RequestBody RecordsRequestPayload payload) {
    Pageable pageable = PageRequest.of(payload.getCurrentPage(), payload.getPerPage());
    return this.pLucService.getAllPL(payload, pageable);
  }

  @GetMapping("/{id}")
  public PhuLuc getPhuLuc(@PathVariable(name = "id") Long id) {
    return this.pLucService.getOnePL(id);
  }

  @PostMapping
  public ResponseEntity<ResponsePayload> createPhuLuc(@RequestBody PhuLuc phuLuc) {
    PhuLuc insertedPL = this.pLucService.insertPhuLuc(phuLuc);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponsePayload("Successfully created", true, insertedPL));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponsePayload> updatePhuLuc(@PathVariable(name = "id") Long id, @RequestBody PhuLuc phuLuc) {
    PhuLuc updatedPL = this.pLucService.updatePhuLuc(id, phuLuc);
    return ResponseEntity.ok().body(new ResponsePayload("Successfully created", true, updatedPL));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponsePayload> deletePhuluc(@PathVariable(name = "id") Long id) {
    this.pLucService.deletePhuLuc(id);
    return ResponseEntity.ok().body(new ResponsePayload("Successfully created", true, null));
  }
}