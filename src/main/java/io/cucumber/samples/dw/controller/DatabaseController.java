package io.cucumber.samples.dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by stlv for developerworks article
 */
@RestController
public class DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/database/test", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    ResponseEntity<Map<String, Integer>> filterAddressByCardNum() {
        final List<Map<String, Integer>> cardNumList = new LinkedList<>();
        ResponseEntity<Map<String, Integer>> entity = new ResponseEntity(cardNumList, HttpStatus.OK);
        try {
            jdbcTemplate.query("SELECT COUNT(*) AS CARD_COUNT FROM CARD", new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    int cartCount = resultSet.getInt("CARD_COUNT");
                    System.out.println("Card count = " + cartCount);
                    Map<String, Integer> cardNumMap = new HashMap<String, Integer>();
                    cardNumMap.put("cardCount", cartCount);
                    cardNumList.add(cardNumMap);
                }
            });
            jdbcTemplate.query("SELECT COUNT(*) AS ADDRESS_COUNT FROM ADDRESS", new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    int addressCount = resultSet.getInt("ADDRESS_COUNT");
                    Map<String, Integer> addressMap = new HashMap<String, Integer>();
                    addressMap.put("addressCount", addressCount);
                    cardNumList.add(addressMap);
                }
            });
        } catch (Exception e) {
            cardNumList.clear();
            entity = new ResponseEntity(cardNumList, HttpStatus.INTERNAL_SERVER_ERROR);
            System.err.println("Error while performing DML or DDL with database:\n");
            e.printStackTrace();
        }
        return entity;
    }
}
