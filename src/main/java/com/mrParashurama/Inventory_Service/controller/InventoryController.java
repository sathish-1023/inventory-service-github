package com.mrParashurama.Inventory_Service.controller;

import com.mrParashurama.Inventory_Service.dto.InventoryResponse;
import com.mrParashurama.Inventory_Service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
            return inventoryService.isInStock(skuCode);
    }
}
