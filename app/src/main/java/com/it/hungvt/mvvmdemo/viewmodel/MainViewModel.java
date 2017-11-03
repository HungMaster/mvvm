package com.it.hungvt.mvvmdemo.viewmodel;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.hungvt.mvvmdemo.BR;
import com.it.hungvt.mvvmdemo.R;
import com.it.hungvt.mvvmdemo.RecyclerConfiguration;
import com.it.hungvt.mvvmdemo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/3/2017.
 */

public class MainViewModel {
    private Context context;
    private RecyclerBindingAdapter<User> adapter = new RecyclerBindingAdapter<>(R.layout.item_user,BR.item,new ArrayList<>());
    private RecyclerConfiguration recyclerConfiguration = new RecyclerConfiguration();

    public MainViewModel(Context context) {
        this.context = context;
        initRecycler();
    }

    public void setData(List<User> users) {
        adapter.setItems(new ArrayList<>(users));
    }


    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerConfiguration.setLayoutManager(layoutManager);
        recyclerConfiguration.setItemAnimator(new DefaultItemAnimator());

        recyclerConfiguration.setItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }
        });
        recyclerConfiguration.setAdapter(adapter);
        adapter.setOnItemClickListener(((position, item) -> {

        }));
    }
}
