package com.example.jialebao02.jialebao_ms_informalversion.activity;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jialebao02.jialebao_ms_informalversion.R;
import com.example.jialebao02.jialebao_ms_informalversion.util.SaveUserPwdUtil;
import com.example.jialebao02.jialebao_ms_informalversion.widget.CustomProgressDialog;

import java.util.LinkedList;

import butterknife.Bind;

public class WelcomeActivity extends AppCompatActivity {

    @Bind(R.id.rg_title)
    private RadioGroup rg_title;
    @Bind(R.id.system_send)
    private RadioButton rb_systemSend;
    @Bind(R.id.system_manager)
    private RadioButton rb_systemManager;
    @Bind(R.id.username)
    private EditText et_userName;
    @Bind(R.id.dropdown_button)
    private ImageButton ib_dropDwon;
    @Bind(R.id.password)
    private EditText et_password;
    @Bind(R.id.remember)
    private CheckBox cb_remember;
    @Bind(R.id.login)
    private Button bt_login;

    SharedPreferences sp; //保存密码
    private SaveUserPwdUtil pwdUtil;
    private int recordType=0; // 0表示售货员 1表示管理系统入口
    private IntentFilter intentFilter;
    private CustomProgressDialog customProgressDialog;
    private PopupWindow popupWindow;
    private ListView listView;
    private LinkedList<String> userName;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}
