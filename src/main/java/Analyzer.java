import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Analyzer {

	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> listSentences = new ArrayList<Sentence>();
		
		// Fichero del que queremos leer
		File fichero = new File(filename);
		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				System.out.println(linea);      // Imprimimos la linea
				
				String score = linea.substring(0, linea.indexOf(" "));
				String text = linea.substring(linea.indexOf(" ") + 1, linea.length());
				
				Sentence sentence = new Sentence(Integer.valueOf(score), text);
				
				listSentences.add(sentence);
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		
		return listSentences;

	}

	/*
	 * Implement this method in Part 2
	 * Este método debe encontrar todos las palabras individuales 
	 * en el campo de texto de cada oración en la lista  y crear objetos 
	 * Word para cada palabra distinta. Los objetos Word deben hacer un 
	 * seguimiento del número de apariciones de esa palabra en todas las
	 * oraciones, y la puntuación acumulativa total de todas las oraciones
	 * en las que aparece. Este método debería devolver un conjunto de esos 
	 * objetos de Word. Se debe convertir todas las palabras a minúsculas.
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
    	Set<Word> listaPalabras = new TreeSet<Word>();
    	for (Sentence sentence : sentences) {
    		String[] palabras = sentence.text.split(" ");
    		for (String palabra : palabras) {
    			Word word = new Word(palabra.toLowerCase().trim());
    			listaPalabras.add(word);
    		}
    	}
    	Integer numeroSentimiento = 0;
    	for (Word palabra : listaPalabras) {
    		String palabraBuscar = palabra.getText();
        	for (Sentence sentence : sentences) {
        		String[] palabras = sentence.text.split(" ");
        		for (String palabr : palabras) {
        			if (palabraBuscar.equals(palabr.toLowerCase().trim())) {
        				palabra.increaseTotal(sentence.getScore());
        			}
        		}
        		
        	}
        	numeroSentimiento = 0;
		}
    	
		return listaPalabras;
	}

	/*
	 * Implement this method in Part 3
	 * Este método debe iterar sobre cada palabra en el conjunto 
	 * de entrada, usar el método de CalculateScore de Word para
	 * obtener el puntaje de sentimiento promedio para esa palabra,
	 * y luego colocar el texto de la palabra (como clave) y la 
	 * puntuación calculada (como valor) en un mapa. Si el conjunto
	 * de palabras de entrada es nulo o está vacío, el método 
	 * calculateScores debe devolver un mapa vacío.
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> mapa = new HashMap<String, Double>();
		for (Word word: words) {
			mapa.put(word.getText(), word.calculateScore());
		}

		return mapa;

	}

}
