package com.example.quartz_email_scheduler.payload;

import java.util.UUID;

public class CustomerBill {
    private UUID billId;
    private String plan_type;
    private Double planAmount;
    private String planName;
    private String planDuration;
    private String planDueDate;
    private String customerId;

    public CustomerBill() {
    }

    public CustomerBill(UUID billId, String plan_type, Double planAmount, String planName, String planDuration,
            String planDueDate, String customerId) {
        this.billId = billId;
        this.plan_type = plan_type;
        this.planAmount = planAmount;
        this.planName = planName;
        this.planDuration = planDuration;
        this.planDueDate = planDueDate;
        this.customerId = customerId;
    }

    public UUID getBillId() {
        return billId;
    }

    public void setBillId(UUID billId) {
        this.billId = billId;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
    }

    public Double getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(Double planAmount) {
        this.planAmount = planAmount;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    public String getPlanDueDate() {
        return planDueDate;
    }

    public void setPlanDueDate(String planDueDate) {
        this.planDueDate = planDueDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
