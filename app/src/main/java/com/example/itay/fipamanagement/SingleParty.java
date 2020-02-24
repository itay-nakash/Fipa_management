package com.example.itay.fipamanagement;

/**
 * Created by Itay on 29/04/2018.
 */

public class SingleParty {
    private boolean eventPosted;
    private int minAge,fourDigitTime,customerCost,originalCustomerCost,ticketsLeft,maxTickets;
    private String partyTitle,place,partyId,accountId,description,mainPicture;

    public SingleParty(){ //for testing
        eventPosted= true;
        minAge= 18;
        fourDigitTime = 2230;
        customerCost = 120;
        originalCustomerCost = 150;
        ticketsLeft = 5;
        maxTickets = 1000;
        partyTitle = "test";
        place = "rehovot";
        partyId = "testID";
        accountId= "itay";
        description=" good party and test together";
        mainPicture="1";
    }

    public SingleParty(boolean eventPosted, int minAge, int fourDigitTime, int customerCost, int originalCustomerCost, int ticketsLeft, int maxTickets, String partyTitle, String place, String partyId, String accountId, String description, String mainPicture) {
        this.eventPosted = eventPosted;
        this.minAge = minAge;
        this.fourDigitTime = fourDigitTime;
        this.customerCost = customerCost;
        this.originalCustomerCost = originalCustomerCost;
        this.ticketsLeft = ticketsLeft;
        this.maxTickets = maxTickets;
        this.partyTitle = partyTitle;
        this.place = place;
        this.partyId = partyId;
        this.accountId = accountId;
        this.description = description;
        this.mainPicture = mainPicture;
    }
    public SingleParty changePartyData(boolean eventPosted, String minAge, String fourDigitTime, String customerCost, String originalCustomerCost, String ticketsLeft, String maxTickets, String partyTitle, String place, String partyId, String accountId, String description){
        this.eventPosted = eventPosted;
        this.minAge = Integer.parseInt(minAge);
        this.fourDigitTime = Integer.parseInt(fourDigitTime);
        this.customerCost = Integer.parseInt(customerCost);
        this.originalCustomerCost = Integer.parseInt(originalCustomerCost);
        this.ticketsLeft = Integer.parseInt(ticketsLeft);
        this.maxTickets = Integer.parseInt(maxTickets);
        this.partyTitle = partyTitle;
        this.place = place;
        this.partyId = partyId;
        this.accountId = accountId;
        this.description = description;
        return this;
    }



    public boolean isEventPosted() {
        return eventPosted;
    }

    public void setEventPosted(boolean eventPosted) {
        this.eventPosted = eventPosted;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getFourDigitTime() {
        return fourDigitTime;
    }

    public void setFourDigitTime(int fourDigitTime) {
        this.fourDigitTime = fourDigitTime;
    }

    public int getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(int customerCost) {
        this.customerCost = customerCost;
    }

    public int getOriginalCustomerCost() {
        return originalCustomerCost;
    }

    public void setOriginalCustomerCost(int originalCustomerCost) {
        this.originalCustomerCost = originalCustomerCost;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public String getPartyTitle() {
        return partyTitle;
    }

    public void setPartyTitle(String partyTitle) {
        this.partyTitle = partyTitle;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

}
