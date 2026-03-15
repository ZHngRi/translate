package org.example.bk.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bk.service.UserService;
import org.example.trcommon.R.R;
import org.example.trpojo.dto.UserLoginDTO;
import org.example.trpojo.dto.UserRegisterDTO;
import org.example.trpojo.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public R<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){ //@RequestBody把 HTTP 请求体（body）里的 JSON 数据转换成 Java 对象
        log.info("开始登录{}",userLoginDTO);

        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return R.ok(userLoginVO);
    }

    @PostMapping("register")
    public R register(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("开始注册{}",userRegisterDTO);
        userService.register(userRegisterDTO);
        return R.ok();
    }

}


/**
 * 一、正常流程
 *
 *          前端请求 Controller。
 *
 *          Controller 调用 Service。
 *
 *          Service 执行业务逻辑，一切正常。
 *
 *          Controller 返回 Result.success(data) → 前端收到成功数据。
 *
 * 二、发生异常时的流程
 *
 *          前端请求 Controller。
 *
 *          Controller 调用 Service。
 *
 *          Service 出现异常，比如：
 *
 *          throw new PasswordErrorException("密码错误");
 *
 *
 *       异常会沿调用栈向上抛：
 *
 *          Controller 里没有 try/catch → 异常继续抛。
 *
 *          Spring MVC 会捕获 Controller 层未处理的异常。
 *
 *        Spring MVC 找到 @RestControllerAdvice 或 @ControllerAdvice 中匹配的 @ExceptionHandler：
 *
 *          比如你写的 exceptionHandler(BaseException ex)。
 *
 *          对应的 @ExceptionHandler 被调用 → 返回封装好的 Result.error(msg) JSON 给前端。
 *
 *          Controller 本身的方法不会继续往下执行，也不会返回原本的 Result.success()。
 *
 * */
