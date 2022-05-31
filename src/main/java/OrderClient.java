import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class OrderClient extends RestAssuredClient {


    Response response;
    private static final String ORDER_PATH = "api/v1/orders/";

    @Step("Создание заказа")
    public Response createOrder(String[] order) throws JsonProcessingException {
        return response = given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(ORDER_PATH);
}

    @Step("Отменить заказ")
    public ValidatableResponse deleteOrder(int orderTrack) {
        return given()
                .spec(getBaseSpec())
                .when()
                .delete(ORDER_PATH + "cancel/")
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrderList() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(ORDER_PATH)
                .then();
    }
}

