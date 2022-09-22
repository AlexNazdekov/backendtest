package lesson4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lesson5.ApiSearchResult;
import lesson5.SpoonaccularService;

public class Main {
    public static void main(String[] args) {

        User user = User.builder()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setAddress("Address")
                .setEmail("123@ya.ru")
                .build();
        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
        System.out.println(recipes);

        // DSL - domain specific language

        RequestSpecification requestSpecification =  // Вход. Для решения вопросов query, path, URL, apikey, log, body. А также GET,POST,PUT,DELETE
                new RequestSpecBuilder()
                        .build();
    }
}
