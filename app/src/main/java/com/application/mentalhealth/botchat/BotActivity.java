package com.application.mentalhealth.botchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.application.mentalhealth.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BotActivity extends AppCompatActivity {

    private RecyclerView chatsRv;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFab;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatsModel> chatsModelArrayList;
    private ChatAdaptor chatAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        chatsRv = findViewById(R.id.idRvChats);
        userMsgEdt = findViewById(R.id.idEtMessage);
        sendMsgFab = findViewById(R.id.idFABsend);
        chatsModelArrayList = new ArrayList<>();
        chatAdaptor = new ChatAdaptor(chatsModelArrayList,this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        chatsRv.setLayoutManager(manager);
        chatsRv.setAdapter(chatAdaptor);

        sendMsgFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userMsgEdt.getText().toString().isEmpty()) {
                    Toast.makeText(BotActivity.this, "please enter the message", Toast.LENGTH_LONG).show();
                } else {
                    getResponse(userMsgEdt.getText().toString());
                    userMsgEdt.setText("");
                }
            }
        });

    }
    private void getResponse(String message) {
        chatsModelArrayList.add(new ChatsModel(message, USER_KEY));
        chatAdaptor.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=161286&key=GVNLpbjWlpqyAz6Q&uid=[uid]&msg="+message;
        String baseurl = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroFitApi retroFitApi = retrofit.create(RetroFitApi.class);
        Call<MsgModel> call = retroFitApi.getMessage(url);
        call.enqueue(new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if (response.isSuccessful()) {
                    MsgModel model = response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(), BOT_KEY));
                    chatAdaptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                chatsModelArrayList.add(new ChatsModel(t.getMessage(), BOT_KEY));
                chatAdaptor.notifyDataSetChanged();
            }
        });

    }
}