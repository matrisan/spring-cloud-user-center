package com.github.user.center.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
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

    private static final long serialVersionUID = -7068753554204834403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    String url;

    @Column(columnDefinition = "CHAR(10) COMMENT '资源请求方式'")
    HttpMethod method;

    @Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0 COMMENT '菜单优先级'")
    Integer priority;

    @Column(name = "menu_code", nullable = false, columnDefinition = "CHAR(20) COMMENT '资源唯一名称'")
    String menuCode;

    @Column(name = "menu_note", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '资源URL'")
    String menuNote;

    @Column(name = "parent_id")
    Long parentId;

    @Override
    public String getAttribute() {
        return url;
    }
}
