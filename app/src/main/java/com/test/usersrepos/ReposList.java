package com.test.usersrepos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposList extends BaseFragment  {

    private RecyclerView rvList;

    private ArrayList<Repo> list;

    private RVA adapter;

    private TextView txtUserName2;


    @Override
    public String getTitle() {
        return null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reposlist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, EditText txtUsersName) {
        super.onViewCreated(view, savedInstanceState);

        list=new ArrayList<>();
        rvList = view.findViewById(R.id.rvList);
        adapter = new RVA(list);
        adapter.notifyDataSetChanged();

        getRepo(""+txtUsersName.getText().toString());

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(adapter);

        txtUserName2=view.findViewById(R.id.txtUserName2);

        txtUserName2.setText(txtUsersName.getText().toString());
    }

    private void getRepo(String name) {
        RestService.create().getRepo(name).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                list.addAll(response.body());
                adapter.setList(list);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
