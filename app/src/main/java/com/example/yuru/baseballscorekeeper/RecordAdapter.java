package com.example.yuru.baseballscorekeeper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by YURU on 2018/6/13.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    // 儲存項目資料的 List 物件
    private List<Record> item_record;

    // 儲存最後一個項目的位置
    private int lastPosition = -1;
    private Context context;

    public RecordAdapter(List<Record> item_record, Context context) {
        this.item_record = item_record;
        this.context = context;
    }

    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 建立項目使用的畫面配置元件
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item02, parent, false);
        // 建立與回傳包裝好的畫面配置元件
        RecordAdapter.ViewHolder viewHolder = new RecordAdapter.ViewHolder(v);
        return viewHolder;
    }

    // 使用 ViewHolder 包裝項目使用的畫面元件
    public class ViewHolder extends RecyclerView.ViewHolder {

        // 編號、名稱、說明與是否選擇
        protected TextView text_gameName;
        protected TextView text_gameDate;

        // 包裝元件
        protected View rootView;

        public ViewHolder(View view) {
            super(view);

            // 使用父類別 ViewHolder 宣告的「itemView」欄位變數，
            // 取得背號、名稱
            text_gameName = (TextView) itemView.findViewById(R.id.card_gameName);
            text_gameDate = (TextView) itemView.findViewById(R.id.card_gameDate);

            // 設定包裝元件
            rootView = view;
        }
    }

    @Override
    public void onBindViewHolder(final RecordAdapter.ViewHolder holder, final int position) {
        // 讀取目前位置的項目物件
        final Record record = item_record.get(position);

        // 設定編號、名稱、說明與是否選擇
        holder.text_gameName.setText(record.getGameName());
        holder.text_gameDate.setText(record.getGameDate());  //String.valueOf(player.getPosition())

        // 設定動畫效果
        setAnimation(holder.rootView, position);
    }

    // 設定動畫效果
    private void setAnimation(View view, int position) {
        // 如果是最後一個項目
        if (position > lastPosition) {
            // 建立 Animation 動畫物件, 指定效果為由左方滑入
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            // 啟動動畫效果
            view.startAnimation(animation);
            // 儲存最後一個項目的位置
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return item_record.size();
    }

    // 新增一個項目
    public void add(Record record) {
        item_record.add(record);
        // 通知資料項目已經新增
        notifyItemInserted(item_record.size());
    }

    // 刪除一個項目
    public void remove(int position) {
        item_record.remove(position);
        // 通知資料項目已經刪除
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, item_record.size());
    }

    // 實作 ItemTouchHelperAdapter 介面的方法
    // 左右滑動項目
    @Override
    public void onItemDismiss(int position) {
        // 刪除項目
        remove(position);
    }

    // 實作 ItemTouchHelperAdapter 介面的方法
    // 長按並移動項目
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            // 如果是往下拖拉
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(item_record, i, i + 1);
            }
        } else {
            // 如果是往上拖拉
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(item_record, i, i - 1);
            }
        }

        // 通知資料項目已經移動
        notifyItemMoved(fromPosition, toPosition);
    }


}