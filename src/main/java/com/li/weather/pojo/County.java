package com.li.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Author：lqq
 * @ClassName：County
 * @Time：2020/1/15
 * @Describe：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "county")
@XmlAccessorType(XmlAccessType.FIELD)
public class County {

    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "weatherCode")
    private String weatherCode;
}
