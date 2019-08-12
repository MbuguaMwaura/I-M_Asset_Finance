package com.example.assetfinance.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.assetfinance.R;
import com.example.assetfinance.models.Property;
import com.example.assetfinance.models.Vehicle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebasePropertyViewHolder  extends RecyclerView.ViewHolder {
    @BindView(R.id.savedproperty)
    TextView property;
    @BindView(R.id.savedsize) TextView size;
    @BindView(R.id.savedlocation) TextView location;
    @BindView(R.id.savedlrNo) TextView lrNo;
    @BindView(R.id.savedvalue) TextView value;
    View mView;
    Context mContext;


    public FirebasePropertyViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindProperty(Property mproperty){
        ButterKnife.bind(this,mView);
        property.setText(mproperty.getProperty());
        size.setText(mproperty.getSize());
        location.setText(mproperty.getLocation());
        lrNo.setText(mproperty.getLrNo());
        value.setText(mproperty.getApproxValue());

    }
}
