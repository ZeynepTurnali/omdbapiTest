import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class test {

    @Test()
    public void deneme(){
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
                .all();
    }
}
