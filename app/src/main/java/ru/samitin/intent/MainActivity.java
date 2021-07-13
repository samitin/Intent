package ru.samitin.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants{
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    EditText txtName;
    private Acount acount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acount=new Acount();
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode!=REQUEST_CODE_SETTING_ACTIVITY){
        super.onActivityResult(requestCode, resultCode, data);
        return;
        }
        if (resultCode==RESULT_OK){
            acount=data.getParcelableExtra(YOUR_ACOUNT);
            popularView();
        }
    }
    private void popularView(){
        txtName.setText(acount.getName());
    }

    private void initView(){
        txtName=findViewById(R.id.textName);
        Button brnGritings=findViewById(R.id.btnGreetings);
        final EditText txtName=findViewById(R.id.textName);
        final TextView txtGritings=findViewById(R.id.textHello);
        brnGritings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtName.getText().toString();
                String sayHello=getString(R.string.say_hello)+name;
                txtGritings.setText(sayHello);
            }
        });
        Button btnSettings=findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent runSettings=new Intent(MainActivity.this,SettingsActivity.class);
                popularAcount();
                runSettings.putExtra(YOUR_ACOUNT,acount);
                startActivityForResult(runSettings,REQUEST_CODE_SETTING_ACTIVITY);
            }
        });
    }
    private void popularAcount(){
        acount.setName(txtName.getText().toString());
    }
}