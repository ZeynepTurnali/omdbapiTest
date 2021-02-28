import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.logging.Logger;

public class BaseMethods extends Preparation implements Parameters{

   public Logger logger = Logger.getLogger(BaseMethods.class.getName());

    public String getFilmIDByTitle(String movieTitle, String filteredMovie, String year) {
        Response response = RestAssured.given().when()
                .param("apikey", apiKey)
                .param(movieTitleToSearch, movieTitle)
                .param(dataType, "json")
                .param(yearOfRelease, year)
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
            }
        }

        logger.info("Movie Id: " + movieId);

        return movieId;
    }

    public void getFilmInfoWithID(String movieTitle, String filteredMovie, String year) {
        String id = getFilmIDByTitle(movieTitle, filteredMovie, year);

        Response response = RestAssured.given()
                .when()
                .param("apikey", apiKey)
                .param(dataType, "json")
                .param(movieByID, id)
                .param(yearOfRelease, year)
                .get(RestAssured.baseURI)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .extract()
                .response();

        Assert.assertEquals(true, response.asString().contains(filteredMovie));
        Assert.assertEquals(true, response.asString().contains("Year"));

        String releaseDate = response.path("Released");
        logger.info("Release Date: " +releaseDate);

    }

}
