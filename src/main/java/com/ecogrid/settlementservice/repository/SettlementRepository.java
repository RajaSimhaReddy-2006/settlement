package com.ecogrid.settlementservice.repository;

import com.ecogrid.settlementservice.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    List<Settlement> findBySellerId(Long sellerId);
    List<Settlement> findByBuyerId(Long buyerId);
    List<Settlement> findByOrderId(Long orderId);
}
