package com.example.bingzhong.baby_life_community;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialsharingFragment3 extends Fragment {
    private ImageButton ima_back_share,supply5,supply6,ima_left,ima_right;
    private ImageButton Btn_buy5,Btn_buy6;
    private TextView goods_name,goods_money;
    private EditText edit_number;


    private SharingFragment3 interaction;
    public MaterialsharingFragment3() {
        // Required empty public constructor
    }

    private void back(){
        ima_back_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ShowFragment.getInstance("") , "do");
                transaction.commit();
            }
        });
    }

    private void processViews(View view){
        supply5 = (ImageButton) view.findViewById(R.id.supply5);
        supply6 = (ImageButton) view.findViewById(R.id.supply6);
        ima_left = (ImageButton) view.findViewById(R.id.ima_left);
        ima_right = (ImageButton) view.findViewById(R.id.ima_right);
        ima_back_share = (ImageButton)view.findViewById(R.id.ima_back_share);

        Btn_buy5 = (ImageButton) view.findViewById(R.id.Btn_buy5);
        Btn_buy6 = (ImageButton) view.findViewById(R.id.Btm_buy6);

    }

    private void processController(){
        supply5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }

        });
        supply6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
    private void Touch(){
        Btn_buy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonController();
            }
        });
        Btn_buy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonController2();
            }
        });
    }


    private void ButtonController(){
        final View item1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_good, null);
        new AlertDialog.Builder(getActivity())
                .setView(item1)
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(item1.getContext(), "選購成功，近期將會聯絡你", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();

        goods_name = (TextView)item1.findViewById(R.id.goods_name);
        goods_money = (TextView)item1.findViewById(R.id.goods_money);
        edit_number = (EditText)item1.findViewById(R.id.edit_number);
        goods_name.setText("商品名稱: "+"博士巧斯(幼犬專用)");
        goods_money.setText("商品價格: "+"1460元");

    }

    private void ButtonController2(){
        final View item2 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_good2, null);
        new AlertDialog.Builder(getActivity())
                .setView(item2)
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(item2.getContext(), "選購成功，近期將會聯絡你", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
        goods_name = (TextView)item2.findViewById(R.id.goods_name);
        goods_money = (TextView)item2.findViewById(R.id.goods_money);
        edit_number = (EditText)item2.findViewById(R.id.edit_number);
        goods_name.setText("商品名稱: "+"博士巧斯(成犬專用)");
        goods_money.setText("商品價格: "+"1400元");
    }
    private void right_left(){
        ima_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, new MaterialsharingFragment2(), "Materialsharing2");
                transaction.commit();
            }
        });
        ima_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, new MaterialsharingFragment4() , "Materialsharing4");
                transaction.commit();
            }
        });
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materialsharing_fragment3, container, false);
        processViews(view);
        processController();
        Touch();
        right_left();
        back();
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interaction = (SharingFragment3) context;
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }

    public interface SharingFragment3{

    }

}
