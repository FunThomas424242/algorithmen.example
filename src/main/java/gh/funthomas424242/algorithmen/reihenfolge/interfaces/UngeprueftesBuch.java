package gh.funthomas424242.algorithmen.reihenfolge.interfaces;

import javax.xml.bind.ValidationException;

public interface UngeprueftesBuch {

    public class Factory {
        static public UngeprueftesBuch create() {
            return new Buch();
        }
    }

    public UngeprueftesBuch setTitel(final String titel);

    public UngeprueftesBuch setISBN(final String isbn);

    public String getTitel();

    public String getISBN();

    default public GeprueftesBuch validate() throws ValidationException {
        final Buch newBuch = new Buch();
        newBuch.titel = getTitel();
        newBuch.isbn = getISBN();
        if (newBuch.titel == null) {
            throw new ValidationException("Titel ist ein Pflichtfeld");
        }
        return newBuch;
    };

}
