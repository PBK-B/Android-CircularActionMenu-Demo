package com.zmide.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zmide.myapplication3.view.CircularActionMenu;

public class MainActivity extends AppCompatActivity {

    String TAG = "tzmax";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        CircularActionMenu menu = findViewById(R.id.main_menu);
        menu.addOnStateChangeListener(new CircularActionMenu.OnStateChangeListenerAdapter() {
            public void onCollapsed(CircularActionMenu menu) {
                // 关闭
                Log.d(TAG, "onCollapsed: ");
            }

            public void onExpanded(CircularActionMenu menu) {
                // 展开
                Log.d(TAG, "onExpanded: ");
            }
        });

        Log.d(TAG, "initView: " + menu.getItemCount());


        findViewById(R.id.id_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: " + menu.isExpanded());
                if(!menu.isExpanded()) {
                    menu.expand(menu.getItemCount());
                } else {
                    menu.collapse();
                }

            }
        });

    }
}