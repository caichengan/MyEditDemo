package com.cca.an.mycleardemo;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by an on 2016/12/18.
 */



    class CompanyAdapter extends BaseAdapter{

    private static final String TAG = "CompanyAdapter";
    private List<CompanyTextBean> mListCompanyName;
    private Context mContexts;
    public CompanyAdapter(List<CompanyTextBean> mListCompany, Context mContext){

        Log.i(TAG,"-------CompanyAdapter---");
        this.mContexts=mContext;
        this.mListCompanyName=mListCompany;

        for (int i=0;i<mListCompany.size();i++){
            String companyName = mListCompany.get(i).getCompanyName();
            Log.i(TAG,"------companyName---------"+companyName);
        }

    }
        @Override
        public int getCount() {
            if (mListCompanyName.size()>0){
                return mListCompanyName.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return mListCompanyName.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Log.i(TAG,"------进入----"+position);
            ViewHolder holder;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(mContexts,R.layout.item_main,null);

                holder. mCompanyLIneart= (LinearLayout) convertView.findViewById(R.id.CompanyLinear);
                holder.mCompanyName= (TextView) convertView.findViewById(R.id.companyName);
                holder.mName= (TextView) convertView.findViewById(R.id.Name);

                convertView.setTag(holder);

            }else{
                holder= (ViewHolder) convertView.getTag();

            }

            CompanyTextBean companyTextBean = mListCompanyName.get(position);

            String companyName = companyTextBean.getCompanyName();

            if (companyName.equals("中上公司")){


                TextView tv=new TextView(mContexts);
                for (int i=0;i<5;i++){

                    tv.setText("成安"+i);
                    holder. mCompanyLIneart.addView(tv);
                }


            }


            String name = companyTextBean.getName();
            Log.i(TAG,"------进入----"+companyName+name);
            holder.mCompanyName.setText(companyName);

            holder.mName.setText(name);

            return convertView;
        }

    class ViewHolder{
        LinearLayout mCompanyLIneart;
        TextView mCompanyName;
        TextView mName;
    }
    }



