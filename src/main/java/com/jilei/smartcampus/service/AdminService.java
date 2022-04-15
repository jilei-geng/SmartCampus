package com.jilei.smartcampus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jilei.smartcampus.pojo.Admin;
import com.jilei.smartcampus.pojo.LoginForm;

public interface AdminService extends IService<Admin> {


    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);


    IPage<Admin> getAdminsByOpr(Page<Admin> pageParam, String adminName);
}
