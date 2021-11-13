package com.application.mentalhealth.botchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.mentalhealth.R;

import java.util.ArrayList;

public class ChatAdaptor extends RecyclerView.Adapter {


    private ArrayList<ChatsModel> chatsModelArrayList;
    private Context context;

    public ChatAdaptor(ArrayList<ChatsModel> chatsModelArrayList, Context context) {
        this.chatsModelArrayList = chatsModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rvitem, parent, false);
                return new userviewHolder(view);

            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rvitem, parent, false);
                return new botViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatsModel chatsModel = chatsModelArrayList.get(position);
        switch (chatsModel.getSender()) {
            case "user":
                ((userviewHolder) holder).UserTv.setText(chatsModel.getMessage());
                break;
            case "bot":
                ((botViewHolder) holder).MessageTv.setText(chatsModel.getMessage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatsModelArrayList.get(position).getSender()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return chatsModelArrayList.size();
    }

    public class userviewHolder extends RecyclerView.ViewHolder {
        TextView UserTv;

        public userviewHolder(@NonNull View itemView) {
            super(itemView);
            UserTv = itemView.findViewById(R.id.idTvUser);
        }
    }

    public class botViewHolder extends RecyclerView.ViewHolder {
        TextView MessageTv;

        public botViewHolder(@NonNull View itemView) {
            super(itemView);
            MessageTv = itemView.findViewById(R.id.idTvBot);
        }
    }
}
