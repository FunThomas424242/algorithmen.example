package gh.funthomas424242.algorithmen.reihenfolge.interfaces;

class Buch implements UngeprueftesBuch, GeprueftesBuch {

    protected String titel;
    protected String isbn;

    protected Buch() {
        // für Factory Pattern
    }

    @Override
    public UngeprueftesBuch setTitel(String titel) {
        final Buch newBuch = new Buch();
        newBuch.titel = titel;
        newBuch.isbn = this.isbn;
        return newBuch;
    }

    @Override
    public UngeprueftesBuch setISBN(String isbn) {
        final Buch newBuch = new Buch();
        newBuch.titel = this.titel;
        newBuch.isbn = isbn;
        return newBuch;
    }

    @Override
    public GeprueftesBuch validate() {
        if (titel == null) {
            throw new IllegalStateException("Titel ist ein Pflichtparameter");
        }
        return this;
    }

    @Override
    public String getTitel() {
        return titel;
    }

    @Override
    public String getISBN() {
        return isbn;
    }

}