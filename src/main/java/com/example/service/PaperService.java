package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Paper;
import com.example.entity.Role;
import com.example.mapper.PaperMapper;
import com.example.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaperService extends ServiceImpl<PaperMapper, Paper> {

    @Resource
    private PaperMapper PaperMapper;

}
