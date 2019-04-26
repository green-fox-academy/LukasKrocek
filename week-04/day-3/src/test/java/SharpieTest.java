import org.junit.Test;
import static org.junit.Assert.*;

public class SharpieTest {

    Sharpie sharpie = new Sharpie("Blue",8);

    @Test
    public void sharpieCreation_BlueColorWidth8 (){
        String blueString = "Blue";
        assertTrue(sharpie.color == blueString&&sharpie.width==8);
    }
}
