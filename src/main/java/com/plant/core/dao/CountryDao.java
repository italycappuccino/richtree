package com.plant.core.dao;

import java.util.List;

import com.plant.core.entity.City;

public interface CountryDao {

    public Long countCountryByCondition(City city);

    public List<City> listCityByCondition(City city);

}
