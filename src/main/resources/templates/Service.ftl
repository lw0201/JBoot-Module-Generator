package ${packageName}.service.impl;

import org.springframework.stereotype.Service;

import org.jboot.generator.base.impl.BaseService;
import ${packageName}.entity.${entityName}VO;
import ${packageName}.service.I${entityName}Service;

/**
 * ${entityName}实体业务逻辑处理层
 * 
 * @author liwen
 *
 */
@Service
public class ${entityName}Service extends BaseService<${entityName}VO> implements I${entityName}Service {

}
