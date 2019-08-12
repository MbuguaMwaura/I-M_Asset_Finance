package com.example.assetfinance.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.assetfinance.R;
import com.example.assetfinance.models.BankDetails;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>{
    private ArrayList<BankDetails> mBank;
    private Context context;


    public BankAdapter (ArrayList<BankDetails> banks, Context context){
        context = context;
        mBank = banks;
    }


    @Override
    public BankAdapter.BankViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_item,viewGroup,false);
       BankViewHolder viewHolder = new BankViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( BankAdapter.BankViewHolder bankViewHolder, int i) {
        bankViewHolder.bindBanks(mBank.get(i));
    }

    @Override
    public int getItemCount() {
        return mBank.size();
    }

    public class BankViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.bankName)
        TextView bankName;
        @BindView(R.id.branch) TextView branch;
        @BindView(R.id.accountNumber) TextView accountNumber;
        @BindView(R.id.odLimit) TextView odLimit;
        @BindView(R.id.outStandingLoans) TextView outStandingLoans;
        private Context mContext;

        public BankViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mContext = view.getContext();

        }
        public void bindBanks(BankDetails bank){
           bankName.setText(bank.getBankName());
           branch.setText(bank.getBranch());
           accountNumber.setText(bank.getAccountNumber());
           odLimit.setText(bank.getOdLimit());
           outStandingLoans.setText(bank.getOutStandingLoans());
        }


    }

}
