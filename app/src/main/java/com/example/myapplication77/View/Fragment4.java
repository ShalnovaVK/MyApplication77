package com.example.myapplication77.View;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication77.R;
import com.example.myapplication77.model.ListData;
import com.example.myapplication77.model.MyRecuclerAdapter;
import com.example.myapplication77.viewmodel.ItemsViewModel;
import com.example.myapplication77.viewmodel.ItemDetailViewModel;

import java.util.ArrayList;

public class Fragment4 extends Fragment {
    private ItemsViewModel  viewModel;

    // Строка, которую мы выводим в список
    MyRecuclerAdapter myAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    private String[] dikovinki = { "Красноплодник", "Цветы скорби","Гриб Руккхашава", "Личинка жировика","Лотос Кальпалата",
            "Лотос Нилотпала","Падисара","Скарабей", "Тришираит","Ламповый колокольчик",
            "Радужная роза","Темнозвездник","Подблок обнаружения", "Источник первой росы" };
    private int[] imageList = {R.drawable.cactus, R.drawable.cvetyskorbi, R.drawable.grib, R.drawable.lichinkazhirovika,
            R.drawable.lotus1, R.drawable.lotus2, R.drawable.padissara, R.drawable.skarabej,
            R.drawable.trishirait,R.drawable.lampovyjkolokolchik,R.drawable.raduzhnajaroza,
            R.drawable.temnozvezdnik, R.drawable.podblokobnaruzhenija, R.drawable.istochnikpervojrosy};

    public Fragment4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // получаем элемент ListView
        RecyclerView listView = view.findViewById(R.id.recyclerView);
        for (int j = 0; j<17 ;j++){
            for (int i = 0; i<imageList.length; i++) {
                listData = new ListData(dikovinki[i],imageList[i]);
                dataArrayList.add(listData);
            }
        }
        // создаем адаптер
        myAdapter = new MyRecuclerAdapter(this.getContext(),dataArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        listView.setLayoutManager(layoutManager);
        //myAdapter.notifyDataSetChanged();
        // устанавливаем для списка адаптер


        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(ItemsViewModel.class);

        viewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            myAdapter.notifyDataSetChanged();
        });
        listView.setAdapter(myAdapter);
        //return view;

    }
}
