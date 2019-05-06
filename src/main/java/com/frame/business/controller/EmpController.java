package com.frame.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frame.business.entity.EmpVO;
import com.frame.business.service.IEmpService;

@RestController
public class EmpController {

	@Autowired
	IEmpService iEmpService;

	@PostMapping("emp/insert")
	public int insert(@RequestBody EmpVO entity) {
		return iEmpService.insert(entity);
	}

	@PostMapping("emp/delete/{id}")
	public int delete(@PathVariable("id") Integer id) {
		return iEmpService.deleteById(id);
	}

	@PostMapping("emp/update")
	public int update(@RequestBody EmpVO entity) {
		return iEmpService.update(entity);
	}

	@GetMapping("emp/find/{id}")
	public EmpVO findById(@PathVariable("id") Integer id) {
		return iEmpService.findById(id);
	}

	@GetMapping("emp/find/list/")
	public EmpVO findList(@PathVariable("id") Integer id) {
		return iEmpService.findById(id);
	}

}
