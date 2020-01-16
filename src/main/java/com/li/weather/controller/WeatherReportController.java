package com.li.weather.controller;

import com.li.weather.pojo.WeatherResponse;
import com.li.weather.service.CityDataService;
import com.li.weather.service.WeatherResportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author：lqq
 * @ClassName：WeatherReportController
 * @Time：2020/1/15
 * @Describe：
 */
@RestController
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    @Autowired
    private WeatherResportService weatherResportService;
    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId")String cityId, Model model) throws Exception {

        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.cityList());
        model.addAttribute("report",weatherResportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report","reportModel",model);
    }
}
