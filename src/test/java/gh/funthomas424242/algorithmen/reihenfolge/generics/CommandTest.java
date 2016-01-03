package gh.funthomas424242.algorithmen.reihenfolge.generics;

import gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate.Command;
import gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate.False;
import gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate.True;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMitTitelUndIsbn_AusgabeOK() {
        Command<False> invalidCommand = new Command<False>().setTitel(
                "Testtitel").setIsbn("3-3-3");
        final Command<True> validCommand = invalidCommand.validate();
        Command.execute(validCommand);
    }

    @Test
    public void testMitTitelOhneIsbn_AusgabeOK() {
        Command<False> invalidCommand = new Command<False>()
                .setTitel("Testtitel");
        final Command<True> validCommand = invalidCommand.validate();
        Command.execute(validCommand);
    }

    @Test
    public void testOhneTitelMitIsbn_ValidierungsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Titel ist ein Pflichtparameter!");

        Command<False> invalidCommand = new Command<False>().setIsbn("3-3-5");
        final Command<True> validCommand = invalidCommand.validate();
        Command.execute(validCommand);
    }
}
