package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：lqq
 * @ClassName：Yesterday
 * @Time：2020/1/13
 * @Describe：昨天天气
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yesterday implements Serializable {

    private String date;//日期
    private String high;//最高温
    private String fx;//风力
    private String low;//最低度
    private String fl;//风力
    private String type;//天气
}
