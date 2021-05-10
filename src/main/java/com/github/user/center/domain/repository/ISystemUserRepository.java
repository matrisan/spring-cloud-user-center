package com.github.user.center.domain.repository;

import com.github.user.center.domain.aggregate.SystemUserAgg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemUserRepository extends JpaRepository<SystemUserAgg, Long>, JpaSpecificationExecutor<SystemUserAgg> {

    Optional<SystemUserAgg> findByUsername(String username);


    Optional<SystemUserAgg> findByPhone(String mobile);

}
