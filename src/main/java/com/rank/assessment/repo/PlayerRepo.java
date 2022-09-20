package com.rank.assessment.repo;

import com.rank.assessment.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface PlayerRepo extends JpaRepository<PlayerEntity,Integer> {
    Optional<PlayerEntity> findByUsernameIgnoreCase(String username);

    @Query("SELECT u FROM PlayerEntity u WHERE u.username = ?1")
    PlayerEntity findByUsernameCustom(String username);
}
