package ${packageName}.attr;

/**
 * 属性列
 * 
 * @author liwen
 */
public enum ${entityName} {

    <#list fields as fidld>
    <#if !fidld_has_next>
    /** ${fidld.comments} */
    ${fidld.attrName};
    
    <#else>
    /** ${fidld.comments} */
    ${fidld.attrName},
    
    </#if>
    </#list>

}