package org.jiuwo.generator.util;

import java.io.File;

/**
 * 文件操作类
 *
 * @author junhan
 */
public class FileUtil {

    /**
     * 文件夹不存在则创建
     *
     * @param path 路径
     */
    public static void createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 取当前父路径
     *
     * @param level 级别
     * @return 路径
     */
    public static String getCurrentDirParent(int level) {
        String path = System.getProperty("user.dir");
        for (int i = 1; i <= level; i++) {
            File file = new File(path);
            path = file.getParent();
        }
        return path;
    }
}
