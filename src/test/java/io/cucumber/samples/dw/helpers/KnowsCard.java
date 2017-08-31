package io.cucumber.samples.dw.helpers;

import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import com.jayway.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Created by stlv for developerworks article
 */
@Qualifier("cardHelper")
@Scope("cucumber-glue")
@Service
public class KnowsCard extends KnowsHttp {
    private ValidatableResponse response = null;

    public void assertThatCardWithNumberHadBeenExisted(String cardNum) {
        given().parameter("cardNum", cardNum).
                get("/card/count").
                then().body("data", is(1));

    }

    public void assertThatRepliedCardDataIsNotNullOrEmpty(String cardNum) {
        response = given().parameter("cardNum", cardNum).
                get("/card/query").
                then().body("data", not(isEmptyOrNullString()));
    }

    public void assertThatRepliedCardDataMetSchemaDefinedSpecs(String schemaFile) {
        response.body(
                JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaFile));
    }

    public void assertThatFetchedCardDataCountAsExpected(String cardNum, int expectedCardCount) {
        response.body("data.size()", is(expectedCardCount));
        for (int i = 0; i < expectedCardCount; i++) {
            response.body("data.cardNum[" + i + "]", is(cardNum));
        }
    }

    public void assertThatCardWithNumberDoesNotExisted(String cardNum) {
        given().parameter("cardNum", cardNum).
                get("/card/count").
                then().body("data", is(0));
    }
}