import org.junit.Test;

public class GetMethods extends BaseMethods {

    BaseMethods baseMethods = new BaseMethods();

    @Test
    public void test(){
        baseMethods.getFilmIDByTitle("Harry Potter", "Harry Potter and the Sorcerer's Stone");
    }

}
