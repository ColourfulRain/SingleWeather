package com.li.weather.service;

import com.li.weather.pojo.WeatherResponse;

/**
 * @Author：lqq
 * @ClassName：WeatherDataService
 * @Time：2020/1/13
 * @Describe：
 */
public interface WeatherDataService {

    /**
     * 根据城市di天气查询
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
