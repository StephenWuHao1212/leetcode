/*
	
	Compare two version numbers version1 and version2.
	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	
	You may assume that the version strings are non-empty and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.
	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
	
	Here is an example of version numbers ordering:
	
	0.1 < 1.1 < 1.2 < 13.37
	
	
	two pointers and two linkedlist to store char for both string
	before comparing string, clear the first few zeros
	
	add char into corresponding linkedlist until reach dot
	clear zero for both linkedlist
	compare length before compare real digit
*/
import java.util.*;
public class Solution {
    public static int compareVersion(String version1, String version2) {
        LinkedList<Character> lista = new LinkedList<Character>();
        LinkedList<Character> listb = new LinkedList<Character>();
        int indexa = 0;
        int indexb = 0;
        while(true){
        	if(indexa == version1.length() && indexb == version2.length()) return 0;
        	if(version1.charAt(indexa) == '.') indexa++;
        	if(version2.charAt(indexb) == '.') indexb++;
        	while(indexa < version1.length() && version1.charAt(indexa) != '.'){
        		lista.add(version1.charAt(indexa));
        		indexa++;
        	}
        	while(lista.peekFirst() == '0' && lista.size() != 1) lista.pollFirst();
        	while(indexb < version2.length() && version2.charAt(indexb) != '.'){
        		listb.add(version2.charAt(indexb));
        		indexb++;
        	}
        	while(listb.peekFirst() == '0' && listb.size() != 1) listb.pollFirst();
        	
        	if(lista.size() > listb.size()) return 1;
        	else if(lista.size() < listb.size()) return -1;
        	else{
        		for(int i = 0; i < lista.size(); i++){
        			if(lista.get(i) > listb.get(i)) return 1;
        			else if(lista.get(i) < listb.get(i)) return -1;
        		}
        		lista.clear();
        		listb.clear();
        	}
        	
        }
    }
    
    public static void main(String[] args){
    	System.out.println(compareVersion("1.0","1.0"));
    }
}

