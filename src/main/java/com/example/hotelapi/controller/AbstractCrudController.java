package com.example.hotelapi.controller;

import com.example.hotelapi.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudController<TDTO, TFORM, TUFORM, TID> {

    protected final BaseService<TDTO, TFORM, TUFORM, TID> service;

    protected AbstractCrudController(BaseService<TDTO, TFORM, TUFORM, TID> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TDTO> getOne(@PathVariable TID id){
        return ResponseEntity.ok( service.getOne(id) );
    }

    @GetMapping
    public ResponseEntity<List<TDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
    }

    @PostMapping
    public ResponseEntity<TDTO> insert(@Valid @RequestBody TFORM form){
        return ResponseEntity.ok( service.insert(form) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TDTO> delete(@PathVariable TID id){
        return ResponseEntity.ok( service.delete(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TDTO> update(@PathVariable TID id, @Valid @RequestBody TUFORM tform){
        return ResponseEntity.ok( service.update(id, tform) );
    }
}
