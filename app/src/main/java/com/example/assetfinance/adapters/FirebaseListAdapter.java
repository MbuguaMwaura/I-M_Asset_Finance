package com.example.assetfinance.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.assetfinance.R;
import com.example.assetfinance.models.BankDetails;
import com.example.assetfinance.ui.PreviewActivity;
import com.example.assetfinance.util.ItemTouchHelperAdapter;
import com.example.assetfinance.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;



import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseListAdapter extends FirebaseRecyclerAdapter<BankDetails, FirebaseBankViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<BankDetails> mBank = new ArrayList<>();

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseListAdapter(@NonNull FirebaseRecyclerOptions<BankDetails> options,Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mBank.add(dataSnapshot.getValue(BankDetails.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void onBindViewHolder(@NonNull final FirebaseBankViewHolder holder, int position, @NonNull BankDetails model) {
        holder.bindBank(model);

        holder.mCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PreviewActivity.class);
                intent.putExtra("position", holder.getAdapterPosition());
                intent.putExtra("chuck", Parcels.wrap(mBank));
                mContext.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public FirebaseBankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_item,viewGroup,false);
        return new FirebaseBankViewHolder(view);
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mBank,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        setIndexInFirebase();
        return false;
    }
    private void setIndexInFirebase() {
        for (BankDetails bankDetails: mBank) {
            int index = mBank.indexOf(bankDetails);
            DatabaseReference ref = getRef(index);
            bankDetails.setIndex(Integer.toString(index));
            ref.setValue(bankDetails);
        }
    }


    @Override
    public void onItemDismiss(int position) {
        mBank.remove(position);
        getRef(position).removeValue();
    }
    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }
}
