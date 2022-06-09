package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Paper;
import com.example.entity.Tag;
import com.example.mapper.PaperMapper;
import com.example.mapper.TagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TagService extends ServiceImpl<TagMapper, Tag> {

    @Resource
    private TagMapper TagMapper;

}
