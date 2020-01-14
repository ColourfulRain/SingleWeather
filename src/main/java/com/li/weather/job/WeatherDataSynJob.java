package com.li.weather.job;

import com.li.weather.pojo.City;
import com.li.weather.service.CityDataService;
import com.li.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：lqq
 * @ClassName：WeatherDataSynJob
 * @Time：2020/1/14
 * @Describe：通过Quartz实现定时任务
 */
@Slf4j
public class WeatherDataSynJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取城市id列表
        List<City> cityList = null;
        //遍历城市id获取天气
        try {
            cityList = cityDataService.cityList();
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("exception",e);
        }
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("【城市服务】cityId={}",cityId);
            weatherDataService.syncDataByCityId(cityId);
        }
    }
}
