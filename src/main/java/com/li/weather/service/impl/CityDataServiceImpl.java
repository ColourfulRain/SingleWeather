package com.li.weather.service.impl;

import com.li.weather.pojo.City;
import com.li.weather.pojo.CityList;
import com.li.weather.service.CityDataService;
import com.li.weather.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：CityDataServiceImpl
 * @Time：2020/1/14
 * @Describe：
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> cityList() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer sf = new StringBuffer();
        String line = "";

        while ((line = bf.readLine()) != null) {
            sf.append(line);
        }
        bf.close();
        //将XML文件转换成java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,sf.toString());
        return cityList.getCityList();
    }
}
