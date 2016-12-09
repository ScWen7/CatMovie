package com.atguigu.cateyesmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.view.MyEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 解晓辉  on 2016/12/6 10:42 *
 * QQ  ：811733738
 * 作用:
 */

public class AccountLoginFragment extends Fragment {
    @Bind(R.id.et_login_phone)
    MyEditText etLoginPhone;
    @Bind(R.id.et_login_pwd)
    MyEditText etLoginPwd;

    @Bind(R.id.ib_login_visible)
    ImageButton ibLoginVisible;

    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.forget_pass)
    TextView forgetPass;

    /**
     * 密码是否可见
     */
    private boolean isVisable = false;
    private EditText et_phone;
    private EditText et_pwd;

    private String phone;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        initListener();
    }

    private void initListener() {
        et_phone.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pwd= s.toString();
                if(TextUtils.isEmpty(pwd)|| TextUtils.isEmpty(phone)) {
                    btnLogin.setEnabled(false);
                }else {
                    btnLogin.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void init() {
        //用户名
        et_phone = etLoginPhone.et_search;
        et_phone.setHint("手机/邮箱/用户名");

        //密码
        et_pwd = etLoginPwd.et_search;
        et_pwd.setHint("请输入密码");
        et_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.ib_login_visible)
    void isVisable(View view) {
        isVisable = !isVisable;
        if (isVisable) {
            //密码可见
            ibLoginVisible.setBackgroundResource(R.drawable.a9d);
            et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            et_pwd.setSelection(et_pwd.getText().length());
        } else {
            //密码不可见，passward
            ibLoginVisible.setBackgroundResource(R.drawable.a9_);
            et_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            et_pwd.setSelection(et_pwd.getText().length());
        }
    }
}
