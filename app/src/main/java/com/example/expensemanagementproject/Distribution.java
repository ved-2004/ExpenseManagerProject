package com.example.expensemanagementproject;

import androidx.fragment.app.Fragment;

public class Distribution extends Fragment {
    public Distribution(){}

//    BarChart barChart;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        View view = inflater.inflate(R.layout.frag_frag_dist,container,false);
//        barChart = (BarChart)view.findViewById(R.id.barCharDist);
////        createBarChart();
//        return view;
//    }
//
//    public ArrayList<String> queryXData() {
//        DBHelper db = new DBHelper(getActivity());
//        SQLiteDatabase sqLiteDatabase =db.getReadableDatabase();
//        ArrayList<String> xNewData = new ArrayList<>();
//        String query = "SELECT category_add FROM Add_Expense GROUP BY category_add";
//        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
//        for(cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()) {
//            xNewData.add(cursor.getString(0));
//        }
//        cursor.close();
//        return xNewData;
//    }
//
//    public ArrayList<Integer> queryYData() {
//        DBHelper db = new DBHelper(getActivity());
//        SQLiteDatabase sqLiteDatabase =db.getReadableDatabase();
//        ArrayList<Integer> yNewData = new ArrayList<>();
//        String query="SELECT category_add, SUM(amount) AS total FROM Add_Expense GROUP BY category_add";
//        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
//        for(cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()) {
//            yNewData.add(cursor.getInt(cursor.getColumnIndexOrThrow("total")));
//        }
//        cursor.close();
//        return yNewData;
//    }

//    public void createBarChart(){
//        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
//        for(int i=0;i<queryYData().size();i++)
//            yVals.add(new BarEntry(queryYData().get(i), i));
//        List<String> xVals = new ArrayList<String>();
//
//        for(int i = 0; i < queryXData().size(); i++)
//            xVals.add(queryXData().get(i).toString());
//
//        ArrayList<Integer> colors=new ArrayList<Integer>();
//        for(int c: ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//        for(int c: ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
//        for(int c: ColorTemplate.COLORFUL_COLORS)
//            colors.add(c);
//        for(int c: ColorTemplate.LIBERTY_COLORS)
//            colors.add(c);
//        for(int c: ColorTemplate.PASTEL_COLORS)
//            colors.add(c);
//        colors.add(ColorTemplate.getHoloBlue());
//
//        BarDataSet dataSet = new BarDataSet(yVals, "Expense");
//        dataSet.setColors(colors);
//
//        BarData data = new BarData(dataSet);
//        data.setDrawValues(true);
//        data.setBarWidth(100f);
//
//        barChart.setData(data);
//        barChart.setEnabled(true);
//        barChart.setDragEnabled(true);
//        barChart.setScaleEnabled(true);
//        barChart.setDrawGridBackground(false);
//
//        barChart.setFitBars(true);
//        barChart.animateXY(2000, 2000);
//    }
}
