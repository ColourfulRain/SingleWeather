package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：lqq
 * @ClassName：WeatherResponse
 * @Time：2020/1/13
 * @Describe：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse implements Serializable {

    private Weather data;
    private Integer status;
    private String desc;
}
