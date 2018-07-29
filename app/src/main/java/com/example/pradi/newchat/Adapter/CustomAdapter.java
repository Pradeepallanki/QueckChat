package com.example.pradi.newchat.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.pradi.newchat.R;
import com.example.pradi.newchat.models.chatmodel;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

/**
 * Created by pradi on 28/7/18.
 */

public class CustomAdapter extends BaseAdapter {

    private List<chatmodel> list_chat_models;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<chatmodel> list_chat_models, Context context) {
        this.list_chat_models = list_chat_models;
        this.context = context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list_chat_models.size();
    }

    @Override
    public Object getItem(int i) {
        return list_chat_models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View v=view;

       if(v==null)
       {
           if(list_chat_models.get(i).isSend)
               v=layoutInflater.inflate(R.layout.list_item_message_send,null);
           else
               v=layoutInflater.inflate(R.layout.list_item_message_recieved,null);
           BubbleTextView text_message=(BubbleTextView) v.findViewById(R.id.text_message);
           text_message.setText(list_chat_models.get(i).message);
       }

       return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
