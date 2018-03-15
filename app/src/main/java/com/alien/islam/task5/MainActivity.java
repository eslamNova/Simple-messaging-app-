package com.alien.islam.task5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Switch aSwitch ;
    RecyclerView recyclerView ;
    Button button ;
    messageAdaptar messageAdaptar;
    ArrayList<customMessage> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
        initRecView();
    }


    private void initFields (){
        editText =(EditText) findViewById(R.id.messageEditText);
        aSwitch =(Switch) findViewById(R.id.switch1);

    }

    private void initRecView (){
        recyclerView =(RecyclerView) findViewById(R.id.messageRecView);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        messageAdaptar =new messageAdaptar(arrayList);
        recyclerView.setAdapter(messageAdaptar);
    }

    public void sendMessage (View v){
        String messageText = editText.getText().toString().trim();
        if(messageText.isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter Text :3",Toast.LENGTH_LONG).show();
            return;
        }
        editText.setText("");
        customMessage customMessage = new customMessage(messageText);
        if(aSwitch.isChecked()) customMessage.setMode(com.alien.islam.task5.customMessage.BLUE_MODE);
        else customMessage.setMode(com.alien.islam.task5.customMessage.RED_MODE);
        arrayList.add(customMessage);
        messageAdaptar.notifyDataSetChanged();


    }
}
