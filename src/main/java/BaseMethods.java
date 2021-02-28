import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.logging.Logger;

public class BaseMethods extends Preparation implements Parameters{

   public Logger logger = Logger.getLogger(BaseMethods.class.getName());

    public String getFilmIDByName(String movieTitle, String filteredMovie) {
        Response response = RestAssured.given().when()
                .param("apikey", apiKey)
                .param(movieTitleToSearch, movieTitle)
                .param(dataType, "json")
                .param(yearOfRelease, "2001")
                .get(RestAssured.baseURI)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .extract()
                .response();
        List<String> jsonResponseTitle = response.jsonPath().getList("Search.Title");
        List<String> jsonResponseID = response.jsonPath().getList("Search.imdbID");

        String movieId = "";

        for (int index = 0; index < jsonResponseTitle.size(); index++) {
            if (jsonResponseTitle.get(index).equals(filteredMovie)) {
                movieId = jsonResponseID.get(index);
                logger.info("Movie Id: " + movieId);
            }
        }

        return movieId;
    }

    public void getFilmIDByTitle(String movieTitle, String filteredMovie) {
        String id = getFilmIDByName(movieTitle, filteredMovie);

        String response = RestAssured.given()
                .when()
                .param("apikey", apiKey)
                .param(dataType, "json")
                .param(movieByID, id)
                .param(yearOfRelease, "2001")
                .get(RestAssured.baseURI)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .extract()
                .response().asString();

        Assert.assertEquals(true, response.contains(filteredMovie));
        Assert.assertEquals(true, response.contains("Year"));
        System.out.println(response);
    }

}
