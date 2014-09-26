package com.plant.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plant.core.common.BaseDao;
import com.plant.core.dao.CountryDao;
import com.plant.core.entity.City;

@Repository
public class CountryDaoImpl extends BaseDao implements CountryDao {

    @SuppressWarnings("deprecation")
    @Override
    public Long countCountryByCondition(City city) {
        return (Long) this.getSqlMapClientTemplate().queryForObject("City.countCityByCondition", city);
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<City> listCityByCondition(City city) {
        return (List<City>) this.getSqlMapClientTemplate().queryForList("City.listCityByCondition", city);
    }

}
