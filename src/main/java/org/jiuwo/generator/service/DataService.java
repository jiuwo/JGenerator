package org.jiuwo.generator.service;

import java.util.List;
import java.util.Map;

import org.jiuwo.generator.model.Field;
import org.jiuwo.generator.model.Table;


/**
 * 数据业务
 *
 * @author junhan
 */
public interface DataService {

    /**
     * 根据表名获取模板要用的Map型数据
     * (带有列信息)
     *
     * @param table     表名
     * @param fieldList 字段List
     * @return Map
     */
    Map<String, Object> getDbTemplateData(Table table, List<Field> fieldList);
}

