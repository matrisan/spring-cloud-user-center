package com.github.user.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/5/10 8:53 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2191753221757519036L;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '备注'")
    private String note;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '是否为预置'")
    private Boolean preset;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 1 COMMENT '是否启用'")
    private Boolean enabled;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '改记录是否删除'")
    private Boolean deleted;

    @JsonIgnore
    @Version
    @Column(columnDefinition = "BIGINT DEFAULT 0 COMMENT '改记录是否删除'")
    private Long version;

    @CreatedDate
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

}
