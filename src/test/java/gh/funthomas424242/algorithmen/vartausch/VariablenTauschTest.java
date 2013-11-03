package gh.funthomas424242.algorithmen.vartausch;

import org.junit.Before;
import org.junit.Test;

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

public class VariablenTauschTest {
    
    private void printMessage(final String message){
	System.out.println(message);
    }
    
    
    @Before
    public void setUp(){
	printMessage("    ");
    }

    @Test
    public void tauscheIntegerViaXOR(){
	int registerA=8;
	int registerB=38;
	
	printMessage("regA: "+registerA+" regB: "+registerB);
	printMessage("----");
	
	// A <- A xor B
	registerA=registerA ^ registerB;
	printMessage("regA: "+registerA);
	
	// B <- B xor A
	registerB=registerB ^ registerA;
	printMessage("regB: "+registerB);
	
	// A <- A xor B
	registerA=registerA ^ registerB;
	printMessage("regA: "+registerA);
	
	printMessage("----");
	printMessage("regA: "+registerA+" regB: "+registerB);
    }

    
    @Test
    public void tauscheIntegerViaPlus(){
	int registerA=80;
	int registerB=16;
	
	printMessage("regA: "+registerA+" regB: "+registerB);
	printMessage("----");
	
	// A <- A + B
	registerA=registerA + registerB;
	printMessage("regA: "+registerA);
	
	// B <- A - B
	registerB=registerA - registerB;
	printMessage("regB: "+registerB);
	
	// A <- A - B
	registerA=registerA - registerB;
	printMessage("regA: "+registerA);
	
	printMessage("----");
	printMessage("regA: "+registerA+" regB: "+registerB);
    }

    @Test
    public void tauscheIntegerViaMinus(){
	int registerA=90;
	int registerB=96;
	
	printMessage("regA: "+registerA+" regB: "+registerB);
	printMessage("----");
	
	// A <- A - B
	registerA=registerA - registerB;
	printMessage("regA: "+registerA);
	
	// B <- B + A
	registerB=registerB + registerA;
	printMessage("regB: "+registerB);
	
	// A <- B - A
	registerA=registerB - registerA;
	printMessage("regA: "+registerA);
	
	printMessage("----");
	printMessage("regA: "+registerA+" regB: "+registerB);
    }
    
}
