package com.alien.islam.task5;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by islam on 3/15/2018.
 */

public class messageAdaptar extends  RecyclerView.Adapter<messageAdaptar.MyViewHolder> {
    ArrayList<customMessage> list ;

    // Constructor with the DataSource ArrayList as a parameter
    messageAdaptar(ArrayList<customMessage> list){

        this.list = list;
    }


    @Override
    public messageAdaptar.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating the Layout you designed for the single cell in the RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_layout_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(messageAdaptar.MyViewHolder holder, int position) {
        // getting the corresponding object in the arrayList to the position of each cell in the recyclerView
        // and passing it to the bindData() method
        customMessage data = list.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView messageTextView ;
        LinearLayout baseLayout ;
        //in the constructor we initiate the designed cell view elements using the passed View object parameter
        public MyViewHolder(View v) {
            super(v);
            messageTextView = (TextView) v.findViewById(R.id.messageTextView) ;
            baseLayout = (LinearLayout) v.findViewById(R.id.baseLayout);
        }
        //binding data of each object to the cell's view elements
        public void bindData( customMessage obj){
            messageTextView.setText(obj.getText());
            if(obj.getMode()==customMessage.BLUE_MODE)
            {
                baseLayout.setGravity(Gravity.RIGHT);
                messageTextView.setTextColor(Color.WHITE);
                messageTextView.setBackgroundColor(Color.BLUE);
            }
            else {
                baseLayout.setGravity(Gravity.LEFT);
                messageTextView.setTextColor(Color.WHITE);
                messageTextView.setBackgroundColor(Color.RED);
            }

        }
    }

}