package com.gmtmarbles.backend.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
import com.gmtmarbles.backend.repository.SlabRepository;

@Service
public class SlabService {

    private final SlabRepository slabRepository;

    public SlabService(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }
    public List<Slab> getAllSlabs() {
        return slabRepository.findAll();
    }
    public List<Slab> getSlabsByStatus(SlabStatus status) {
        return slabRepository.findByStatus(status);
    }
    public List<Slab> getSlabsByMaterial(String material) {
        return slabRepository.findByMaterial(material);
    }
    public List<Slab> getSlabsBySlabCode(String slabCode) {
        return slabRepository.findBySlabCode(slabCode);
    }
    public List<Slab> getSlabsByPurchasePriceBetween(BigDecimal min, BigDecimal max) {
        return slabRepository.findByPurchasePriceBetween(min, max);
    }
    public Slab createSlab(Slab slab) {
        return slabRepository.save(slab);
    }
    public Slab getSlabById(Long id) {
        return slabRepository.findById(id).orElse(null);
    }
    public Slab updateSlab(Long id, Slab updatedSlab) {
        Slab existingSlab = slabRepository.findById(id).orElse(null);

        if (existingSlab == null) {
            return null;
        }

        existingSlab.setSlabCode(updatedSlab.getSlabCode());
        existingSlab.setMaterial(updatedSlab.getMaterial());
        existingSlab.setLength(updatedSlab.getLength());
        existingSlab.setWidth(updatedSlab.getWidth());
        existingSlab.setThickness(updatedSlab.getThickness());
        existingSlab.setPurchasePrice(updatedSlab.getPurchasePrice());
        existingSlab.setStatus(updatedSlab.getStatus());

        return slabRepository.save(existingSlab);
    }
    public void deleteSlab(Long id) {
        slabRepository.deleteById(id);
    }
}
