package gh.funthomas424242.algorithmen.loeschen.liste;

import java.util.List;

public class KorrektesLoeschen {

    public int deleteAllElementsOfList(final List<ListItem> elements) {

        while (elements.size() > 0) {
            elements.remove(0);
        }

        return elements.size();
    }

}
