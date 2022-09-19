package com.rank.assessment.dto.req;

import com.rank.assessment.helper.TransactionType;

import java.math.BigDecimal;

public class PlayerUpdateDto {

    private int playerId;
    private BigDecimal amount;
    private TransactionType transactionType;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
