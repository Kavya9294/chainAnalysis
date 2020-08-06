package com.example.chainanalysis;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
class APIController{

    String bestSeller;
    float bestSP;
    String bestBuyer;
    float bestBP;




    @RequestMapping(value = "/getCurrency", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCurrency(@RequestParam( defaultValue = "BTC") String currencyType) {

        RestTemplate restTemplate = new RestTemplate();
        Coinbase cbBuy=restTemplate.getForObject("https://api.coinbase.com/v2/prices/"+currencyType+"-USD/buy", Coinbase.class);
        Coinbase cbSell=restTemplate.getForObject("https://api.coinbase.com/v2/prices/"+currencyType+"-USD/sell", Coinbase.class);
        Data buy=cbBuy.getData();
        Data sell=cbSell.getData();

        Gemini cb=restTemplate.getForObject("https://api.gemini.com/v1/pubticker/"+currencyType+"usd", Gemini.class);

        if (sell.getAmount() > cb.getAsk()){
            bestSP=sell.getAmount();
            bestSeller="Coinbase";
        }else{
            bestSP=cb.getAsk();
            bestSeller="Gemini";
        }

        if (buy.getAmount() < cb.getBid()){
            bestBP=buy.getAmount();
            bestBuyer="Coinbase";
        }else {
            bestBP = cb.getBid();
            bestBuyer = "Gemini";
        }

        return "{" +
                "\"Buycb\":" + "\""+buy.getAmount() +"\""+
                ",\"Sellcb\":" +"\""+ sell.getAmount() +"\""+
                ",\"Buygemini\":" + "\""+cb.getBid() +"\""+
                ",\"Sellgemini\":" +"\""+ cb.getAsk() +"\""+
                ",\"bestSeller\":" + "\""+bestSeller +"\""+
                ",\"bestSP\":" +"\""+ bestSP +"\""+
                ",\"bestBuyer\":" + "\""+bestBuyer +"\""+
                ",\"bestBP\":" +"\""+ bestBP +"\""+
                '}';
    }


}

