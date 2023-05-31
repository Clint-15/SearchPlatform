package com.search.springbootinit.model.vo;

import com.search.springbootinit.model.entity.Picture;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 樊金亮
 * @date 2023/5/19
 */
@Data
public class SearchVO implements Serializable {
    private List<UserVO> userList;

    private List<PostVO> postList;

    private List<Picture> pictureList;

    private List<?> dataList;

    private static final long serialVersionUID = 1L;
}
