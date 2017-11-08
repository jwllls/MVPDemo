package com.jwllls.mvpdemo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.jwllls.mvpdemo.contract.LoginContract;
import com.jwllls.mvpdemo.model.UserModel;
import com.jwllls.mvpdemo.model.bean.User;
import com.jwllls.mvpdemo.view.activity.MainActivity;

/**
 * Created by jwllls on 2017/11/8.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private UserModel model;
    private Activity activity;

    public LoginPresenter(LoginContract.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
        view.setPresenter(this);  //在构造方法中将 Presenter 和 View 绑定
        model = new UserModel();  //创建UserModel对象
    }

    @Override
    public void onStart() {
        // userLogin  可以在onStar( )进行初始化方法
    }


    @Override
    public void userLogin(String username, String password) {

        User user = model.getUserModel();

        view.showLoading();

        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.toastSucMsg();
                    view.dismissLoading();
                    activity.startActivity(new Intent(activity, MainActivity.class));  //跳转到主界面
                }
            }, 2000);

        } else {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.toastFailMsg();
                    view.dismissLoading();
                }
            }, 1000);

        }
    }
}
