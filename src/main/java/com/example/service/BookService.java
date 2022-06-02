package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Book;
import com.example.entity.Role;
import com.example.mapper.BookMapper;
import com.example.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService extends ServiceImpl<BookMapper, Book> {

    @Resource
    private BookMapper bookMapper;

}
