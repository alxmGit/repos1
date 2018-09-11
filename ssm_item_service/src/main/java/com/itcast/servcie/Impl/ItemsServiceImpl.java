package com.itcast.servcie.Impl;

import com.itcast.dao.ItemsDao;
import com.itcast.domain.Items;
import com.itcast.servcie.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService{
    @Autowired
    private ItemsDao itemsDao;
    @Override
    public List<Items> findAll() {


        return itemsDao.findAll();
    }

    @Override
    public Items findById(Integer id) {

        Items items= itemsDao.findById(id);
        return items;
    }

//    修改信息
    @Override
    public void update(Items items) {
        itemsDao.update(items);
    }
}
