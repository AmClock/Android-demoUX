package com.example.demohf.presenter;
import android.text.TextUtils;
import com.example.demohf.contract.LoginContract;
import com.example.demohf.local.interator.LoginInterator;
import com.example.demohf.local.vo.Result;

public class LoginPresenter implements LoginContract.LoginPresenter {

    private LoginContract.LoginView view;

    public LoginPresenter(){

    }

    public LoginPresenter(LoginContract.LoginView view){
        this.view = view;
        // model
    }

    @Override
    public Result loginCheck(String id, String pwd) {
        if(TextUtils.isEmpty(id)){
            view.onError("ID");
            return new Result("false");
        }else if(TextUtils.isEmpty(pwd)){
            view.onError("PASSWORD");
            return new Result("false");
        }else{
            try {
                String url="";
                return new LoginInterator().execute(url).get();
            }catch (Exception e){
                e.printStackTrace();
                return new Result("false");
            }//Exception end
        }

    }//checkLogin end

}
