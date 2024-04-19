package com.zhaoxue.bean_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zhaoxue.bean_backend.common.bean.entity.PersonEntity;
import com.zhaoxue.bean_backend.common.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonEntity addPerson(@RequestParam String name) {
		return personService.createPerson(name); // 插入新的Person对象
	}

	@GetMapping("/persons/name")
	public String getNameById(@RequestParam Long id) {
		return personService.findNameById(id); // 根据id查询name
	}
}
