package com.github.user.center.domain.entity;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Setter(AccessLevel.PRIVATE)
public class SystemRoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public String getAuthority() {
        return null;
    }
}
