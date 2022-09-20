package com.rank.assessment.dto.resp;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PlayerUpdateResponseDto {
    private BigInteger transactionId;
    private BigDecimal balance;

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigInteger transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public PlayerUpdateResponseDto(BigInteger transactionId, BigDecimal balance) {
        this.transactionId = transactionId;
        this.balance = balance;
    }
}
