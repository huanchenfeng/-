package com.meng.reggie.contrller;

import com.meng.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/Setmeal")
public class SetmealController {
    @Autowired
    private static SetmealService setmealService;
}
