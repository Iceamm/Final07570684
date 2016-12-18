package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    loginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginDataBaseAdapter=new  loginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        final EditText editTextUserName=(EditText) findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText) findViewById(R.id.editTextPasswordToLogin);
        Button bntnewaccount = (Button)findViewById(R.id.newaccount);



       bntnewaccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });

    }


}

