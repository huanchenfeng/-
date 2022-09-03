package com.meng.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@Slf4j
public class MyMateObjectHandler implements MetaObjectHandler {
//插入自动填充
    @Override
    public void insertFill(MetaObject metaObject) {

    metaObject.setValue("createTime", LocalDateTime.now());
    metaObject.setValue("updateTime",LocalDateTime.now());
    metaObject.setValue("createUser",BaseContext.getCurrentId());
    metaObject.setValue("updateUser",BaseContext.getCurrentId());


    }
//更新自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("进入");
        long id=Thread.currentThread().getId();
        log.info("线程id为:{}",id);
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());

    }
}
