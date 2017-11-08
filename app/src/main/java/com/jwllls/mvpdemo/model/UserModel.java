package com.jwllls.mvpdemo.model;

import com.jwllls.mvpdemo.model.bean.User;

/**
 * Created by jwllls on 2017/11/8.
 */

public class UserModel {


    //在Model中进行具体的数据操作，如请求网络数据或请求数据库的数据等等。


    /**
     * 在这定义一个获取用户对象的方法
     */
    public User getUserModel() {

        //假设从服务器上获取到的对象是User

        User user = new User();

        user.setUsername("admin");
        user.setPassword("12345");

        return user;

    }

}
