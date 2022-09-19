package com.rank.assessment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rank.assessment.dto.req.PlayerUpdateDto;
import com.rank.assessment.dto.resp.LastDecaTransactionsDto;
import com.rank.assessment.dto.resp.PlayerUpdateResponseDto;
import com.rank.assessment.helper.TransactionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/casino")
public class CasinoController{

    @GetMapping("/test")
    public ResponseEntity<?> test(){

        //time conversion test
        long currentTimestamp = Instant.now().toEpochMilli();
        Date date = new Date(currentTimestamp );

        return ResponseEntity.status(HttpStatus.OK).body("Test Successful: " +  date.toString());
    }

    @RequestMapping(value = "/player/{playerid}/balance", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<?> getPlayerBalance(@PathVariable int playerid){
        return ResponseEntity.status(HttpStatus.OK).body("{ \"id\": " + playerid + ", \"balance\": \"R 402.39\" }");
    }

    @RequestMapping(value = "/player/{playerid}/balance/update", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> updatePlayerBalance(@PathVariable int playerid, @RequestBody PlayerUpdateDto updates) throws JsonProcessingException {

        PlayerUpdateResponseDto response = new PlayerUpdateResponseDto(new BigDecimal(1028), updates.getAmount());
        return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(response));
    }

    @RequestMapping(value = "/admin/player/transaction", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> lastDecaTransactions(@RequestBody String username) throws JsonProcessingException {

        List<LastDecaTransactionsDto> transactions = new ArrayList<>();
        transactions.add( new LastDecaTransactionsDto(TransactionType.WAGER, new BigInteger(String.valueOf(1011110)),new BigDecimal(20.012)));

        return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(transactions));
    }

}