package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

import gh.funthomas424242.algorithmen.reihenfolge.generics.False;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;
import gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate.ImmutableCommand;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ImmutableCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMitTitelUndIsbn_AusgabeOK() {
        ImmutableCommand<False> invalidCommand = new ImmutableCommand<False>().setTitel(
                "Testtitel").setIsbn("3-3-3");
        final ImmutableCommand<True> validCommand = invalidCommand.validate();
        ImmutableCommand.execute(validCommand);
    }

    @Test
    public void testMitTitelOhneIsbn_AusgabeOK() {
        ImmutableCommand<False> invalidCommand = new ImmutableCommand<False>()
                .setTitel("Testtitel");
        final ImmutableCommand<True> validCommand = invalidCommand.validate();
        ImmutableCommand.execute(validCommand);
    }

    @Test
    public void testOhneTitelMitIsbn_ValidierungsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Titel ist ein Pflichtparameter!");

        ImmutableCommand<False> invalidCommand = new ImmutableCommand<False>().setIsbn("3-3-5");
        final ImmutableCommand<True> validCommand = invalidCommand.validate();
        ImmutableCommand.execute(validCommand);
    }
}
