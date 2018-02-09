package com.example.databindingtest;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wuheng on 18-2-9.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BindingHolder>{
    List<User> datas;

    public RecyclerViewAdapter(List<User> datas){
        this.datas = datas;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recyclerview_item, parent, false);
        return new BindingHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(BR.user, datas.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(datas != null){
            return datas.size();
        }
        return 0;
    }

    public User getItem(int position){
        if(position < datas.size()) {
            return datas.get(position);
        }
        return null;
    }

    public void swapData(List<User> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    class BindingHolder extends RecyclerView.ViewHolder{
        private final ViewDataBinding viewDataBinding;
        public BindingHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }
        public ViewDataBinding getViewDataBinding(){
            return viewDataBinding;
        }
    }
}
