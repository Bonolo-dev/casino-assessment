package com.rank.assessment.dto.resp;

import java.math.BigDecimal;

public class PlayerUpdateResponseDto {
    private BigDecimal transactionId;
    private BigDecimal balance;

    public BigDecimal getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public PlayerUpdateResponseDto(BigDecimal transactionId, BigDecimal balance) {
        this.transactionId = transactionId;
        this.balance = balance;
    }
}
