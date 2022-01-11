package com.hermes.sinfo.domain;

public class Stock {
    String code;
    String name;
    String date;
    String svoluem;
    String bvolume;
    String pbvolume;
    String spayment;
    String bpayment;
    String psvolume;
    String market;
    String buyer;

    public Stock() {

    }

    public void setValues(String code, String name, String date, String svoluem, String bvolume, String pbvolume, String spayment, String bpayment, String psvolume, String market, String buyer) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.svoluem = svoluem;
        this.bvolume = bvolume;
        this.pbvolume = pbvolume;
        this.spayment = spayment;
        this.bpayment = bpayment;
        this.psvolume = psvolume;
        this.market = market;
        this.buyer = buyer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSvoluem() {
        return svoluem;
    }

    public void setSvoluem(String svoluem) {
        this.svoluem = svoluem;
    }

    public String getBvolume() {
        return bvolume;
    }

    public void setBvolume(String bvolume) {
        this.bvolume = bvolume;
    }

    public String getPbvolume() {
        return pbvolume;
    }

    public void setPbvolume(String pbvolume) {
        this.pbvolume = pbvolume;
    }

    public String getSpayment() {
        return spayment;
    }

    public void setSpayment(String spayment) {
        this.spayment = spayment;
    }

    public String getBpayment() {
        return bpayment;
    }

    public void setBpayment(String bpayment) {
        this.bpayment = bpayment;
    }

    public String getPsvolume() {
        return psvolume;
    }

    public void setPsvolume(String psvolume) {
        this.psvolume = psvolume;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}

