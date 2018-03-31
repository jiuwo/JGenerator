package org.jiuwo.generator.model;

/**
 * 表实体
 *
 * @author junhan
 */
public class Table {
    /**
     * 表名
     */
    private String name;
    /**
     * 程序用表名
     */
    private String proName;
    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
