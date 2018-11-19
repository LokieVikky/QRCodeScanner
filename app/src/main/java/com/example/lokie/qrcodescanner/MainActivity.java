package com.example.lokie.qrcodescanner;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import java.util.List;


public class MainActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {
    QRCodeReaderView barcodeReader;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeReader=findViewById(R.id.qrdecoderview);
        barcodeReader.setOnQRCodeReadListener(this);
        barcodeReader.setQRDecodingEnabled(true);

        barcodeReader.setAutofocusInterval(2000L);
        barcodeReader.setBackCamera();
    }


    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        barcodeReader.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        barcodeReader.stopCamera();
    }

    public void flash(View view) {
        if(i==0) {
            barcodeReader.setTorchEnabled(true);
            i = 1;
        }
        else {
            barcodeReader.setTorchEnabled(false);
            i = 0;
        }
    }
}
