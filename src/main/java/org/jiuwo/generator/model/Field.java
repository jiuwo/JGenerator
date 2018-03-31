package org.jiuwo.generator.model;

/**
 * 表字段实体
 *
 * @author junhan
 */
public class Field {
    /**
     * 字段名
     */
    private String name;
    /**
     * 程序用字段名
     */
    private String proName;
    /**
     * 数据类型
     */
    private String type;
    /**
     * 最大长度
     */
    private Long maxLength;
    /**
     * 是否可为NULL
     */
    private int isNullable;
    /**
     * 是否自增
     */
    private int isIdentity;
    /**
     * 字段描述
     */
    private String description;
    /**
     * 是否主键
     */
    private int isPk;
    /**
     * 对应JDBC类型
     */
    private String jdbcType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    public int getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(int isNullable) {
        this.isNullable = isNullable;
    }

    public int getIsIdentity() {
        return isIdentity;
    }

    public void setIsIdentity(int isIdentity) {
        this.isIdentity = isIdentity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public int getIsPk() {
        return isPk;
    }

    public void setIsPk(int isPk) {
        this.isPk = isPk;
    }
}
