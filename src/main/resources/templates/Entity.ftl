package ${packageName}.entity;

<#if importPackages?? && (importPackages?size > 0) >
<#list importPackages as packageName>
<#if packageName == 'BigDecimal'>
import java.math.BigDecimal;
<#elseif packageName == 'Date'>
import java.util.Date;
</#if>
</#list>
</#if>

import org.hibernate.validator.constraints.Length;

import org.jboot.generator.base.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * ${entityName} 实体类
 * 
 * @author liwen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName}VO extends BaseVO {

    private static final long serialVersionUID = 1L;

    <#list fields as fidld>
    <#if fidld.attrName != 'createdBy' && fidld.attrName != 'createdDate' && fidld.attrName != 'lastUpdateBy' && fidld.attrName != 'lastUpdateDate'>
    /**
     * ${fidld.comments}
     */
    <#if fidld.em.javaType == 'String' && fidld.columnSize < 10000 >
    @Length(max = ${fidld.columnSize})
    </#if>
    @ApiModelProperty("${fidld.comments}")
    private ${fidld.em.javaType} ${fidld.attrName};

    </#if>
    </#list>

}