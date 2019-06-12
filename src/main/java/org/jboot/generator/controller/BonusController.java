package org.jboot.generator.controller;

import java.util.List;

import org.jboot.generator.base.Result;
import org.jboot.generator.conditions.Wrapper;
import org.jboot.generator.entity.BonusVO;
import org.jboot.generator.service.IBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

/**
 * Bonus实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class BonusController {

    @Autowired
    IBonusService iBonusService;

    /**
     * 新增实体数据
     * 
     * @param entity
     *            业务实体
     * @return 返回新增影响的数据
     */
    @PostMapping("/v1/bonus/insert")
    public Result<String> insert(@RequestBody BonusVO entity) {
        iBonusService.insert(entity);
        return new Result<String>().success();
    }

    /**
     * 根据实体ID删除数据，并持久化删除数据。
     * 
     * @param id
     *            实体ID
     * @return 返回删除影响的实体
     */
    @DeleteMapping("/v1/bonus/delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer id) {
        iBonusService.deleteById(id);
        return new Result<String>().success();
    }

    /**
     * 跟新实体数据并持久化保存操作
     * 
     * @param entity
     *            操作的业务实体对象
     * @return 返回影响的行
     */
    @PostMapping("/v1/bonus/update")
    public Result<String> update(@RequestBody BonusVO entity) {
        iBonusService.update(entity);
        return new Result<String>().success();
    }

    /**
     * 根据实体ID查询实体对象并返回实体对象的详细信息
     * 
     * @param id
     *            实体对象对应的ID
     * @return 返回实体对象的相信信息
     */
    @GetMapping("/v1/bonus/single/{id}")
    public Result<BonusVO> findById(@PathVariable("id") Integer id) {
        return new Result<BonusVO>().success(iBonusService.findById(id));
    }

    /**
     * 根据实体查询并返回实体对象集合
     * 
     * @param entity
     *            业务实体对象
     * @return 实体对象集合
     */
    @PostMapping("/v1/bonus/find/list")
    public Result<List<BonusVO>> findList(@RequestBody BonusVO entity) {
        return new Result<List<BonusVO>>().success(iBonusService.findList(entity));
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
    @PostMapping("/v1/bonus/page/{pageNo}/{pageSize}")
    public Result<PageInfo<BonusVO>> findPage(@RequestBody Wrapper<BonusVO> entity, @PathVariable("pageNo") int pageNo,
        @PathVariable("pageSize") int pageSize) {
        return new Result<PageInfo<BonusVO>>().success(iBonusService.findPage(entity, pageNo, pageSize));
    }

}
