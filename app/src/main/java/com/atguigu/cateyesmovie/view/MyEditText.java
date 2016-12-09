package com.atguigu.cateyesmovie.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.atguigu.cateyesmovie.R;

/**
 * Created by 解晓辉  on 2016/12/6 11:03 *
 * QQ  ：811733738
 * 作用:
 */

public class MyEditText extends LinearLayout  {
    private Context context;
    private LayoutInflater inflater;
    /**
     * 搜索框控件
     */
    public EditText et_search;
    /**
     * 清除按钮
     */
    private ImageView iv_search_clear;

    public MyEditText(Context context) {
        this(context, null);

    }

    public MyEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        inflater = LayoutInflater.from(context);
        initView();
        initListener();
    }

    private void initListener() {
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String content = s.toString();
                if (TextUtils.isEmpty(content)) {
                    iv_search_clear.setVisibility(GONE);
                } else {
                    iv_search_clear.setVisibility(VISIBLE);
                }
            }
        });
        iv_search_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                et_search.setText("");
                iv_search_clear.setVisibility(GONE);
            }
        });
    }

    private void initView() {
        View searchView = inflater.inflate(R.layout.my_edit_text, this);
        et_search = (EditText) searchView.findViewById(R.id.et_search);
        iv_search_clear = (ImageView) searchView.findViewById(R.id.iv_search_clear);
    }


}
