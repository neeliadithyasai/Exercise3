package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class operationsActivity extends AppCompatActivity {

    private TextView edtName;
    private Button upper;
    private Button lower;
    private Button noOfWords;
    private Button length;
    private Button reverse;
    private Button initials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        edtName = findViewById(R.id.edtName);
        upper = findViewById(R.id.btnUpper);
        lower = findViewById(R.id.btnLower);
        noOfWords = findViewById(R.id.btnNo);
        length = findViewById(R.id.btnLength);
        reverse = findViewById(R.id.btnReverse);
        initials = findViewById(R.id.btnInitials);


        String receivingdata = getIntent().getStringExtra("edtName");

        edtName.setText(receivingdata);
        edtName.setTextColor(Color.RED);
        edtName.setTextSize(16);




        upper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Name = edtName.getText().toString().toUpperCase();

                    Intent mIntent = new Intent();
                    mIntent.putExtra("Name", Name);
                    setResult(RESULT_OK, mIntent);
                    finish();

            }
        });
        lower.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Name = edtName.getText().toString().toLowerCase();


                    Intent mIntent = new Intent();
                    mIntent.putExtra("Name", Name);
                    setResult(RESULT_OK, mIntent);
                    finish();

            }
        });
        noOfWords.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int Name = edtName.getText().toString().length();


                    Intent mIntent = new Intent();
                    mIntent.putExtra("Name", String.valueOf(Name));
                    setResult(RESULT_OK, mIntent);
                    finish();

            }
        });
        length.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int Name = edtName.getText().toString().length();


                Intent mIntent = new Intent();
                mIntent.putExtra("Name", String.valueOf(Name));
                setResult(RESULT_OK, mIntent);
                finish();

            }
        });
        reverse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Name = edtName.getText().toString().toLowerCase();

                char ch[]=Name.toCharArray();
                String str="";
                for(int j=ch.length-1;j>=0;j--){
                    str+=ch[j];
                }


                Intent mIntent = new Intent();
                mIntent.putExtra("Name", str);
                setResult(RESULT_OK, mIntent);
                finish();

            }
        });
        initials.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Name = edtName.getText().toString().toLowerCase();

                String str = "";
                String words[] = Name.split(" ");
                for(String word : words) {
                    str = str + Character.toUpperCase(word.charAt(0)) + " ";
                }
                Intent mIntent = new Intent();
                mIntent.putExtra("Name", str);
                setResult(RESULT_OK, mIntent);
                finish();

            }
        });



    }
}
