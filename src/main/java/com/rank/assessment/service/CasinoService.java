package com.rank.assessment.service;

import com.rank.assessment.dto.req.PlayerUpdateDto;
import com.rank.assessment.dto.resp.LastDecaTransactionsDto;
import com.rank.assessment.dto.resp.PlayerBalanceDto;
import com.rank.assessment.dto.resp.PlayerUpdateResponseDto;
import com.rank.assessment.entity.PlayerEntity;
import com.rank.assessment.entity.TransactionsEntity;
import com.rank.assessment.repo.PlayerRepo;
import com.rank.assessment.repo.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CasinoService {

    private PlayerRepo playerRepository;
    private TransactionsRepo transactionsRepository;
    @Autowired
    public CasinoService(PlayerRepo playerRepository, TransactionsRepo transactionsRepository){
        this.playerRepository = playerRepository;
        this.transactionsRepository = transactionsRepository;
    }
    public PlayerBalanceDto getPlayerBalance(int playerId){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(playerId);
        if(!playerEntity.isPresent()){
            throw new RuntimeException("Player data not found");
        }
        PlayerEntity player = playerEntity.get();
        return new PlayerBalanceDto(player.getId(),player.getBalance());
    }
    public PlayerUpdateResponseDto updatePlayerBalance(PlayerUpdateDto updates){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(updates.getPlayerId());
        if(!playerEntity.isPresent()){
            throw new RuntimeException("Player data not found");
        }
        PlayerEntity player = playerEntity.get();

        TransactionsEntity newTransaction = this.transactionsRepository.save(new TransactionsEntity(updates.getTransactionType(),updates.getAmount(),player));
        BigDecimal updateBalance = player.getBalance().add(updates.getAmount());
        player.setBalance(updateBalance);
        PlayerEntity updatedPlayer = this.playerRepository.save(player);
        return new PlayerUpdateResponseDto(newTransaction.getId(), updatedPlayer.getBalance());
    }

    public List<LastDecaTransactionsDto> getLastDecaTransactions(String username){
        Optional<PlayerEntity> playerEntity = playerRepository.findByUsernameIgnoreCase(username);
        if(!playerEntity.isPresent()){
            throw new RuntimeException( username + "'s data not found");
        }
        PlayerEntity player = playerEntity.get();
        List<LastDecaTransactionsDto> transactions = new ArrayList<>();
        List<TransactionsEntity> entityTransactions = transactionsRepository.findFirst10ByPlayerOrderByIdDesc(player);

        for(TransactionsEntity transaction : entityTransactions){
           transactions.add( new LastDecaTransactionsDto(transaction.getTransactionType(), transaction.getId(),transaction.getAmount()));
        }
        return transactions;
    }
}
