package com.tintin.inventoryservice.controller;

import com.tintin.inventoryservice.dto.InventoryResponse;
import com.tintin.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13
    // http://localhost:8082/api/inventory/iphone-13,iphone13-red
    // http://localhost:8082/api/inventory?skuCode=iphone-13&sku-code=iphone13-red
//    @GetMapping("/{sku-code}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes) {
        return inventoryService.isInStock(skuCodes);
    }
}
