

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
	
	//Pruebas ReadFile
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

	//Pruebas AllWords
	@Test
	public void testAllWordsReturnList2Words() {
		List<Sentence> Lista= new ArrayList<Sentence>();
		Sentence sentence= new Sentence(-1, "Web develop");
		Lista.add(sentence);
		Set<Word> ListaPalabrasResult=Analyzer.allWords(Lista);
		assertEquals(2, ListaPalabrasResult.size());		
	}
	@Test
    public void testMapaEmpty() {
        Set<Word> listaPalabrasVacia = new TreeSet<Word>();
        List<Sentence> listaVacia = new ArrayList<Sentence>();
        listaVacia = Analyzer.readFile("archivoVacio.txt");
        listaPalabrasVacia = Analyzer.allWords(listaVacia);

        Map<String, Double> mapa = new HashMap<String, Double>();
        mapa = Analyzer.calculateScores(listaPalabrasVacia);
        assertEquals(0, mapa.size());
    }	
//Pruebas calculateScores
	  @Test
	    public void testCalculateScores1WordMuch() {
	        Set<Word> listWords = new TreeSet<Word>();
	        List<Sentence> list = new ArrayList<Sentence>();
	        list = Analyzer.readFile("archivo.txt");
	        listWords = Analyzer.allWords(list);

	        Map<String, Double> map = new HashMap<String, Double>();
	        map = Analyzer.calculateScores(listWords);

	        double score = 0;
	        for (Map.Entry<String, Double> entry : map.entrySet()) {
	            if ("much".equals(entry.getKey())) {
	                score = entry.getValue();
	            }
	        }
	        assertEquals("1.0", String.valueOf(score));
	    }
	  @Test
	    public void testCalculateScores05WordThis() {
	        Set<Word> listWords = new TreeSet<Word>();
	        List<Sentence> list = new ArrayList<Sentence>();
	        list = Analyzer.readFile("archivo.txt");
	        listWords = Analyzer.allWords(list);

	        Map<String, Double> map = new HashMap<String, Double>();
	        map = Analyzer.calculateScores(listWords);

	        double score = 0;
	        for (Map.Entry<String, Double> entry : map.entrySet()) {
	            if ("this".equals(entry.getKey())) {
	                score = entry.getValue();
	            }
	        }
	        assertEquals("0.5", String.valueOf(score));
	    }
	   

  

}
