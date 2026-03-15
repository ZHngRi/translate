package org.example.bk.service;

import org.example.trpojo.dto.UserLoginDTO;
import org.example.trpojo.dto.UserRegisterDTO;
import org.example.trpojo.vo.UserLoginVO;

public interface UserService {
    UserLoginVO login(UserLoginDTO userLoginDTO);

    void register(UserRegisterDTO userRegisterDTO);
}

