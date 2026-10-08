package com.ecogrid.settlementservice.controller;

import com.ecogrid.settlementservice.entity.Settlement;
import com.ecogrid.settlementservice.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settlement")
@Tag(name = "Settlement", description = "Micro-ledger energy settlement")
public class SettlementController {

    @Autowired
    private SettlementService service;

    @PostMapping
    @Operation(summary = "Create a new settlement")
    public ResponseEntity<Settlement> create(@RequestBody Settlement settlement) {
        return ResponseEntity.ok(service.create(settlement));
    }

    @GetMapping
    @Operation(summary = "Get all settlements")
    public ResponseEntity<List<Settlement>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get settlement by ID")
    public ResponseEntity<Settlement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/seller/{sellerId}")
    @Operation(summary = "Get settlements by seller")
    public ResponseEntity<List<Settlement>> getBySeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(service.getBySeller(sellerId));
    }

    @GetMapping("/buyer/{buyerId}")
    @Operation(summary = "Get settlements by buyer")
    public ResponseEntity<List<Settlement>> getByBuyer(@PathVariable Long buyerId) {
        return ResponseEntity.ok(service.getByBuyer(buyerId));
    }

    @GetMapping("/order/{orderId}")
    @Operation(summary = "Get settlements by order")
    public ResponseEntity<List<Settlement>> getByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getByOrder(orderId));
    }

    @PutMapping("/{id}/clear")
    @Operation(summary = "Manually clear a settlement")
    public ResponseEntity<Settlement> clear(@PathVariable Long id) {
        return ResponseEntity.ok(service.clear(id));
    }
}
