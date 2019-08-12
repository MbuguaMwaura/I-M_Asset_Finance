package com.example.assetfinance.adapters;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.assetfinance.R;
import com.example.assetfinance.models.Credit;
import com.example.assetfinance.models.Property;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseCreditViewHolder  extends RecyclerView.ViewHolder  {

    @BindView(R.id.savedname)
    TextView name;
    @BindView(R.id.savedfacilityType) TextView facilityType;
    @BindView(R.id.savedlimit) TextView limit;
    @BindView(R.id.savedoutstanding) TextView outstanding;
    View mView;
    Context mContext;


    public FirebaseCreditViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }
    public void bindCredit(Credit credit){
        ButterKnife.bind(this,mView);
        name.setText(credit.getName());
        facilityType.setText(credit.getFacilityType());
        limit.setText(credit.getSanctionedLimit());
        outstanding.setText(credit.getCurrentOutstanding());

    }
}
