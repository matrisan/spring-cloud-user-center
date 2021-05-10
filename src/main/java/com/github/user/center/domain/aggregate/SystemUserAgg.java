package com.github.user.center.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.user.center.domain.annotation.AggregateRoot;
import com.github.user.center.domain.common.SystemUserExtend;
import com.github.user.center.domain.entity.SystemRoleEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.github.user.center.domain.common.IUserExtendInfo.USER_EXTEND_INFO;
import static com.github.user.center.domain.common.IUserExtendInfo.USER_ID;
import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

/**
 * 用户的聚合根
 * <p>
 * create in 2021/5/6 2:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Entity
@ToString
@AggregateRoot
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@SecondaryTable(name = USER_EXTEND_INFO, pkJoinColumns = @PrimaryKeyJoinColumn(name = USER_ID), foreignKey = @ForeignKey(NO_CONSTRAINT))
public class SystemUserAgg implements UserDetails {

    private static final long serialVersionUID = -8750984095480358268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    String username;

    @Column(table = USER_EXTEND_INFO, columnDefinition = "CHAR(20) COMMENT '手机号码'")
    String phone;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) COMMENT '密码'")
    String password;

    @MapKey
    @JsonManagedReference
    @ManyToMany(targetEntity = SystemRoleEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "mid_role_user",
            joinColumns = @JoinColumn(name = "mid_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mid_role_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(NO_CONSTRAINT)
    )
    Map<Long, SystemRoleEntity> roles;

    /**
     * 用户的其他信息
     */
    @Embedded
    SystemUserExtend userInfo;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "DATETIME COMMENT '账户没有过期'")
    Date accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "DATETIME COMMENT '账户没有被锁定'")
    Date accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "DATETIME COMMENT '凭证没有过期'")
    Date credentialsNonExpired;

    public SystemUserAgg(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SystemUserAgg(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public void addRoles(List<SystemRoleEntity> roles) {

    }

    public void replaceAllRoles(List<SystemRoleEntity> roles) {
    }

    public void deleteRoles(List<SystemRoleEntity> roles) {

    }

    @Override
    public Collection<SystemRoleEntity> getAuthorities() {
        return roles.values();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @DomainEvents
    List<Object> domainEvents() {
        return new ArrayList<>();
    }

    @AfterDomainEventPublication
    void callbackMethod() {
        log.info("AfterDomainEventPublication");
    }

}
