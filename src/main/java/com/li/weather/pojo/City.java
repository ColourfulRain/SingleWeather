package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author：lqq
 * @ClassName：City
 * @Time：2020/1/14
 * @Describe：
 */
//声明是一个读取根元素的
@XmlRootElement(name = "d")
//访问类型,根据字段来访问
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;
    @XmlAttribute(name = "d2")
    private String cityName;
    @XmlAttribute(name = "d3")
    private String cityCode;
    @XmlAttribute(name = "d4")
    private String provice;
}
