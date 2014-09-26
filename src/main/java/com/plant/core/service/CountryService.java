/*
 * Copyright 2014 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.plant.core.service;

import java.util.List;

import com.plant.core.entity.City;

/**
 * 类CountryService.java的实现描述：TODO 类实现描述
 * 
 * @author liulei 2014年9月22日 下午2:25:50
 */
public interface CountryService {

    public List<City> listCityByCondition(City city);

    public Long countCountryByCondition(City city);

}
