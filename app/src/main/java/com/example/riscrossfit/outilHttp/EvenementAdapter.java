package com.example.riscrossfit.outilHttp;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riscrossfit.R;
import com.example.riscrossfit.models.Evenement;

import java.util.ArrayList;

    public class EvenementAdapter extends RecyclerView.Adapter<EvenementAdapter.MyViewHolder>{
        private ArrayList<Evenement> dataSet;

        public EvenementAdapter(ArrayList<Evenement> data) {
            this.dataSet = data;
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView eventTitre;
            TextView eventDescription;
            TextView eventDate;
            public MyViewHolder(View itemView) {
                super(itemView);
                this.eventTitre = (TextView) itemView.findViewById(R.id.evenementTitre);
                this.eventDescription = (TextView) itemView.findViewById(R.id.evenementDescription);
                this.eventDate = (TextView) itemView.findViewById(R.id.evenementDate);
            }
        }
        @Override
        public EvenementAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.evenement_row, parent, false);
            //view.setOnClickListener(UsersActivity.myOnClickListener);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull EvenementAdapter.MyViewHolder holder, int position) {
            TextView eventTitre = holder.eventTitre;
            TextView eventDescription = holder.eventDescription;
            TextView eventDate = holder.eventDate;

            eventTitre.setText(dataSet.get(position).getTitre());
            eventDescription.setText(dataSet.get(position).getDescription());
            eventDate.setText(dataSet.get(position).getDateDebut());
        }



        @Override
        public int getItemCount() {
            return dataSet.size();
        }
    }
