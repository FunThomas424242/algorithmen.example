package gh.funthomas424242.algorithmen.vartausch;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.standard.Severity;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Die Klasse zeigt ein Beispiel wie die Werte zweier Variablen ohne Benutzung
 * einer Hilfsvariablen mittels XOR Operation getauscht werden können.
 * 
 * Quelle: "Des Programmieres kleine Vergnügen", Michael Wiedeking, KaffeeKlatsch 08/2008.
 * @see http://www.bibsonomy.org/bibtex/275c1df698bf22cf1860ebfd393c9ff18/funthomas424242
 * 
 * @author SchubertT006
 *
 */

public class XORTausch {
    
    final static private Logger LOG = Logger.getLogger(XORTausch.class.getName());

    @Test
    public void tauscheIntegerWerte(){
	int registerA=8;
	int registerB=38;
	
	LOG.log(Level.INFO,"regA: "+registerA+" regB: "+registerB);
	LOG.log(Level.INFO,"----");
	
	// A <- A xor B
	registerA=registerA ^ registerB;
	LOG.log(Level.INFO,"regA: "+registerA);
	
	// B <- B xor A
	registerB=registerB ^ registerA;
	LOG.log(Level.INFO,"regB: "+registerB);
	
	// A <- A xor B
	registerA=registerA ^ registerB;
	LOG.log(Level.INFO,"regA: "+registerA);
	
	LOG.log(Level.INFO,"----");
	LOG.log(Level.INFO,"regA: "+registerA+" regB: "+registerB);
    }

}
