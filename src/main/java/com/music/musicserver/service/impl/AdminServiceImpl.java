package com.music.musicserver.service.impl;

import com.music.musicserver.dao.AdminMapper;
import com.music.musicserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean verifyPassword(String name, String password) {
        System.out.println(name+":"+password);
        return adminMapper.verifyPassword(name,password)>0;
    }
}
