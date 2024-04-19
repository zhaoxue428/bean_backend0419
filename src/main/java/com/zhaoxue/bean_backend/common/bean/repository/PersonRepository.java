package com.zhaoxue.bean_backend.common.bean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhaoxue.bean_backend.common.bean.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    // 这里可以根据需要定义额外的方法
}
