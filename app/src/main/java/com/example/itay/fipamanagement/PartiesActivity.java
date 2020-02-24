package com.example.itay.fipamanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


//TODO fix the age bag- after refresh age null
public class PartiesActivity extends AppCompatActivity implements CustomDialog.CustomDialogListener {

    static Boolean isSuperAdmin = false;// Ofir and Shahak
    Button barcodeBtn;
    TextView publishedTv,waitingForPublishedTv,waitingForApprovalTv;
    RecyclerView publishedRV,waitingForPublishedRV,waitingForApprovalRV;
    private RecyclerView.LayoutManager publishedLM ,waitingForPublishedLM, waitingForApprovalLM;
    PartyAdapter publishedAdp,waitingForPublishedAdp,waitingForApprovalAdp;
    ArrayList<SingleParty> publishedList, waitingForPublishedList, waitingForApprovalList;
    SingleParty editedParty;
    int editedPosition=-1;
    ArrayList<SingleParty> listEdited;
    Intent barcodeIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);
        getIntentExtras();
        initializeVariables();
        addDataToLists();
        bindAdaptersToLists();
        initializeLM();
        initializeRv();
        initializeListeners();
    }
    public void initializeVariables() {
        publishedList=new ArrayList<>();
        waitingForPublishedList=new ArrayList<>();
        waitingForApprovalList=new ArrayList<>();
        barcodeBtn = findViewById(R.id.barcode_btn);
        barcodeIntent = new Intent(PartiesActivity.this, BarcodeActivity.class);
        publishedTv = findViewById(R.id.published_tv);
        waitingForPublishedTv = findViewById(R.id.waiting_for_published_tv);
        waitingForApprovalTv = findViewById(R.id.waiting_for_approval_tv);
        publishedRV=findViewById(R.id.published_recyclerView);
        waitingForPublishedRV=findViewById(R.id.waiting_for_published_recyclerView);
        waitingForApprovalRV=findViewById(R.id.waiting_for_approval_recyclerView);
    }
    public void addDataToLists(){
        addDataFromDBToList(publishedList);
        addDataFromDBToList(waitingForPublishedList);
        addDataFromDBToList(waitingForApprovalList);
    }
    public void bindAdaptersToLists(){
        publishedAdp= bindSingleAdapterToList(publishedRV,publishedList);
        waitingForPublishedAdp= bindSingleAdapterToList(waitingForPublishedRV,waitingForPublishedList);
        waitingForApprovalAdp= bindSingleAdapterToList(waitingForApprovalRV,waitingForApprovalList);
    }
    public void initializeLM(){
        publishedLM=new LinearLayoutManager(this);
        waitingForPublishedLM = new LinearLayoutManager(this);
        waitingForApprovalLM=new LinearLayoutManager(this);
    }
    public void initializeRv(){
        publishedRV.setHasFixedSize(true);
        waitingForPublishedRV.setHasFixedSize(true);
        waitingForApprovalRV.setHasFixedSize(true);
        waitingForApprovalRV.setHasFixedSize(true);
        publishedRV.setLayoutManager(publishedLM);
        waitingForPublishedRV.setLayoutManager(waitingForPublishedLM);
        waitingForApprovalRV.setLayoutManager(waitingForApprovalLM);
    }

    public void addDataFromDBToList(ArrayList<SingleParty> partiesList){
        //gets from the server the relevant data
        SingleParty p=new SingleParty();
        partiesList.add(p);
        partiesList.add(p);
        partiesList.add(p);
        partiesList.add(p);
        partiesList.add(p);
        partiesList.add(p);

    }
    public PartyAdapter bindSingleAdapterToList(RecyclerView rv, ArrayList<SingleParty> partiesList){
        PartyAdapter adapter = new PartyAdapter(this, partiesList);
        rv.setAdapter(adapter);
        return adapter;
    }


    public void initializeListeners(){
        barcodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(barcodeIntent);
            }
        });
    }
    public void getIntentExtras(){
        Intent intent = getIntent();
        isSuperAdmin = intent.getBooleanExtra("isSuperAdmin",false); //if it's a string you stored.
    }

    public void showCustomDialog(SingleParty editedParty, int position, ArrayList<SingleParty> listEdited){
        CustomDialog customDialog=new CustomDialog();
        customDialog.setEditedParty(editedParty);
        //check if he is super admin
        //super admin- delete waiting for published and edit/delete published one
        this.editedParty=editedParty;
        this.editedPosition=position;
        this.listEdited=listEdited;
        customDialog.show(getSupportFragmentManager(),"");
     //   customDialog.setDialogValues();
    }

    @Override
    public void applyTexts(boolean eventPosted,boolean deleteB, String minAge, String fourDigitTime, String customerCost, String originalCustomerCost, String ticketsLeft, String maxTickets, String partyTitle, String place, String partyId, String accountId, String description) {
        if(deleteB){
            listEdited.remove(editedPosition);
        }
        else {
            editedParty = editedParty.changePartyData(eventPosted, minAge, fourDigitTime, customerCost, originalCustomerCost, ticketsLeft, maxTickets, partyTitle, place, partyId, accountId, description);
        }
        //get the data and edit it in the db
    }
}

