package org.jboot.generator.conditions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

/**
 * 查询条件
 * 
 * @author liwen
 */
@Data
public class Wrapper<T> {

    private final static Logger logger = LoggerFactory.getLogger(Wrapper.class);

    /**
     * 排序字段
     */
    private List<Sort> sorts;

    /**
     * 查询条件
     */
    private List<Condition> conditions;

    public Wrapper() {
        logger.info("你进入了自定义构建实体查询。");
    }

}
