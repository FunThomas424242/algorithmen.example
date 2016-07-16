package gh.funthomas424242.algorithmen.reihenfolge.interfaces;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.xml.bind.ValidationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BuchTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMitTitelUndISBN_GeprueftOK() {

        try {
            final GeprueftesBuch buch = UngeprueftesBuch.Factory.create()
                    .setISBN("3-3-3-").setTitel("Hallo").validate();
            assertNotNull(buch);
        } catch (ValidationException e) {
            fail();
        }
    }

}
