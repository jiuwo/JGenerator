package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_SERVICE_IMPL_NAME}.impl${config.GENERATOR_ROOT};

import javax.annotation.Resource;

import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT}.${tableProName?cap_first};
import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME}${config.PACKAGE_DB_NAME}.${tableProName?cap_first}Dao;
import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_SERVICE_NAME}.${tableProName?cap_first}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ${tableProName?cap_first}${config.PACKAGE_SERVICE_IMPL_NAME?cap_first}Impl implements ${tableProName?cap_first}Service {

	@Resource
	private ${tableProName?cap_first}Dao ${tableProName}Dao;

    /**
     * 增加
     */
	@Override
	public ${tableProName?cap_first} add(${tableProName?cap_first} ${tableProName}) {
${tableProName}Dao.add(${tableProName});
		return ${tableProName};
	}

    /**
     * 修改
     */
	@Override
	public void update(${tableProName?cap_first} ${tableProName}) {
${tableProName}Dao.update(${tableProName});
	}

    /**
     * 删除
     */
	@Override
	public void remove(${fieldPk.type} ${fieldPk.proName}) {
${tableProName}Dao.remove(${fieldPk.proName});
	}

    /**
     * 根据ID查询
     */
	@Override
	public ${tableProName?cap_first} getBy${fieldPk.proName?cap_first}(${fieldPk.type} ${fieldPk.proName}) {
		return ${tableProName}Dao.getBy${fieldPk.proName?cap_first}(${fieldPk.proName});
	}

}
