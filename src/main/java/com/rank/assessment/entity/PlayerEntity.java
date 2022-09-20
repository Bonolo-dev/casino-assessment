package com.rank.assessment.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table( name = "PlayerEntity")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private BigDecimal balance;

    @OneToMany
    private Set<TransactionsEntity> playerTransactionsSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<TransactionsEntity> getPlayerTransactionsSet() {
        return playerTransactionsSet;
    }

    public void setPlayerTransactionsSet(Set<TransactionsEntity> playerTransactionsSet) {
        this.playerTransactionsSet = playerTransactionsSet;
    }
}
