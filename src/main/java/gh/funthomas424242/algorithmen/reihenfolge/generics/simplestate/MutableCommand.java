package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

import gh.funthomas424242.algorithmen.reihenfolge.generics.Bool;
import gh.funthomas424242.algorithmen.reihenfolge.generics.False;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;

public class MutableCommand<B extends Bool> implements Validateable<B> {

    // mandatory
    protected String titel;
    // optional
    protected String isbn;

    protected MutableCommand() {

    }

    public static MutableCommand<False> newMutableCommand() {
        return new MutableCommand<False>();
    }

    public MutableCommand<False> setTitel(final String titel) {
        this.titel = titel;
        return (MutableCommand<False>) this;
    }

    public MutableCommand<B> setIsbn(final String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public MutableCommand<True> validate() {
        if (titel == null) {
            throw new RuntimeException("Titel ist ein Pflichtparameter!");
        }
        return (MutableCommand<True>) this;
    }

    public static void execute(MutableCommand<True> command) {
        command.doit();
    }

    protected void doit() {
        System.out.println("Titel:" + titel);
        System.out.println("ISBN:" + isbn);
    }

}
