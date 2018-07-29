package com.example.pradi.newchat;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pradi.newchat.Adapter.CustomAdapter;
import com.example.pradi.newchat.Helper.HttpDataHandler;
import com.example.pradi.newchat.models.chatmodel;
import com.example.pradi.newchat.models.simsimimodel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<chatmodel> listchat=new ArrayList<>();
    FloatingActionButton btn_send_message;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list_of_message);

        editText=(EditText)findViewById(R.id.usermessage);
        btn_send_message=findViewById(R.id.fab);

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();

                chatmodel model=new chatmodel(text,true);
                listchat.add(model);

                new SimsimiAPI().execute(listchat);

                editText.setText("");

            }
        });


    }

    private class SimsimiAPI extends AsyncTask<List<chatmodel>,Void,String >{

        String stream=null;
        List<chatmodel> models;
        String text=editText.getText().toString();

        @Override
        protected String doInBackground(List<chatmodel>[] lists) {
            String url=String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=1.0&text=%s",getText(R.string.simsimi),text);
            models=lists[0];
            HttpDataHandler httpDataHandler=new HttpDataHandler();
            stream=httpDataHandler.GetHttpData(url);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson=new Gson();
            simsimimodel response=gson.fromJson(s,simsimimodel.class);

            chatmodel c=new chatmodel(response.getResponse(),false);
            models.add(c);

            CustomAdapter ct=new CustomAdapter(models,getApplicationContext());
            listView.setAdapter(ct);

        }
    }
}
