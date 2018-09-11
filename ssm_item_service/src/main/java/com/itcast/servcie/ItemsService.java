package com.itcast.servcie;

import com.itcast.domain.Items;


import java.util.List;


public interface ItemsService {
    List<Items> findAll();

    Items findById(Integer id);

    void update(Items items);
}
