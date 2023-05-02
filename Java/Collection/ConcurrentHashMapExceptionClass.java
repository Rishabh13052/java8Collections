package Java.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExceptionClass {
	public static void main(String args[]) {
		// HashMap Concurrent Modification Exception
		HashMap<Integer, String> conHmap = new HashMap();
		conHmap.put(1, "Rish1");
		conHmap.put(2, "Rish2");
		conHmap.put(3, "Rish3");
		conHmap.put(4, "Rish4");
		conHmap.put(5, "Rish5");

		Iterator<Map.Entry<Integer, String>> itr = conHmap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, String> entry = itr.next();

			if (entry.getKey() == 2) {
				entry.setValue("Rish20");
				//Below Statement is causing the concurrent Modification Exception.
				//conHmap.remove(2);
			}
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// Remove Concurrent HashMap Exception
		// use concurrent HashMap

		ConcurrentHashMap<Integer, String> conCurHashMap = new ConcurrentHashMap();

		conCurHashMap.put(1, "Rish1");
		conCurHashMap.put(2, "Rish2");
		conCurHashMap.put(3, "Rish3");
		conCurHashMap.put(4, "Rish4");
		conCurHashMap.put(5, "Rish5");

		Iterator<Map.Entry<Integer, String>> itr1 = conCurHashMap.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry<Integer, String> entry = itr1.next();
			if (entry.getKey() == 2) {
				entry.setValue("Sample");
				//Not Causing concurrent Modification Exception because concurrent Hashmap taking
				//care of concurrent modification.
				conCurHashMap.remove(2);
			}
			conCurHashMap.remove(2);
			System.out.println(entry.getKey() + " " + entry.getValue());

		}
	}

}
