package com.example.progect7_2.Data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.progect7_2.Data.DataSourse.Files.AppSpecificDS;
import com.example.progect7_2.Data.DataSourse.Files.ExternalStorageDirectory;
import com.example.progect7_2.Data.DataSourse.Room.Appdatabase;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.DataSourse.SharedPreferences.SharedPreferencesDS;
import com.example.progect7_2.Data.model.ListData;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private Appdatabase db;
    public MutableLiveData<List<Cathegory>> mutableLiveData;
    private AppSpecificDS appSpecificDataSource;
    private ExternalStorageDirectory externalStorageDirectory;
    private SharedPreferencesDS Localds;
    public Repository() {}
    public Repository(Context context, String appSpecDSFileName, String externalStorageDirectory) {
        this.appSpecificDataSource = new AppSpecificDS(context, appSpecDSFileName);
        this.externalStorageDirectory = new ExternalStorageDirectory(context, externalStorageDirectory);
    }
    public void writeAppSpecDS(String inputContent) {
        appSpecificDataSource.writeAppSpecificDS("\n" + inputContent);
    }
    public String readAppSpecDS() {
        return appSpecificDataSource.readAppSpecificDS();
    }
    public boolean writeExternalStorageDirectory(String inputContent) {
        return externalStorageDirectory.writeContent("\n" + inputContent);

    }

    public String readExternalStorageDirectory() {
        return externalStorageDirectory.readFile();
    }


    public void createDatabase(Context context, ArrayList<String> values) {
        if (db != null) return;

        db = Room.databaseBuilder(context,
                Appdatabase.class, "list").allowMainThreadQueries().build();
        for (int i = 0; i < values.size(); i++){
            insertCateg(values.get(i));
        }
    }


    public  void getAllCategories(){
        List<Cathegory> cathegoryList = db.listDAO().getAllCategoriesList();
        if(cathegoryList.size()> 0){
            mutableLiveData.postValue(cathegoryList);
        }else {
            mutableLiveData.postValue(null);
        }
    }
    public  void insertCateg(String catName){
        Cathegory cathegory= new Cathegory();
        cathegory.catName = catName;
        db.listDAO().insertCategory(cathegory);
        getAllCategories();
    }
    public  void updateCateg(Cathegory cathegory){
        db.listDAO().updateCategory(cathegory);
        getAllCategories();
    }
    public  void deleteCateg(Cathegory cathegory){
        db.listDAO().deleteCategory(cathegory);
        getAllCategories();
    }


    public void createLocalds(Context context) {
        if (Localds == null)
            Localds = new SharedPreferencesDS(context);
    }
    public String getLocalName() {
        if (Localds == null) return null;
        else return Localds.getString("Name");
    }
    public Integer getLocalImg() {
        if (Localds == null) return null;
        else return Localds.getInt("Img");
    }
    public void setLocalName(String name) {
        if (Localds == null) return;
        else Localds.writeString("Name", name);
    }
    public void setLocalImg(int img) {
        if (Localds == null) return;
        else Localds.writeInt("Img", img);
    }
    public ListData getItems() {
        if (Localds == null) return null;
        else return new ListData(
                Localds.getString("Name"),
                Localds.getInt("Img")
        );
    }

}

