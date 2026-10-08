package com.ecogrid.settlementservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "settlements")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long sellerId;
    private Long buyerId;
    private double energyAmount;
    private double pricePerKw;
    private double totalAmount;
    private String transactionHash;

    @Enumerated(EnumType.STRING)
    private SettlementStatus status = SettlementStatus.PENDING;

    private LocalDateTime settledAt;

    public enum SettlementStatus { PENDING, CLEARED, FAILED }

    @PrePersist
    public void prePersist() {
        this.settledAt = LocalDateTime.now();
        this.totalAmount = this.energyAmount * this.pricePerKw;
        this.transactionHash = "TX-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 99999);
        this.status = SettlementStatus.CLEARED;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }
    public Long getBuyerId() { return buyerId; }
    public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }
    public double getEnergyAmount() { return energyAmount; }
    public void setEnergyAmount(double energyAmount) { this.energyAmount = energyAmount; }
    public double getPricePerKw() { return pricePerKw; }
    public void setPricePerKw(double pricePerKw) { this.pricePerKw = pricePerKw; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getTransactionHash() { return transactionHash; }
    public void setTransactionHash(String transactionHash) { this.transactionHash = transactionHash; }
    public SettlementStatus getStatus() { return status; }
    public void setStatus(SettlementStatus status) { this.status = status; }
    public LocalDateTime getSettledAt() { return settledAt; }
    public void setSettledAt(LocalDateTime settledAt) { this.settledAt = settledAt; }
}
