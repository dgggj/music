package com.music.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.music.musicserver.dto.AdminRequest;
import com.music.musicserver.service.AdminService;
import com.music.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/admin/login/status")
    public Object loginStatus(AdminRequest adminRequest, HttpSession session){
        JSONObject jsonObject=new JSONObject();
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
        boolean flag=adminService.verifyPassword(adminRequest.getName(),adminRequest.getPassword());
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
            session.setAttribute(Consts.NAME,adminRequest.getName());
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"用户名或者密码错误");
        return jsonObject;

    }


}
