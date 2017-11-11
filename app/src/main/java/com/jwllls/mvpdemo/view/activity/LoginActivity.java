package com.jwllls.mvpdemo.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jwllls.mvpdemo.R;
import com.jwllls.mvpdemo.contract.LoginContract;
import com.jwllls.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;

    private ProgressDialog progressDialog;

    private EditText et_username, et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        presenter = new LoginPresenter(this, this);  //第一个参数为 LoginContract.View , 第二个参数为上下文 activity

        progressDialog = new ProgressDialog(this);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.userLogin(et_username.getText().toString(), et_password.getText().toString());
            }
        });
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toastSucMsg() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toastFailMsg() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

}
