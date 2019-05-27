package ${packageName}.entity;

import java.io.Serializable;
<#if importPackages?? && (importPackages?size > 0) >
<#list importPackages as packageName>
<#if packageName == 'BigDecimal'>
import java.math.BigDecimal;
<#elseif packageName == 'Date'>
import java.util.Date;
</#if>
</#list>
</#if>

import lombok.Data;

/**
 * Emp 实体类
 * 
 * @author liwen
 */
@Data
public class ${entityName}VO implements Serializable {

    private static final long serialVersionUID = 1L;

    <#list fields as fidld>
    /**
     * ${fidld.comments}
     */
    private ${fidld.em.javaType} ${fidld.attrName};
    
    </#list>

}