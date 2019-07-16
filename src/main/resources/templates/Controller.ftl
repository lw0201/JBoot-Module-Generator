package ${packageName}.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import ${packageName}.base.Result;
import ${packageName}.conditions.Wrapper;
import ${packageName}.entity.${entityName}VO;
import ${packageName}.service.I${entityName}Service;
import org.jboot.generator.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

/**
 * ${entityName}实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class ${entityName}Controller {

    @Autowired
    I${entityName}Service i${entityName}Service;

    /**
     * 新增实体数据
     * 
     * @param entity
     *            业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/${entityName?lower_case}/save")
    public Result<Integer> save(@RequestBody ${entityName}VO entity) {
        return new Result<Integer>().success(i${entityName}Service.insert(entity));
    }

    /**
     * 根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            实体ID
     * @return 返回删除影响的实体
     */
    @DeleteMapping("/v1/${entityName?lower_case}/delete/{id}")
    public Result<Integer> delete(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<Integer>().success(i${entityName}Service.deleteById(id));
    }

    /**
     * 跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/${entityName?lower_case}/update")
    public Result<Integer> update(@RequestBody ${entityName}VO entity) {
        return new Result<Integer>().success(i${entityName}Service.update(entity));
    }

    /**
     * 根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/${entityName?lower_case}/single/{id}")
    public Result<${entityName}VO> findById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<${entityName}VO>().success(i${entityName}Service.findById(id));
    }

    /**
     * 根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/${entityName?lower_case}/find/list")
    public Result<List<${entityName}VO>> findList(@RequestBody ${entityName}VO entity) {
        return new Result<List<${entityName}VO>>().success(i${entityName}Service.findList(entity));
    }

    /**
     * 分页操作
     * 
     * @param entity
     *            业务实体对象
     * @param pageNo
     *            起始页
     * @param pageSize
     *            显示数量
     * @return 返回实体的分页信息
     */
    @PostMapping("/v1/${entityName?lower_case}/page/{pageNo}/{pageSize}")
    public Result<PageInfo<${entityName}VO>> findPage(@RequestBody Wrapper<${entityName}VO> entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<${entityName}VO>>().success(i${entityName}Service.findPage(entity, pageNo, pageSize));
    }

}
