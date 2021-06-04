package com.hello.fast.controller;

import com.hello.fast.DO.User;
import com.hello.fast.VO.Result;
import com.hello.fast.util.Constant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

 /*   @RequestMapping(path = "/user/login")
    public Map<String, Object> login(@RequestBody User user){
        System.out.println(user.getUsername() + " ----"+ user.getPassword());
        Map<String, Object> res = new HashMap<>();
        if ("calo".equals(user.getUsername()) && "12345".equals(user.getPassword())){
            res.put("isSuccess", true);
            Map<String, String> data = new HashMap<>();
            data.put("username",user.getUsername());
            data.put("token", "666666666");
            res.put("data", data);
        }else {
            res.put("isSuccess", false);
        }
        return res;
    }
*/

    @RequestMapping(path = "/user/login")
    public Result login(@RequestBody User user){
        Result result = new Result();
        if ("calo".equals(user.getUsername()) && "12345".equals(user.getPassword())){

            Map<String, String> data = new HashMap<>();
            data.put("username",user.getUsername());
            data.put("token", "666666666");
            result.setCode(Constant.SUCCESS);
            result.setMessage("登陆成功");
            result.setData(data);
            return result;
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("登陆失败");
            return result;
        }
    }
}
