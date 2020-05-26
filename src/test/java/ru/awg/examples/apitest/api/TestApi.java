package ru.awg.examples.apitest.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.awg.examples.apitest.config.Config;

public abstract class TestApi {

    private static RequestSpecBuilder baseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(Config.getValue("testapi.base_url"))
                .addFilter(new AllureRestAssured());
    }

    public static RequestSpecification users() {
        return RestAssured
                .given()
                .spec(baseSpec()
                        .setBasePath("/users")
                        .build()
                );
    }

    public static ResponseSpecification postUserResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectBody(JsonSchemaValidator.matchesJsonSchemaInClasspath("post_user_response.json"))
                .build();
    }

    public static ResponseSpecification getUsersResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(JsonSchemaValidator.matchesJsonSchemaInClasspath("get_users_response.json"))
                .build();
    }
}
