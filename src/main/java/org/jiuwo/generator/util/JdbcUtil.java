package org.jiuwo.generator.util;

import java.util.HashMap;

import org.apache.commons.dbcp2.BasicDataSource;
import org.jiuwo.generator.model.Config;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 数据操作类
 *
 * @author junhan
 */
public class JdbcUtil {

    /**
     * 存储templateMap，起缓存作用
     */
    private static HashMap<String, JdbcTemplate> templateMap = new HashMap<String, JdbcTemplate>();

    /**
     * 默认Key
     */
    private static String jdbcTemplateKey = "jdbcTemplate";

    /**
     * 创建数据连接 Template
     *
     * @return JdbcTemplate
     */
    private static JdbcTemplate createMysqlTemplate() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(Config.DB_URL);
        dataSource.setUsername(Config.DB_USER);
        dataSource.setPassword(Config.DB_PASSWORD);
        dataSource.setInitialSize(5);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        templateMap.put(jdbcTemplateKey, template);
        return template;
    }

    /**
     * 取JdbcTemplate,如果缓存存在则直接取缓存中的返回
     *
     * @return JdbcTemplate
     */
    public static JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = templateMap.get(jdbcTemplateKey);
        if (jdbcTemplate == null) {
            jdbcTemplate = createMysqlTemplate();
        }
        return jdbcTemplate;
    }

}
