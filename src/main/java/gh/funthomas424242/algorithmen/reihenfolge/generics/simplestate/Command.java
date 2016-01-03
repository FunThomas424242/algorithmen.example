package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

public class Command<B extends Bool> implements Validateable<B> {

    // mandatory
    protected String titel;
    // optional
    protected String isbn;

    public Command<False> setTitel(final String titel) {
        Command<False> command = new Command<False>();
        command.isbn = this.isbn;
        command.titel = titel;
        return command;
    }

    public Command<B> setIsbn(final String isbn) {
        Command<B> command = new Command<B>();
        command.isbn = isbn;
        command.titel = this.titel;
        return command;
    }

    @Override
    public Command<True> validate() {
        if (titel == null) {
            throw new RuntimeException("Titel ist ein Pflichtparameter!");
        }
        final Command<True> command = new Command<True>();
        command.isbn = this.isbn;
        command.titel = this.titel;
        return command;
    }

    public static void execute(Command<True> command) {
        command.doit();
    }

    protected void doit() {
        System.out.println("Titel:" + titel);
        System.out.println("ISBN:" + isbn);
    }

}
