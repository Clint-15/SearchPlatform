package com.search.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.search.springbootinit.model.entity.Picture;

/**
 * 图片服务接口
 *
 * @author 樊金亮
 * @date 2023/5/15
 */

public interface PictureService {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
