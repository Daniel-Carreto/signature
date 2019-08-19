package com.danycarreto.signature;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private SignatureView signatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signatureView = (SignatureView) findViewById(R.id.signature_view);
        findViewById(R.id.signature_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSignature();
            }
        });
    }

    private void sendSignature() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        signatureView.getSignatureBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();
    }
}
