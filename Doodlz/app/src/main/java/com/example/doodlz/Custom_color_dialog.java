package com.example.doodlz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Custom_color_dialog extends LinearLayout {
    Context context;
    TextView txtAlpha,txtRed,txtGreen,txtBlue,txtLine;
    SeekBar skbAlpha,skbRed,skbGreen,skbBlue,skbLine;
    Button btnOk;
    ImageView imgTableLine;

    private int alpha = 0;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int line = 0;


    public Custom_color_dialog(Context context) {
        super(context);
    }

    public Custom_color_dialog(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        this.context = context;
        IntializeLayout();

        skbAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alpha = progress;
                CreateLine(alpha,red,green,blue,line);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                CreateLine(alpha,red,green,blue,line);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                CreateLine(alpha,red,green,blue,line);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                CreateLine(alpha,red,green,blue,line);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skbLine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                line = progress;
                CreateLine(alpha,red,green,blue,line);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public Custom_color_dialog(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private void IntializeLayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.color_dialog,this);

        txtAlpha = view.findViewById(R.id.txtAlpha);
        txtRed = view.findViewById(R.id.txtRed);
        txtGreen = view.findViewById(R.id.txtGreen);
        txtBlue = view.findViewById(R.id.txtBlue);
        txtLine = view.findViewById(R.id.txtLine);

        skbAlpha = view.findViewById(R.id.skbAlpha);
        skbRed = view.findViewById(R.id.skbRed);
        skbGreen = view.findViewById(R.id.skbGreen);
        skbBlue = view.findViewById(R.id.skbBlue);
        skbLine = view.findViewById(R.id.skbLine);

        btnOk = view.findViewById(R.id.btnOk);

       imgTableLine = view.findViewById(R.id.imgShowLine);

       CreateLine(0,0,0,0,10);



    }

   public void CreateLine(int vlAlpha,int vlRed,int vlGreen,int vlBlue,int vlLine)
   {
       Bitmap bitmap = Bitmap.createBitmap(1000,300,Bitmap.Config.ARGB_8888);
       Canvas canvas = new Canvas(bitmap);
       Paint paint = new Paint();
       paint.setColor(Color.argb(vlAlpha,vlRed,vlGreen,vlBlue));
       paint.setStrokeWidth(vlLine);
       canvas.drawColor(Color.WHITE);

       canvas.drawLine(0,0,1000,0,paint);
       imgTableLine.setImageBitmap(bitmap);
   }
}
