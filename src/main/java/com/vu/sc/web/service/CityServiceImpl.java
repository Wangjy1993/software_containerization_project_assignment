package com.vu.sc.web.service;

import com.vu.sc.web.entity.CityEntity;
import com.vu.sc.web.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<CityEntity> findAllCities() {
        return cityMapper.findAll();
    }

    @Override
    public Boolean addCity(CityEntity city) {

        cityMapper.insert(city);
        return true;
    }
}
