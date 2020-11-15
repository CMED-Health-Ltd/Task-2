package com.example.task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Response;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private Context context;
        private List<Response> List;


        public Adapter(Context context, java.util.List<Detail> list) {
            this.context = context;
            this.List = List;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.fragment_, parent, false);
            return new ViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Response Response = List.get(position);
            holder.name.setText(List.get(position).getClass().getName());
           
           //holder.image.setText(List.get(position).getClass().getField(im));

        }

        @Override
        public int getItemCount() {
            return List.size();
        }








        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView name,image ;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);

             
                image = itemView.findViewById(R.id.image);
            }
        }


    }


