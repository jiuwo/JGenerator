package org.jiuwo.generator.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.mysql.cj.core.exceptions.ClosedOnExpiredPasswordException;
import org.jiuwo.generator.model.Config;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 配置类
 *
 * @author junhan
 */
public class PropUtil {

    /**
     * 加载配置
     *
     * @param args 数组
     */
    public static void loadConf(String[] args) {
        if (args == null || args.length == 0) {
            Config.CONFIG_IS_LOCAL = true;
            PropUtil.loadConf(Config.CONFIG_LOCAL_PATH);
            System.out.println(String.format("加载默认配置完成：数据库[%s]", Config.DB_NAME));
        } else {
            Config.CONFIG_IS_LOCAL = false;
            Config.CONFIG_PATH = args[0];
            PropUtil.loadConf(Config.CONFIG_PATH);
            System.out.println(String.format("加载自定义配置完成：数据库[%s]", Config.DB_NAME));
        }
    }

    /**
     * 加载配置并赋值实体
     *
     * @param path 路径
     */
    public static void loadConf(String path) {
        try {
            Properties props = new Properties();
            InputStream in;
            if (Config.CONFIG_IS_LOCAL) {
                in = PropUtil.class.getClassLoader().getResourceAsStream(path);
            } else {
                in = new FileInputStream(path);
            }
            props.load(in);
            Config.DB_URL = props.getProperty("db.url");
            Config.DB_USER = props.getProperty("db.user");
            Config.DB_PASSWORD = props.getProperty("db.password");
            Config.DB_NAME = props.getProperty("db.name");
            Config.PACKAGE_ROOT_NAME = props.getProperty("package.root.name");
            Config.PACKAGE_ROOT_PATH = props.getProperty("package.root.path");
            Config.PACKAGE_MODEL_NAME = props.getProperty("package.model.name");
            Config.PACKAGE_MODEL_PATH = props.getProperty("package.model.path");
            Config.PACKAGE_DAO_NAME = props.getProperty("package.dao.name");
            Config.PACKAGE_DAO_PATH = props.getProperty("package.dao.path");
            Config.PACKAGE_SERVICE_IMPL_NAME = props.getProperty("package.service.impl.name");
            Config.PACKAGE_SERVICE_IMPL_PATH = props.getProperty("package.service.impl.path");
            Config.PACKAGE_SERVICE_NAME = props.getProperty("package.service.name");
            Config.PACKAGE_SERVICE_PATH = props.getProperty("package.service.path");
            Config.PACKAGE_MAPPER_PATH = props.getProperty("package.mapper.path");
            Config.TRIM_STRINGS = Boolean.parseBoolean(props.getProperty("trim.strings"));
            Config.PARENT_MODEL_LIVE = Integer.parseInt(props.getProperty("package.model.level"));
            Config.PARENT_DAO_LIVE = Integer.parseInt(props.getProperty("package.dao.level"));
            Config.PARENT_SERVICE_LIVE = Integer.parseInt(props.getProperty("package.service.level"));
            Config.PARENT_MAPPER_LIVE = Integer.parseInt(props.getProperty("package.mapper.level"));
            Config.GENERATOR_ROOT = props.getProperty("generator.root");
            Config.DB_NAME = props.getProperty("db.name");
            Config.PACKAGE_DB_NAME = props.getProperty("package.db.name");
            Config.PARENT_SERVICE_IMPL_LIVE = Integer.parseInt(props.getProperty("package.service.impl.level"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
