import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Strings {

	public Strings() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	
	
	static boolean permutation1(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        System.out.println(s1Arr);
        s1Arr.toString();
        String sb1 = new String(s1Arr);
        
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        s2Arr.toString();
        String sb2 = new String(s2Arr);
        System.out.println(s2Arr);
        return sb1.equals(sb2);
    }

	private String trimNonAlphaNumeric(String str) {
		if(str == null)
			return str;
		int i =0;
		//System.out.println();
		return new String(str.replaceAll("[^A-Za-z0-9 ]", ""));
	}
	
	private void run() {
		// TODO Auto-generated method stub
		//String str = "This is              shams";
		//StringBuffer result = ReverseWords(str);
		//System.out.println(result);
		String T = "I LIKE TECHIEME ShasS";
		String P = "SaasS";
		
		String s1 = "cba";
		char[] s1Arr =  s1.toCharArray();
		Arrays.sort(s1Arr);
		//System.out.println(s1Arr);
		//System.out.println(permutation1("abc","cba"));
		//System.out.println(findPattern(T,P,lookUpTable(P)));
		//System.out.println(trimNonAlphaNumeric("aC9#@!$"));
		Map<String,String> map = new HashMap<String, String>();
		map.put("p",null);
		map.put("s","s");
		map.put(null,null);
		map.put("a",null);
		//System.out.println(map);
		
//		String str = "aaabcbbbccddd";
//		System.out.println(RLE(str));
		//System.out.println("first occurence : "+strstr("pipipi pipepipe", "pipe"));
		//encryString("12221");
		//removeDuplicates("missisippi");
//		StringBuffer str = new StringBuffer("abcd");
//		System.out.println(str);
//		reverseString(str,0,str.length()-1);
//		System.out.println(str);
//		StringBuffer str = new StringBuffer("aba/bab/");
//		System.out.println(checkPalindrome(str,4,6));
//		String[]  strings = {"at","", "", "", "ball", "", "", "car", "", "", "dad", "", "","eat"};
//		String str = "car";
//
//		
//		System.out.println(searchNew(strings,str,0,strings.length-1));
		
		String[] strings = {"cat", "dog", "tac", "god", "act"};
	//	consecutiveAnagrams(strings);
		//for(int i = 0;i < strings.length; i++)
		//	System.out.println(strings[i]);
		
		//permutation("","abcdefg");
		permutationOfGivenLength("","234",2);
		//printDangerousString(6);
	}

	/**
	 * function to find shortest unique prefix for a given word in a given list
	 * http://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
	 * **/
	
	private void printShortestUniquePrefix(String[] str) {
		if(str == null)
			return;
		if(str.length == 1) {
			System.out.println(str);
			return;
		}
		String str1 = str[0];
		String str2 = str[1];
	}
	/**
	 * Boyer Moore patrern matching Algorithm
	 * http://techieme.in/pattern-finding-boyre-moore/
	 * */
	private int findPattern(String text, String pattern,int[] last) {
		int patternLength = pattern.length()-1;
		int i=patternLength;
		int j=i;
		while(i<text.length()) {
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j==0)
					return i;
				i--;
				j--;
			}else {
				if(last[text.charAt(i)] == -1) {
					i = i+patternLength;
				}else {
					i += (j-last[text.charAt(i)]);
				}
			}
		}
		return -1;
	}

	private int[] lookUpTable(String p) {
		int[] last = new int[255];
		for(int i=0;i<255;i++)
			last[i] = -1;
		for(int i=0;i<p.length();i++)
			last[p.charAt(i)] = i;
		return last;
	}


	
	
	
	/***
	 * Function to print all permutations of a string
	 * 
	 * */
	
	public void permutationOfGivenLength(String prefix, String str,int len) {
//		if(str == null) {
//			System.out.println("Null String");
//			return;
//		}
//		if(prefix.length() == len) {
//			System.out.println(prefix);
//			return;
//		}
//		
//		for(int i=0;i<str.length();i++) {
//			permutationOfGivenLength(prefix+str.charAt(i),str.substring(0, i)+str.substring(i+1),len);
//		}
		
		List<String> result = new ArrayList<String>();
        Set<Integer> valueSet = new HashSet<Integer>();
        valueSet.add(2);
        valueSet.add(3);
        valueSet.add(4);

        Iterator<Integer> outerIter = valueSet.iterator();
        while (outerIter.hasNext()) {
            Integer outerValue = outerIter.next();
            Iterator<Integer> innerIter = valueSet.iterator();
            while (innerIter.hasNext()) {
                Integer innerValue = innerIter.next();
                result.add(outerValue.toString() + " " + innerValue.toString());
            }
        }

        System.out.println(result);
	}
	

	/***
	 * Function to print all permutations of a string
	 * 
	 * */
	
	public void permutation(String prefix, String str) {
		if(str == null) {
			System.out.println("Null String");
			return;
		}
		if(str.length() == 0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			permutation(prefix+str.charAt(i),str.substring(0, i)+str.substring(i+1));
		}
	}
	
	/***
	 * Write a method to sort an array of strings so that all the anagrams are next to each other
	 * Example : "cat", "dog", "tac", "god", "act"
	 * Result : "cat tac act dog god"
	 * */
	
	class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(String one, String two) {
			String s1 = sortChars(one);
			String s2 = sortChars(two);
			return s1.compareTo(s2);
		}
		String sortChars(String str) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
			//return chars.toString();
		}
	}

	private void consecutiveAnagrams(String[] strings) {
		Arrays.sort(strings, new AnagramComparator());
		//System.out.println(strings[0]);
		//System.out.println(strings);
	}

	/** Recursive Method
	 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string
	 * 
	 * Example: find �ball� in [�at�, ��, ��, ��, �ball�, ��, ��, �car�, ��, ��, �dad�, ��, ��] will return 4
	 * */
	private int search(String[] arr, String str, int start, int end) {
		if(start > end)
			return -1;
		while(arr[end].equals(""))
			end--;
		int i = start; int j = end;
		int mid = (i+j)/2;
		while(arr[mid].equals(""))
			mid++;
		if(arr[mid].equals(str))
			return mid;
		while(i< j && arr[i].equals("")) 
			i++;
		
		if((str.compareTo(arr[i]) >= 0 ) && (str.compareTo(arr[mid]) < 0)) {
			return search(arr, str, start, mid-1);
		}else {
			return search(arr, str, mid+1, end);
		}
	}
	
	private int searchNew(String[] arr, String str, int start, int end) {
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		while(arr[mid].equals("")) 
			mid++;
		if(str.equals(arr[mid]))
			return mid;
		while(arr[start].equals(""))
			start++;
		while(arr[end].equals(""))
			end--;
		if(str.compareTo(arr[start]) == 0)
			return start;
		if(str.compareTo(arr[end]) == 0)
			return end;
		if(str.compareTo(arr[start]) >0 && str.compareTo(arr[mid]) < 0)
			return searchNew(arr,str,start,mid);
		else 
			return searchNew(arr,str,mid+1,end);
	}
	
	/*** iterative method */
	
	public int searchIterative(String[] arr, String str, int start, int end) {
		while(start <= end) {
			while(end >= start && arr[end].equals(""))
				end--;
			int mid = (start+end) >> 1;
			while(arr[mid].equals(""))
				mid++;
			int r = str.compareTo(arr[mid]);
			if(r == 0)
				return mid;
			if(r > 0)
				start = mid + 1;
			else 
				end = mid -1;
		}
		return -1;
	}

	public int checkPalindrome(StringBuffer str,int aCost,int bCost) {
		int i = 0, j = str.length()-1;
		int ac = 0,bc = 0;
		while(i < j) {
			if(str.charAt(i) == 'b') {
				if(str.charAt(j) == '/') {
					str.setCharAt(j, 'b');
					bc += bCost;
				}else if(str.charAt(j) =='b'){
				}else {
					return -1;
				}
			}else if(str.charAt(i) == 'a') {
				if(str.charAt(j) == '/') {
					str.setCharAt(j, 'a');
					ac += aCost;
				}else if(str.charAt(j) =='a') {
				}
				else {
					return -1;
				}
			}else {
				// char is /
				if(str.charAt(j) == 'a') {
					str.setCharAt(i, 'a');
					ac += aCost;
				}else if(str.charAt(j) == 'b'){
					str.setCharAt(j, 'b');
					bc += bCost;
				}else {
					str.setCharAt(i, 'b');
					str.setCharAt(j, 'b');
					bc += bCost;
					bc += bCost;
				}
			}
			++i; --j;
		}
		return ac+bc;
	}
	
	public void reverseString(StringBuffer string, int start,int end) {
		if(start >= end)
			return;
		if(start < end)
			swap(string,start,end);
		reverse(string, start++, end--);
	}
	private void swap(StringBuffer string, int start, int end) {
		char temp1 = string.charAt(start);
		char temp2 = string.charAt(end);
		string.setCharAt(end, temp1);
		string.setCharAt(start, temp2);
	}

	public void removeDuplicates(String string) {
		string = string.toLowerCase();
		BitSet bitset = new BitSet(26);
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < string.length();++i) {
			int k = string.charAt(i) - 'a';
			if(!bitset.get(k)) {
				bitset.set(k);
				result.append(string.charAt(i));
			}
		}
			System.out.println(result.toString());
	}
	/***
	 * function to return the original strings from encrypted string
	 * */
	public String encryString(String str) {
		if(str == null)
			return null;
		StringBuffer newStr = new StringBuffer(str);
		System.out.println(newStr);
		for(int i = 0 ; i < str.length();++i) {
			if(i == 0) {
				if(str.charAt(i) == 0) {
					newStr.setCharAt(i, '0');
				}else if (str.charAt(i) == 1) {
					newStr.setCharAt(i, '0');
					++i;
					newStr.setCharAt(i, '1');
				}else {
					
				}
			}else {
				
			}
		}
		return null;
	}
	
	/**
	 * Run Length Encoding
	 * 
	 * aaabcbbbccddd
	 * */
	public StringBuffer RLE(String str) {
		StringBuffer resultStr = new StringBuffer();
		int strlen = str.length();
		int count = 1;
		int i = 1;
		for( i = 1;i < strlen; ++i) {
			if(str.charAt(i-1) == str.charAt(i))
				++count;
			else {
				resultStr.append(str.charAt(i-1));
				resultStr.append(count);
				count = 1;
			}
		}
		resultStr.append(str.charAt(i-1));
		resultStr.append(count);
		//System.out.println(resultStr);
		return resultStr;
	}

	private StringBuffer reverse(StringBuffer str, int i, int j) {
		// TODO Auto-generated method stub
		StringBuffer newStr = new StringBuffer(str);
		char temp;
		while (i < j) {
			temp = newStr.charAt(i);
			newStr.setCharAt(i, newStr.charAt(j));
			newStr.setCharAt(j, temp);
			++i;
			--j;
		}
		return newStr;
	}
	
	/**
	 * function to reverse the words in the string
	 * */

	private StringBuffer ReverseWords(String str) {
		// TODO Auto-generated method stub
		StringBuffer newStr = new StringBuffer(str);
		System.out.println(str);
		int i = 0;
		int j = str.length() - 1;

		newStr = reverse(newStr, i, j);
		i = 0;
		j = 0;
		int k;

		while (i < newStr.length() - 1) {

			while (j < newStr.length() && (newStr.charAt(j) != ' '))
				++j;

			k = j;
			--j;
			k++;

			newStr = reverse(newStr, i, j);
			i = k;
			j = k;
		}
		return newStr;
	}

	/**
	 * strstr
	 * "pipipi pipepipe", "pipe"
	 * */
	public int strstr(String hay, String needle) {
		System.out.println("coming here");
		if (hay == null || needle == null) {
			System.out.println("Either one of the string is null");
			return -1;
		}
		for(int i = 0; i < hay.length();++i) {
			for(int j = 0;j < needle.length() && i+j < hay.length();++j) {
				if(hay.charAt(i+j) != needle.charAt(j)) {
					break;
				}else if(j == needle.length()-1)
					return i;
			}
		}
		return -1;
	}
	
	/***
	 * A binary string, of length N, is considered dangerous if it has 3 or more 0's adjacent to each other. Given N, how will you 
		1. Compute the number of dangerous binary strings of length N. 
		2. List them. 
		Examples
		N = 3 --> only one string 000. 
		N = 4 --> 3 strings, 1000, 0000, 0001.
	 * 
	 * */
	
	public void printDangerousString(int N) {
		if(N < 3) {
			System.out.println("No Dangerous Strings");
			return;
		}
			
		StringBuffer str = new StringBuffer("");
		for(int i=0;i<N;i++)
			str.append('0');
		System.out.println(str);
		while(N > 3) {
			int i = 0;
			while(i<N) {
				if((N-i) > 3 || i > 2) {
					str.setCharAt(i, '1');
					System.out.println(str);
					if(i != N-1)
						str.setCharAt(i, '0');
				}
				i++;
			}
			N--;
		}
		System.out.println(str.reverse());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Strings();
	}

}
