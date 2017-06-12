package com.example.bingzhong.baby_life_community;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionFragment extends Fragment {
    private ImageButton ima_facebook,ima_animal,ima_fund;
    private ImageButton ima_back_introduction;


    public IntroductionFragment() {
        // Required empty public constructor
    }

    private void processViews(View view){
        ima_facebook = (ImageButton)view.findViewById(R.id.ima_facebook);
        ima_animal = (ImageButton)view.findViewById(R.id.ima_animal);
        ima_back_introduction = (ImageButton)view.findViewById(R.id.ima_back_introduction);
        ima_fund = (ImageButton)view.findViewById(R.id.ima_fund);
    }

    private void back(){
        ima_back_introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ShowFragment.getInstance("") , "do");
                transaction.commit();
            }
        });
    }
    private void openweb(){
        ima_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/cherish.animal/");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
        ima_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://animal.coa.gov.tw/html/");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
        ima_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://animal.coa.gov.tw/html/");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduction, container, false);
        processViews(view);
        back();
        openweb();
        return view;
    }

}
