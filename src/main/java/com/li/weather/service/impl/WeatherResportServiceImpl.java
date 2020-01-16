package com.li.weather.service.impl;

import com.li.weather.pojo.Weather;
import com.li.weather.pojo.WeatherResponse;
import com.li.weather.service.WeatherDataService;
import com.li.weather.service.WeatherResportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：lqq
 * @ClassName：WeatherResportServiceImpl
 * @Time：2020/1/15
 * @Describe：
 */
@Service
public class WeatherResportServiceImpl implements WeatherResportService {

    @Autowired
    WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {

        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        return dataByCityId.getData();
    }
}
