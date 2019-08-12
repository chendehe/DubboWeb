package com.chendehe.service;

import com.chendehe.server.service.CarDubboService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chendehe.dao.UserDao;
import com.chendehe.entity.UserEntity;
import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserDubboService;
import com.chendehe.vo.Page;
import com.chendehe.vo.PageResult;
import com.chendehe.vo.UserVo;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Reference
    private UserDubboService userDubboService;
    @Reference
    private CarDubboService carDubboService;

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public PageResult<UserVo> findAll(Page page) {

        PageResult<UserVo> result = new PageResult<>();
        List<UserEntity> userList = userDao.findAll();
        List<UserVo> userVoList = new ArrayList<>();

        for (UserEntity user : userList) {
            userVoList.add(convertEntityToVo(user));
        }
        result.setList(userVoList);
        result.setTotalNum(userDao.totalNum());
        result.setPageSize(page.getPageSize());
        result.setCurrentPage(page.getCurrentPage());
        return result;
    }

    @Override
    public UserVo findOne(String id) {
        List<UserAddress> addressList = userDubboService.getUserAddress("users");
        addressList.forEach(System.out::println);
        System.out.println(carDubboService.getCarName("car"));
        return convertEntityToVo(userDao.findOne(id));
    }

    @Transactional
    @Override
    public UserVo save(UserVo vo) {
        // data bind if need validator
        // DataBinder binder = new DataBinder(vo);
        // binder.setValidator(new UserValidator());
        // binder.validate();
        vo.setId(UUID.randomUUID().toString());

        UserEntity entity = convertVoToEntitySave(vo);
        userDao.save(entity);

        return vo;
    }

    @Transactional
    @Override
    public UserVo update(UserVo vo) {

        UserEntity user = convertVoToEntityUpdate(vo);

        userDao.update(user);
        return vo;
    }

    @Transactional
    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    /**
     * entity 转为 vo.
     *
     * @param user
     *            entity
     * @return vo
     */
    private UserVo convertEntityToVo(UserEntity user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setName(user.getName());
        userVo.setGender(user.getGender());
        userVo.setBirthday(user.getBirthday());
        userVo.setAddress(user.getAddress());
        return userVo;
    }

    /**
     * vo 转为 entity.
     *
     * @param vo
     *            UserVo
     * @return UserEntity
     */
    private UserEntity convertVoToEntitySave(UserVo vo) {
        UserEntity user = new UserEntity();

        convertVoToEntity(vo, user);

        user.setCreateTime(new Date());
        return user;
    }

    /**
     * vo 转为更新后的 entity.
     *
     * @param vo
     *            UserVo
     * @return UserEntity
     */
    private UserEntity convertVoToEntityUpdate(UserVo vo) {
        UserEntity user = new UserEntity();

        convertVoToEntity(vo, user);

        user.setUpdateTime(new Date());
        return user;
    }

    private void convertVoToEntity(UserVo vo, UserEntity user) {
        user.setId(vo.getId());
        user.setName(vo.getName());
        user.setGender(vo.getGender());
        user.setBirthday(vo.getBirthday());
        user.setAddress(vo.getAddress());
    }

}
