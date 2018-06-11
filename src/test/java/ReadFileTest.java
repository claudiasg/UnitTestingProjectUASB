import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class ReadFileTest {	
	
	//Pruebas ReadFile
		@Test
		public void testReadFileEmpty() {
			List<Sentence> ListaVaciaResult=Analyzer.readFile("archivoVacio.txt");
			int numeroLineas=0;
			assertEquals(numeroLineas, ListaVaciaResult.size());		
		}
		
		@Test
		public void testReadFile() {
			List<Sentence> ListaVaciaResult=Analyzer.readFile("archivo.txt");
			int numeroLineas=6;
			assertEquals(numeroLineas, ListaVaciaResult.size());		
		}
		@Test
		public void testReadFileCorrectFormatReturn3() {
			List<Sentence> ListaVaciaResult=Analyzer.readFile("archivoFormato.txt");
			int numeroLineasCorrectas=3;
			assertEquals(numeroLineasCorrectas, ListaVaciaResult.size());		
		}
		
		@Test
		public void testReadReturnList6Elements() {
			List<Sentence> ListaResult=Analyzer.readFile("archivo.txt");
			int numeroTotalLineas=6;
			assertEquals(numeroTotalLineas, ListaResult.size());		
		}
		@Test
		public void testReadFileFormatTxt() {
			String nombreArchivo="archivo.txt";
			String extencionArchivoResult=nombreArchivo.substring((nombreArchivo.length())-3, nombreArchivo.length());
			String extensioArchivo="txt"; 
			assertTrue("El archivo debe tener extension txt",extencionArchivoResult.equals(extensioArchivo));		
		}

	

}
