package org.jiuwo.generator.service;

import java.util.List;

import org.jiuwo.generator.model.Field;
import org.jiuwo.generator.model.Table;


/**
 * 代码生成业务
 *
 * @author junhan
 */
public interface CodeGeneratorService {

    /**
     * 生成文件方法
     *
     * @param templateName 模板名
     * @param table        表名
     * @param fieldList    字段List
     * @param packagePath  包路径
     * @param fileName     文件名
     * @param level        级别
     */
    void generateFile(String templateName,
                      Table table,
                      List<Field> fieldList,
                      String packagePath,
                      String fileName,
                      int level);

    /**
     * 生成所有文件
     */
    void generatorAllTables();
}
