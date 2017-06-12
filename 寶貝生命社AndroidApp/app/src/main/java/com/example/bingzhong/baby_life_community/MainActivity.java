package com.example.bingzhong.baby_life_community;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private EditText inputA,inputB;
    public static SQLiteDatabase db;
    public static final String FILE_NAME = "myDatabase.db";
    public static final String TABLE_NAME = "myTable";
    private void init(){
        db = openOrCreateDatabase(FILE_NAME,MODE_PRIVATE,null);
        //Create table if not exists TABLE_NAME  (_id INTEGER PRIMARY KEY ,account TEXT )
        db.execSQL("Create table if not exists "+ TABLE_NAME +" (_id INTEGER PRIMARY KEY ," +"account TEXT ,"+"password TEXT) ");
    }
    private void processViews(){
        inputA = (EditText)findViewById(R.id.inputA);
        inputB = (EditText)findViewById(R.id.inputB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processViews();
        init();
        //secret();
    }
    public void LogInOnClick(View v){
        String inputX = inputA.getText().toString();
        String inputY = inputB.getText().toString();
        if ( inputX.length() == 0 || inputY.length() ==0)
            Toast.makeText(getApplicationContext(), "欄位不為0", Toast.LENGTH_SHORT).show();
        else
        {
            Cursor cursor;
            //select account from TABLENAME where account = input
            cursor = db.rawQuery("select * from "+TABLE_NAME+" where account = '"+inputX+"' and password='"+inputY+"'",null);
            Log.d("myLog","select * from "+TABLE_NAME+" where account = '"+inputX+"' and password='"+inputY+"'");
            //確認有沒有找到對應的帳號
            if ((cursor.getCount() == 0 || cursor == null))
                Toast.makeText(getApplicationContext(),"帳號密碼不存在!!", Toast.LENGTH_SHORT).show();
            else
            {
                Toast.makeText(getApplicationContext(),"登入成功!!", Toast.LENGTH_SHORT).show();
                Log(v);
            }

        }

    }

    /*private void secret(){
        findViewById(R.id.textname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("111")
                        .setMessage("1111")
                        .setPositiveButton("Y", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("N", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        });
    }*/

    //註冊
    public void registerOnC(View v){
        Intent intent  = new Intent();
        intent.setClass(this,RegisterActivity.class);
        startActivity(intent);
    }
    //登入
    public void Log(View v){
        Intent intent  = new Intent();
        intent.setClass(this,DrawActivity.class);
        startActivity(intent);
    }
    //訪客登入
    /*public void visitOnC(View v){
        Intent intent  = new Intent();
        intent.setClass(this,DrawActivity.class);
        startActivity(intent);

    }*/


}
