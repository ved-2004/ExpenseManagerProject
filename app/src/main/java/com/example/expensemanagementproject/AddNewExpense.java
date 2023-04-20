package com.example.expensemanagementproject;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.List;

public class AddNewExpense extends Fragment implements AdapterView.OnItemSelectedListener {

    ListView listView;
    Button btnSave, btnCancel;
    EditText etAmt, etDate, etNote;
    Calendar calendar;
    private int year,month,day;

    public AddNewExpense(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.tab2,container,false);
        listView = (ListView)view.findViewById(R.id.listCategory);
        DBHelper dbHelper = new DBHelper(getContext());
        List<String> labels = dbHelper.getAllCategory();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_single_choice,labels);
        listView.setAdapter(dataAdapter);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month+1,day);

        etAmt = (EditText)view.findViewById(R.id.editAmount);
        etDate = (EditText) view.findViewById(R.id.editDate);
        etNote = (EditText) view.findViewById(R.id.editNote);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSave = (Button) view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category_add = listView.getSelectedItem().toString();
                String amount = etAmt.getText().toString();
                String note = etNote.getText().toString();
                String date = etDate.getText().toString();

                if(category_add.trim().length()>0){
                    DBHelper db = new DBHelper(getContext());
                    db.insertAdd_Expense(category_add,amount,date,note);
                    etAmt.setText("");
                    etDate.setText("");
                    etNote.setText("");

                    InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(listView.getWindowToken(),0);
                    InputMethodManager imm_amt = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(etAmt.getWindowToken(),0);
                    InputMethodManager imm_note = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(etNote.getWindowToken(),0);
                    InputMethodManager imm_date = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(etDate.getWindowToken(),0);
                }
                else{
                    Toast.makeText(getContext(), "Please Enter Label Name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public void setDate(View view){
        getActivity().showDialog(999);
        Toast.makeText(getContext(), "Choose Date", Toast.LENGTH_SHORT).show();
        return;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i,i1+1,i2);
        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==999){
            return new DatePickerDialog(getContext(),myDateListener,year,month,day);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {
        etDate.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();
        listView.getSelectedItem().toString();
        Toast.makeText(parent.getContext().getApplicationContext(), "You Selected: "+label, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getActivity().getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
