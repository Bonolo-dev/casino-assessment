package com.rank.assessment.repo;

import com.rank.assessment.entity.PlayerEntity;
import com.rank.assessment.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TransactionsRepo extends JpaRepository<TransactionsEntity, BigInteger> {
    List<TransactionsEntity> findFirst10ByPlayerOrderByIdDesc(PlayerEntity player);
}
