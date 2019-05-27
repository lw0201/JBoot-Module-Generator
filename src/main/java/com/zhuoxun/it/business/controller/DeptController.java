package com.zhuoxun.it.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frame.business.base.Result;
import com.zhuoxun.it.business.entity.DeptVO;
import com.zhuoxun.it.business.service.IDeptService;
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
     * <li>新增实体数据
     * 
     * @param entity
     *            :业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/dept/insert")
    public Result<String> insert(@RequestBody DeptVO entity) {
        iDeptService.insert(entity);
        return new Result<String>().success();
    }

    /**
     * <li>根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            :实体ID
     * @return 返回删除影响的实体
     */
    @PostMapping("/v1/dept/delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer id) {
        iDeptService.deleteById(id);
        return new Result<String>().success();
    }

    /**
     * <li>跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            :操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/dept/update")
    public Result<String> update(@RequestBody DeptVO entity) {
        iDeptService.update(entity);
        return new Result<String>().success();
    }

    /**
     * <li>根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            :实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/dept/find/{id}")
    public Result<DeptVO> findById(@PathVariable("id") Integer id) {
        return new Result<DeptVO>().success(iDeptService.findById(id));
    }

    /**
     * <li>根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            :业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/dept/find/list")
    public Result<List<DeptVO>> findList(@RequestBody DeptVO entity) {
        return new Result<List<DeptVO>>().success((iDeptService.findList(entity)));
    }

    /**
     * <li>分页操作
     * 
     * @param entity
     *            :业务实体对象
     * @param pageNo
     *            :起始页
     * @param pageSize
     *            :显示数量
     * @return 返回实体的分页信息
     */
    @PostMapping("/v1/dept/page/{pageNo}/{pageSize}")
    public Result<PageInfo<DeptVO>> findPage(@RequestBody DeptVO entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<DeptVO>>().success((iDeptService.findPage(entity, pageNo, pageSize)));
    }

}
