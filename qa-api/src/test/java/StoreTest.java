import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class StoreTest {
    public static final  String API_URL= "https://petstore.swagger.io/v2";
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(API_URL)
                .setRelaxedHTTPSValidation()
                .build();
    }

  //  @Test
    public void getStoreInventoryTest(){
        RestAssured
                .given(getRequestSpecification())
                .contentType(ContentType.JSON).log().all()
                .when()
                .get("/store/inventory")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("totvs", not(emptyString()))
                .body("Sale", equalTo(1));




    }
    }

