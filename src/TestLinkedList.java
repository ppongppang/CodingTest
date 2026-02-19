import java.util.*;

public class TestLinkedList {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
//		List<Integer> l = new LinkedList<>();
		
		
		for(int i=0; i <100_000 ; i++) {
			l.add(new Integer(i));
		}
		
		long time = System.nanoTime();
		
		long s = 0;
		Iterator<Integer> iter = l.iterator();
		while(iter.hasNext()) {
			s += iter.next();
		}
		
//		for(Integer i : l) {
//			s += i;
//		}
//		 for (int i = 0, len = l.size(); i < len; i++) {
//			s += l.get(i);
//		}
		
		
		System.out.println(System.nanoTime() - time);
	}
}
