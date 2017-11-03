package com.it.hungvt.mvvmdemo.view;

import android.database.Observable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.it.hungvt.mvvmdemo.R;
import com.it.hungvt.mvvmdemo.databinding.ActivityMainBinding;
import com.it.hungvt.mvvmdemo.model.User;
import com.it.hungvt.mvvmdemo.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ObservableField<String> title = new ObservableField<>();
    private MainViewModel viewModel;
    private ArrayList<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMain(this);
        title.set("Welcome DataBinding");
        viewModel = new MainViewModel(this);
        setupData();


    }

    private void setupData() {
        users = new ArrayList<>();
        users.add(new User(R.drawable.ic_heart,"Heart"));
        users.add(new User(R.drawable.ic_my_heart,"My Heart"));
        users.add(new User(R.drawable.ic_love,"Love"));
        users.add(new User(R.drawable.ic_smile,"Smile"));
        viewModel.setData(users);
    }
}
