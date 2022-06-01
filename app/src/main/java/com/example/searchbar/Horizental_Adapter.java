package com.example.searchbar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Horizental_Adapter extends RecyclerView.Adapter<Horizental_Adapter.ViewHolder> {

    List<Horizental_Model> list;
    Context context;
    public OnItemClickListener onItemClickListener;

    public Horizental_Adapter(Context context, List<Horizental_Model> list) {
        this.list = list;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    interface OnItemClickListener {
        void OnItem(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_horizental, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Horizental_Model horizental_model = list.get(position);
        holder.tv.setText(horizental_model.getTitle());
        Log.d("ggg","values "+horizental_model.getTitle()  +"  hhh "+ horizental_model.getImage() );
        Glide.with(context).load(horizental_model.getImage()).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position >= 0) {
                            onItemClickListener.OnItem(position);
                        }
                    }
                }
            });
        }
    }
}
