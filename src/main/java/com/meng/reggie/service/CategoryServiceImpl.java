package com.meng.reggie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.reggie.entity.Category;
import com.meng.reggie.mapper.Categorymapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<Categorymapper, Category> implements CategoryService {
}
