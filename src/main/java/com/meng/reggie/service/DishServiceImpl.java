package com.meng.reggie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.reggie.entity.Dish;
import com.meng.reggie.mapper.DishMapper;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper,Dish> implements DishService{
}
