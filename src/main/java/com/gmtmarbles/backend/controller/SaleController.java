package com.gmtmarbles.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmtmarbles.backend.entity.Sale;
import com.gmtmarbles.backend.service.SaleService;

@RestController
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/api/sales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @PostMapping("/api/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }
}