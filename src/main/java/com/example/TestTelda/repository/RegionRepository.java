
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
 * @author Уфилин Д.В.
 */

@Mapper
public interface RegionRepository {
    
    @Select("select * from region")
    public List<Region> findAll();

    @Select("SELECT * FROM region WHERE id = #{id}")
    public Region findById(long id);

    @Delete("DELETE FROM region WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO region(id, regionfullname, regionshortname) " +
         " VALUES (#{id}, #{regionfullname}, #{regionshortname})")
    public int insertRegion(Region region);

    @Update("Update region set regionfullname=#{regionfullname}, " +
         " regionshortname=#{regionshortname} where id=#{id}")
    public int updateRegion(Region region);
    
    
}
