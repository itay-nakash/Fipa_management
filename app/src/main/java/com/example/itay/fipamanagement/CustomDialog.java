package com.example.itay.fipamanagement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

/**
 * Created by Itay on 01/05/2018.
 */

public class CustomDialog extends AppCompatDialogFragment {

    private SingleParty editedParty;
    private CustomDialogListener listener;
    private RadioGroup eventPosted;
    private RadioButton published,notPublished;
    private EditText minAge, fourDigitTime, customerCost, originalCustomerCost, ticketsLeft, maxTickets, partyTitle, place, partyId, accountId, description;
    private boolean selectedB,deleteB;
    private String minAgeS, fourDigitTimeS, customerCostS, originalCustomerCostS, ticketsLeftS, maxTicketsS, partyTitleS, placeS, partyIdS, accountIdS, descriptionS;
    ToggleButton deleteTB;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View view = inflater.inflate(R.layout.custom_dialog, null);
        initializeVariables(view);
        builder.setView(view)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        selectedB=published.isChecked();
                        getStringDataFromDialog();
                        listener.applyTexts(selectedB,
                                deleteB,
                                minAgeS,
                        fourDigitTimeS,
                        customerCostS,
                        originalCustomerCostS,
                        ticketsLeftS,
                        maxTicketsS,
                        partyTitleS,
                        placeS,
                        partyIdS,
                        accountIdS,
                        descriptionS);
                    }
                })
                // Add action buttons
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dont save changes
                    }
                });
        AlertDialog alertDialog = builder.create();
        //gets the dialog to be rtl
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            alertDialog.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        return alertDialog;
    }

    public void deleteTbCheck(){
        deleteTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    deleteB=true;
                } }
        });
    }
    public void initializeVariables(View view) {
        published=view.findViewById(R.id.radio_yes);
        notPublished=view.findViewById(R.id.radio_no);
        eventPosted = view.findViewById(R.id.eventPosted);
        minAge = view.findViewById(R.id.minAgae);
        fourDigitTime = view.findViewById(R.id.fourDigitTime);
        customerCost = view.findViewById(R.id.customerCost);
        originalCustomerCost = view.findViewById(R.id.originalCustomerCost);
        ticketsLeft = view.findViewById(R.id.ticketsLeft);
        maxTickets = view.findViewById(R.id.maxTickets);
        partyTitle = view.findViewById(R.id.partyTitle);
        place = view.findViewById(R.id.place);
        partyId = view.findViewById(R.id.partyId);
        accountId = view.findViewById(R.id.accountId);
        description = view.findViewById(R.id.description);
        deleteTB=view.findViewById(R.id.deleteBtn);
        setDialogValues();

    }

    public void setDialogValues(){
       if(editedParty.isEventPosted())
 //          published.setChecked(true);
       this.minAge.setText(String.valueOf(editedParty.getMinAge()));
       this.fourDigitTime.setText(String.valueOf(editedParty.getFourDigitTime()));
       this.customerCost.setText(String.valueOf(editedParty.getCustomerCost()));
       this.originalCustomerCost.setText(String.valueOf(editedParty.getOriginalCustomerCost()));
       this.ticketsLeft.setText(String.valueOf(editedParty.getTicketsLeft()));
       this.maxTickets.setText(String.valueOf(editedParty.getMaxTickets()));
       this.partyTitle.setText(editedParty.getPartyTitle());
       this.place.setText(editedParty.getPlace());
       this.partyId.setText(editedParty.getPartyId());
       this.accountId.setText(editedParty.getAccountId());
       this.description.setText(editedParty.getDescription());
    }

    public void getStringDataFromDialog() {
        minAgeS = minAge.getText().toString();
        fourDigitTimeS = fourDigitTime.getText().toString();
        customerCostS = customerCost.getText().toString();
        originalCustomerCostS = originalCustomerCost.getText().toString();
        ticketsLeftS = ticketsLeft.getText().toString();
        maxTicketsS = maxTickets.getText().toString();
        partyTitleS = partyTitle.getText().toString();
        placeS = place.getText().toString();
        partyIdS = partyId.getText().toString();
        accountIdS = accountId.getText().toString();
        descriptionS = description.getText().toString();
        deleteTbCheck();
    }



    public void setEditedParty(SingleParty editedParty) {
        this.editedParty = editedParty;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener= (CustomDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" must implement CustomDialogListener");
        }

    }


    public interface CustomDialogListener {
        void applyTexts(boolean eventPosted, boolean deleteB, String minAge, String fourDigitTime, String customerCost, String originalCustomerCost, String ticketsLeft, String maxTickets, String partyTitle, String place, String partyId, String accountId, String description);

    }
}
