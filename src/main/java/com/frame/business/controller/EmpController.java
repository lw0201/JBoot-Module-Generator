package com.frame.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frame.business.entity.EmpVO;
import com.frame.business.service.IEmpService;
import com.github.pagehelper.PageInfo;

/**
 * Emp实体控制层
 * 
 * @author liwen
 *
 */
@RestController
public class EmpController {

	@Autowired
	IEmpService iEmpService;

	/**
	 * 新增实体数据
	 * 
	 * @param entity 业务实体
	 * @return 返回新增影响的数据
	 */
	@PostMapping("emp/insert")
	public int insert(@RequestBody EmpVO entity) {
		return iEmpService.insert(entity);
	}

	/**
	 * 根据实体ID删除数据，并持久化删除数据。
	 * 
	 * @param id 实体ID
	 * @return 返回删除影响的实体
	 */
	@PostMapping("emp/delete/{id}")
	public int delete(@PathVariable("id") Integer id) {
		return iEmpService.deleteById(id);
	}

	/**
	 * 跟新实体数据并持久化保存操作
	 * 
	 * @param entity 操作的业务实体对象
	 * @return 返回影响的行
	 */
	@PostMapping("emp/update")
	public int update(@RequestBody EmpVO entity) {
		return iEmpService.update(entity);
	}

	/**
	 * 根据实体ID查询实体对象并返回实体对象的详细信息
	 * 
	 * @param id 实体对象对应的ID
	 * @return 返回实体对象的相信信息
	 */
	@GetMapping("emp/find/{id}")
	public EmpVO findById(@PathVariable("id") Integer id) {
		return iEmpService.findById(id);
	}

	/**
	 * 根据实体查询并返回实体对象集合
	 * 
	 * @param entity 业务实体对象
	 * @return 实体对象集合
	 */
	@PostMapping("emp/find/list")
	public List<EmpVO> findList(@RequestBody EmpVO entity) {
		return iEmpService.findList(entity);
	}

	/**
	 * 分页操作
	 * 
	 * @param entity   业务实体对象
	 * @param pageNo   起始页
	 * @param pageSize 显示数量
	 * @return 返回实体的分页信息
	 */
	@PostMapping("emp/page/{pageNo}/{pageSize}")
	public PageInfo<EmpVO> findPage(@RequestBody EmpVO entity, @PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize) {
		return iEmpService.findPage(entity, pageNo, pageSize);
	}

}
