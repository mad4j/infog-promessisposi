package dolmisani.data.ipromessisposi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
				
		List<String> lines = Files.readAllLines(
									Paths.get("resources/ipromessisposi.txt"),
									StandardCharsets.ISO_8859_1);
		
	}
	
	
	

}
