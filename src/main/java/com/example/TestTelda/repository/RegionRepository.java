/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.TestTelda.repository;

import com.example.TestTelda.entity.Region;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author kiry
 */

@Mapper
public interface RegionRepository {
    
    @Select("select * from users")
    public List<Region> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    public Region findById(long id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO region(id, regionfullname, regionshortname) " +
         " VALUES (#{id}, #{regionfullname}, #{regionshortname})")
    public int insert(Region region);

    @Update("Update region set regionfullname=#{regionfullname}, " +
         " regionshortname=#{regionshortname} where id=#{id}")
    public int update(Region region);
    
    
}
