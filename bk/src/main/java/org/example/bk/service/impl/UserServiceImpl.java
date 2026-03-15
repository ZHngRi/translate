package org.example.bk.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.bk.mapper.UserMapper;
import org.example.bk.service.UserService;
import org.example.trcommon.exception.BaseException;
import org.example.trcommon.exception.LoginException;
import org.example.trpojo.dto.UserLoginDTO;
import org.example.trpojo.dto.UserRegisterDTO;
import org.example.trpojo.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.trpojo.entity.User;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {

        User user = userMapper.findByUsername(userLoginDTO.getUsername());

        if(user == null){
            throw new LoginException("用户不存在");
        }

        if(!user.getPassword().equals(userLoginDTO.getPassword())){
            throw new LoginException("密码错误");
        }

        UserLoginVO vo = new UserLoginVO();
        vo.setId(user.getId());
        vo.setUserName(user.getUsername());
        vo.setCreatedAt(user.getCreatedAt());

        log.info("登录成功{}",vo);
        return vo;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.findByUsername(userRegisterDTO.getUsername());
        if(user != null){
            throw new LoginException("用户已存在");
        }
        User newUser = new User();
        newUser.setUsername(userRegisterDTO.getUsername());
        newUser.setPassword(userRegisterDTO.getPassword());
        newUser.setCreatedAt(LocalDateTime.now());

        log.info("登录成功{}",newUser);
        userMapper.insert(newUser);
    }
}
