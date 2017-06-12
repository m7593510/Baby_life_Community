package com.example.bingzhong.baby_life_community;


import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.method.Touch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class messageFragment extends Fragment {
    private TextView Touchtext,showName,showMessage;
    private ImageButton ima_back_me;



    private meFragment interaction;

    public messageFragment() {
        // Required empty public constructor
    }

    private void back(){
        ima_back_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ShowFragment.getInstance("") , "do");
                transaction.commit();
            }
        });
    }

    private void processViews(View view){
        Touchtext = (TextView) view.findViewById(R.id.Touchtext);
        showName = (TextView) view.findViewById(R.id.showName);
        showMessage = (TextView) view.findViewById(R.id.showMessage);
        ima_back_me = (ImageButton)view.findViewById(R.id.ima_back_me);
    }

    private void Touch(){
        Touchtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });
    }
    private void customDialog(){
        final View item = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        new AlertDialog.Builder(getActivity())
                .setTitle("留言版")
                .setView(item)
                .setPositiveButton("送出留言", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText inputName = (EditText) item.findViewById(R.id.inputName);
                        EditText inputMessage = (EditText) item.findViewById(R.id.inputMessage);
                        String getName,getMessage;
                        getName = inputName.getText().toString();
                        showName.setText("名字: "+getName);
                        getMessage = inputMessage.getText().toString();
                        showMessage.setText("留言: "+getMessage);
                    }
                })
                .show();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        processViews(view);
        Touch();
        back();
        return view;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interaction = (messageFragment.meFragment) context;
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }

    public interface meFragment{

    }

}
