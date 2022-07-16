package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder>{

    private List<Poetry> mPoetryList;
    private OnItemIsClickListener onItemIsClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View PoetryView;
        TextView poetryName;
        TextView poetryAuthor;

        public ViewHolder(View view) {
            super(view);
            PoetryView = view;
            poetryName = (TextView) view.findViewById(R.id.poetry_name);
            poetryAuthor = (TextView) view.findViewById(R.id.poetry_author);
        }
    }

    public PoetryAdapter(List<Poetry> poetryList) {
        mPoetryList = poetryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.poetryName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                onItemIsClickListener.onItemNameIsClick(position);
            }
        });

        holder.poetryAuthor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                onItemIsClickListener.onItemAuthorIsClick(position);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Poetry poetry = mPoetryList.get(position);
        holder.poetryName.setText(poetry.getPoetryName());
        holder.poetryAuthor.setText(poetry.getPoetryAuthor());
    }

    @Override
    public int getItemCount() {
        return mPoetryList.size();
    }

    public interface OnItemIsClickListener {
        void onItemNameIsClick(int position);
        void onItemAuthorIsClick(int position);
    }

    public void setOnItemIsClick(OnItemIsClickListener onItemIsClickListener) {
        this.onItemIsClickListener = onItemIsClickListener;
    }

}