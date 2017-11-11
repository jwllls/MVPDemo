package com.jwllls.mvpdemo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.jwllls.mvpdemo.contract.LoginContract;
import com.jwllls.mvpdemo.model.LoginModel;
import com.jwllls.mvpdemo.model.bean.User;
import com.jwllls.mvpdemo.view.activity.MainActivity;

/**
 * Created by jwllls on 2017/11/8.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginModel model;   //用于数据的处理，如网络请求、数据库请求等
    private Activity activity;

    public LoginPresenter(LoginContract.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
        view.setPresenter(this);  //在构造方法中将 Presenter 和 View 绑定
        model = new LoginModel();  //创建UserModel对象
    }

    @Override
    public void onStart() {
        // userLogin  可以在onStar( )进行初始化方法
    }

    @Override
    public void userLogin(String username, String password) {

        User user = model.getUser();   //模拟获得网络请求返回的用户数据

        view.showLoading();  //显示加载窗

        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {  //加入账号密码正确则登录成功

            new Handler().postDelayed(new Runnable() {  //延迟2秒后执行
                @Override
                public void run() {
                    view.toastSucMsg();     //登录成功提示消息
                    view.dismissLoading();  //关闭加载窗
                    activity.startActivity(new Intent(activity, MainActivity.class));  //跳转到主界面
                }
            }, 2000);

        } else {

            new Handler().postDelayed(new Runnable() { //延迟1秒后执行
                @Override
                public void run() {
                    view.toastFailMsg();    //登录失败提示消息
                    view.dismissLoading(); //关闭加载窗
                }
            }, 1000);

        }
    }
}
