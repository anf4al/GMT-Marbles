package com.gmtmarbles.backend.controller;

import com.gmtmarbles.backend.service.SlabService;
import org.springframework.web.bind.annotation.RestController;

import com.gmtmarbles.backend.entity.Slab;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

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
}