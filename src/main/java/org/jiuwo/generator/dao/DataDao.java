package org.jiuwo.generator.dao;

import java.util.ArrayList;
import java.util.List;

import org.jiuwo.generator.model.Field;
import org.jiuwo.generator.model.Table;
import org.jiuwo.generator.util.JdbcUtil;
import org.jiuwo.generator.util.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 数据操作
 *
 * @author junhan
 */
public class DataDao {
    private JdbcTemplate jdbcTemplate;

    public DataDao() {
        jdbcTemplate = JdbcUtil.getJdbcTemplate();
    }

    String tableSql = "SELECT \n" +
            "\t              TABLE_NAME as name,\n" +
            "\t              TABLE_COMMENT as description \n" +
            "          FROM \n" +
            "\t              information_schema.TABLES \n" +
            "          WHERE \n" +
            "\t              TABLE_SCHEMA='%s'";

    String fildSql = "SELECT \n" +
            "\t             c.COLUMN_NAME as name,\n" +
            "\t             c.DATA_TYPE as type,\n" +
            "\t             IFNULL(c.CHARACTER_MAXIMUM_LENGTH,0) as maxLength,\n" +
            "\t             (CASE c.IS_NULLABLE WHEN 'NO' THEN 0 ELSE 1 END) as isNullable,\n" +
            "\t             (CASE WHEN t.AUTO_INCREMENT>0 AND k.COLUMN_NAME IS NOT NULL AND c.EXTRA='auto_increment' THEN 1 ELSE 0 END) as isIdentity,\n" +
            "\t             c.COLUMN_COMMENT as description,\n" +
            "\t             (CASE c.COLUMN_KEY WHEN 'PRI' THEN 1 ELSE 0 END) as isPk\n" +
            "          FROM \n" +
            "\t             information_schema.COLUMNS AS c\n" +
            "\t             INNER JOIN information_schema.`TABLES` AS t ON t.TABLE_SCHEMA=c.TABLE_SCHEMA AND t.TABLE_NAME=c.TABLE_NAME\n" +
            "\t             LEFT JOIN information_schema.KEY_COLUMN_USAGE k ON k.COLUMN_NAME=c.COLUMN_NAME AND c.TABLE_NAME=k.TABLE_NAME AND c.TABLE_SCHEMA=k.TABLE_SCHEMA\n" +
            "          WHERE \n" +
            "\t             c.TABLE_SCHEMA='%s'" +
            "\t             AND c.TABLE_NAME='%s'" +
            "          ORDER BY\n" +
            "\t             c.ORDINAL_POSITION ASC";

    /**
     * 根据表名获取所有的列信息
     *
     * @param tableSchema 库名
     * @param tableName   表名
     * @return 字段List
     */
    public List<Field> getAllColums(String tableSchema, String tableName) {
        try {
            String sql = String.format(fildSql, tableSchema, tableName);
            List<Field> fieldList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Field.class));
            fieldList.forEach(field -> {
                field.setProName(StringUtil.convertField(field.getName()));
                String fieldType = field.getType();
                String javaType = StringUtil.convertToJavaType(fieldType);
                field.setType(javaType);
                field.setJdbcType(StringUtil.convertToJdbcType(fieldType));
                field.setDescription(StringUtil.toDefault(field.getDescription(), ""));
            });
            return fieldList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Field>();
    }

    /**
     * 根据库名取所有表
     *
     * @param tableSchema 库名
     * @return 表List
     */
    public List<Table> getAllTables(final String tableSchema) {
        try {
            String sql = String.format(tableSql, tableSchema);
            List<Table> tableList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Table.class));
            tableList.forEach(table -> {
                table.setProName(StringUtil.convertField(table.getName()));
                table.setDescription(StringUtil.toDefault(table.getDescription(), ""));
            });
            return tableList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Table>();
    }
}
