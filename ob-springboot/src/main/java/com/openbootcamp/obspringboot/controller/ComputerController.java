package com.openbootcamp.obspringboot.controller;

import com.openbootcamp.obspringboot.entity.ComputerEntity;
import com.openbootcamp.obspringboot.service.implement.ComputerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {

    private ComputerServiceImpl service;

    @Autowired
    public ComputerController(ComputerServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ComputerEntity> save(@Valid @RequestBody ComputerEntity entity) {
        ComputerEntity entitySaved = service.save(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(entitySaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerEntity> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ComputerEntity>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputerEntity> update(@PathVariable Long id, @RequestBody ComputerEntity entity) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
