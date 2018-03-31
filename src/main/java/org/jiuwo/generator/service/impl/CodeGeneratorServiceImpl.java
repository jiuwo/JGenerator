package org.jiuwo.generator.service.impl;

import java.util.List;
import java.util.Map;

import org.jiuwo.generator.dao.DataDao;
import org.jiuwo.generator.model.Config;
import org.jiuwo.generator.model.Field;
import org.jiuwo.generator.model.Table;
import org.jiuwo.generator.service.CodeGeneratorService;
import org.jiuwo.generator.util.FreeMakerUtil;
import org.jiuwo.generator.util.StringUtil;

/**
 * 代码生成业务
 *
 * @author junhan
 */
public class CodeGeneratorServiceImpl implements CodeGeneratorService {

    /**
     * 数据操作类
     */
    private DataDao dataDao = new DataDao();

    /**
     * FreeMakerUtil
     */
    private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();

    /**
     * DataServiceImpl
     */
    private static DataServiceImpl dataService = new DataServiceImpl();

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
    @Override
    public void generateFile(String templateName,
                                   Table table,
                                   List<Field> fieldList,
                                   String packagePath,
                                   String fileName,
                                   int level) {
        Map<String, Object> templateData = dataService.getDbTemplateData(table, fieldList);
        freeMakerUtil.generateFile(
                templateName,
                templateData,
                packagePath + fileName,
                level);
    }

    /**
     * 生成所有文件
     */
    @Override
    public void generatorAllTables() {
        List<Table> tables = dataDao.getAllTables(Config.DB_NAME);
        for (Table table : tables) {
            long startTime = System.currentTimeMillis();
            List<Field> fieldList = dataDao.getAllColums(Config.DB_NAME, table.getName());
            String tableName = StringUtil.toUpperCaseFirstOne(table.getProName());
            //生成文件
            generateFile(
                    "ModelTemplate.ftl",
                    table,
                    fieldList,
                    Config.PACKAGE_MODEL_PATH,
                    String.format("%s.java", tableName),
                    Config.PARENT_MODEL_LIVE);
            generateFile(
                    "DaoTemplate.ftl",
                    table,
                    fieldList,
                    Config.PACKAGE_DAO_PATH,
                    String.format("%sDao.java", tableName),
                    Config.PARENT_DAO_LIVE);
            generateFile(
                    "ServiceImplTemplate.ftl",
                    table,
                    fieldList,
                    Config.PACKAGE_SERVICE_IMPL_PATH,
                    String.format("%sServiceImpl.java", tableName),
                    Config.PARENT_SERVICE_IMPL_LIVE);
            generateFile(
                    "ServiceTemplate.ftl",
                    table,
                    fieldList,
                    Config.PACKAGE_SERVICE_PATH,
                    String.format("%sService.java", tableName),
                    Config.PARENT_SERVICE_LIVE);
            generateFile(
                    "MapperTemplate.ftl",
                    table,
                    fieldList,
                    Config.PACKAGE_MAPPER_PATH,
                    String.format("%sBaseMapper.xml", tableName),
                    Config.PARENT_MAPPER_LIVE);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("[%s]表生成完毕,用时[%d]ms", tableName, endTime - startTime));
        }
    }


}

