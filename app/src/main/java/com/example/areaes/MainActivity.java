package com.example.areaes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sp_shapes=findViewById(R.id.area_spiner_shapes);
        final EditText et_rectangle_width=findViewById(R.id.area_et_rectangle_width);
        final EditText et_rectangle_height=findViewById(R.id.area_et_rectangle_height);
        final EditText et_tringle_base=findViewById(R.id.area_et_tringle_base);
        final EditText et_tringle_height=findViewById(R.id.area_et_tringle_height);
        final EditText et_circle_radius=findViewById(R.id.area_et_circle_radius);
        Button btn_calculte=findViewById(R.id.area_btn_calculte);
        final TextView tv_answer=findViewById(R.id.area_tv_answer);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                       et_rectangle_width.setVisibility(View.GONE);
                       et_rectangle_height.setVisibility(View.GONE);
                       et_tringle_base.setVisibility(View.GONE);
                       et_tringle_height.setVisibility(View.GONE);
                       et_circle_radius.setVisibility(View.GONE);
                       break;
                    case 1:
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_tringle_base.setVisibility(View.GONE);
                        et_tringle_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 2:
                        et_rectangle_width.setVisibility(View.GONE);
                        et_rectangle_height.setVisibility(View.GONE);
                        et_tringle_base.setVisibility(View.VISIBLE);
                        et_tringle_height.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        break;
                    case 3:
                        et_rectangle_width.setVisibility(View.GONE);
                        et_rectangle_height.setVisibility(View.GONE);
                        et_tringle_base.setVisibility(View.GONE);
                        et_tringle_height.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_calculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int indx=sp_shapes.getSelectedItemPosition();
                double area=0;
                switch (indx){
                    case 1:
                        double rect_width=Double.parseDouble(et_rectangle_width.getText().toString());
                        double rect_height=Double.parseDouble(et_rectangle_height.getText().toString());
                        area=rect_width*rect_height;
                        break;
                    case 2:
                        double tring_height=Double.parseDouble(et_tringle_height.getText().toString());
                        double tring_base=Double.parseDouble(et_tringle_base.getText().toString());
                        area=0.5*tring_base*tring_height;
                        break;
                    case 3:
                        double circle_ridus=Double.parseDouble(et_circle_radius.getText().toString());
                        area=Math.PI*circle_ridus*circle_ridus;
                        break;
                }
                tv_answer.setText(area+"");

            }
        });

    }
}
