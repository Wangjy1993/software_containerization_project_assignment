package com.vu.sc.web.mapper;

import com.vu.sc.web.entity.CityEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(CityEntity city);

    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    CityEntity findById(long id);


    @Select("SELECT id, name, state, country FROM city")
    List<CityEntity> findAll();

}
