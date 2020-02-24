package com.example.itay.fipamanagement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Itay on 29/04/2018.
 */

public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.PartyViewHolder> {

    private Context context;
    private ArrayList<SingleParty> partyList;

    public PartyAdapter(Context context,ArrayList<SingleParty> partyList){
        this.context=context;
        this.partyList=partyList;
    }

    @Override
    public PartyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_list,null);
        PartyViewHolder holder = new PartyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PartyViewHolder holder, final int position) {
        SingleParty party=partyList.get(position);
        String partyItemTitle= party.getPartyTitle()+ " at "+ party.getFourDigitTime()+ " in "+ party.getPlace();
        holder.partyDescription.setText(partyItemTitle);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PartiesActivity)context).showCustomDialog(partyList.get(position),position,partyList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return partyList.size();
    }


    class PartyViewHolder extends RecyclerView.ViewHolder{

        TextView partyDescription;
        public LinearLayout linearLayout;

        public PartyViewHolder(View itemView) {
            super(itemView);
            partyDescription=itemView.findViewById(R.id.party_detailes_list_tv);
            linearLayout=itemView.findViewById(R.id.item_linear_layout);
        }
    }
}
