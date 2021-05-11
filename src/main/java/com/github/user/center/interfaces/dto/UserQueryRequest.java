package com.github.user.center.interfaces.dto;

import com.github.user.center.domain.entity.SystemUserEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/5/8 11:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserQueryRequest {

    String username;


    public Specification<SystemUserEntity> specification() {
        return (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(this.getUsername())) {
                Predicate predicateParent = builder.equal(root.get("username").as(Long.class), this.getUsername());
                list.add(predicateParent);
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        };
    }


}
