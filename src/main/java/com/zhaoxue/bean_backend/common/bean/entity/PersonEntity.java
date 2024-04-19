package com.zhaoxue.bean_backend.common.bean.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person") // 指定数据库中的表名
public class PersonEntity {

	@Id // 标识这是主键字段
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 配置主键的生成策略，使用数据库自增
	private int id;

	@Column(name = "name", nullable = false, length = 50) // 映射到name字段，不能为空，最大长度50
	private String name;

	// 构造函数
	public PersonEntity() {
	}

	// 带参数的构造函数
	public PersonEntity(String name) {
		this.name = name;
	}

	// Getter和Setter方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
