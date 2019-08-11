package com.chendehe.server.service;

import java.util.List;

import com.chendehe.server.bean.UserAddress;

public interface UserService {

    List<UserAddress> getUserAddress(String userId);

}
