package com.example.expensemanagementproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ExpenseManager.db";
    public static final String EXPENSE_TABLE_NAME = "Category";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_CATEGORY_NAME = "category_name";
    public static final String EXPENSE_TABLE_ADD = "Add_Expense";
    public static final String EXPENSE_ADD_COLUMN_ID = "add_id";
    public static final String EXPENSE_ADD_COLUMN_CATEGORY_ADD = "category_add";
    public static final String EXPENSE_ADD_COLUMN_AMOUNT = "amount";
    public static final String EXPENSE_ADD_COLUMN_DATE = "date";
    public static final String EXPENSE_ADD_COLUMN_NOTE = "note";

    private HashMap hp;
    private Context con;

    DBHelper(Context context)
    {
        super(context,"ExpenseManager",null,1);
        con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE Category (id integer primary key AUTOINCREMENT,category_name,identifier);";
        sqLiteDatabase.execSQL(createTable);

        String createTableAdd = "CREATE TABLE Add_Expense (add_id integer primary key AUTOINCREMENT, category_add, amount, date, note);";
        sqLiteDatabase.execSQL(createTableAdd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS!");
//        onCreate(sqLiteDatabase);
//
//    }

    public void insertCategory(String category_name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXPENSE_COLUMN_CATEGORY_NAME,category_name);
        db.insert(EXPENSE_TABLE_NAME,null,values);
        db.close();
    }

    public void insertAdd_Expense(String category_add,String amount,String date,String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXPENSE_ADD_COLUMN_CATEGORY_ADD, category_add);
        values.put(EXPENSE_ADD_COLUMN_AMOUNT,amount);
        values.put(EXPENSE_ADD_COLUMN_DATE,date);
        values.put(EXPENSE_ADD_COLUMN_NOTE,note);
        db.insert(EXPENSE_TABLE_ADD,null,values);
        db.close();
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Category where id = " + id + "",null);
        return res;
    }

    public Cursor getDataAdd(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor_add = db.rawQuery("SELECT * FROM Category WHERE id_add = " + id + "",null);
        return cursor_add;
    }

    public Cursor getSumExpenseAmount(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT sum(amount) FROM Add_Expense WHERE category_add = '$category_add'",null);
        return cursor;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows =(int) DatabaseUtils.queryNumEntries(db, EXPENSE_TABLE_NAME);
        return numRows;
    }

    public int numberOfRowsAdd(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRowsAdd =(int) DatabaseUtils.queryNumEntries(db, EXPENSE_TABLE_ADD);
        return numRowsAdd;
    }

    public boolean updateCategory(Integer id,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("cateory_name",name);
        db.update("Category",contentValues,EXPENSE_COLUMN_ID + "=" + id,null);
        return true;
    }

    public boolean updateCategoryAdd(Integer id,String category_add,String amount,String date,String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("add_id",id);
        contentValues.put("category_add",category_add);
        contentValues.put("amount",amount);
        contentValues.put("date",date);
        contentValues.put("note",note);
        return true;
    }

    public boolean deleteCategory(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXPENSE_TABLE_NAME, EXPENSE_COLUMN_CATEGORY_NAME + " = '" + value + "';",null)>0;
    }

    public boolean deleteAddCategory(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXPENSE_TABLE_ADD, EXPENSE_ADD_COLUMN_CATEGORY_ADD + "='" + value +"' ;", null)>0;
    }

    public int deleteAddExpense(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXPENSE_TABLE_ADD, EXPENSE_ADD_COLUMN_ID +"=" + id , null);

    }

    @SuppressLint("Range")
    public ArrayList<String> getAllCategory(){
        ArrayList<String> array_list =new ArrayList<>();
        hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Category",null);
        res.moveToFirst();
        while(res.isAfterLast()==false)
        {
            array_list.add(res.getString(res.getColumnIndex(EXPENSE_COLUMN_CATEGORY_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public List<Overview_ListView> getOverviewList(){
        Overview_ListView overList = null;
        List<Overview_ListView> listOverview =new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT category_add,date,note,SUM(amount) AS total FROM Add_Expense Group By category_add ORDER by date desc",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            overList = new Overview_ListView(cursor.getInt(0), cursor.getString(cursor.getColumnIndexOrThrow("category_add")),cursor.getInt(cursor.getColumnIndexOrThrow("total")),cursor.getString(cursor.getColumnIndexOrThrow("date")),cursor.getString(cursor.getColumnIndexOrThrow("note")));
            listOverview.add(overList);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return listOverview;
    }

    public List<Tab1_ListView> getCategoryName() {
        Tab1_ListView overList = null;

        List<Tab1_ListView> listOverview = new ArrayList<>();
        hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Category", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            overList = new Tab1_ListView(cursor.getInt(0), cursor.getString(1));
            listOverview.add(overList);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return listOverview;
    }

//    public List<TabHistory_Week_Adapter> getHistoryWeek() {
//    }

    public List<Edit_expense_List> getAllExpenses() {
        Edit_expense_List list = null;
        List<Edit_expense_List> listArray = new ArrayList<>();
        hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *  FROM Add_Expense ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list = new Edit_expense_List(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            listArray.add(list);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return listArray;
    }

    public List<TabHistory_Week_List> getHistoryWeek() {
        TabHistory_Week_List sample = null;

        List<TabHistory_Week_List> sampleList = new ArrayList<>();
        hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Add_Expense  ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            sample = new TabHistory_Week_List(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
            sampleList.add(sample);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return sampleList;
    }
}
