package com.it.hungvt.mvvmdemo.viewmodel;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by Administrator on 11/3/2017.
 */

public class RecyclerBindingAdapter<T> extends RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder> {


    private int holderLayout;
    private int varId;
    private AbstractList<T> items = new ArrayList<T>();
    private OnItemClickListener<T> onItemClickListener;

    public RecyclerBindingAdapter(int holderLayout, int varId, AbstractList<T> items) {
        this.holderLayout = holderLayout;
        this.varId = varId;
        this.items = items;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(holderLayout,parent,false);
        return new BindingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        T item  = items.get(position);
        holder.getDataBinding().getRoot().setOnClickListener(v->{
            if (onItemClickListener!=null){
                onItemClickListener.onItemClick(position,item);
            }
        });

        holder.getDataBinding().setVariable(varId,item);
    }

    public void setItems(AbstractList<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener<T>{
        void onItemClick(int position,T item);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class BindingHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding dataBinding;
        public BindingHolder(View itemView) {
            super(itemView);
            dataBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getDataBinding() {
            return dataBinding;
        }
    }

}
