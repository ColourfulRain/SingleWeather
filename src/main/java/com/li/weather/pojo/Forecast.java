package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：lqq
 * @ClassName：Forecast
 * @Time：2020/1/13
 * @Describe：预测天气
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast implements Serializable {

    private String date;//日期
    private String high;//最高温
    private String fengli;//风力
    private String low;//最低度
    private String fengxiang;//风力
    private String type;//天气
}
