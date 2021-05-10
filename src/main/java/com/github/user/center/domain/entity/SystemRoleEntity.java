package com.github.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.user.center.domain.aggregate.SystemUserAgg;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * 角色实体
 * <p>
 * create in 2021/5/6 2:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Entity
@Setter(AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SystemRoleEntity implements GrantedAuthority {

    private static final long serialVersionUID = -3457042881449113477L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_name", nullable = false, columnDefinition = "CHAR(20) COMMENT '角色名称'")
    String roleName;

    @Column(name = "role_code", nullable = false, columnDefinition = "CHAR(20) DEFAULT '' COMMENT '角色编号'")
    String roleCode;

    @Column(name = "role_note", columnDefinition = "VARCHAR(50) COMMENT '角色备注'")
    String roleNote;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "roles")
    private List<SystemUserAgg> users;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}
