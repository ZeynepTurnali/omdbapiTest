public interface Parameters {

    String apiKey = "20c82626";

    // parameters for by ıd or title
    String movieNameByTitle = "t";
    String returnShortOrFull = "plot";
    String movieByID = "i";

    // parameters for by search
    String movieTitleToSearch = "s";
    String page = "page";

    // parameters for general
    String resultToReturn = "type";  // movie, series, episode
    String yearOfRelease = "y";
    String dataType = "r"; // The data type to return. (json, xml)
    String callBack = "callback"; // JSON callback name.
    String apiVersion = "v"; // API version (reserved for future use).



}
