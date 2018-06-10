

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class AnalyzerTest {
	@Test
	public void testReadFileEmpty() {
		List<Sentence> ListaVaciaResult=Analyzer.readFile("archivoVacio.txt");
		assertEquals(0, ListaVaciaResult.size());		
	}
	
	@Test
	public void testReadFile() {
		List<Sentence> ListaVaciaResult=Analyzer.readFile("archivo.txt");
		assertEquals(6, ListaVaciaResult.size());		
	}
	
	@Test
	public void testReadReturnList6Elements() {
		List<Sentence> ListaResult=Analyzer.readFile("archivo.txt");
		assertEquals(6, ListaResult.size());		
	}
	@Test
	public void testReadFileStringEntry() {
		String nombreArchivo="archivo.txt";
		String extencionArchivo=nombreArchivo.substring((nombreArchivo.length())-3, nombreArchivo.length());		
		assertTrue(extencionArchivo.equals("txt"));		
	}

		
	@Test
	public void testAllWordsReturnList2Words() {
		List<Sentence> Lista= new ArrayList<Sentence>();
		Sentence sentence= new Sentence(5, "Web develop");
		Lista.add(sentence);
		Set<Word> ListaPalabrasResult=Analyzer.allWords(Lista);
		assertEquals(2, ListaPalabrasResult.size());		
	}
	@Test
    public void testMapaVacio() {
        Set<Word> listaPalabrasVacia = new TreeSet<Word>();
        List<Sentence> listaVacia = new ArrayList<Sentence>();
        listaVacia = Analyzer.readFile("archivoVacio.txt");
        listaPalabrasVacia = Analyzer.allWords(listaVacia);

        Map<String, Double> mapa = new HashMap<String, Double>();
        mapa = Analyzer.calculateScores(listaPalabrasVacia);


        assertEquals(0, mapa.size());
    }
	
  /*  @Test
    public void testSomeLibraryMethod() {
    	//Sentence sentence = new Sentence();
    	
    	List<Sentence> lista = new ArrayList<Sentence>(); 
    	lista = Analyzer.readFile("archivo.txt");
    	
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    
    @Test
    public void testSomeLibraryMethod1() {
    	Set<Word> listaPalabras = new TreeSet<Word>();
    	List<Sentence> lista = new ArrayList<Sentence>(); 
    	lista = Analyzer.readFile("archivo.txt");
    	listaPalabras = Analyzer.allWords(lista);
    	
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    
    @Test
    public void testSomeLibraryMethod2() {
    	Set<Word> listaPalabras = new TreeSet<Word>();
    	List<Sentence> lista = new ArrayList<Sentence>(); 
    	lista = Analyzer.readFile("archivo.txt");
    	listaPalabras = Analyzer.allWords(lista);
    	
    	Map<String, Double> mapa = new HashMap<String, Double>();
    	mapa = Analyzer.calculateScores(listaPalabras);
    	
    	for (Map.Entry<String, Double> entry : mapa.entrySet()) {
    		System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
*/
}
