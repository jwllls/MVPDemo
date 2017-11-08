package com.jwllls.mvpdemo.base;

/**
 * Created by jwllls on 2017/11/8.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);  //用于绑定View

}
