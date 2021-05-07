package com.github.user.center.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 菜单实体
 * <p>
 * create in 2021/5/6 4:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Entity
@Setter(AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SystemMenuEntity implements ConfigAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "url", columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    String url;

    @Column(name = "method", columnDefinition = "VARCHAR(100) COMMENT '资源请求方式'")
    String method;

    @Column(nullable = false, columnDefinition = "INT(1) DEFAULT 0 COMMENT '菜单优先级'")
    Integer priority;

    @Column(name = "menu_code", nullable = false, columnDefinition = "VARCHAR(20) COMMENT '资源唯一名称'")
    String resourceCode;

    @Column(name = "menu_note", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '资源URL'")
    String resourceNote;

    String attribute;

    Long parentId;

    @Override
    public String getAttribute() {
        return attribute;
    }
}
