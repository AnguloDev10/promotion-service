package com.upc.edu.pe.service;

import com.upc.edu.pe.entity.Disccount;

public interface DisccountService extends CrudServices<Disccount,Long> {
    Disccount getDisccountById(Long menuId);
}
