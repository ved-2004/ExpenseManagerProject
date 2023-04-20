package com.example.expensemanagementproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.List;

public class Overview extends Fragment {
    private ListView listView;
    List<Overview_ListView> listOverview;
    Overview_List_Adapter adapterOverview;
    TextView total;

    public Overview(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_overview,container,false);

        listView = (ListView) view.findViewById(R.id.list_viewAll);
        total = (TextView) view.findViewById(R.id.txtAmountOverview);
        getTotal();

        DBHelper db = new DBHelper(getContext());
        listOverview = db.getOverviewList();
        adapterOverview = new Overview_List_Adapter(getContext(),listOverview);
        listView.setAdapter(adapterOverview);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Cursor getTotal(){
        DBHelper db = new DBHelper(getContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        String query = "SELECT SUM(amount) AS total FROM Add_Expense";
        Cursor c = sql.rawQuery(query,null);
        c.moveToFirst();
        c.getInt(0);
        DecimalFormat precision = new DecimalFormat("0.00");
        total.setText(precision.format(c.getInt(0)));
        return c;
    }
}
