package com.zhaoxue.bean_backend.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.zhaoxue.bean_backend.common.bean.entity.PersonEntity;
import com.zhaoxue.bean_backend.common.bean.repository.PersonRepository;

@Service
public class PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	/**
	 * 添加新的Person对象到数据库
	 * 
	 * @param name 人名，不应为空
	 * @return 保存后的Person对象
	 */
	public PersonEntity createPerson(String name) {
		Assert.hasText(name, "Name must not be empty");
		PersonEntity person = new PersonEntity(name);
		try {
			return personRepository.save(person);
		} catch (Exception e) {
			logger.error("Error saving person: ", e);
			throw e;
		}
	}

	/**
	 * 根据id查找person的name
	 * 
	 * @param id 人的ID
	 * @return 返回找到的name，如果没有找到返回null
	 */
	public String findNameById(Long id) {
		Assert.notNull(id, "ID must not be null");
		return personRepository.findById(id).map(PersonEntity::getName).orElse(null);
	}
}
