package com.github.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/5/11 9:47 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
@Entity
@IdClass(SystemUserRoleEntity.UserRolePk.class)
public class SystemUserRoleEntity extends BaseEntity {

    private static final long serialVersionUID = -7423876517579685280L;

    @Id
    Long userId;

    @Id
    Long roleId;

    LocalDateTime expiredDate;

    @Data
    static class UserRolePk implements Serializable {

        private static final long serialVersionUID = -1948295789426690897L;

        @Column
        Long userId;

        @Column
        Long roleId;

        @ManyToOne()
        @JsonBackReference
        SystemUserEntity user;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemUserRoleEntity that = (SystemUserRoleEntity) o;
        return new EqualsBuilder().append(userId, that.userId).append(roleId, that.roleId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(userId).append(roleId).toHashCode();
    }
}
