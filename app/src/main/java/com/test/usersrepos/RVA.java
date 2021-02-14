package com.test.usersrepos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVA extends RecyclerView.Adapter<MVH>{

    private List<Repo> repos;

    public RVA(List<Repo> repo) {
        this.repos = repo;
    }

    public void setList(List<Repo> repos){
        this.repos = repos;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contaner, parent, false);
        return new MVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {
        holder.onBind(repos.get(position));

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public interface OnItemClick {
        public void onClick(Repo model);
    }
}
