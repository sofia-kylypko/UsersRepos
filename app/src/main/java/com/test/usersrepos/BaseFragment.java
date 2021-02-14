package com.test.usersrepos;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public abstract String getTitle();

    public abstract void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, EditText txtUsersName);
}
