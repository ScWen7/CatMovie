package com.atguigu.cateyesmovie.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.view.MyEditText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 解晓辉  on 2016/12/6 10:42 *
 * QQ  ：811733738
 * 作用:
 */

public class PhoneLoginFragment extends Fragment {
    @Bind(R.id.et_login_phone)
    MyEditText etLoginPhone;
    @Bind(R.id.tv_getyanzheng)
    TextView tvGetyanzheng;
    @Bind(R.id.et_login_pwd)
    MyEditText etLoginPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.argee)
    TextView argee;
    /**
     * 手机号输入框
     */
    private EditText et_phone;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码输入框
     */
    private EditText et_pwd;

    private SpannableStringBuilder ssb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_login, container, false);
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
                if(phone.length()!=11) {
                    tvGetyanzheng.setEnabled(false);
                }else{
                    tvGetyanzheng.setEnabled(true);
                }
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
                if(TextUtils.isEmpty(pwd)|| TextUtils.isEmpty(phone)||phone.length()!=11||pwd.length()!=6) {
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
        et_phone.setHint("仅支持中国大陆手机号");

        //密码
        et_pwd = etLoginPwd.et_search;
        et_pwd.setHint("请输入验证码");
        et_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        ssb  = new SpannableStringBuilder("登录代表你同意《美团网用户协议》 ");
        ssb.setSpan(new URLSpan("http://www.atguigu.com"), 7, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new ForegroundColorSpan(Color.LTGRAY), 7, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        argee.setMovementMethod(LinkMovementMethod.getInstance());// 让链接的点击事件响应的必要一句代码
        argee.setText(ssb);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
