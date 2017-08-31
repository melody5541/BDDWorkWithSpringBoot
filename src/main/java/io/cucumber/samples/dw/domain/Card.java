package io.cucumber.samples.dw.domain;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by stlv for developerworks article
 */
public class Card {
    private long id;
    private String cardNum;
    private boolean isPrimaryCard;
    private String cardOwnerName;
    private String cardType;
    private int cardSeqNum;
    private BigDecimal starPoints;
    private Address[] cardBillingAddressList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public boolean isPrimaryCard() {
        return isPrimaryCard;
    }

    public void setIsPrimaryCard(boolean isPrimaryCard) {
        this.isPrimaryCard = isPrimaryCard;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public int getCardSeqNum() {
        return cardSeqNum;
    }

    public void setCardSeqNum(int cardSeqNum) {
        this.cardSeqNum = cardSeqNum;
    }

    public BigDecimal getStarPoints() {
        return starPoints;
    }

    public void setStarPoints(BigDecimal starPoints) {
        this.starPoints = starPoints;
    }

    public Address[] getCardBillingAddressList() {
        return cardBillingAddressList;
    }

    public void setCardBillingAddressList(Address[] cardBillingAddressList) {
        this.cardBillingAddressList = cardBillingAddressList;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", isPrimaryCard=" + isPrimaryCard +
                ", cardOwnerName='" + cardOwnerName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardSeqNum=" + cardSeqNum +
                ", starPoints=" + starPoints +
                ", cardBillingAddressList=" + Arrays.toString(cardBillingAddressList) +
                '}';
    }
}
