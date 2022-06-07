package com.example.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Paper;
import com.example.service.PaperService;
import com.example.service.LogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/paper")
public class PaperController {
    @Resource
    private PaperService paperService;
    @Resource
    private LogService logService;

    @PostMapping
    public Result<?> save(@RequestBody Paper paper) {
        logService.log(StrUtil.format("新增文献：{}", paper.getTitle()));
        return Result.success(paperService.save(paper));
    }

    @PutMapping
    public Result<?> update(@RequestBody Paper paper) {
        logService.log(StrUtil.format("更新文献：{}", paper.getTitle()));
        return Result.success(paperService.updateById(paper));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        Paper paper = paperService.getById(id);
        logService.log(StrUtil.format("删除文献：{}", paper.getTitle()));

        paperService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Paper> findById(@PathVariable Long id) {
        return Result.success(paperService.getById(id));
    }

    @GetMapping
    public Result<List<Paper>> findAll() {
        return Result.success(paperService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Paper>> findPage(@RequestParam(required = false, defaultValue = "") String title,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(paperService.page(new Page<>(pageNum, pageSize), Wrappers.<Paper>lambdaQuery().like(Paper::getTitle, title)));
    }

}
