package dolmisani.data.ipromessisposi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		
		List<String> names = List.of(
				"Renzo", "Lucia", "Abbondio",
				"Rodrigo", "Griso", "Tonio",
				"Egidio", "Agnese",	"Perpetua",
				"Gervaso", "Azzecca-garbugli", "Gertrude",
				"Cristoforo", "Attilio", "innominato",
				"Prassede", "Borromeo");
		
		HashMap<String, Vector<Integer>> counters = new HashMap<>(names.size());
		
		for (String s : names) {
			counters.put(s, new Vector<>(40));
		}
		
		counters.forEach((n, v) -> { 
			v.setSize(40); 
			v.replaceAll((i) -> 0); 
		});
		
		
		int chapterCount = 0;
		
		List<String> lines = Files.readAllLines(Paths.get("resources/ipromessisposi.txt"), StandardCharsets.ISO_8859_1);
		
		for (String l : lines) {
			
			if (l.startsWith("###")) {
				chapterCount++;
			}
			
			for (String n : counters.keySet()) {
				
				if (l.contains(n)) {
					Vector<Integer> v = counters.get(n);
					
					v.get(chapterCount);
					v.set(chapterCount, v.get(chapterCount)+1);
				}
			}		
		}
		
		
		for (String n : counters.keySet()) {
			
			
			Vector<Integer> v = counters.get(n);
			
			int total = v.stream()
					      .reduce((x, y) -> x+y)
					      .get();
			
			System.out.format("%20s %10d : ", n, total, counters.get(n));
			for (int i=0; i<chapterCount; i++) {
				System.out.format("%3d", v.get(i+1));
			}
			System.out.format("\n");
		}
		
	}

}
