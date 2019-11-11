package com.example.moviecatalogue19.list_movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue19.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<MovieModel> modelList;

    private OnItemClickListener mItemClickListener;

    public ListMovieAdapter(Context context,ArrayList<MovieModel> modelList){
        this.mContext = context;
        this.modelList = modelList;

    }
    public void updateList(ArrayList<MovieModel> modelList){
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_list, viewGroup,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final MovieModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder)holder;

            genericViewHolder.itemTxtTitle.setText(model.getTitle());

            if (model.getOverview().length()>50){
                genericViewHolder.itemTxtOverview.setText(model.getOverview().substring(0,49)+".....");
            }else{
                genericViewHolder.itemTxtOverview.setText(model.getOverview());
            }
            genericViewHolder.imgposter.setImageResource(model.getPoseter());
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  void setmItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }
    private MovieModel getItem(int position){
        return modelList.get(position);
    }


    public interface OnItemClickListener{
        void onItemClick(View view, int position , MovieModel model);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgposter;
        private TextView   itemTxtTitle;
        private TextView itemTxtOverview;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.imgposter = itemView.findViewById(R.id.img_poster);
            this.itemTxtTitle = itemView.findViewById(R.id.item_txt_title);
            this.itemTxtOverview = itemView.findViewById(R.id.item_txt_overview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));



                }
            });
        }
    }

}

