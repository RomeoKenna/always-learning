package com.yfk.spring.lesson001.demo3;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;


public class UserFactoryBean implements FactoryBean<UserModel> {
    int count = 1;

    @Nullable
    @Override
    public UserModel getObject() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setName("我是通过FactoryBean创建的第" + count++ + "对象");
        return userModel;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
