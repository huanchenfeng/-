package com.meng.reggie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.reggie.entity.Setmeal;
import com.meng.reggie.mapper.Setmealmapper;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<Setmealmapper, Setmeal> implements SetmealService{
}
