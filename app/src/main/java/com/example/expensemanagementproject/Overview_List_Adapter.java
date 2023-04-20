package com.example.expensemanagementproject;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.icu.text.Transliterator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class Overview_List_Adapter extends BaseAdapter {

    Context context;
    List<Overview_ListView> listOverview;

    public Overview_List_Adapter(Context context, List<Overview_ListView> listOverview)
    {
        this.context = context;
        this.listOverview = listOverview;
    }

    @Override
    public int getCount() {
        return listOverview.size();
    }

    @Override
    public Object getItem(int i) {
        return listOverview.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context,R.layout.overview_list,null);
        TextView txtName = (TextView) view1.findViewById(R.id.txtOverview_name);
        TextView txtAmount = (TextView) view1.findViewById(R.id.txtOverview_amount);
        ProgressBar progressBar = (ProgressBar)view1.findViewById(R.id.progressBar);

        txtName.setText(listOverview.get(i).getName());
        DecimalFormat precision = new DecimalFormat("0.00");
        txtAmount.setText(precision.format(listOverview.get(i).getAmount())+"Rs.");
        progressBar.setProgress(txtAmount.getAutoLinkMask());
        progressBar.setProgress(0);
        progressBar.setMax(100);
        return view1;
    }
}
