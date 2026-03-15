package org.example.trcommon.R;


import lombok.Data;

/**
 * @BelongsProject: spring_std1
 * @BelongsPackage: com.atguigu.springmvcrestfulcrud.common
 * @Author: yanhongwei
 * @CreateTime: 2026-01-17  03:19
 * @Description: TODO
 * @Version: 1.0
 */


//返回要统一格式，也就是统一返回R对象
//  统一曾为json格式
//  格式为{
//      "code":200,
//      "msg":"",
//      "data":{}           //这里返回一个对象就是{}，返回很多对象就是"data":[{},{}]
//  }
//这样前端看到状态码就可以直接处理
//  1.200 接受数据
//  2.其他就是显示msg消息

//下面的静态方法是经常使用的R对象
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static<T> R<T> ok(T data){
        R r = new R();
        r.code = 200;
        r.msg = "ok";
        r.data = data;
        return r;
    }

    public static R ok(){
        R r = new R();
        r.code = 200;
        r.msg = "ok";
        return r;
    }

    public static R error(){
        R r = new R();
        r.code = 500;
        r.msg = "error";
        return r;
    }

    //自定义失败码和信息
    public static R error(Integer code,String msg){
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }
    //自定义失败码和信息和数据
    public static R error(Integer code,String msg,Object data){
        R r = new R();
        r.code = code;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static R error( String msg){
        R r = new R();
        r.code = 500;
        r.msg = msg;
        return r;
    }

}
