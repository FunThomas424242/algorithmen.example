package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gh.funthomas424242.algorithmen.reihenfolge.generics.False;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;

public class MutableCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMitTitelUndIsbn_AusgabeOK() {
        MutableCommand<False> invalidCommand = MutableCommand
                .newMutableCommand().setTitel("Testtitel").setIsbn("3-3-3");
        final MutableCommand<True> validCommand = invalidCommand.validate();
        MutableCommand.execute(validCommand);
    }

    @Test
    public void testMitTitelOhneIsbn_AusgabeOK() {
        MutableCommand<False> invalidCommand = MutableCommand
                .newMutableCommand().setTitel("Testtitel");
        final MutableCommand<True> validCommand = invalidCommand.validate();
        MutableCommand.execute(validCommand);
    }

    @Test
    public void testOhneTitelMitIsbn_ValidierungsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Titel ist ein Pflichtparameter!");

        MutableCommand<False> invalidCommand = MutableCommand
                .newMutableCommand().setIsbn("3-3-5");
        final MutableCommand<True> validCommand = invalidCommand.validate();
        MutableCommand.execute(validCommand);
    }
}
