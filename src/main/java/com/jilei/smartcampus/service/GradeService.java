package com.jilei.smartcampus.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jilei.smartcampus.pojo.Grade;

import java.util.List;

public interface GradeService extends IService<Grade> {


    List<Grade> getGrades();

    IPage<Grade> getGradeByOpr(Page<Grade> page, String gradeName);
}
