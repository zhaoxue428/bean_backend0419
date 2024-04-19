package com.zhaoxue.bean_backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaoxue.bean_backend.common.bean.entity.PersonEntity;
import com.zhaoxue.bean_backend.common.bean.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * 添加新的Person对象到数据库
	 * 
	 * @param name 人名
	 * @return 保存后的Person对象
	 */
	public PersonEntity createPerson(String name) {
		PersonEntity person = new PersonEntity(name);
		return personRepository.save(person);
	}

	/**
	 * 根据id查找person的name
	 * 
	 * @param id 人的ID
	 * @return 返回找到的name，如果没有找到返回null
	 */
	public String findNameById(int id) {
		return personRepository.findById(id).map(PersonEntity::getName).orElse(null); // 如果未找到，返回null
	}
}
