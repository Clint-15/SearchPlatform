package com.search.springbootinit.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.search.springbootinit.common.ErrorCode;
import com.search.springbootinit.exception.BusinessException;
import com.search.springbootinit.model.entity.Picture;
import com.search.springbootinit.service.PictureService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 图片接口实现类
 *
 * @author 樊金亮
 * @date 2023/5/15
 */

@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public Page<Picture> searchPicture(String searchText, long pageNum, long pageSize) {
        long current = (pageNum - 1) * pageSize;
        String url = String.format("https://cn.bing.com/images/search?q=%s&first=%s", searchText, current);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据获取异常");
        }
        Elements elements = doc.select(".iuscp.isv");
        List<Picture> pictures = new ArrayList<>();
        for (Element element : elements) {
            // 获取图片地址
            String m = element.select(".iusc").get(0).attr("m");
            Map<String, Object> map = JSONUtil.toBean(m, Map.class);
            String mUrl = (String) map.get("murl");
            System.out.println("图片地址：" + mUrl);

            // 获取图片标题
            String title = element.select(".iusc").get(0).attr("aria-label");
            System.out.println("图片标题：" + title);

            Picture picture = new Picture();
            picture.setTitle(title);
            picture.setUrl(mUrl);
            pictures.add(picture);
            if (pictures.size() >= pageSize) {
                break;
            }
        }

        Page<Picture> picturePage = new Page<>(pageNum, pageSize);
        picturePage.setRecords(pictures);

        return picturePage;
    }
}
