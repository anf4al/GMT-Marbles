package com.gmtmarbles.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.service.SlabService;

@RestController
public class SlabController {

    private final SlabService slabService;

    public SlabController(SlabService slabService) {
        this.slabService = slabService;
    }
    @GetMapping("/api/slabs")
    public List<Slab> getAllSlabs() {
        return slabService.getAllSlabs();
    }
    @PostMapping("/api/slabs")
    @ResponseStatus(HttpStatus.CREATED)
    public Slab createSlab(@RequestBody Slab slab) {
        return slabService.createSlab(slab);
    }
    @GetMapping("/api/slabs/{id}")
    public Slab getSlabById(@PathVariable Long id) {
        return slabService.getSlabById(id);
    }
    @PutMapping("/api/slabs/{id}")
    public Slab updateSlab(@PathVariable Long id, @RequestBody Slab slab) {
        return slabService.updateSlab(id, slab);
    }
    @DeleteMapping("/api/slabs/{id}")
    public void deleteSlab(@PathVariable Long id) {
        slabService.deleteSlab(id);
    }
}