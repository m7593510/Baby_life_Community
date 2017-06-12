package com.example.bingzhong.baby_life_community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoveadoptionFragment extends Fragment {
    private Gallery gal_show;
    private ImageView ima_love;
    private ImageButton Btn_next,Btn_adopt;
    private TextView text_love;
    private ImageButton ima_back_love;
    public int x = -1;
    String[] m_name = {"小黑","小乖","小橘貓","寶利發母貓"};
    String[] m_locate = {"銘傳校區","銘傳校區","龜山區公所","寶利發D棟"};
    String[] m_category ={"米克斯犬","米克斯犬","米克斯","米克斯"};
    String[] m_grow = {"否","是","否","否"};

    int[] m_ids = new int[]{R.drawable.black_black,R.drawable.cute_dog,R.drawable.little_cat,R.drawable.boo_cat};

    private AdoptionFragment interaction;

    public LoveadoptionFragment() {
        // Required empty public constructor
    }
    private void processViews(View view){
        gal_show = (Gallery)view.findViewById(R.id.gal_show);
        ima_love =(ImageView) view.findViewById(R.id.ima_love);
        Btn_next =(ImageButton) view.findViewById(R.id.Btn_next);
        Btn_adopt =(ImageButton) view.findViewById(R.id.Btn_adopt);
        text_love =(TextView) view.findViewById(R.id.textlove);
        ima_back_love = (ImageButton)view.findViewById(R.id.ima_back_love);
    }
    private void back(){
        ima_back_love.setOnClickListener(new View.OnClickListener() {
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
        View view = inflater.inflate(R.layout.fragment_loveadoption, container, false);
        processViews(view);
        back();
        Btn_adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "我們將與你聯絡 !", Toast.LENGTH_SHORT).show();
            }
        });
        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                x %= m_ids.length;
                ima_love.setImageResource(m_ids[x]);
                text_love.setText("名字:  " + m_name[x] + "\r\n出現地點:  " + m_locate[x] + "\r\n種類:  " + m_category[x] +"\r\n是否結紮:  " + m_grow[x]);
            }
        });

        MyAdapter ada =new MyAdapter(getActivity());

        gal_show.setAdapter(ada);
        gal_show.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override public void onNothingSelected(AdapterView<?> parent){}
            @Override public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
                x=position;
                x %= m_ids.length;
                ima_love.setImageResource(m_ids[x]);
                text_love.setText("名字:  " + m_name[x] + "\r\n出現地點:  " + m_locate[x] + "\r\n種類:  " + m_category[x] +"\r\n是否結紮:  " + m_grow[x]);
            }
        });
        Btn_next.callOnClick();
        gal_show.setSelection(Integer.MAX_VALUE/2);
        return view;

    }
    public class MyAdapter extends BaseAdapter {
        Context y;

        public MyAdapter(Context ctx) {
            y = ctx;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }


        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView iv = new ImageView(y);
            iv.setImageResource(m_ids[position % m_ids.length]);
            iv.setLayoutParams(new Gallery.LayoutParams(45,60));
            return iv;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            interaction = (AdoptionFragment) context;
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }

    public interface AdoptionFragment{

    }


}
