package gh.funthomas424242.algorithmen.reihenfolge.generics.simplestate;

import gh.funthomas424242.algorithmen.reihenfolge.generics.Bool;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;

public interface Validateable<B extends Bool> {

    Validateable<True> validate();

}
