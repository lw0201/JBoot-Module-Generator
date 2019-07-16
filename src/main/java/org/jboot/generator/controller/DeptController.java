package org.jboot.generator.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboot.generator.base.Result;
import org.jboot.generator.conditions.Wrapper;
import org.jboot.generator.entity.DeptVO;
import org.jboot.generator.service.IDeptService;
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
 * Dept实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class DeptController {

    @Autowired
    IDeptService iDeptService;

    /**
     * 新增实体数据
     * 
     * @param entity
     *            业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/dept/save")
    public Result<Integer> save(@RequestBody DeptVO entity) {
        return new Result<Integer>().success(iDeptService.insert(entity));
    }

    /**
     * 根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            实体ID
     * @return 返回删除影响的实体
     */
    @DeleteMapping("/v1/dept/delete/{id}")
    public Result<Integer> delete(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<Integer>().success(iDeptService.deleteById(id));
    }

    /**
     * 跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/dept/update")
    public Result<Integer> update(@RequestBody DeptVO entity) {
        return new Result<Integer>().success(iDeptService.update(entity));
    }

    /**
     * 根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/dept/single/{id}")
    public Result<DeptVO> findById(@PathVariable("id") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "路径参数[id]错误。");
        return new Result<DeptVO>().success(iDeptService.findById(id));
    }

    /**
     * 根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/dept/find/list")
    public Result<List<DeptVO>> findList(@RequestBody DeptVO entity) {
        return new Result<List<DeptVO>>().success(iDeptService.findList(entity));
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
    @PostMapping("/v1/dept/page/{pageNo}/{pageSize}")
    public Result<PageInfo<DeptVO>> findPage(@RequestBody Wrapper<DeptVO> entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<DeptVO>>().success(iDeptService.findPage(entity, pageNo, pageSize));
    }

}
