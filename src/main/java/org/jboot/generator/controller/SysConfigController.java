package org.jboot.generator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.jboot.generator.base.Result;
import org.jboot.generator.entity.SysConfigVO;
import org.jboot.generator.service.ISysConfigService;
import com.github.pagehelper.PageInfo;

/**
 * SysConfig实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class SysConfigController {

    @Autowired
    ISysConfigService iSysConfigService;

    /**
     * <li>新增实体数据
     * 
     * @param entity
     *            :业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/sysconfig/insert")
    public Result<String> insert(@RequestBody SysConfigVO entity) {
        iSysConfigService.insert(entity);
        return new Result<String>().success();
    }

    /**
     * <li>根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            :实体ID
     * @return 返回删除影响的实体
     */
    @PostMapping("/v1/sysconfig/delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer id) {
        iSysConfigService.deleteById(id);
        return new Result<String>().success();
    }

    /**
     * <li>跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            :操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/sysconfig/update")
    public Result<String> update(@RequestBody SysConfigVO entity) {
        iSysConfigService.update(entity);
        return new Result<String>().success();
    }

    /**
     * <li>根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            :实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/sysconfig/find/{id}")
    public Result<SysConfigVO> findById(@PathVariable("id") Integer id) {
        return new Result<SysConfigVO>().success(iSysConfigService.findById(id));
    }

    /**
     * <li>根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            :业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/sysconfig/find/list")
    public Result<List<SysConfigVO>> findList(@RequestBody SysConfigVO entity) {
        return new Result<List<SysConfigVO>>().success((iSysConfigService.findList(entity)));
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
    @PostMapping("/v1/sysconfig/page/{pageNo}/{pageSize}")
    public Result<PageInfo<SysConfigVO>> findPage(@RequestBody SysConfigVO entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<SysConfigVO>>().success((iSysConfigService.findPage(entity, pageNo, pageSize)));
    }

}
