package com.example.expensemanagementproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Graph_all_Adapter {
    Context context;
    private List<Graph_all_List> lists;


    public Graph_all_Adapter (Context context, List<Graph_all_List> lists){
        this.context = context;
        this.lists = lists;

    }



    public int getCount() {
        return lists.size();
    }


    public Object getItem(int position) {
        return lists.get(position);
    }


    public long getItemId(int position) {
        return lists.get(position).getId();
    }


    public View getView(final int position, View itemView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.piegraph_list, null);

        TextView txtName = (TextView)view.findViewById(R.id.piegraph_name);
        TextView txtAmount = (TextView) view.findViewById(R.id.piegraph_amount);
        TextView txtPercent = (TextView) view.findViewById(R.id.piegraph_percent);

        txtName.setText(lists.get(position).getName());
        txtAmount.setText(String.valueOf(lists.get(position).getAmount()));
        if(!txtAmount.toString().equals("")){
            double amount = Double.parseDouble(txtAmount.getText().toString());
            double res = (amount  / 100.0f);
            txtPercent.setText(String.valueOf(res)+"%");
        }else {

        }

        return view;
    }
}
