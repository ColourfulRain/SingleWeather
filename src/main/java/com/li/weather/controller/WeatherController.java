package com.li.weather.controller;

import com.li.weather.pojo.Weather;
import com.li.weather.pojo.WeatherResponse;
import com.li.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：lqq
 * @ClassName：WeatherController
 * @Time：2020/1/13
 * @Describe：
 */
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        log.info("【返回数据】WeatherResponse={}",dataByCityId);
        return dataByCityId;
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        WeatherResponse dataByCityName = weatherDataService.getDataByCityName(cityName);
        log.info("【返回数据】WeatherResponse={}",dataByCityName);
        return dataByCityName;
    }

}
