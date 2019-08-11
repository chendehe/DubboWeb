package com.chendehe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chendehe.entity.StudentEntity;

@Mapper
public interface StudentDao extends BaseDao {

    List<StudentEntity> findAll();

    // StudentEntity findOne(String id);

    void save(StudentEntity student);

    void saveBatch(List<StudentEntity> student);

    // void update(StudentEntity student);
    // void delete(String id);
    // int totalNum();
}
