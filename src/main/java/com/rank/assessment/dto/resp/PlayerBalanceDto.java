package com.rank.assessment.dto.resp;

import java.math.BigDecimal;

public class PlayerBalanceDto {
    private int playerId;
    private BigDecimal balance;

    public PlayerBalanceDto(int playerId, BigDecimal balance) {
        this.playerId = playerId;
        this.balance = balance;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
