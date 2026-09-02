package com.gmtmarbles.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gmtmarbles.backend.entity.Sale;
import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
import com.gmtmarbles.backend.repository.SaleRepository;
import com.gmtmarbles.backend.repository.SlabRepository;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SlabRepository slabRepository;

    public SaleService(
            SaleRepository saleRepository,
            SlabRepository slabRepository) {

        this.saleRepository = saleRepository;
        this.slabRepository = slabRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale createSale(Sale sale) {

        Slab slab = sale.getSlab();
        
        if (slab.getStatus() != SlabStatus.AVAILABLE) {
            throw new RuntimeException("Slab is not available for sale");
        }

        slab.setStatus(SlabStatus.SOLD);

        slabRepository.save(slab);

        return saleRepository.save(sale);
    }
}