package com.spring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.model.ModelCafeMenu;

public interface IDaoCafeMenu {
    
    List<ModelCafeMenu> getCafeMenu(int cafeno);
    
}
