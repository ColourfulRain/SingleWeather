package com.li.weather.service;

import com.li.weather.pojo.City;
import com.li.weather.pojo.CityList;

import java.util.List;

/**
 * @Author：lqq
 * @ClassName：CityDataService
 * @Time：2020/1/14
 * @Describe：
 */
public interface CityDataService {

    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> cityList() throws Exception;


}
