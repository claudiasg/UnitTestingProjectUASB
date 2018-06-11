import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class ReadFileTest {	
	
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
		public void testReadFileCorrectFormatReturn3() {
			List<Sentence> ListaVaciaResult=Analyzer.readFile("archivoFormato.txt");
			assertEquals(3, ListaVaciaResult.size());		
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
			assertTrue("El archivo debe tener extension txt",extencionArchivo.equals("txt"));		
		}

	

}
