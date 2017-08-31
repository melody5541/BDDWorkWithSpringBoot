package io.cucumber.samples.dw.service.impl;

import io.cucumber.samples.dw.domain.Address;
import io.cucumber.samples.dw.domain.Card;
import io.cucumber.samples.dw.service.AddressService;
import io.cucumber.samples.dw.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by stlv for developerworks article
 */
@Service
public class CardServiceImpl implements CardService {
    private final static String baseColumnSql = "SELECT ID, CARD_NUM, IS_PRIMARY_CARD, CARD_OWNER_NAME, CARD_TYPE, STAR_POINTS ";

    private final static String counCardsSql = "SELECT COUNT(1) FROM CARD ";

    private final static String queryCardByCardNumSql = baseColumnSql + " FROM CARD WHERE CARD_NUM = ? ";

    private final static String queryAllCardsSql = baseColumnSql + " FROM CARD ORDER BY ID ASC ";

    private final static String queryPagedCardsSql = baseColumnSql + " FROM CARD ORDER BY ID ASC " +
            "OFFSET ? ROWS " +
            "FETCH FIRST ? ROWS ONLY ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AddressService addressService;

    @Override
    public Long countCards(String cardNum) {
        Long count;
        if (null == cardNum) {
            count = jdbcTemplate.queryForObject(counCardsSql, Long.class);
        } else {
            count = jdbcTemplate.queryForObject(
                    counCardsSql + " WHERE CARD_NUM = ? "
                    , new Object[]{cardNum}, Long.class
            );
        }
        return count;
    }

    @Override
    public List<Card> queryCardsByCardNum(String cardNum) {
        List<Card> cardList = jdbcTemplate.query(queryCardByCardNumSql, new Object[]{cardNum}, new BeanPropertyRowMapper(Card.class));
        fillInBillingAddress(cardList);
        return cardList;
    }

    @Override
    public List<Card> queryAllCards() {
        List<Card> cardList = jdbcTemplate.query(queryAllCardsSql, new Object[]{}, new BeanPropertyRowMapper(Card.class));
        fillInBillingAddress(cardList);
        return cardList;
    }

    @Override
    public List<Card> queryPagedCards(Integer offSet, Integer pageSize) {
        List<Card> cardList = jdbcTemplate.query(queryPagedCardsSql, new Object[]{offSet, pageSize}, new BeanPropertyRowMapper(Card.class));
        fillInBillingAddress(cardList);
        return cardList;
    }

    private void fillInBillingAddress(List<Card> cardList) {
        for (Card card : cardList) {
            List<Address> addressList = addressService.queryAddressesByCardNum(card.getCardNum());
            Address[] addresses = new Address[addressList.size()];
            addressList.toArray(addresses);
            card.setCardBillingAddressList(addresses);
        }
    }
}
