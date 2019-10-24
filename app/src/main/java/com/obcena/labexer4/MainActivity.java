package com.obcena.labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, version, apiLvl, rDate, message;
    ListView list;
    int[] cLogo = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread, R.drawable.honeycomb,
            R.drawable.icecreamsandwich, R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat, R.drawable.oreo, R.drawable.pie, R.drawable.android10};

    ArrayList<Android> androidVersion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.names);
        version = getResources().getStringArray(R.array.version);
        apiLvl = getResources().getStringArray(R.array.apiLvl);
        rDate = getResources().getStringArray(R.array.rDate);
        message = getResources().getStringArray(R.array.message);
        list = findViewById(R.id.lvAndroidVersions);
        for (int i = 0; i < names.length; i++) {
            androidVersion.add(new Android(cLogo[i], names[i], version[i], apiLvl[i], rDate[i], message[i]));

        }
        list = findViewById(R.id.lvAndroidVersions);
        CollegeAdapter adapter = new CollegeAdapter(this, R.layout.item, androidVersion);
        list.setAdapter(adapter);
        // list.position
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidVersion.get(i).getNames());
        dialog.setIcon(androidVersion.get(i).getLogo());
        dialog.setMessage(androidVersion.get(i).getMessage());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}
