package io.cucumber.samples.dw.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

/**
 * Created by stlv for developerworks article
 */
public class KnowsHttp {
    static {
        RestAssured.basePath = "/dw";
        RestAssured.baseURI = "http://localhost:8080";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(LogDetail.PARAMS))
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY))
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK).
                        expectContentType(ContentType.JSON).build();

    }
}
