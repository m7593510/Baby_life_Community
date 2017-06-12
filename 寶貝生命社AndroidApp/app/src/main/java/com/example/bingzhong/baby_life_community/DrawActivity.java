package com.example.bingzhong.baby_life_community;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrawActivity extends AppCompatActivity implements ShowFragment.FragmentInteraction , SmuggleFragment.InteractionCamera , LoveadoptionFragment.AdoptionFragment , MaterialsharingFragment.SharingFragment , messageFragment.meFragment , MedicaltreatmentFragment.TreatmentFragment , MaterialsharingFragment2.SharingFragment2 , MaterialsharingFragment3.SharingFragment3 , MaterialsharingFragment4.SharingFragment4{
    private String[] datas = {"首頁","登出","製作團隊"};
    private final String mDrawerTitle = "目錄";
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;  //抽屜按鈕偵聽
    private DrawerLayout mDrawer;
    private ListView mListView;

    private void processViews(){
        mListView = (ListView)findViewById(R.id.mylist);
        mDrawer = (DrawerLayout)findViewById(R.id.activity_draw);
    }

    private void processController(){
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new MyListViewListener());
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawer , R.string.open, R.string.close){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawer.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        processViews();
        processController();

        //預設選擇第0個資料 "A"
        if(savedInstanceState == null)
            selectItem(0);

        //playMP3();

    }



    @Override
    public void clickChildPage(int id) {
        /***換上子頁面***/
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(id){
            case R.id.image_1:
                fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new SmuggleFragment() , "smuggle")
                        .commit();
                break;
            case R.id.image_2:
               fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new MaterialsharingFragment() , "Materialsharing")
                        .commit();
                break;
            case R.id.image_3:
                fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new LoveadoptionFragment() , "Loveadoption")
                        .commit();
                break;
            case R.id.image_4:
               fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new IntroductionFragment() , "Introduction")
                        .commit();
                break;
            case R.id.image_5:
                fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new MedicaltreatmentFragment() , "Medicaltreatment")
                        .commit();
                break;
            case R.id.image_6:
               fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, new messageFragment() , "message")
                        .commit();
                break;
        }
    }

    @Override
    public void openCamera() {
        Intent intent_camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent_camera, 0);
    }

    @Override
    public void setImageViewInFragment(Bitmap bmp) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SmuggleFragment smuggle = (SmuggleFragment) fragmentManager.findFragmentByTag("smuggle");
        //LoveadoptionFragment adoption = (LoveadoptionFragment) fragmentManager.findFragmentByTag("Loveadoption");
        smuggle.setShowImgPicture(bmp);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //拍照後顯示圖片
        if (resultCode == RESULT_OK)
        {

            //取出拍照後回傳資料
            Bundle extras = data.getExtras();
            //將資料轉換為圖像格式
            Bitmap bmp = (Bitmap) extras.get("data");

            setImageViewInFragment(bmp);
        }

        //覆蓋原來的Activity
        super.onActivityResult(requestCode, resultCode, data);
    }



    /**ListView偵聽器**/
    private class MyListViewListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }
    }

    //選擇Item觸發顯示Fragment
    private void selectItem(int position){
        switch(position)
        {
            case 0:  //home page
                mDrawer.closeDrawer(mListView);  //然後關閉抽屜
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace( R.id.content_frame, ShowFragment.getInstance("") , "do")
                        .commit();
                break;
            case 1:  // log out
                finish();
                break;
            case 2: //team
                new AlertDialog.Builder(DrawActivity.this)
                        .setTitle("製作團隊")
                        .setMessage("洪賓忠、甘佳加、梅雪禎")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

        }

    }

    @Override  //改變標題
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
      /*  boolean drawerOpen = mDrawer.isDrawerOpen(mListView);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);*/
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        }
        else
            mDrawer.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

    private void playMP3(){

        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.maplestory);
        mediaPlayer.start();
    }
}
