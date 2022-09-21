package com.rank.assessment.helper;

import com.rank.assessment.dto.req.PlayerUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

public class Validator {

    public static void verifyPlayer(Boolean isVerified){
        if(!isVerified){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    public static void validateUpdateTransaction(PlayerUpdateDto updates, BigDecimal playerBalance){
        if(updates.getAmount().compareTo(BigDecimal.ZERO) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(updates.getTransactionType().compareTo(TransactionType.WAGER) == 0){
            if(updates.getAmount().compareTo(playerBalance) > 0){
                throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
            }
        }
    }
}
