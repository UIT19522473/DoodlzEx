package com.example.doodlz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnD;

    private Button btnOk;
    private SeekBar skbAlpha,skbRed,skbGreen,skbBlue,skbLine;

    private int clAlpha,clRed,clGreen,clBlue,clLine;

    private PaintView paintView;

    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintView = findViewById(R.id.paint_view);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);


    }

    private void Dialog_table_color_line(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.table_choose_dialog);
        dialog.show();



        skbLine = (SeekBar)dialog.findViewById(R.id.skbLine);

        skbAlpha = (SeekBar)dialog.findViewById(R.id.skbAlpha);
        skbRed = (SeekBar)dialog.findViewById(R.id.skbRed);
        skbGreen= (SeekBar)dialog.findViewById(R.id.skbGreen);
        skbBlue = (SeekBar)dialog.findViewById(R.id.skbBlue);

        if(check)
        {
            skbAlpha.setProgress(clAlpha);
            skbRed.setProgress(clRed);
            skbGreen.setProgress(clGreen);
            skbBlue.setProgress(clBlue);
            skbLine.setProgress(clLine);
        }

        btnOk =(Button)dialog.findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check == false)
                {
                    clAlpha = skbAlpha.getProgress();
                    clGreen = skbGreen.getProgress();
                    clRed = skbRed.getProgress();
                    clBlue = skbBlue.getProgress();
                    clLine = skbLine.getProgress();

                    paintView.setCOLOR_PEN(clAlpha,clRed,clGreen,clBlue);
                    paintView.setBRUSh_SIZE(clLine);

                    check = true;

                    dialog.hide();
                }
                else{
                    clAlpha = skbAlpha.getProgress();
                    clGreen = skbGreen.getProgress();
                    clRed = skbRed.getProgress();
                    clBlue = skbBlue.getProgress();
                    clLine = skbLine.getProgress();

                    paintView.setCOLOR_PEN(clAlpha,clRed,clGreen,clBlue);
                    paintView.setBRUSh_SIZE(clLine);

                    dialog.hide();
                }

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doodle_fragment_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pen_line:
                paintView.pen();
                Toast.makeText(this, "Pen active", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eraser:
                paintView.eraser();
                Toast.makeText(this, "eraser active", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_draving:
                paintView.clear();
                Toast.makeText(this, "clear active", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.color:
                Dialog_table_color_line();
                return true;

        }

        return super.onOptionsItemSelected(item);

    }
}