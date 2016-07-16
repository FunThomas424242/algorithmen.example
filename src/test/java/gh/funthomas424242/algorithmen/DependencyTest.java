package gh.funthomas424242.algorithmen;

import static de.schauderhaft.degraph.check.JCheck.classpath;
import static de.schauderhaft.degraph.check.JCheck.violationFree;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import de.schauderhaft.degraph.configuration.NamedPattern;

/**
 * @author huluvu424242
 *
 * Erstellt eine Datei violations.graphml in welcher z.B. zyklische Abhängigkeiten visualisiert sind
 * Die Graphen lassen sich visualisieren durch folgende Aktionen:
 * 1. Öffnen im Editor yED (yworks.com/products/yed
 * 2. Einstellung Layout/Hierarchie Layout
 * 3. Allgemein: Links nach Rechts
 * 4. Kantenstyle: Polyline
 *
 */
//@RunWith(JUnitRunner.class)
public class DependencyTest {

    @Test
    public void ohneZyklus() {
        assertThat(classpath().noJars().printTo("zyklen.graphml").including(
                "gh.funthomas424242.algorithmen.**"), violationFree());
    }

    @Test
    public void test() {
        assertThat(
                classpath().noJars()
                    .printTo("violations.graphml")
                    .including("gh.funthomas424242.algorithmen.**")
                    .withSlicing("part",
                            "gh.funthomas424242.algorithmen.(*).**")
                    .withSlicing("layer",
                            "gh.funthomas424242.algorithmen.*.*(*).**",
                            new NamedPattern("**", "other"))
                    .withSlicing("module",
                            "gh.funthomas424242.algorithmen.*.(*).**"),
                violationFree());

    }

}
