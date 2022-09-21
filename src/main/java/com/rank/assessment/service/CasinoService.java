package com.rank.assessment.service;

import com.rank.assessment.dto.req.PlayerUpdateDto;
import com.rank.assessment.dto.resp.LastDecaTransactionsDto;
import com.rank.assessment.dto.resp.PlayerBalanceDto;
import com.rank.assessment.dto.resp.PlayerUpdateResponseDto;
import com.rank.assessment.entity.PlayerEntity;
import com.rank.assessment.entity.TransactionsEntity;
import com.rank.assessment.helper.TransactionType;
import com.rank.assessment.helper.Validator;
import com.rank.assessment.repo.PlayerRepo;
import com.rank.assessment.repo.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
        Validator.verifyPlayer(playerEntity.isPresent());
        PlayerEntity player = playerEntity.get();
        return new PlayerBalanceDto(player.getId(),player.getBalance());
    }
    public PlayerUpdateResponseDto updatePlayerBalance(PlayerUpdateDto updates){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(updates.getPlayerId());
        Validator.verifyPlayer(playerEntity.isPresent());

        PlayerEntity player = playerEntity.get();
        Validator.validateUpdateTransaction(updates,player.getBalance());

        TransactionsEntity newTransaction = this.transactionsRepository.save(new TransactionsEntity(updates.getTransactionType(),updates.getAmount(),player));

        BigDecimal updateBalance = newTransaction.getTransactionType().equals(TransactionType.WIN)
                ? player.getBalance().add(newTransaction.getAmount())
                : player.getBalance().subtract(newTransaction.getAmount());

        player.setBalance(updateBalance);
        PlayerEntity updatedPlayer = this.playerRepository.save(player);
        return new PlayerUpdateResponseDto(newTransaction.getId(), updatedPlayer.getBalance());
    }

    public List<LastDecaTransactionsDto> getLastDecaTransactions(String username){
        Optional<PlayerEntity> playerEntity = playerRepository.findByUsernameIgnoreCase(username);
        Validator.verifyPlayer(playerEntity.isPresent());
        PlayerEntity player = playerEntity.get();
        List<LastDecaTransactionsDto> transactions = new ArrayList<>();
        List<TransactionsEntity> entityTransactions = transactionsRepository.findFirst10ByPlayerOrderByIdDesc(player);

        for(TransactionsEntity transaction : entityTransactions){
           transactions.add( new LastDecaTransactionsDto(transaction.getTransactionType(), transaction.getId(),transaction.getAmount()));
        }
        return transactions;
    }
}
