package com.example.progect7_2.UI_Layer.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.example.progect7_2.Data_Lauer.model.ListData;
//import com.example.progect7_2.Data_Lauer.repository.Repository;
import com.example.progect7_2.Data.DataSourse.Room.Appdatabase;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.repository.Repository;
//import com.example.progect7_2.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemsViewModel extends ViewModel {
    private Repository repository = new Repository();

    public MutableLiveData<List<Cathegory>> getItemsObserv() {
        return repository.mutableLiveData;
    }
    private final MutableLiveData<Repository> uiState =
            new MutableLiveData<>(new Repository());
    public LiveData<Repository> getUiState() {
        return uiState;
    }

    public void createList(Context context, ArrayList<String> cathegories) {
        Objects.requireNonNull(uiState.getValue()).createDatabase(context, cathegories);
    }
    /*
    public ItemsViewModel(@NonNull Application application) {
        super(application);
        mutableLiveData = new MutableLiveData<>();
        appdatabase = Appdatabase.getINSTANCE(getApplication().getApplicationContext());
    }
    //
    public  void getAllCategories(){
        List<Cathegory> cathegoryList = appdatabase.listDAO().getAllCategoriesList();
        if(cathegoryList.size()> 0){
            mutableLiveData.postValue(cathegoryList);
        }else {
            mutableLiveData.postValue(null);
        }
    }
    public  void insertCateg(String catName){
        Cathegory cathegory= new Cathegory();
        cathegory.catName = catName;
        appdatabase.listDAO().insertCategory(cathegory);
        getAllCategories();
    }
    public  void updateCateg(Cathegory cathegory){
        appdatabase.listDAO().updateCategory(cathegory);
        getAllCategories();
    }
    public  void deleteCateg(Cathegory cathegory){
        appdatabase.listDAO().deleteCategory(cathegory);
        getAllCategories();
    }*/

}
