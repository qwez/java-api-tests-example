package ru.awg.examples.apitest.tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import ru.awg.examples.apitest.api.TestApi;
import ru.awg.examples.apitest.model.PostUserRequest;
import ru.awg.examples.apitest.model.PostUserResponse;

public class PostUserTest {

    private static Faker faker = Faker.instance();

    @Test
    public void userShouldBeCreated() {
        PostUserRequest postUserRequest = new PostUserRequest(faker.name().firstName(), faker.job().position());
        PostUserResponse postUserResponse = TestApi.users()
                .given()
                .body(postUserRequest)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(TestApi.postUserResponse()) // валидация по JSON Schema
                .and()
                .extract()
                .as(PostUserResponse.class);

        // Проверка на наличие всех полей в ответе происходит с помощью валидации по JSON Schema
        // Для удобства валидация вынесена в ResponseSpecification, см. TestApi#postUserResponse

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(postUserResponse.getName()).as("Name must be correct").isEqualTo(postUserRequest.getName());
            s.assertThat(postUserResponse.getJob()).as("Job must be correct").isEqualTo(postUserRequest.getJob());
        });
    }
}
