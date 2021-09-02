package com.example.glianativetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.glia.widgets.GliaWidgets;
import com.glia.widgets.GliaWidgetsConfig;
import com.glia.widgets.chat.ChatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GliaWidgets.onAppCreate(getApplication());

//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        GliaWidgetsConfig gliaConfig = new GliaWidgetsConfig.Builder()
                .setApiToken("aYDwJZ0TemP5ub9rwQBXcg")
                .setAppToken("xWa2EKJTN35En26o")
                .setSiteId("72c76913-ff1b-48a6-b209-bbeb57bd8649")
                .setRegion("beta")
                .setContext(getApplicationContext())
                .build();

        GliaWidgets.init(gliaConfig);


        this.findViewById(R.id.chat_activity_button).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            intent.putExtra(GliaWidgets.COMPANY_NAME, "Test");
            intent.putExtra(GliaWidgets.QUEUE_ID, "a0b87175-4ed1-44a7-9e78-e798f45d233f");
            intent.putExtra(GliaWidgets.CONTEXT_URL,"a0b87175-4ed1-44a7-9e78-e798f45d233f");
            intent.putExtra(GliaWidgets.USE_OVERLAY, false);
            startActivity(intent);
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        GliaWidgets.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}