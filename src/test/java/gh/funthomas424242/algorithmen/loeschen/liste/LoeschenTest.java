package gh.funthomas424242.algorithmen.loeschen.liste;

import java.util.ArrayList;
import java.util.List;

public class LoeschenTest {

    public static void main(final String args[]) {
        /* Korrektes Loeschen */{
            final List<ListItem> list = createNewList();
            System.out.println("Vor KorrektesLoeschen Anzahl: " + list.size());
            final KorrektesLoeschen algorithmus = new KorrektesLoeschen();
            final int counter = algorithmus.deleteAllElementsOfList(list);
            System.out.println("Nach KorrektesLoeschen Anzahl: " + counter);
        }
        /* Falsches Loeschen */{
            final List<ListItem> list = createNewList();
            System.out.println("Vor FalschesLoeschen Anzahl: " + list.size());
            final FalschesLoeschen algorithmus = new FalschesLoeschen();
            final int counter = algorithmus.deleteAllElementsOfList(list);
            System.out.println("Nach FalschesLoeschen Anzahl: " + counter);
        }

    }

    protected static List<ListItem> createNewList() {
        final List<ListItem> list = new ArrayList<ListItem>(100);
        for (int i = 0; i < 100; i++) {
            list.add(new ListItem());
        }
        return list;
    }

}
