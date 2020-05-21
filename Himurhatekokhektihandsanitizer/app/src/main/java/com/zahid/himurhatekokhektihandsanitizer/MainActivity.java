package com.zahid.himurhatekokhektihandsanitizer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RewardedVideoAdListener {

    private InterstitialAd mInterstitialAd;
    private InterstitialAd mInterstitialAd2;

    private RewardedVideoAd mRewardedVideoAd;

    int count=0;
    int check_ad=0;
    private long backPressedTime;
    private Toast backToast;
    String[] contents;

    Button homebtn;
    ImageView makeApp;
    TextView tvContent;
    TextView page;
    ImageView fme_fb;
    ImageView lme_fb;
    TextView copy_right;
    GifImageView backHome;



    Button prv;
    Button next;
    Button home;


    Button prv1;
    Button next1;
    Button home1;

    Button prv2;
    Button next2;
    Button home2;

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    LinearLayout layout6;

    LinearLayout lastNxt;
    LinearLayout rupa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7388729690641194/1215665820");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId("ca-app-pub-7388729690641194/6039250114");
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());



        MobileAds.initialize(this, "ca-app-pub-7388729690641194~2556118915");
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener((RewardedVideoAdListener) this);
        loadRewardedVideoAd();}

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-7388729690641194/3855939902",
                new AdRequest.Builder().build());





        onRestart();


        homebtn=findViewById(R.id.homebtn);
        makeApp=findViewById(R.id.make_app);
        tvContent=findViewById(R.id.tvContent);
        page=findViewById(R.id.page);
        lme_fb=findViewById(R.id.lme_fb);
        fme_fb=findViewById(R.id.fme_fb);
        copy_right=findViewById(R.id.copyRight);
        backHome=findViewById(R.id.back_home);


        prv=findViewById(R.id.prv);
        next=findViewById(R.id.next);
        home=findViewById(R.id.home);


        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);
        layout3=findViewById(R.id.layout3);
        layout4=findViewById(R.id.layout4);
        layout5=findViewById(R.id.layout5);
        layout6=findViewById(R.id.layout6);

        rupa=findViewById(R.id.rupa);
        lastNxt=findViewById(R.id.last_next);



        prv1=findViewById(R.id.prv1);
        next1=findViewById(R.id.next1);
        home1=findViewById(R.id.home1);

        prv2=findViewById(R.id.prv2);
        next2=findViewById(R.id.next2);
        home2=findViewById(R.id.home2);

        homebtn.setOnClickListener(this);
        makeApp.setOnClickListener(this);
        lastNxt.setOnClickListener(this);
        fme_fb.setOnClickListener(this);
        lme_fb.setOnClickListener(this);
        rupa.setOnClickListener(this);
        copy_right.setOnClickListener(this);
        backHome.setOnClickListener(this);


        prv.setOnClickListener(this);
        next.setOnClickListener(this);
        home.setOnClickListener(this);


        prv1.setOnClickListener(this);
        next1.setOnClickListener(this);
        home1.setOnClickListener(this);

        prv2.setOnClickListener(this);
        next2.setOnClickListener(this);
        home2.setOnClickListener(this);





        contents=getResources().getStringArray(R.array.contents);


    }


//back on press..
@Override
public void onBackPressed() {
    if (backPressedTime + 2000 > System.currentTimeMillis()) {
        super.onBackPressed();
        return;
    } else {
        backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
        backToast.show();
    }

    backPressedTime = System.currentTimeMillis();
}

//back on press end..

    //Error code here...

    public void checkNetworkConnection(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("No internet Connection");
        builder.setMessage("Please turn on internet connection to continue");
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    public boolean isNetworkConnectionAvailable(){
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        if(isConnected) {
            Log.d("Network", "Connected");
            return true;
        }
        else{
            checkNetworkConnection();
            Log.d("Network","Not Connected");
            return false;
        }
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        isNetworkConnectionAvailable();
    }

    //Error code finished...


    //code for reward ad....

    @Override
    public void onRewarded(RewardItem reward) {

        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }


    //code for reward ad finish ....


    @Override
    public void onClick(View v) {
        onRestart();
        if (v.getId()==R.id.homebtn) {

            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.VISIBLE);

        }else if (v.getId()==R.id.home1){

            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.GONE);

        }else if (v.getId()==R.id.next1){

            layout2.setVisibility(View.GONE);
            layout3.setVisibility(View.VISIBLE);

        }else if (v.getId()==R.id.prv1){
            layout2.setVisibility(View.GONE);
            layout1.setVisibility(View.VISIBLE);
        }else if (v.getId()==R.id.home2){

        layout1.setVisibility(View.VISIBLE);
        layout3.setVisibility(View.GONE);

    }else if (v.getId()==R.id.next2){

            if (mRewardedVideoAd.isLoaded()) {
                mRewardedVideoAd.show();
                check_ad=1;
            }

            tvContent.setText(contents[count]);
            page.setText("page:"+(4+count));
            count++;

        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.VISIBLE);

    }else if (v.getId()==R.id.prv2){
        layout3.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);

    } else if (v.getId()==R.id.home){
        count=0;
            layout1.setVisibility(View.VISIBLE);
            layout4.setVisibility(View.GONE);

    }else if (v.getId()==R.id.next){


    //for show ad....

            if (count==7){

                layout5.setVisibility(View.VISIBLE);
                layout4.setVisibility(View.GONE);
            }else {
                if(count==1){
                    if (check_ad==0){
                        if (mRewardedVideoAd.isLoaded()) {
                            mRewardedVideoAd.show();
                            check_ad=1;
                        }
                    }
                }else if (count==3){
                    mInterstitialAd.show();
                }else if (count==6){
                     if(check_ad==0){
                         if (mRewardedVideoAd.isLoaded()) {
                             mRewardedVideoAd.show();
                             check_ad=1;
                         }
                     }
                }


     //for show ad....(end)


                tvContent.setText(contents[count]);
                page.setText("page:"+(4+count));
                count++;

            }

    }else if (v.getId()==R.id.prv){
        count--;

        if (count==0){

            layout3.setVisibility(View.VISIBLE);
            layout4.setVisibility(View.GONE);

        }else {

            tvContent.setText(contents[count-1]);
            page.setText("page:"+(4+count-1));
        }

    }else if (v.getId()==R.id.last_next){

            layout5.setVisibility(View.GONE);
            layout6.setVisibility(View.VISIBLE);
    }else if (v.getId()==R.id.rupa){

            //method to get the right URL to use in the intent


            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = getFacebookPageUrlRupa(this);
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);

    }else if (v.getId()==R.id.fme_fb||v.getId()==R.id.copyRight){

            //method to get the right URL to use in the intent


            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = getFacebookPageURL(this);
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);


    }else if (v.getId()==R.id.lme_fb||v.getId()==R.id.make_app){

            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + "114758030227687"));
                startActivity(intent);
            } catch (Exception e) {
                Intent intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + "114758030227687"));
                startActivity(intent);
            }

    }else if (v.getId()==R.id.back_home){

            mInterstitialAd2.show();
            layout6.setVisibility(View.GONE);
            layout1.setVisibility(View.VISIBLE);
            count=0;
    }



    }


    //for my fb accout...

    public static String FACEBOOK_URL = "https://www.facebook.com/solaymanislamjahid";
    public static String FACEBOOK_PAGE_ID = "solaymanislamjahid";

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    //for my fb accout...(end)

    //for rupa fb account...


    public static String FACEBOOK_URL_RUPA = "https://www.facebook.com/rupkothar.kobitika";
    public static String FACEBOOK_PAGE_ID_RUPA = "rupkothar.kobitika";

    public String getFacebookPageUrlRupa(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL_RUPA;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID_RUPA;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL_RUPA
                    ; //normal web url
        }
    }


    //for rupa fb account...(end)


}

