package gh.funthomas424242.algorithmen.reihenfolge.generics;

public interface Validateable<B extends Bool> {

    Validateable<True> validate();

}
