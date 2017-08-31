package io.cucumber.samples.dw.helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;

/**
 * Created by stlv for developerworks article
 */
public class KnowsHttp {
    static {
        RestAssured.basePath = "/dw";
        RestAssured.baseURI = "http://localhost:8080";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(LogDetail.PATH))
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY))
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK).
                        expectContentType(ContentType.JSON).build();

    }
}
