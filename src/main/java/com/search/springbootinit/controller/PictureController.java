package com.search.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.search.springbootinit.common.ErrorCode;
import com.search.springbootinit.exception.ThrowUtils;
import com.search.springbootinit.model.entity.Picture;
import com.search.springbootinit.service.PictureService;
import com.search.springbootinit.common.BaseResponse;
import com.search.springbootinit.common.ResultUtils;
import com.search.springbootinit.model.dto.picture.PictureQueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 樊金亮
 * @date 2023/5/18
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {
    @Resource
    private PictureService pictureService;

    /**
     * 分页查询图片
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest, HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();

        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR, "每页最多20条");
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);

        return ResultUtils.success(picturePage);
    }
}
