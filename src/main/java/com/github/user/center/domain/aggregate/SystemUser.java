package com.github.user.center.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.user.center.domain.annotation.AggregateRoot;
import com.github.user.center.domain.entity.SystemRoleEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Entity
@AggregateRoot
@Setter(AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SystemUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    String username;

    @Column(columnDefinition = "CHAR(20) COMMENT '手机号码'")
    String mobile;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) COMMENT '密码'")
    String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    String email;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "DATETIME COMMENT '账户没有过期'")
    Date accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "DATETIME COMMENT '账户没有被锁定'")
    Date accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "DATETIME COMMENT '凭证没有过期'")
    Date credentialsNonExpired;


    public void replaceAllRoles(List<SystemRoleEntity> roles) {

    }

    public void addRoles(List<SystemRoleEntity> roles) {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
