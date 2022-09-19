package com.rank.assessment.dto.resp;

import com.rank.assessment.helper.TransactionType;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LastDecaTransactionsDto {
    private TransactionType transactionType;
    private BigInteger transactionId;
    private BigDecimal amount;

    public LastDecaTransactionsDto(TransactionType transactionType, BigInteger transactionId, BigDecimal amount) {
        this.transactionType = transactionType;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigInteger transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
