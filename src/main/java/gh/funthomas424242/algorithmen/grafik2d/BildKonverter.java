package gh.funthomas424242.algorithmen.grafik2d;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BildKonverter {

    public static void main(String args[]) throws IOException {

        final File pictureFile = Paths.get("src/main/java/gh/funthomas424242/algorithmen/grafik2d/Falero_Luis_Ricardo_Lily_Fairy_1888.jpg").toFile().getAbsoluteFile();
        final String parent = pictureFile.getParent().toString();
        final File myJPegFile = new File( parent,pictureFile.getName());
        final BufferedImage img = ImageIO.read(myJPegFile);

        // Bild darstellen
        JLabel picLabel = new JLabel(new ImageIcon(img));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(new Dimension(img.getWidth(), img.getHeight()));
        f.add(jPanel);
        f.setVisible(true);

    }

}
