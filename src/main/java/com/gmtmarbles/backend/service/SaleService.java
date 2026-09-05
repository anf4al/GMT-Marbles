package com.gmtmarbles.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gmtmarbles.backend.entity.Customer;
import com.gmtmarbles.backend.entity.Sale;
import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
import com.gmtmarbles.backend.repository.CustomerRepository;
import com.gmtmarbles.backend.repository.SaleRepository;
import com.gmtmarbles.backend.repository.SlabRepository;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final SlabRepository slabRepository;

    public SaleService(
            SaleRepository saleRepository,
            CustomerRepository customerRepository,
            SlabRepository slabRepository) {

        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.slabRepository = slabRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale createSale(Sale sale) {

        if (sale.getCustomer() == null || sale.getCustomer().getId() == null || 
            sale.getSlab() == null || sale.getSlab().getId() == null) {
            return null;
        }

        Long customerId = sale.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId).orElse(null);

        Long slabId = sale.getSlab().getId();
        Slab slab = slabRepository.findById(slabId).orElse(null);
        
        if (customer == null || slab == null) {
            return null;
        }
        
        if (slab.getStatus() != SlabStatus.AVAILABLE) {
            throw new RuntimeException("Slab is not available for sale");
        }

        sale.setCustomer(customer);
        sale.setSlab(slab);
        slab.setStatus(SlabStatus.SOLD);

        slabRepository.save(slab);

        return saleRepository.save(sale);
    }
}
