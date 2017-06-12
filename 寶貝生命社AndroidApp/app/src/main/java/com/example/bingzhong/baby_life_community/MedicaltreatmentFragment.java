package com.example.bingzhong.baby_life_community;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import static android.R.attr.colorBackground;
import static android.R.attr.data;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicaltreatmentFragment extends Fragment {
    private ImageButton ima_back_medical;
    private ListView list_medical;
    private String[] list = {"欣欣","湖光","新世紀"};
    private ArrayAdapter<String> listAdapter;

    private TreatmentFragment interaction;


    public MedicaltreatmentFragment() {
        // Required empty public constructor
    }
    private void processViews(View view){
            ima_back_medical = (ImageButton)view.findViewById(R.id.ima_back_medical);
            list_medical = (ListView)view.findViewById(R.id.list_medical);
    }
    private void listview(){
            listAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);
            list_medical.setAdapter(listAdapter);

    }
    private void back(){
        ima_back_medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ShowFragment.getInstance("") , "do");
                transaction.commit();
            }
        });
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicaltreatment, container, false);
        processViews(view);
        listview();
        list_medical.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        new AlertDialog.Builder(getActivity())
                                .setTitle("欣欣動物醫院")
                                .setMessage("")
                                .setPositiveButton("前往網站", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri = Uri.parse("http://www.sinsin-pet.com.tw/");
                                        Intent i0=new Intent(Intent.ACTION_VIEW,uri);
                                        startActivity(i0);
                                    }
                                })
                                .setNeutralButton("電話", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri = Uri.parse("tel:033500683");
                                        Intent a0=new Intent(Intent.ACTION_DIAL,uri);
                                        startActivity(a0);
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .show();
                        break;

                    case 1:
                        new AlertDialog.Builder(getActivity())
                                .setTitle("湖光動物醫院")
                                .setMessage("備註: 可以申請免費結紮喲!")
                                .setPositiveButton("前往網站", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri1 = Uri.parse("https://www.facebook.com/%E6%B9%96%E5%85%89%E5%8B%95%E7%89%A9%E9%86%AB%E9%99%A2%E5%8D%97%E5%B4%81%E5%88%86%E9%99%A2-314342308630100/");
                                        Intent i1=new Intent(Intent.ACTION_VIEW,uri1);
                                        startActivity(i1);
                                    }
                                })
                                .setNeutralButton("電話", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri = Uri.parse("tel:033528861");
                                        Intent a1=new Intent(Intent.ACTION_DIAL,uri);
                                        startActivity(a1);
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .show();
                        break;
                    case 2:
                        new AlertDialog.Builder(getActivity())
                                .setTitle("新世紀動物醫院")
                                .setMessage("")
                                .setPositiveButton("前往網站", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri2 = Uri.parse("http://pda.cmoremap.com.tw/edm_detail_pda2.php?userid=73984&lat=24.945425&lon=121.24706");
                                        Intent i2=new Intent(Intent.ACTION_VIEW,uri2);
                                        startActivity(i2);
                                    }
                                })
                                .setNeutralButton("電話", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Uri uri = Uri.parse("tel:033328100");
                                        Intent a2=new Intent(Intent.ACTION_DIAL,uri);
                                        startActivity(a2);
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .show();
                        break;


                }
            }
        });

        back();
        return view;
    }






    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interaction = (MedicaltreatmentFragment.TreatmentFragment) context;
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }

    public interface TreatmentFragment{

    }


}
