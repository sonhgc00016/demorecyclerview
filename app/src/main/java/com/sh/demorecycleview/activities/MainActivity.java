package com.sh.demorecycleview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

import com.sh.demorecycleview.R;
import com.sh.demorecycleview.Utils.SimpleItemTouchHelperCallback;
import com.sh.demorecycleview.adapters.DataAdapter;
import com.sh.demorecycleview.models.AndroidVersion;

public class MainActivity extends AppCompatActivity {

    private final String arr_android_version_name[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String arr_android_img_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_android);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(androidVersions, getApplicationContext());
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private ArrayList<AndroidVersion> prepareData() {
        ArrayList<AndroidVersion> androidVersions = new ArrayList<>();
        for (int i = 0; i < arr_android_version_name.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(arr_android_version_name[i]);
            androidVersion.setAndroid_img_url(arr_android_img_urls[i]);
            androidVersions.add(androidVersion);
        }
        return androidVersions;
    }
}
