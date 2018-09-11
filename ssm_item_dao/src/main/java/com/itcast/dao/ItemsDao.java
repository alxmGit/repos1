package com.itcast.dao;

import com.itcast.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemsDao {

    @Select("select * from items")
    List<Items> findAll();

    @Select("select * from items where id=#{id}")
    Items findById(Integer id);

    @Update("update items set name=#{name},price=#{price},pic=#{pic},createtime=#{createtime},detail=#{detail} where id=#{id}")
    void update(Items items);
}
