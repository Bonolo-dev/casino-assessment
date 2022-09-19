package com.rank.assessment.service;

import com.rank.assessment.dto.req.PlayerUpdateDto;
import com.rank.assessment.dto.resp.LastDecaTransactionsDto;
import com.rank.assessment.dto.resp.PlayerBalanceDto;
import com.rank.assessment.dto.resp.PlayerUpdateResponseDto;
import com.rank.assessment.helper.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CasinoService {

    public PlayerBalanceDto getPlayerBalance(int playerId){
        return new PlayerBalanceDto(playerId,new BigDecimal(402.32));
    }
    public PlayerUpdateResponseDto updatePlayerBalance(PlayerUpdateDto updates){
        return new PlayerUpdateResponseDto(new BigDecimal(1028), updates.getAmount());
    }

    public List<LastDecaTransactionsDto> getLastDecaTransactions(String username){
        List<LastDecaTransactionsDto> transactions = new ArrayList<>();
        transactions.add( new LastDecaTransactionsDto(TransactionType.WAGER, new BigInteger(String.valueOf(1011110)),new BigDecimal("20.012")));
        transactions.add( new LastDecaTransactionsDto(TransactionType.WAGER, new BigInteger(String.valueOf(1011110)),new BigDecimal("20.012")));
        transactions.add( new LastDecaTransactionsDto(TransactionType.WAGER, new BigInteger(String.valueOf(1011110)),new BigDecimal("20.012")));
        return transactions;
    }
}
