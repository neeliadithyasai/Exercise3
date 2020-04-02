package com.example.exercise3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnNEXT;
    private TextView txtName;

    public static int name = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNEXT = findViewById(R.id.btnNext);
        txtName = findViewById(R.id.txtName);


        btnNEXT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(txtName.getText().toString().matches(""))
                {
                    txtName.setError("Enter Valid Name");
                }
                else
                {
                    String passingdata = txtName.getText().toString();
                    Intent mIntent = new Intent(MainActivity.this, operationsActivity.class);
                    mIntent.putExtra("edtName", passingdata );
                    startActivityForResult(mIntent, name);

                }

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == name)
            {
                String newName = data.getStringExtra("Name");
                txtName.setText(newName);
                Toast.makeText(MainActivity.this, newName, Toast.LENGTH_SHORT).show();;
            }
        }


    }
}
