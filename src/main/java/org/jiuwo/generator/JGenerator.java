package org.jiuwo.generator;

import org.jiuwo.generator.service.CodeGeneratorService;
import org.jiuwo.generator.service.impl.CodeGeneratorServiceImpl;
import org.jiuwo.generator.util.PropUtil;

/**
 * 代码生成Main
 *
 * @author junhan
 */
public class JGenerator {

    /**
     * 代码处成主方未能
     *
     * @param args 数组
     */
    public static void main(String[] args) {
        PropUtil.loadConf(args);

        CodeGeneratorService cg = new CodeGeneratorServiceImpl();
        cg.generatorAllTables();

        System.out.println("****** OK ******");
    }
}
