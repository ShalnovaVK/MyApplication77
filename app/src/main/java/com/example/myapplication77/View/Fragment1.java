package com.example.myapplication77.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication77.R;


public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController =
                Navigation.findNavController(view);
        Button button = getActivity().findViewById(R.id.button);
        EditText editText = getActivity().findViewById(R.id.editText);
        Bundle bundle =  new Bundle();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Привет, ";
                name += String.valueOf(editText.getText());
                bundle.putString("MyArg", name);
                navController.navigate(R.id.fragment2, bundle);
            }
        });
    }
}