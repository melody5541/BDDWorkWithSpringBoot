package io.cucumber.samples.dw.controller;

import io.cucumber.samples.dw.base.StandardJsonResponse;
import io.cucumber.samples.dw.domain.Address;
import io.cucumber.samples.dw.domain.Card;
import io.cucumber.samples.dw.service.AddressService;
import io.cucumber.samples.dw.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by stlv for developerworks article
 */
@RestController(value = "")
public class AppController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/address/count", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> countAddress(@RequestParam(required = false, name = "cardNum") String cardNum) {
        StandardJsonResponse<Long> response = new StandardJsonResponse<>();
        Long addressCount = addressService.countAddress(cardNum);
        response.setData(addressCount);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/address/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getAddressByCardNum(@RequestParam("cardNum") String cardNum) {
        StandardJsonResponse<List<Address>> response = new StandardJsonResponse<>();
        List<Address> accountAddressList = addressService.queryAddressesByCardNum(cardNum);
        response.setData(accountAddressList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/address/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getAllAddress() {
        StandardJsonResponse<List<Address>> response = new StandardJsonResponse<>();
        List<Address> accountAddressList = addressService.queryAllAddress();
        response.setData(accountAddressList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/address/paged", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getPagedAddress(@RequestParam("offSet") Integer offSet,
                                                         @RequestParam("pageSize") Integer pageSize) {
        StandardJsonResponse<List<Address>> response = new StandardJsonResponse<>();
        List<Address> accountAddressList = addressService.queryPagedAddress(offSet, pageSize);
        response.setData(accountAddressList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }


    @RequestMapping(value = "/card/count", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> countCards(@RequestParam(required = false, name = "cardNum") String cardNum) {
        StandardJsonResponse<Long> response = new StandardJsonResponse<>();
        Long cardCount = cardService.countCards(cardNum);
        response.setData(cardCount);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/card/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getCardByCardNum(@RequestParam("cardNum") String cardNum) {
        StandardJsonResponse<List<Card>> response = new StandardJsonResponse<>();
        List<Card> cardList = cardService.queryCardsByCardNum(cardNum);
        response.setData(cardList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/card/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getAllCards() {
        StandardJsonResponse<List<Card>> response = new StandardJsonResponse<>();
        List<Card> cardList = cardService.queryAllCards();
        response.setData(cardList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/card/paged", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<StandardJsonResponse> getPagedCards(@RequestParam("offSet") Integer offSet,
                                                       @RequestParam("pageSize") Integer pageSize) {
        StandardJsonResponse<List<Card>> response = new StandardJsonResponse<>();
        List<Card> cardList = cardService.queryPagedCards(offSet, pageSize);
        response.setData(cardList);
        ResponseEntity<StandardJsonResponse> entity = new ResponseEntity(response, HttpStatus.OK);
        return entity;
    }
}
