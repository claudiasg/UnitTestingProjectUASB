import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AllWordTest {	
	
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
		public void testAllWordsReturnList4Words() {
			List<Sentence> Lista= new ArrayList<Sentence>();
			Sentence sentence= new Sentence(-2, "I would have preferred an easier assignment");
			Lista.add(sentence);
			Set<Word> ListaPalabrasResult=Analyzer.allWords(Lista);
			assertEquals(7, ListaPalabrasResult.size());		
		}
		

	

}
