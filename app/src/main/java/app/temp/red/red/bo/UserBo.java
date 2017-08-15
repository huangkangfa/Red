package app.temp.red.red.bo;

import com.hkf.coffee.http.HttpManager;
import com.hkf.coffee.http.base.HttpParams;
import com.hkf.coffee.http.base.ResultCallBack;

import app.temp.red.red.global.AllURL;

/**
 * 用户相关业务
 * Created by huangkangfa on 2017/8/15.
 */
public class UserBo {
    //登录
    public static void login(String tel, String pwd, ResultCallBack callback){
        HttpParams params=new HttpParams();
        params.put("tel",tel);
        params.put("pwd",pwd);
        HttpManager.getHttp().httpsPost(1, AllURL.LOGIN,params,callback);
    }
}
