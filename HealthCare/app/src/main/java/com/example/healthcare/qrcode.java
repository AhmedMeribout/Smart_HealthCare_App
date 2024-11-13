package com.example.healthcare;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrcode extends AppCompatActivity {
    ImageView qr;
    public void goback(View view) {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#3FAA81");
        window.setStatusBarColor(colorCodeDark);
        setContentView(R.layout.activity_qrcode);
        qr=findViewById(R.id.imageView);
        SharedPreferences address= getSharedPreferences("address",MODE_PRIVATE);
        String address__=address.getString("address_without","");
        SharedPreferences sharedPreferences= getSharedPreferences("login",MODE_PRIVATE);


        String id=sharedPreferences.getString("id","");
        String url_user=address__+"doctor/test/sidebar-01/user.php?doctor=1&id="+id;


        generateQR(url_user);
    }
    private void generateQR(String url_user)
    {
        SharedPreferences sharedqr= getSharedPreferences("qr",MODE_PRIVATE);
        String qrinfo =sharedqr.getString("qrinfo","");
        String firstname =sharedqr.getString("firstname","");
        String lastname =sharedqr.getString("lastname","");
        String birth =sharedqr.getString("birth","");
        String gender =sharedqr.getString("gender","");
        String address =sharedqr.getString("address","");
        String phone =sharedqr.getString("phone","");
        String height =sharedqr.getString("height","");
        String weight =sharedqr.getString("weight","");
        String bloodtype =sharedqr.getString("bloodtype","");
        String text = "FIRSTNAME:"+firstname+"\n"+"lastname:"+lastname+"\n"+"birth:"+birth+"\n"+
                "gender:"+gender+"\n"+
                "address:"+address+"\n"+"phone:"+phone+"\n"+
                "height:"+height+"\n"+"weight:"+weight+"\n"+"bloodtype:"+bloodtype+"\n"+
                url_user+"\n";
        MultiFormatWriter writer = new MultiFormatWriter();
        try
        {
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE,600,600);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            qr.setImageBitmap(bitmap);

        } catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}