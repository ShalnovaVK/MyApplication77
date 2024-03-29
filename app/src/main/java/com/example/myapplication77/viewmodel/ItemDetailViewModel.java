package com.example.myapplication77.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication77.model.Item;
import com.example.myapplication77.model.ListData;
import com.example.myapplication77.repository.Repository;

public class ItemDetailViewModel extends ViewModel {
    private Repository repository = new Repository();

    public LiveData<ListData> getItem(int itemId) {
        return repository.getItem(itemId);
    }
}
