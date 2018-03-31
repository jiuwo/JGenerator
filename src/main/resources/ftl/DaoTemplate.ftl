package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT};

import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT}.${tableProName?cap_first};
import org.springframework.stereotype.Repository;


@Repository
public interface ${tableProName?cap_first}Dao {

    /**
     * 增加
     */
${fieldPk.type} add(${tableProName?cap_first} ${tableProName});

    /**
     * 修改
     */
    void update(${tableProName?cap_first} ${tableProName});

    /**
     * 删除
     */
    void remove(${fieldPk.type} ${fieldPk.proName});

    /**
     * 根据ID查询
     */
${tableProName?cap_first} getBy${fieldPk.proName?cap_first}(${fieldPk.type} ${fieldPk.proName});

}
