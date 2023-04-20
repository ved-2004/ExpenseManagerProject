package com.example.expensemanagementproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class History extends Fragment {
    ListView list;
    TabHistory_Week_Adapter adapter;
    List<TabHistory_Week_Adapter> lists;

    public History(){}

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View view = layoutInflater.inflate(R.layout.tabhistory_week,container,false);
        list = (ListView)view.findViewById(R.id.listview_week);

        DBHelper db = new DBHelper(getContext());
//        list = db.getHistoryWeek();
//        adapter = new TabHistory_Week_Adapter(getContext(), (ArrayList<TabHistory_Week_List>) lists);
        list.setAdapter(adapter);

        return view;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getActivity().getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.editText){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
