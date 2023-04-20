package com.example.expensemanagementproject;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class TabHistory_Week_Adapter extends BaseAdapter {
    Context context;
    List<TabHistory_Week_List> listWeek;

    public TabHistory_Week_Adapter(Context context, List<TabHistory_Week_List> listWeek){
        this.context = context;
        this.listWeek = listWeek;
    }
    @Override
    public int getCount() {
        return listWeek.size();
    }

    @Override
    public Object getItem(int i) {
        return listWeek.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = View.inflate(context,R.layout.tab_history_week_list,null);

        TextView txtName = (TextView) view.findViewById(R.id.thw_name);
        TextView txtAmount = (TextView) view.findViewById(R.id.thw_amount);
        TextView txtDate = (TextView) view.findViewById(R.id.thw_date);
        TextView txtNote = (TextView) view.findViewById(R.id.thw_note);

        txtName.setText(listWeek.get(i).getName());
        DecimalFormat precision =new DecimalFormat("0.00");
        txtAmount.setText(precision.format(listWeek.get(i).getAmount()));
        txtDate.setText(listWeek.get(i).getDate());
        txtNote.setText(listWeek.get(i).getNote());
        return view;
    }
}
