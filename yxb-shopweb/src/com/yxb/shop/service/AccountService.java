package com.yxb.shop.service;

import com.yxb.shop.model.UserDTO;

/**
 * Created by BING on 2017/6/13.
 */
public interface AccountService {
    public UserDTO getUserByNameAndPwd(String name, String password);
}
