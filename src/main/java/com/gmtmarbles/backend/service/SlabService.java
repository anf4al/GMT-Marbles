package com.gmtmarbles.backend.service;

import org.springframework.stereotype.Service;

import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.repository.SlabRepository;

import java.util.List;

@Service
public class SlabService {

    private final SlabRepository slabRepository;

    public SlabService(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }
    public List<Slab> getAllSlabs() {
        return slabRepository.findAll();
    }
}