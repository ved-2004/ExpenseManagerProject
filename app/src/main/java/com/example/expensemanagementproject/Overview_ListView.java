package com.example.expensemanagementproject;

public class Overview_ListView {
    private int id,amount;
    private String name,note,date;

    public Overview_ListView(int id,String name,int amount,String date,String note){
        this.id=id;
        this.amount=amount;
        this.date=date;
        this.name=name;
        this.note=note;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note=note;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}
