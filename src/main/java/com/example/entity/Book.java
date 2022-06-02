package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.common.handler.ListHandler;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "book", autoResultMap = true)
public class Book extends Model<Book> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String meeting;

    private String date;

    private String link;

    @TableField(typeHandler = ListHandler.class)
    private List<Long> permission;
}
