package com.github.user.center.domain.repository;

import com.github.user.center.domain.entity.SystemRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemRoleRepository extends JpaRepository<SystemRoleEntity, Long>, JpaSpecificationExecutor<SystemRoleEntity> {

}
