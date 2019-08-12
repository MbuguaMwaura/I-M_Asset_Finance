package com.example.assetfinance.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.assetfinance.R;
import com.example.assetfinance.models.BankDetails;
import com.example.assetfinance.util.ItemTouchHelperViewHolder;

public class FirebaseBankViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    View mView;
    Context mContext;
    public CardView mCard;
    public TextView mBankName;
    public TextView mBranch;
    public TextView mAccountNumber;
    public TextView mOdLimit;
    public TextView mOutstandingLoans;
    public FirebaseBankViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindBank (BankDetails bank){
        mCard = (CardView) mView.findViewById(R.id.card2);
        mBankName = (TextView) mView.findViewById(R.id.bankName);
        mBranch = (TextView) mView.findViewById(R.id.branch);
        mAccountNumber = (TextView) mView.findViewById(R.id.accountNumber);
        mOdLimit = (TextView) mView.findViewById(R.id.odLimit);
        mOutstandingLoans = (TextView) mView.findViewById(R.id.outStandingLoans);

        mBankName.setText(bank.getBankName());
        mBranch.setText(bank.getBranch());
        mAccountNumber.setText(bank.getAccountNumber());
        mOdLimit.setText(bank.getOdLimit());
        mOutstandingLoans.setText(bank.getOutStandingLoans());
    }

    @Override
    public void onItemSelected() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.7f)
                .scaleY(0.7f)
                .setDuration(300);
    }

    @Override
    public void onItemClear() {
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }
}
