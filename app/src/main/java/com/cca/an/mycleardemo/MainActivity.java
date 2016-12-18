package com.cca.an.mycleardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText editText;
    private ListView listView;
    private LinearLayout activitymain;
    private List<CompanyTextBean> mListCompanyName;
    private CompanyAdapter companyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();


    }





    private void initialize() {

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        activitymain = (LinearLayout) findViewById(R.id.activity_main);


        mListCompanyName = new ArrayList<>();

        for (int i=0;i<5;i++) {
            CompanyTextBean item=new CompanyTextBean();
            item.setCompanyName("小后台" + i+"");

            item.setName("成龙");
            Log.i(TAG,"----"+item.getCompanyName());

            mListCompanyName.add(item);
        }

        for (int i=0;i<5;i++) {
            CompanyTextBean item=new CompanyTextBean();
            item.setCompanyName("小后台");

            item.setName("成好纠");
            Log.i(TAG,"----"+item.getCompanyName());

            mListCompanyName.add(item);
        }

        CompanyTextBean item=new CompanyTextBean();
        item.setCompanyName("中上公司");

        item.setName("李连杰");
        Log.i(TAG,"----"+item.getCompanyName());

        mListCompanyName.add(item);


        companyAdapter = new CompanyAdapter(mListCompanyName,MainActivity.this);
        listView.setAdapter(companyAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG,"-----输入前-----");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.i(TAG,"----------"+s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG,"-----输入后----");
            }
        });





    }
}
