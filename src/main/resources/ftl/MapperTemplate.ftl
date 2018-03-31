<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME}${config.PACKAGE_DB_NAME}.${tableProName?cap_first}${config.PACKAGE_DAO_NAME?cap_first}">
    <resultMap id="${tableProName?cap_first}BaseMap" type="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT}.${tableProName?cap_first}">
    <#list fieldList as pro>
        <#if pro.isPk == 1>
        <id column="${pro.name}" property="${pro.proName}" jdbcType="${pro.jdbcType}"/>
        <#else>
        <result column="${pro.name}" property="${pro.proName}" jdbcType="${pro.jdbcType}"/>
        </#if>
    </#list>
    </resultMap>

    <sql id="columnList">
        <#list fieldList as pro>
            ${pro.name}<#if pro_has_next>,</#if>
        </#list>
    </sql>

    <insert id="add" useGeneratedKeys="true" keyProperty="${fieldPk.proName}" parameterType="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT}.${tableProName?cap_first}">
        INSERT INTO
    ${tableName}
        (
                <#list fieldList as pro>
                    <#if pro.isIdentity==0>
                        ${pro.name}<#if pro_has_next>,</#if>
                    </#if>
                </#list>
        )
        VALUES
        (
                <#list fieldList as pro>
                    <#if pro.isIdentity==0>
                        <#if pro.name=="gmt_create" || pro.name=="gmt_modify">
                now()<#if pro_has_next>,</#if>
                        <#else>
                            ${r'#'}{${pro.proName}}<#if pro_has_next>,</#if>
                        </#if>
                    </#if>
                </#list>
        )
    </insert>

    <update id="update"  parameterType="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}${config.PACKAGE_DB_NAME}${config.GENERATOR_ROOT}.${tableProName?cap_first}">
        UPDATE
    ${tableName}
        SET
        <#list fieldList as pro>
            <#if pro.isIdentity==0>
                <#if pro.name=="gmt_modify">
                    ${pro.name} = now()<#if pro_has_next>,</#if>
                <#else>
                    ${pro.name} = ${r'#'}{${pro.proName}}<#if pro_has_next>,</#if>
                </#if>
            </#if>
        </#list>
        WHERE
    ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </update>

    <delete id="remove" parameterType="${fieldPk.type}">
        DELETE FROM ${tableName} WHERE ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </delete>

    <select id="getBy${fieldPk.proName?cap_first}" parameterType="java.lang.${fieldPk.type}" resultMap="${tableProName?cap_first}BaseMap">
        SELECT
        <include refid="columnList"/>
        FROM
    ${tableName}
        WHERE
    ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </select>

</mapper>
