package com.example.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Reference;
import com.example.entity.Tag;
import com.example.service.LogService;
import com.example.service.PaperService;
import com.example.service.ReferenceService;
import com.example.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/reference")
public class ReferenceController {
    @Resource
    private ReferenceService referenceService;
    @Resource
    private LogService logService;

    @PostMapping
    public Result<?> save(@RequestBody Reference ref) {
        logService.log(StrUtil.format("新增引用：{}", ref.getName()));
        return Result.success(referenceService.save(ref));
    }

    @PutMapping
    public Result<?> update(@RequestBody Reference ref) {
        logService.log(StrUtil.format("更新引用：{}", ref.getName()));
        return Result.success(referenceService.updateById(ref));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        Reference ref = referenceService.getById(id);
        logService.log(StrUtil.format("删除引用：{}", ref.getName()));

        referenceService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Reference> findById(@PathVariable Long id) {
        return Result.success(referenceService.getById(id));
    }

    @GetMapping
    public Result<List<Reference>> findAll() {
        return Result.success(referenceService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Reference>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(referenceService.page(new Page<>(pageNum, pageSize), Wrappers.<Reference>lambdaQuery().like(Reference::getName, name)));
    }

}
