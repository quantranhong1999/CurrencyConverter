package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int i;
    private int j;
    double[][] ratio = {{1, 4.26/100000, 3.89/100000, 3.39/100000 },
        {23471,1,0.91,0.8},
        {25690.67,1.09,1,0.87},
        {29497.3,1.26,1.15,1}};
    private Spinner spnIn;
    private Spinner spnOut;
    private TextView tvIn;
    private TextView tvOut;
    private Button btnCE;
    private Button btnBS;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Thiet lap spinner In
        spnIn = findViewById(R.id.spnIn);

        List<String> listIn = new ArrayList<>();
        listIn.add("VND");
        listIn.add("USD");
        listIn.add("EURO");
        listIn.add("POUND");

        ArrayAdapter<String> adapterIn = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,listIn);
        spnIn.setAdapter(adapterIn);
        adapterIn.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Đầu vào "+spnIn.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if(spnIn.getItemAtPosition(position).toString().equals("VND")) {i =0; cal();}
                if(spnIn.getItemAtPosition(position).toString().equals("USD")) {i =1; cal();}
                if(spnIn.getItemAtPosition(position).toString().equals("EURO")) {i =2; cal();}
                if(spnIn.getItemAtPosition(position).toString().equals("POUND")) {i =3; cal();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                i=0;
            }
        });
        //Thiet lap spinner Out
        spnOut = findViewById(R.id.spnOut);

        List<String> listOut = new ArrayList<>();
        listOut.add("VND");
        listOut.add("USD");
        listOut.add("EURO");
        listOut.add("POUND");
        ArrayAdapter<String> adapterOut = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,listOut);
        spnOut.setAdapter(adapterOut);
        adapterOut.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Đầu ra "+spnOut.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                if(spnOut.getItemAtPosition(position).toString().equals("VND")) {j =0; cal();}
                if(spnOut.getItemAtPosition(position).toString().equals("USD")) {j =1; cal();}
                if(spnOut.getItemAtPosition(position).toString().equals("EURO")) {j =2; cal();}
                if(spnOut.getItemAtPosition(position).toString().equals("POUND")) {j =3; cal();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                j=0;
            }
        });


        initWidget();
        setEventClickView();;
    }

    public void initWidget(){
        tvIn = findViewById(R.id.tvIn);
        tvOut = findViewById(R.id.tvOut);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCE = findViewById(R.id.btnCE);
        btnBS = findViewById(R.id.btnBS);
        btnDot = findViewById(R.id.btnDot);

    }
    public void setEventClickView(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnDot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                tvIn.append("0");
                cal();;
                break;
            case R.id.btn1:
                tvIn.append("1");
                cal();
                break;
            case R.id.btn2:
                tvIn.append("2");
                cal();
                break;
            case R.id.btn3:
                tvIn.append("3");
                cal();
                break;
            case R.id.btn4:
                tvIn.append("4");
                cal();
                break;
            case R.id.btn5:
                tvIn.append("5");
                cal();
                break;
            case R.id.btn6:
                tvIn.append("6");
                cal();
                break;
            case R.id.btn7:
                tvIn.append("7");
                cal();
                break;
            case R.id.btn8:
                tvIn.append("8");
                cal();
                break;
            case R.id.btn9:
                tvIn.append("9");
                cal();
                break;
            case R.id.btnDot:
                if(tvIn.getText().toString().contains(".")) break;
                tvIn.append(".");
                break;
            case R.id.btnCE:
                tvIn.setText("");
                tvOut.setText("");
                break;
            case R.id.btnBS:
                String temp = tvIn.getText().toString();
                StringBuilder tempBuilder = new StringBuilder(temp);
                if(tempBuilder.length()!=0) tempBuilder.deleteCharAt(tempBuilder.length()-1);
                tvIn.setText(tempBuilder.toString());
                cal();
                break;
        }
    }

    private void cal(){
        if(!tvIn.getText().toString().isEmpty()){
            double tempIn;
            double tempOut;
            tempIn = Float.valueOf(tvIn.getText().toString());
            tempOut = (double) Math.round(tempIn*ratio[i][j]*100.00) / 100.00;
            tvOut.setText(String.valueOf(tempOut));
        }

    }
}
