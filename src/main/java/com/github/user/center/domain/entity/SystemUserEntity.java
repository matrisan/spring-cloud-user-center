package com.github.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.user.center.domain.annotation.AggregateRoot;
import com.github.user.center.domain.common.SystemUserExtend;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
//@Audited
@ToString
@AggregateRoot
//@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@SecondaryTable(name = USER_EXTEND_INFO, pkJoinColumns = @PrimaryKeyJoinColumn(name = USER_ID), foreignKey = @ForeignKey(NO_CONSTRAINT))
public class SystemUserEntity extends BaseEntity {

    private static final long serialVersionUID = -8750984095480358268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    String username;

    @Column(table = USER_EXTEND_INFO, columnDefinition = "CHAR(20) COMMENT '手机号码'")
    String phone;

    @JsonIgnore
    String password;

//    @MapKey
//    @NotAudited
//    @OrderBy("roleId ASC")
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    @Where(clause = "expiredDate = NULL OR expiredDate <= CURRENT_DATE")
//    Map<SystemUserRoleEntity.UserRolePk, SystemUserRoleEntity> userRole;

    /**
     * 用户的其他信息
     */
    @Embedded
    SystemUserExtend userInfo;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "DATETIME COMMENT '账户没有过期'")
    LocalDateTime accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "DATETIME COMMENT '账户没有被锁定'")
    LocalDateTime accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "DATETIME COMMENT '凭证没有过期'")
    LocalDateTime credentialsNonExpired;

    @Column(name = "enabled", columnDefinition = "DATETIME COMMENT '账号用没用启用'")
    LocalDateTime enabled;

    public SystemUserEntity() {
    }

    public SystemUserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SystemUserEntity(String username, String phone, String password) {
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

    public boolean updatePassword(String password) {
        this.password = password;
        return true;
    }

    public boolean getAccountNonExpired() {
        return true;
    }

    public boolean getAccountNonLocked() {
        return true;
    }

    public boolean getCredentialsNonExpired() {
        return true;
    }

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
