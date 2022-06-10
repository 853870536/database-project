package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Reference;
import com.example.entity.Tag;
import com.example.mapper.ReferenceMapper;
import com.example.mapper.TagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReferenceService extends ServiceImpl<ReferenceMapper, Reference> {

    @Resource
    private ReferenceMapper ReferenceMapper;

}
