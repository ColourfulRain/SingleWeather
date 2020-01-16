package com.li.weather.service;

import com.li.weather.pojo.Weather;

/**
 * @Author：lqq
 * @ClassName：WeatherResportService
 * @Time：2020/1/15
 * @Describe：
 */
public interface WeatherResportService {

    /**
     * 根据城市id查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}