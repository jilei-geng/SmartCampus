package com.jilei.smartcampus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jilei.smartcampus.mapper.TeacherMapper;
import com.jilei.smartcampus.pojo.LoginForm;
import com.jilei.smartcampus.pojo.Teacher;
import com.jilei.smartcampus.service.TeacherService;
import com.jilei.smartcampus.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.eq("name", loginForm.getUsername());
        teacherQueryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Teacher teacher = baseMapper.selectOne(teacherQueryWrapper);
        return teacher;
    }

    @Override
    public Teacher getByTeacherById(Long userId) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.eq("id", userId);
        return baseMapper.selectOne(teacherQueryWrapper);
    }

    @Override
    public IPage<Teacher> getTeachersByOpr(Page<Teacher> paraParam, Teacher teacher) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(teacher.getName())) {
            queryWrapper.like("name", teacher.getName());
        }
        if (!StringUtils.isEmpty(teacher.getClazzName())) {
            queryWrapper.eq("clazz_name", teacher.getClazzName());
        }
        queryWrapper.orderByDesc("id");

        Page<Teacher> page = baseMapper.selectPage(paraParam, queryWrapper);
        return page;
    }
}
