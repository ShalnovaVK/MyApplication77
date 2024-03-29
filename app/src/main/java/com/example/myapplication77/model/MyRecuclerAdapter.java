package com.example.myapplication77.model;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication77.R;

import java.util.ArrayList;

public class MyRecuclerAdapter  extends RecyclerView.Adapter< MyRecuclerAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private ArrayList<ListData> items;
    private static Context parent;
    private static final String TAG = "MyApp";
    public MyRecuclerAdapter(Context context, ArrayList<ListData> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        parent = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.frag_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListData listData = items.get(position);
        holder.textView.setText(listData.name);
        holder.imageView.setImageResource(listData.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получаем NavController для перехода между фрагментами
                NavController navController = Navigation.findNavController(view);
                Bundle bundle =  new Bundle();
                bundle.putInt("itemId", listData.image);
                // Выполняем переход на другой фрагмент, указав id действия из графа навигации
                holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fragment5, bundle));
            }
        });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CharSequence text = "Эта диковинка живет только в 1 регионе";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(parent, text, duration);
                    toast.show();
                    Log.i(TAG, "Поздравляю, вы нашли диковину");
                }
            });
        }
    }

}
