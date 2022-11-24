package com.equipe3.compteur.vue;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.equipe3.compteur.model.Client;

public class ClientListAdapter extends ListAdapter<Client, ClientViewHolder> {
    public ClientListAdapter(@NonNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }
    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ClientViewHolder.create(parent);
    }
    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client current = getItem(position);
        holder.bind(current.getIdentifiant(), current.getNom(), current.getPrenom());
        http://www.reseaucerta.org © CERTA - novembre 2022 – v1.0 Page 9/17
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UpdateClient = new Intent(v.getContext(), UpdateClient.class);
                UpdateClient.putExtra("idClient", current.getIdentifiant());
                UpdateClient.putExtra("nomClient", current.getNom());
                UpdateClient.putExtra("prenomClient", current.getPrenom());
                v.getContext().startActivity(UpdateClient);
            }
        });
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    public static class ClientDiff extends DiffUtil.ItemCallback<Client> {
        @Override
        public boolean areItemsTheSame(@NonNull Client oldItem, @NonNull Client
                newItem) {
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull Client oldItem, @NonNull Client
                newItem) {
            return oldItem.getIdentifiant().equals(newItem.getIdentifiant());
        }
    }
}