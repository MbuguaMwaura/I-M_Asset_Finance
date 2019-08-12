package com.example.assetfinance.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.assetfinance.R;
import com.example.assetfinance.models.Vehicle;
import com.example.assetfinance.util.ItemTouchHelperViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseVehicleViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    @BindView(R.id.savedfinancedBy)
    TextView financedBy;
    @BindView(R.id.savedloanBalance) TextView loanBalance;
    @BindView(R.id.savedmake) TextView make;
    @BindView(R.id.savedmodel) TextView model;
    @BindView(R.id.savedvehicleRegNo) TextView regNo;
    @BindView(R.id.cardVehicle) public CardView cardVehicle;


    View mView;
    Context mContext;
    public FirebaseVehicleViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindVehicle(Vehicle vehicle){
        ButterKnife.bind(this,mView);
        financedBy.setText(vehicle.getFinancedBy());
        loanBalance.setText(vehicle.getBalanceLoan());
        make.setText(vehicle.getMake());
        model.setText(vehicle.getModel());
        regNo.setText(vehicle.getRegNo());

    }

    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.7f)
                .scaleY(0.7f)
                .setDuration(300);

    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);

    }
}
