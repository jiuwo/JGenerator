package org.jiuwo.generator.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jiuwo.generator.model.Field;

/**
 * String扩展类
 *
 * @author junhan
 */
public class StringUtil {
    /**
     * 把数据库中的字段转换为变量类型
     * 如（user_id ---- userId）
     *
     * @param field 字段
     * @return 结果
     */
    public static String convertField(String field) {
        //分隔符
        char separator = '_';
        //转化为小写
        String variable = field.toLowerCase();

        if (variable.indexOf(separator) > -1) {
            char[] varArray = variable.toCharArray();
            for (int i = 0; i < varArray.length; i++) {
                if (varArray[i] == separator && i < varArray.length - 1) {
                    varArray[i + 1] = Character.toUpperCase(varArray[i + 1]);
                }
            }
            variable = new String(varArray).replaceAll("_", "");
        }

        return variable;

    }

    /**
     * 获取字符串型的类型名
     *
     * @param type 类型
     * @return String
     */
    public static String convertToJavaType(String type) {
        Map<String, String> map = getTypesJava();
        if (map.containsKey(type)) {
            return map.get(type);
        } else {
            return "String";
        }
    }

    /**
     * 取JavaTypes
     *
     * @return Map
     */
    private static Map<String, String> getTypesJava() {
        Map<String, String> map = new HashMap<String, String>(20);
        map.put("VARCHAR", "String");
        map.put("CHAR", "String");
        map.put("BLOB", "byte[]");
        map.put("TEXT", "String");
        map.put("INTEGER", "Integer");
        map.put("INT", "Integer");
        map.put("SMALLINT", "Short");
        map.put("MEDIUMINT", "Integer");
        map.put("BIT", "Boolean");
        map.put("BIGINT", "Long");
        map.put("FLOAT", "Float");
        map.put("DOUBLE", "Double");
        map.put("DECIMAL", "BigDecimal");
        map.put("BOOLEAN", "Integer");
        map.put("TINYINT", "Byte");
        map.put("DATE", "Date");
        map.put("TIME", "Time");
        map.put("DATETIME", "Date");
        map.put("TIMESTAMP", "Timestamp");
        map.put("YEAR", "Date");
        return map;
    }

    /**
     * 转换成JdbcType
     *
     * @param type 类型
     * @return String
     */
    public static String convertToJdbcType(String type) {
        Map<String, String> map = getTypesJdbc();
        if (map.containsKey(type)) {
            return map.get(type);
        } else {
            return "String";
        }
    }

    /**
     * 取JdbcTypes
     *
     * @return Map
     */
    private static Map<String, String> getTypesJdbc() {
        Map<String, String> map = new HashMap<String, String>(20);
        map.put("VARCHAR", "VARCHAR");
        map.put("CHAR", "CHAR");
        map.put("BLOB", "BINARY");
        map.put("TEXT", "LONGVARCHAR");
        map.put("INTEGER", "INTEGER");
        map.put("INT", "INTEGER");
        map.put("SMALLINT", "SMALLINT");
        map.put("MEDIUMINT", "INTEGER");
        map.put("BIT", "BIT");
        map.put("BIGINT", "BIGINT");
        map.put("FLOAT", "REAL");
        map.put("DOUBLE", "DOUBLE");
        map.put("DECIMAL", "DECIMAL");
        map.put("TINYINT", "TINYINT");
        map.put("DATE", "DATE");
        map.put("TIME", "TIME");
        map.put("DATETIME", "TIMESTAMP");
        map.put("TIMESTAMP", "TIMESTAMP");
        map.put("YEAR", "DATE");
        return map;
    }

    /**
     * 取表的主键
     *
     * @param fieldList 字段List
     * @return Field
     */
    public static Field getFieldPk(List<Field> fieldList) {
        Field field = new Field();
        for (Field item : fieldList) {
            if (item.getIsPk() == 1) {
                field = item;
                break;
            }
        }
        return field;
    }


    /**
     * 首字母转小写
     *
     * @param s 字符
     * @return 首字母小写的字符
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    //

    /**
     * 首字母转大写
     *
     * @param s 字符
     * @return 首字母大写的字符
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * String转换默认值
     *
     * @param value        原始值
     * @param defaultValue 默认值
     * @return 转换后的值
     */
    public static String toDefault(String value, String defaultValue) {
        return value == defaultValue ? "" : value;
    }

}
