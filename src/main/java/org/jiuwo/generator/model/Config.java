package org.jiuwo.generator.model;

/**
 * 配置
 *
 * @author junhan
 */
public class Config {

    /**
     * 数据库连接串
     */
    public static String DB_URL = "";

    /**
     * 数据库用户
     */
    public static String DB_USER = "";

    /**
     * 数据库密码
     */
    public static String DB_PASSWORD = "";

    /**
     * 数据库名
     */
    public static String DB_NAME = "";

    /**
     * 包名根名称
     */
    public static String PACKAGE_ROOT_NAME = "";

    /**
     * 包名根目录
     */
    public static String PACKAGE_ROOT_PATH = "";

    /**
     * 实体包名
     */
    public static String PACKAGE_MODEL_NAME = "";

    /**
     * 实体包名目录
     */
    public static String PACKAGE_MODEL_PATH = "";

    /**
     * 数据访问层包名
     */
    public static String PACKAGE_DAO_NAME = "";

    /**
     * 数据访问层目录
     */
    public static String PACKAGE_DAO_PATH = "";

    /**
     * 业务逻辑层包名
     */
    public static String PACKAGE_SERVICE_IMPL_NAME = "";

    /**
     * 业务逻辑层目录
     */
    public static String PACKAGE_SERVICE_IMPL_PATH = "";

    /**
     * 业务逻辑接口层包名
     */
    public static String PACKAGE_SERVICE_NAME = "";

    /**
     * 业务逻辑接口层目录
     */
    public static String PACKAGE_SERVICE_PATH = "";

    /**
     * MAPPER层目录
     */
    public static String PACKAGE_MAPPER_PATH = "";

    /**
     * 是否过滤空格
     */
    public static boolean TRIM_STRINGS = false;

    /**
     * 配置文件名
     */
    public static String CONFIG_LOCAL_PATH = "config.properties";

    /**
     * 是否使用本地配置
     */
    public static boolean CONFIG_IS_LOCAL = true;

    /**
     * 自定义配置文件名
     */
    public static String CONFIG_PATH = "";

    /**
     * 生成目录相对本目录级别-MODEL
     */
    public static int PARENT_MODEL_LIVE = 1;

    /**
     * 生成目录相对本目录级别-DAO
     */
    public static int PARENT_DAO_LIVE = 1;

    /**
     * 生成目录相对本目录级别-SERVICEIMPL
     */
    public static int PARENT_SERVICE_IMPL_LIVE = 1;

    /**
     * 生成目录相对本目录级别-SERVICE
     */
    public static int PARENT_SERVICE_LIVE = 1;

    /**
     * 生成目录相对本目录级别-MAPPER
     */
    public static int PARENT_MAPPER_LIVE = 1;

    /**
     * 生成根目录
     */
    public static String GENERATOR_ROOT = "";

    /**
     * DB包名-多数据库使用
     */
    public static String PACKAGE_DB_NAME = "";
}
