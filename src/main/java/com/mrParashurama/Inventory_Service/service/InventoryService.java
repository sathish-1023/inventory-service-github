package com.mrParashurama.Inventory_Service.service;

import com.mrParashurama.Inventory_Service.dto.InventoryResponse;
import com.mrParashurama.Inventory_Service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        log.info("wait started");

        log.info("wait Ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map((inventory)->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).collect(Collectors.toList());


    }
}
