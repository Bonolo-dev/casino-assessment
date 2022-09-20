package com.rank.assessment.entity;

import com.rank.assessment.helper.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table( name = "TransactionsEntity")
public class TransactionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private BigInteger id;
    @Column(name = "transactionType")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "player_id", nullable = true)
    private PlayerEntity player;

    public TransactionsEntity() {
    }

    public TransactionsEntity(TransactionType transactionType, BigDecimal amount, PlayerEntity player) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.player = player;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PlayerEntity getPlayerId() {
        return player;
    }

    public void setPlayerId(PlayerEntity player) {
        this.player = player;
    }
}
