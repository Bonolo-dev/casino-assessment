package com.rank.assessment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rank.assessment.dto.req.PlayerUpdateDto;
import com.rank.assessment.dto.resp.LastDecaTransactionsDto;
import com.rank.assessment.dto.resp.PlayerBalanceDto;
import com.rank.assessment.dto.resp.PlayerUpdateResponseDto;
import com.rank.assessment.service.CasinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/casino")
public class CasinoController{

    private final CasinoService casinoService;
    @Autowired
    public CasinoController(CasinoService casinoService){this.casinoService = casinoService;}

    @RequestMapping(value = "/player/{playerid}/balance", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<?> getPlayerBalance(@PathVariable int playerid) {
        PlayerBalanceDto response = casinoService.getPlayerBalance(playerid);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = "/player/{playerid}/balance/update", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> updatePlayerBalance(@PathVariable int playerid, @RequestBody PlayerUpdateDto updates) {

        PlayerUpdateResponseDto response = casinoService.updatePlayerBalance(updates);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = "/admin/player/transaction", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> lastDecaTransactions(@RequestBody String username) {
        List<LastDecaTransactionsDto> transactions = casinoService.getLastDecaTransactions(username);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

}