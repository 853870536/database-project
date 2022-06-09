package com.example.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Paper;
import com.example.entity.Tag;
import com.example.service.LogService;
import com.example.service.PaperService;
import com.example.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    @Resource
    private TagService tagService;
    @Resource
    private PaperService paperService;
    @Resource
    private LogService logService;

    @PostMapping
    public Result<?> save(@RequestBody Tag tag) {
        logService.log(StrUtil.format("新增标签：{}", tag.getName()));
        return Result.success(tagService.save(tag));
    }

    @PutMapping
    public Result<?> update(@RequestBody Tag tag) {
        logService.log(StrUtil.format("更新标签：{}", tag.getName()));
        return Result.success(tagService.updateById(tag));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        Tag tag = tagService.getById(id);
        logService.log(StrUtil.format("删除标签：{}", tag.getName()));

        tagService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Tag> findById(@PathVariable Long id) {
        return Result.success(tagService.getById(id));
    }

    @GetMapping
    public Result<List<Tag>> findAll() {
        return Result.success(tagService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Tag>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(tagService.page(new Page<>(pageNum, pageSize), Wrappers.<Tag>lambdaQuery().like(Tag::getName, name)));
    }

}
