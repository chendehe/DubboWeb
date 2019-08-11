package com.chendehe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chendehe.entity.UserEntity;

@Mapper
public interface UserDao extends BaseDao {

    List<UserEntity> findAll();

    UserEntity findOne(String id);

    void save(UserEntity user);

    void saveBatch(List<UserEntity> user);

    void update(UserEntity user);

    void delete(String id);

    int totalNum();
}
