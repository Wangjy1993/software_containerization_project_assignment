package com.vu.sc.web.service;

import com.vu.sc.web.entity.CityEntity;

import java.util.List;

public interface CityService {
   List<CityEntity> findAllCities();
   Boolean addCity(CityEntity city);
}
