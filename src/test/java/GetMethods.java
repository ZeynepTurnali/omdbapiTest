import org.junit.Test;

public class GetMethods extends BaseMethods {

   BaseMethods baseMethods = new BaseMethods();

    @Test
    public void filmInfoWithParameters(){
        baseMethods.getFilmInfoWithID("Harry Potter", "Harry Potter and the Sorcerer's Stone", "2001");
    }

}
