import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

public class Preparation {
    public RequestSpecification requestSpecification;

    @Before
    public void before(){
        RestAssured.baseURI = "http://www.omdbapi.com/";
        requestSpecification = RestAssured.given();
        requestSpecification.param("apikey", "20c82626");

    }

    @After
    public void after(){
        System.out.println("test ended");
    }

}
