package com.example.expensemanagementproject;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import androidx.fragment.app.Fragment;

public class Expense extends Fragment {

    public Expense(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.frag_add_exp,container,false);
        TabHost TabHostWindow = (TabHost)view.findViewById(R.id.tabhost_add);
        LocalActivityManager localActivityManager = new LocalActivityManager(getActivity(),false);
        localActivityManager.dispatchCreate(savedInstanceState);

        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec("First Tab");
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");

        TabMenu1.setIndicator("Category");
        TabMenu1.setContent(new Intent(getActivity(),Tab1.class));
        TabMenu2.setIndicator("Expense");
        TabMenu2.setContent(new Intent(getActivity(),Tab2.class));

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);

        return view;
    }
}
