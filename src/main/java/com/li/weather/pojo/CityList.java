package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：CityList
 * @Time：2020/1/14
 * @Describe：
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;
}
