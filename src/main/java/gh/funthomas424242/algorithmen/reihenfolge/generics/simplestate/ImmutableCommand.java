package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

import gh.funthomas424242.algorithmen.reihenfolge.generics.Bool;
import gh.funthomas424242.algorithmen.reihenfolge.generics.False;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;

public class ImmutableCommand<B extends Bool> implements Validateable<B> {

    // mandatory
    protected String titel;
    // optional
    protected String isbn;

    public ImmutableCommand<False> setTitel(final String titel) {
        ImmutableCommand<False> command = new ImmutableCommand<False>();
        command.isbn = this.isbn;
        command.titel = titel;
        return command;
    }

    public ImmutableCommand<B> setIsbn(final String isbn) {
        ImmutableCommand<B> command = new ImmutableCommand<B>();
        command.isbn = isbn;
        command.titel = this.titel;
        return command;
    }

    @Override
    public ImmutableCommand<True> validate() {
        if (titel == null) {
            throw new RuntimeException("Titel ist ein Pflichtparameter!");
        }
        final ImmutableCommand<True> command = new ImmutableCommand<True>();
        command.isbn = this.isbn;
        command.titel = this.titel;
        return command;
    }

    public static void execute(ImmutableCommand<True> command) {
        command.doit();
    }

    protected void doit() {
        System.out.println("Titel:" + titel);
        System.out.println("ISBN:" + isbn);
    }

}
