package com.search.springbootinit.model.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片
 *
 * @author 樊金亮
 * @date 2023/5/15
 */
@Data
public class Picture implements Serializable {
    private String title;

    private String url;

    private static final long serialVersionUID = 1L;
}
