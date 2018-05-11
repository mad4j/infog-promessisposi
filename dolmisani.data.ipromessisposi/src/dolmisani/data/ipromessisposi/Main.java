package dolmisani.data.ipromessisposi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Main {

	public static HashMap<String, Vector<Integer>> names = new HashMap<>(10);
	
	
	public static void main(String[] args) throws IOException {
		
		names.put("Renzo", new Vector<>());
		names.put("Lucia", new Vector<>());
		names.put("Abbondio", new Vector<>());
		names.put("Rodrigo", new Vector<>());
		names.put("Griso", new Vector<>());
		names.put("Tonio", new Vector<>());
		names.put("Egidio", new Vector<>());
		names.put("Agnese", new Vector<>());
		names.put("Perpetua", new Vector<>());
		names.put("Gervaso", new Vector<>());
		names.put("Azzecca-garbugli", new Vector<>());
		names.put("Gertrude", new Vector<>());
		names.put("Cristoforo", new Vector<>());
		names.put("Attilio", new Vector<>());
		names.put("innominato", new Vector<>());
		names.put("Prassede", new Vector<>());
		names.put("Borromeo", new Vector<>());
		
		
		for(Vector<Integer> v : names.values()) {
			v.setSize(40);
			v.replaceAll((i) -> 0);
		}
		
		int chapterCount = 0;
		
		List<String> lines = Files.readAllLines(Paths.get("resources/ipromessisposi.txt"), StandardCharsets.ISO_8859_1);
		
		for (String l : lines) {
			
			if (l.startsWith("###")) {
				chapterCount++;
			}
			
			for (String n : names.keySet()) {
				
				if (l.contains(n)) {
					Vector<Integer> v = names.get(n);
					
					v.get(chapterCount);
					v.set(chapterCount, v.get(chapterCount)+1);
				}
			}		
		}
		
		
		for (String n : names.keySet()) {
			
			
			Vector<Integer> v = names.get(n);
			
			int total = v.stream()
					      .reduce((x, y) -> x+y)
					      .get();
			
			System.out.format("%20s %10d : ", n, total, names.get(n));
			for (int i=0; i<chapterCount; i++) {
				System.out.format("%3d", v.get(i+1));
			}
			System.out.format("\n");
		}
		
	}

}
