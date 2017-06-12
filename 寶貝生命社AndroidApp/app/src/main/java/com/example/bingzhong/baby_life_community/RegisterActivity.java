package com.example.bingzhong.baby_life_community;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText account,password;
    private SQLiteDatabase db = MainActivity.db;
    public static final String TABLE_NAME = "myTable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        account = (EditText)findViewById(R.id.account);
        password = (EditText)findViewById(R.id.password);
    }
    public void registerConfirm(View v){
        String A = account.getText().toString();
        String B = password.getText().toString();
        //註冊成功 把帳號放進資料庫
        // insert into TABLE_NAME (account) values ('reg')
        db.execSQL("insert into "+TABLE_NAME+" (account,password) values ('"+A+"','"+B+"')");
        Log.d("myLog","insert into "+TABLE_NAME+" (account,password) values ('"+A+"','"+B+"')");

        finish();
    }
}
