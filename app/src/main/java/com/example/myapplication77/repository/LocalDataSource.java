package com.example.myapplication77.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication77.R;
import com.example.myapplication77.model.ListData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDataSource implements DataSource {
    private Map<Integer, ListData> items = new HashMap<>();

    public LocalDataSource() {
        items.put(R.drawable.cactus, new ListData("Красноплодник",R.drawable.cactus ));
        items.put(R.drawable.lotus1, new ListData("Лотос Кальпалата", R.drawable.lotus1));
        items.put(R.drawable.lotus2, new ListData("Лотос Нилотпала",R.drawable.lotus2));
        items.put(R.drawable.cvetyskorbi, new ListData("Цветы скорби",R.drawable.cvetyskorbi));
        items.put(R.drawable.grib, new ListData("Гриб Руккхашава",R.drawable.grib));
        items.put(R.drawable.lichinkazhirovika, new ListData("Личинка жировика",R.drawable.lichinkazhirovika));
        items.put(R.drawable.padissara, new ListData("Падисара",R.drawable.padissara));
        items.put(R.drawable.skarabej, new ListData("Скарабей",R.drawable.skarabej));
        items.put(R.drawable.trishirait, new ListData("Тришираит",R.drawable.trishirait));
        items.put(R.drawable.lampovyjkolokolchik, new ListData("Ламповый колокольчик",R.drawable.lampovyjkolokolchik));
        items.put(R.drawable.raduzhnajaroza, new ListData("Радужная роза",R.drawable.raduzhnajaroza));
        items.put(R.drawable.temnozvezdnik, new ListData("Темнозвездник",R.drawable.temnozvezdnik));
        items.put(R.drawable.podblokobnaruzhenija, new ListData("Подблок обнаружения",R.drawable.podblokobnaruzhenija));
        items.put(R.drawable.istochnikpervojrosy, new ListData("Источник первой росы",R.drawable.istochnikpervojrosy));


    }

    @Override
    public LiveData<List<ListData>> getItems() {
        MutableLiveData<List<ListData>> liveData = new MutableLiveData<>();
        liveData.setValue(new ArrayList<>(items.values()));
        return liveData;
    }

    @Override
    public LiveData<ListData> getItem(int itemId) {
        MutableLiveData<ListData> liveData = new MutableLiveData<>();
        liveData.setValue(items.get(itemId));
        return liveData;
    }
}
