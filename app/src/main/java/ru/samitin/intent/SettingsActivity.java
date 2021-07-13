package ru.samitin.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity implements Constants{
    private EditText editName;
    private EditText editSurname;
    private EditText editAge;
    private EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();

        Acount acount=getIntent().getParcelableExtra(YOUR_ACOUNT);
        popularView(acount);
        Button btnReturn=findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra(YOUR_ACOUNT,createAcount());
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
    private Acount createAcount(){
        Acount acount=new Acount(editName.getText().toString(),
                editSurname.getText().toString(),
                Integer.parseInt(editAge.getText().toString()),
                editEmail.getText().toString());
        return acount;
    }
    private void popularView(Acount acount){
        editName.setText(acount.getName());
        editSurname.setText(acount.getSurName());
        editAge.setText(String.format(Locale.getDefault(),"%d",acount.getAge()));
        editEmail.setText(acount.getEmail());
    }
    private void initView(){
        editName=findViewById(R.id.editName);
        editSurname=findViewById(R.id.editSurname);
        editAge=findViewById(R.id.editAge);
        editEmail=findViewById(R.id.editEmail);
    }
}