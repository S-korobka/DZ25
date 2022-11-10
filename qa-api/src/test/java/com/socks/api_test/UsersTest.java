package com.socks.api_test;

import com.socks.api.conditions.Conditions;
import com.socks.api.models.UserModel;
import com.socks.api.responses.UserRegistrationResponse;

import org.apache.http.HttpStatus;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.emptyString;


public class UsersTest extends UserBaseTest {



 /*  @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

        RestAssured.baseURI = config.baseUrl();
        faker = new Faker(new Locale(config.locale()));
    }*/

 /*   @Test
    public void testCanRegisterNewUser() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));
    }

    @Test
    public void testCanNotRegisterSameUserTwice() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
*/
    @Test
    public void testCanRegisterNewUser(){
        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());
        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyField("id", not(emptyString())));
    }
 @Test
 public void testCanRegisterNewUserPojo() {
     UserModel user = new UserModel()
             .username(faker.name().username())
             .email(faker.internet().emailAddress())
             .password(faker.internet().password());

     UserRegistrationResponse response = service.registerUser(user)
             .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
             .asPojo(UserRegistrationResponse.class);

     response.getId();
 }

    @Test
    public void testCanNotRegisterSameUserTwice() {
        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyField("id", not(emptyString())));

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }
}
