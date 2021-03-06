package br.com.smartbot.testesmartbot.dto;

import br.com.smartbot.testesmartbot.feignInterface.CoinConsumer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

    private Integer id;
    private String last;
    private String lowestAsk;
    private String highestBid;
    private String percentChange;
    private String baseVolume;
    private String quoteVolume;
    private String isFrozen;
    private String postOnly;
    private String marginTradingEnabled;
    private String high24hr;
    private String low24hr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(String isFrozen) {
        this.isFrozen = isFrozen;
    }

    public String getPostOnly() {
        return postOnly;
    }

    public void setPostOnly(String postOnly) {
        this.postOnly = postOnly;
    }

    public String getMarginTradingEnabled() {
        return marginTradingEnabled;
    }

    public void setMarginTradingEnabled(String marginTradingEnabled) {
        this.marginTradingEnabled = marginTradingEnabled;
    }

    public String getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(String high24hr) {
        this.high24hr = high24hr;
    }

    public String getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(String low24hr) {
        this.low24hr = low24hr;
    }

    public List<Coin> mappingApiResults(CoinConsumer consumer){
        Map<String,Coin> mapCoin = (Map<String, Coin>) consumer.find();
        Set<String> setCoin = mapCoin.keySet();
        List<Coin> coinList = new ArrayList<Coin>(mapCoin.values());

        ObjectMapper mapper = new ObjectMapper();

        List<Coin> coin = mapper.convertValue(
                coinList,
                new TypeReference<List<Coin>>() { });
        return  coin;
    }
}


