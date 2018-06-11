import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CalculateScoreTest {	
	
	//Pruebas calculateScores
	
	  @Test
	    public void testCalculateScores1WordMuch() {
	        Set<Word> ListaPalabrasResult = new TreeSet<Word>();
	        List<Sentence> list = new ArrayList<Sentence>();
	        list = Analyzer.readFile("archivo.txt");
	        ListaPalabrasResult = Analyzer.allWords(list);

	        Map<String, Double> map = new HashMap<String, Double>();
	        map = Analyzer.calculateScores(ListaPalabrasResult);

	        double scoreResult = 0;
	        for (Map.Entry<String, Double> entry : map.entrySet()) {
	            if ("much".equals(entry.getKey())) {
	            	scoreResult = entry.getValue();
	            }
	        }
	        double scoreEsperado=1.0;
	        assertEquals(String.valueOf(scoreEsperado), String.valueOf(scoreResult));
	    }
	  @Test
		public void testCalculateScores2NegativowouldThis() {
			List<Sentence> Lista= new ArrayList<Sentence>();
			Sentence sentence= new Sentence(-2, "I would have preferred an easier assignment");
			Lista.add(sentence);
			Set<Word> ListaPalabrasResult=Analyzer.allWords(Lista);
			 Map<String, Double> map = new HashMap<String, Double>();
		        map = Analyzer.calculateScores(ListaPalabrasResult);

		        double scoreResult = 0;
		        for (Map.Entry<String, Double> entry : map.entrySet()) {
		            if ("would".equals(entry.getKey())) {
		            	scoreResult = entry.getValue();
		            }
		        }
		        double scoreEsperado=-2.0;
		        assertEquals(String.valueOf(scoreEsperado), String.valueOf(scoreResult));
		}
	  @Test
	    public void testCalculateScores05WordThis() {
	        Set<Word> ListaPalabrasResult = new TreeSet<Word>();
	        List<Sentence> list = new ArrayList<Sentence>();
	        list = Analyzer.readFile("archivo.txt");
	        ListaPalabrasResult = Analyzer.allWords(list);

	        Map<String, Double> map = new HashMap<String, Double>();
	        map = Analyzer.calculateScores(ListaPalabrasResult);

	        double scoreResult = 0;
	        for (Map.Entry<String, Double> entry : map.entrySet()) {
	            if ("this".equals(entry.getKey())) {
	            	scoreResult = entry.getValue();
	            }
	        }
	        double scoreEsperado=0.5;
	        assertEquals(String.valueOf(scoreEsperado), String.valueOf(scoreResult));
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
	

}
