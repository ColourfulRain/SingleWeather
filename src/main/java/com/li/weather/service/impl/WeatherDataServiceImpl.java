package com.li.weather.service.impl;


import ch.qos.logback.core.util.TimeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.weather.pojo.WeatherResponse;
import com.li.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author：lqq
 * @ClassName：WeatherDataServiceImpl
 * @Time：2020/1/13
 * @Describe：
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URL + "citykey=" + cityId;

        WeatherResponse data = getData(uri);
        return data;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URL + "city=" + cityName;

        WeatherResponse data = getData(uri);
        return data;
    }

    public WeatherResponse getData(String uri) {

        String strBoy = null;

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weather = null;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(uri)) {
            log.info("【天气实现】{}", "redis命中");
            strBoy = ops.get(uri);
        } else {
            log.info("【天气实现】{}", "redis没有命中");
            ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
            //类型转换
            if (forEntity.getStatusCodeValue() == 200) {
                strBoy = forEntity.getBody();
            }
            //写入缓存中
            ops.set(uri, strBoy, 1800, TimeUnit.SECONDS);
        }
        try {
            weather = objectMapper.readValue(strBoy, WeatherResponse.class);
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("error", e);
        }
        return weather;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URL + "cityKey=" + cityId;
        saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存中
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String strBoy = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //调用服务接口来获取天气服务
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        //类型转换
        if (forEntity.getStatusCodeValue() == 200) {
            strBoy = forEntity.getBody();
        }
        //写入缓存中
        ops.set(uri, strBoy, 1800, TimeUnit.SECONDS);
    }
}
