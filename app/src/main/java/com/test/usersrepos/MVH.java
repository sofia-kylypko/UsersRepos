package com.test.usersrepos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MVH extends RecyclerView.ViewHolder {

    private TextView txtRepo;

    public MVH(@NonNull View itemView) {
        super(itemView);

        txtRepo=itemView.findViewById(R.id.txtRepo);
    }

    public void onBind(Repo repo){
        txtRepo.setText(repo.getName());
    }
}
