package com.chendehe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.chendehe.service.UserService;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // /**
    // * 查找列表. 成功返回200.
    // */
    // @GetMapping("/list")
    // ResponseEntity findAll(Page page) {
    // LOGGER.info("[UserController] id is:{}", page);
    // try {
    // return ResultUtil.success(service.findAll(page), HttpStatus.OK);
    // } catch (BaseException e) {
    // return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
    //
    // /**
    // * 查找详情. 成功返回200.
    // */
    // @GetMapping("/{id}")
    // ResponseEntity findOne(@PathVariable String id) {
    // LOGGER.info("[UserController] id is:{}", id);
    // try {
    // return ResultUtil.success(service.findOne(id), HttpStatus.OK);
    // } catch (BaseException e) {
    // return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // /**
    // * 新建. 成功返回201.
    // */
    // @PostMapping("/")
    // ResponseEntity save(@RequestBody UserVo userVo) {
    // LOGGER.info("[UserController] user is:{}", JSONObject.toJSON(userVo));
    // try {
    // return ResultUtil.success(service.save(userVo), HttpStatus.CREATED);
    // } catch (Exception e) {
    // return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
    //
    // /**
    // * 更新. 成功返回201.
    // */
    // @PutMapping("/{id}")
    // ResponseEntity update(@RequestBody UserVo userVo, @PathVariable String id) {
    // LOGGER.info("[UserController] user is:{}, id is:{}", JSONObject.toJSON(userVo), id);
    // userVo.setId(id);
    // try {
    // return ResultUtil.success(service.update(userVo), HttpStatus.CREATED);
    // } catch (Exception e) {
    // return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
    //
    // /**
    // * 删除. 成功返回204.
    // */
    // @DeleteMapping("/{id}")
    // ResponseEntity delete(@PathVariable String id) {
    // LOGGER.info("[UserController] id is:{}", id);
    // try {
    // service.delete(id);
    // JSONObject json = new JSONObject();
    // json.put("status", "success");
    // return ResultUtil.success(json, HttpStatus.NO_CONTENT);
    // } catch (BaseException e) {
    // return ResultUtil.exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}