package com.example.chainanalysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gemini {
    private float bid;
    private float ask;
    private float last;


    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "{" +
                "\"Buy\":" + "\""+bid +"\""+
                ",\"Sell\":" +"\""+ ask +"\""+
                ", \"Last\":" +"\""+ last+"\""+
                '}';
    }

}
