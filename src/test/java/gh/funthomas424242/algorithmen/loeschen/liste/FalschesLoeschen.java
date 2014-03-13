package gh.funthomas424242.algorithmen.loeschen.liste;

import java.util.List;

public class FalschesLoeschen {

    public int deleteAllElementsOfList(final List<ListItem> elements) {

        for (int i = 0; i < elements.size(); i++) {
            elements.remove(i);
        }
        return elements.size();
    }

}
