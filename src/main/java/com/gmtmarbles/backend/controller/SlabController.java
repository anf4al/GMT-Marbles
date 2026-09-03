package com.gmtmarbles.backend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
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
    @GetMapping("/api/slabs/status/{status}")
    public List<Slab> getSlabsByStatus(@PathVariable SlabStatus status) {
        return slabService.getSlabsByStatus(status);
    }
    @GetMapping("/api/slabs/material/{material}")
    public List<Slab> getSlabsByMaterial(@PathVariable String material) {
        return slabService.getSlabsByMaterial(material);
    }
    @GetMapping("/api/slabs/code/{slabCode}")
    public List<Slab> getSlabsBySlabCode(@PathVariable String slabCode) {
        return slabService.getSlabsBySlabCode(slabCode);
    }
    @GetMapping("/api/slabs/price")
    public List<Slab> getSlabsByPurchasePriceBetween(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return slabService.getSlabsByPurchasePriceBetween(min, max);
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
