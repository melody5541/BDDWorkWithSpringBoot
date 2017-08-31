package io.cucumber.samples.dw.service;

import io.cucumber.samples.dw.domain.Card;

import java.util.List;

/**
 * Created by stlv for developerworks article
 */
public interface CardService {

    Long countCards(String cardNum);

    List<Card> queryCardsByCardNum(String cardNum);

    List<Card> queryAllCards();

    List<Card> queryPagedCards(Integer offSet, Integer pageSize);
}
