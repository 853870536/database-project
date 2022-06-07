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
@TableName(value = "paper", autoResultMap = true)
public class Paper extends Model<Paper> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String conference;

    private String date;

    private String link;

    @TableField(typeHandler = ListHandler.class)
    private List<Long> tag_id;

    @TableField(typeHandler = ListHandler.class)
    private List<Long> ref_id;
}
