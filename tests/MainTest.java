import org.junit.*;

import main.java.com.ct5025.*;
import static org.junit.Assert.*;

public class MainTest {
        @Test
        public void validateName() {
            //Create class
            Main mainTest = new Main();

            //Generate test variables
            String[] firstElementInvalid = new String[2];
            firstElementInvalid[0] = "Draw";
            firstElementInvalid[1] = "validName";

            String[] secondElementInvalid = new String[2];
            secondElementInvalid[0] = "validName";
            secondElementInvalid[1] = "Draw";

            String[] bothElementsInvalid = new String[2];
            bothElementsInvalid[0] = "Draw";
            bothElementsInvalid[1] = "Draw";

            String[] bothElementsValid = new String[2];
            bothElementsValid[0] = "validName";
            bothElementsValid[1] = "validName";

            /////////////////////////////////////////////////////////////////////////////////
            //TEST SUITES:
            //
            //
            //Test that if the first element in the input is invalid, false is returned
            assertFalse(mainTest.validateName(firstElementInvalid));
            //Test that if the second element in the input is invalid, false is returned
            assertFalse(mainTest.validateName(secondElementInvalid));
            //Test that if both elements in the input are invalid, false is returned
            assertFalse(mainTest.validateName(bothElementsInvalid));
            //
            //Test that if both elements in the input are VALID, true is returned
            assertTrue(mainTest.validateName(bothElementsValid));
            /////////////////////////////////////////////////////////////////////////////////

        }
    }
