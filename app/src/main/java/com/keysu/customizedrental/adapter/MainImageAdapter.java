package com.keysu.customizedrental.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.keysu.customizedrental.entity.MainImageData;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class MainImageAdapter extends BannerAdapter<MainImageData, MainImageAdapter.BannerViewHolder> {


    public MainImageAdapter(List<MainImageData> datas) {
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, MainImageData data, int position, int size) {
        //holder.imageView.setImageResource(data.imageRes);
        Glide.with(holder.imageView.getContext()).load((String)data.getImageUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击事件
                        Toast.makeText(v.getContext(),"点击了"+position,Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
