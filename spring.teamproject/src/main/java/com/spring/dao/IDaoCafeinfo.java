package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.ModelCafeinfo;

@Repository
public interface IDaoCafeinfo {
     
    List<ModelCafeinfo> getCafeList(ModelCafeinfo cafebigtype, String orderKind );
    List<ModelCafeinfo> getCafeListName(String name);
    List<ModelCafeinfo> getCafeListAddr(String addr);
    ModelCafeinfo getCafeOne(ModelCafeinfo cafeinfo);
}
