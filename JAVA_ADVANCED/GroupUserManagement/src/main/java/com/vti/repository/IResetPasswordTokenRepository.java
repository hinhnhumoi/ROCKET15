package com.vti.repository;

import com.vti.entity.RegistrationUserToken;
import com.vti.entity.ResetPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IResetPasswordTokenRepository extends JpaRepository<RegistrationUserToken,Short> , JpaSpecificationExecutor<RegistrationUserToken> {

    public ResetPasswordToken findByToken (String token);

    public boolean existsByToken (String token);

    @Modifying
    @Transactional
    @Query("DELETE FROM ResetPasswordToken WHERE user.id = :userId")
    public void deleteByUserId(int userId);
}
