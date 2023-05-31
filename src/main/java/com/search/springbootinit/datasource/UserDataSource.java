package com.search.springbootinit.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.search.springbootinit.model.dto.post.PostQueryRequest;
import com.search.springbootinit.model.entity.Post;
import com.search.springbootinit.model.vo.PostVO;
import com.search.springbootinit.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务实现类
 *
 * @author 樊金亮
 * @date 2023/5/21
 */

@Service
@Slf4j
public class UserDataSource implements DataSource{
    @Resource
    private PostService postService;

    @Override
    public Page<PostVO> doSearch(String searchText, long pageNum, long pageSize) {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setSearchText(searchText);
        postQueryRequest.setCurrent(pageNum);
        postQueryRequest.setPageSize(pageSize);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Page<Post> postPage = postService.searchFromEs(postQueryRequest); // 从 ES 查询

        return postService.getPostVOPage(postPage, request);
    }
}
