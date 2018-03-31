package org.jiuwo.generator.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jiuwo.generator.model.Field;
import org.jiuwo.generator.model.Table;
import org.jiuwo.generator.service.DataService;
import org.jiuwo.generator.util.FreeMakerUtil;
import org.jiuwo.generator.util.StringUtil;

/**
 * 数据业务
 *
 * @author junhan
 */
public class DataServiceImpl implements DataService {

    /**
     * 根据表名获取模板要用的Map型数据
     * (带有列信息)
     *
     * @param table     表名
     * @param fieldList 字段List
     * @return Map
     */
    @Override
    public Map<String, Object> getDbTemplateData(Table table, List<Field> fieldList) {
        Map<String, Object> templateData = new HashMap<String, Object>(8);
        templateData.put("tableName", table.getName());
        templateData.put("tableProName", table.getProName());
        templateData.put("tableDescription", table.getDescription());
        templateData.put("fieldList", fieldList);
        templateData.put("fieldPk", StringUtil.getFieldPk(fieldList));
        templateData.put("config", FreeMakerUtil.useStaticPackage("org.jiuwo.generator.model.Config"));
        return templateData;
    }

}
