package com.example.progect7_2.UI_Layer.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.example.progect7_2.Data_Lauer.model.ListData;
//import com.example.progect7_2.Data_Lauer.repository.Repository;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.model.ListData;
import com.example.progect7_2.Data.repository.Repository;
//import com.example.progect7_2.repository.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemsViewModel extends ViewModel {
    private final Repository repository = new Repository();
    private final MutableLiveData<Repository> liveData = new MutableLiveData<>(new Repository());
    /*public MutableLiveData<List<Cathegory>> getItemsObserv() {
        return repository.mutableLiveData;
    }*/

    public LiveData<Repository> getLiveData() {
        return liveData;
    }

    public void createList(Context context,  Map<String, Integer> cathegories) {
        Objects.requireNonNull(liveData.getValue()).createDatabase(context, cathegories);
    }

    public  void createLocalds(Context context){
        Objects.requireNonNull(liveData.getValue()).createLocalds(context);
    }
    public String getLocalName() {
        return Objects.requireNonNull(liveData.getValue()).getLocalName();
    }
    public Integer getLocalImg() {
        return Objects.requireNonNull(liveData.getValue()).getLocalImg();
    }
    public void setLocalName(String name) {
        Objects.requireNonNull(liveData.getValue()).setLocalName(name);
    }
    public void setLocalImg(int img) {
        Objects.requireNonNull(liveData.getValue()).setLocalImg(img);
    }
    public ListData getItems() {
        return Objects.requireNonNull(liveData.getValue()).getItems();
    }

}
