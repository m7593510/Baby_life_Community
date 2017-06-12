package com.example.bingzhong.baby_life_community;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmuggleFragment extends Fragment implements View.OnClickListener{
    private ImageView showImg;
    private EditText input_category,input_trait,input_locate,input_time;
    private ImageButton inputBtn;
    private TextView text_category,text_trait,text_locate,text_time;
    private ImageButton ima_back_smuggle,cameraBtn;

    private  InteractionCamera interactionCamera;

    public SmuggleFragment() {
        // Required empty public constructor
    }

    public void setShowImgPicture(Bitmap bitmap){
        showImg.setImageBitmap(bitmap);
    }

    private void processViews(View view){
        showImg = (ImageView) view.findViewById(R.id.imageview_smuggle);
        cameraBtn = (ImageButton) view.findViewById(R.id.camera_intentBTN_smuggle);
        text_category = (TextView)view.findViewById(R.id.text_category);
        text_trait = (TextView)view.findViewById(R.id.text_trait);
        text_locate = (TextView)view.findViewById(R.id.text_locate);
        text_time = (TextView)view.findViewById(R.id.text_time);
        inputBtn = (ImageButton)view.findViewById(R.id.camera_inputExit);
        ima_back_smuggle = (ImageButton)view.findViewById(R.id.ima_back_smuggle);
    }

    private void back(){
        ima_back_smuggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ShowFragment.getInstance("") , "do");
                transaction.commit();
            }
        });
    }


    private void processController(){
        cameraBtn.setOnClickListener(this);
        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });
    }
    private void customDialog(){
        final View item = LayoutInflater.from(getActivity()).inflate(R.layout.diago_summgle, null);
        new AlertDialog.Builder(getActivity())
                .setTitle("輸入資訊")
                .setView(item)
                .setPositiveButton("完成", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText input_category = (EditText) item.findViewById(R.id.input_種類);
                        EditText input_trait = (EditText) item.findViewById(R.id.input_特徵);
                        EditText input_locate = (EditText)item.findViewById(R.id.input_所在地);
                        EditText input_time = (EditText)item.findViewById(R.id.input_時間);
                        String getcategory,gettrait,getlocate,gettime;
                        getcategory = input_category.getText().toString();
                        text_category.setText("種類: "+getcategory);
                        gettrait = input_trait.getText().toString();
                        text_trait.setText("特徵: "+gettrait);
                        getlocate = input_locate.getText().toString();
                        text_locate.setText("所在地: "+getlocate);
                        gettime = input_time.getText().toString();
                        text_time.setText("走失時間: "+gettime);
                    }
                })
                .show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smuggle, container, false);
        processViews(view);
        processController();
        back();
        return view;
    }

    @Override
    public void onClick(View view) {
        /*****開相機****/
        interactionCamera.openCamera();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interactionCamera = (InteractionCamera)context;
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionCamera = null;
    }

    public interface InteractionCamera{
        void openCamera();  // 開啟相機
        void setImageViewInFragment(Bitmap bmp); //設定照片
    }
}
