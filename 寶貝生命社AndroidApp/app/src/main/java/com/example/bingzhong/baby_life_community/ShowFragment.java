package com.example.bingzhong.baby_life_community;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.jar.Attributes;

/**
 * Created by BingZhong on 2016/12/15.
 */
public class ShowFragment extends Fragment{
    private ImageButton im1;
    private ImageButton im2;
    private ImageButton im3;
    private ImageButton im4;
    private ImageButton im5;
    private ImageButton im6;
    private String content;


    private FragmentInteraction interaction;


    public static ShowFragment getInstance(String content){
        ShowFragment fragment = new ShowFragment();
        Bundle bundle = new Bundle();  //給Fragment包裹資料
        bundle.putString("Content",content);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ( getArguments() != null ){
            //如果有包裹就替換內容
            content = getArguments().getString("Content");

        }
    }

    private void processViews(View v){
        im1 = (ImageButton) v.findViewById(R.id.image_1);
        im2 = (ImageButton) v.findViewById(R.id.image_2);
        im3 = (ImageButton) v.findViewById(R.id.image_3);
        im4 = (ImageButton) v.findViewById(R.id.image_4);
        im5 = (ImageButton) v.findViewById(R.id.image_5);
        im6 = (ImageButton) v.findViewById(R.id.image_6);


        im1.setOnClickListener(chilcdOnClick);
        im2.setOnClickListener(chilcdOnClick);
        im3.setOnClickListener(chilcdOnClick);
        im4.setOnClickListener(chilcdOnClick);
        im5.setOnClickListener(chilcdOnClick);
        im6.setOnClickListener(chilcdOnClick);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home,null);
        processViews(view);

        return view ;

    }


    private View.OnClickListener chilcdOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /****叫Activity把子頁面換上來***/
            int id = view.getId();
            interaction.clickChildPage(id);
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interaction = (FragmentInteraction) context;
        }catch(Exception err){
            err.printStackTrace();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }



    public interface FragmentInteraction{
        void clickChildPage(int id);  //選擇子頁面
    }
}
