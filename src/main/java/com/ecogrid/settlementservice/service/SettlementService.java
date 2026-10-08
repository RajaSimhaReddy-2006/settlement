package com.ecogrid.settlementservice.service;

import com.ecogrid.settlementservice.entity.Settlement;
import com.ecogrid.settlementservice.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SettlementService {

    @Autowired
    private SettlementRepository repository;

    @Transactional
    public Settlement create(Settlement settlement) {
        return repository.save(settlement);
    }

    public List<Settlement> getAll() { return repository.findAll(); }

    public Settlement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settlement not found"));
    }

    public List<Settlement> getBySeller(Long sellerId) {
        return repository.findBySellerId(sellerId);
    }

    public List<Settlement> getByBuyer(Long buyerId) {
        return repository.findByBuyerId(buyerId);
    }

    public List<Settlement> getByOrder(Long orderId) {
        return repository.findByOrderId(orderId);
    }

    @Transactional
    public Settlement clear(Long id) {
        Settlement s = getById(id);
        s.setStatus(Settlement.SettlementStatus.CLEARED);
        return repository.save(s);
    }
}
