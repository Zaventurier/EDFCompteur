package com.equipe3.compteur.vue.vueCompteur;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.equipe3.compteur.model.Client;
import com.equipe3.compteur.model.Compteur;
import com.equipe3.compteur.vue.vueClient.ClientViewHolder;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class CompteurListAdapter extends ListAdapter<Client, ClientViewHolder>{
    protected CompteurListAdapter(@NonNull @NotNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }
/*
    @NotNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return ClientViewHolder.create(parent);

    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Compteur current = getItem(position);

        holder.bind(String.valueOf(current.getIdentifiantClient()), current.getNomClient(), current.getPrenomClient());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UpdateClient est une méthode/class manquante*/
                /*Intent UpdateClient = new Intent(v.getContext(), com.equipe3.compteur.controler.UpdateClient.class);
                UpdateClient.putExtra("idClient", current.getIdentifiantClient());
                UpdateClient.putExtra("nomClient", current.getNomClient());
                UpdateClient.putExtra("prenomClient", current.getPrenomClient());
                v.getContext().startActivity(UpdateClient);
            }
        });
    }

    public static class ClientDiff extends DiffUtil.ItemCallback<Client> {

        @Override
        public boolean areItemsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return Objects.equals(oldItem.getIdentifiantClient(), newItem.getIdentifiantClient());
        }
    }*/
}