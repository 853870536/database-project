package com.example.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Book;
import com.example.service.BookService;
import com.example.service.LogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private LogService logService;

    @PostMapping
    public Result<?> save(@RequestBody Book book) {
        logService.log(StrUtil.format("新增文献：{}", book.getTitle()));
        return Result.success(bookService.save(book));
    }

    @PutMapping
    public Result<?> update(@RequestBody Book book) {
        logService.log(StrUtil.format("更新文献：{}", book.getTitle()));
        return Result.success(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        Book book = bookService.getById(id);
        logService.log(StrUtil.format("删除文献：{}", book.getTitle()));

        bookService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Book> findById(@PathVariable Long id) {
        return Result.success(bookService.getById(id));
    }

    @GetMapping
    public Result<List<Book>> findAll() {
        return Result.success(bookService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Book>> findPage(@RequestParam(required = false, defaultValue = "") String title,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(bookService.page(new Page<>(pageNum, pageSize), Wrappers.<Book>lambdaQuery().like(Book::getTitle, title)));
    }

}
