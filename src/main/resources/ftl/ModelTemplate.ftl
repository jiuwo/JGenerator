package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT};

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


public class ${ tableProName?cap_first } {

<#list fieldList as pro>
    /**
     * ${pro.description}
     */
    private ${pro.type} ${pro.proName};
</#list>

<#list fieldList as pro>
    /**
     * ${pro.description}
     */
    public ${pro.type} get${pro.proName?cap_first}() {
        return this.${pro.proName};
    }

    public void set${pro.proName?cap_first}(${pro.type} ${pro.proName}) {
    <#if config.TRIM_STRINGS && pro.type=="String">
        this.${pro.proName} = ${pro.proName} == null ? null : ${pro.proName}.trim();
    <#else >
        this.${pro.proName} = ${pro.proName};
    </#if>
    }

</#list>

}
