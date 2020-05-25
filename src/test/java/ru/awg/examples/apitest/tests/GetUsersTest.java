package ru.awg.examples.apitest.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import ru.awg.examples.apitest.api.TestApi;
import ru.awg.examples.apitest.model.GetUsersResponse;

public class GetUsersTest {

    @Test
    public void usersShouldBeReturned() {
        GetUsersResponse getUsersResponse = TestApi.users()
                .when()
                .get()
                .then()
                .assertThat()
                .spec(TestApi.getUsersResponse()) // валидация по JSON Schema
                .and()
                .extract()
                .as(GetUsersResponse.class);

        // Проверка на наличие всех полей в ответе происходит с помощью валидации по JSON Schema
        // Для удобства валидация вынесена в ResponseSpecification, см. TestApi#getUsersResponse

        Assertions.assertThat(getUsersResponse.getData().size())
                .as("Users count must be greater than 0")
                .isGreaterThan(0);
    }
}
