package com.jwllls.mvpdemo.contract;

import com.jwllls.mvpdemo.base.BasePresenter;
import com.jwllls.mvpdemo.base.BaseView;

/**
 * Created by jwllls on 2017/11/8.
 */

public class LoginContract {

    public interface View extends BaseView<Presenter> {
        //这里可以定义与 View 相关的方法

        void showLoading();  // 显示加载

        void dismissLoading();  // 隐藏加载

        void toastSucMsg(); // 提示登录成功消息

        void toastFailMsg();// 提示登录失败

    }


    public interface Presenter extends BasePresenter {
        // 这里可以定义逻辑相关的方法，如请求网络数据或本地数据库的数据等。

        void userLogin(String username, String password); // 定义一个登录方法， 模拟用户请求网络数据进行登录

    }

}
