package com.search.springbootinit.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 搜索类型枚举
 *
 * @author 樊金亮
 * @date 2023/5/19
 */
public enum SearchTypeEnum {
    POST("帖子", "post"),
    USER("用户", "user"),
    PICTURE("图片", "picture"),
    VIDEO("视频", "video");

    private String text;
    private String value;

    SearchTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    // 获取值列表
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList()); // 将枚举转换为值列表
    }

    // 根据 value 获取枚举
    public static SearchTypeEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (SearchTypeEnum anEnum : values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
