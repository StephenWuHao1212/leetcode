/*

	two arrays: a,b
	return a.max - b.min, where the index of a.max and b.min are different

*/

import java.util.*;
import java.util.Map.Entry;
//public class Solution{
//	public static int getMaxSubtract(int[] a, int[] b){
//		//<number, index>
//		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
//		HashMap<Integer, Integer> mapb = new HashMap<Integer, Integer>();
//		for(int i = 0; i < a.length; i++){
//			mapa.put(a[i], i);
//		}
//		for(int i = 0; i < b.length; i++){
//			mapb.put(b[i], i);
//		}
//		
//		Set<Entry<Integer, Integer>> seta = mapa.entrySet();
//		Set<Entry<Integer, Integer>> setb = mapb.entrySet();
//        List<Entry<Integer, Integer>> lista = new ArrayList<Entry<Integer, Integer>>(seta);
//        List<Entry<Integer, Integer>> listb = new ArrayList<Entry<Integer, Integer>>(setb);
//        Collections.sort(lista, numComparator);
//        Collections.sort(listb, numComparator);
//        
//        int indexA = lista.size() - 1;
//        int indexB = 0;
//        while(true){
//        	if(lista.get(indexA).getValue() != listb.get(indexB).getValue()) return lista.get(indexA).getKey() - listb.get(indexB).getKey();
//        	else{
//        		
//        	}
//        }
//	}
//	
//	public static Comparator<Map.Entry<Integer, Integer>> numComparator = new Comparator<Map.Entry<Integer, Integer>>() {
//		public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
//			if(a.getKey() > b.getKey()) return 1;
//			else if(a.getKey() == b.getKey()) return 0;
//			else return -1;
// 		}
//	};
	
	class Base{
		public static void main(String[] args){
			System.out.println("a");
		}
	}
	public class Test extends Base{}

//}