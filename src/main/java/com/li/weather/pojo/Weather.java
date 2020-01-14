package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：Weather
 * @Time：2020/1/13
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {

    private String city;
    private String ganmao;
    private String wendu;

    private Yesterday yesterday;
    private List<Forecast> forecast;
}
