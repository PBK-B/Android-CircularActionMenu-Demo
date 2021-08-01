package com.zmide.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
//        CircularActionMenu menu = findViewById(R.id.main_menu);
        CircularActionMenu menu = (CircularActionMenu) View.inflate(this, R.layout.circular_action_menu, null);

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

        ImageView btn2 = findViewById(R.id.id_button2);
        ViewGroup mViewBox = (ViewGroup) btn2.getParent();
        mViewBox.addView(menu);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: " + menu.isExpanded());
                if (!menu.isExpanded()) {
                    menu.setVisibility(View.VISIBLE);
                    menu.expand(Gravity.LEFT);
                } else {
                    menu.collapse();
                    menu.setVisibility(View.GONE);
                }

            }
        });

        for (int i = 0; i < menu.getItemCount(); i++) {
            View item = menu.getItemAt(i);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) item.getLayoutParams();
            params.gravity = Gravity.CENTER;
            item.setLayoutParams(params);
        }

        findViewById(R.id.main_img1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示 Image 1", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: img1");
            }
        });

        findViewById(R.id.main_img5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示 Image 5", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: img5");
            }
        });

        menu.collapse();


    }
}