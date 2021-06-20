
public class JavaTestExamples {

	public JavaTestExamples() {
		// TODO Auto-generated constructor stub
	}
	Integer i = 3;
	int j;
	String s = "7";
	int x = Integer.parseInt(s);
	double d = Double.parseDouble("420.24") ;
	boolean b = new Boolean("12kdfds").booleanValue();
	public void go() {
		j = i;
		System.out.println(s);
		System.out .println(b);
	}
	
	/***
	 * funciton to print - aabaa - a2b1a2 
	 * */
	public void runLengthEncoding(StringBuffer str) {
		int count = 1;
		StringBuffer newStr = new StringBuffer();
		for(int i = 0; i < str.length();++i) {
			if((i+1) < str.length() && str.charAt(i) == str.charAt(i+1)) {
				count++;
			}else {
				newStr.append(str.charAt(i));
				newStr.append(count);
				count = 1;
			}
		}System.out.println(newStr);	
	}
	
	/**
	 * function to print all palindromes in the given string
	 * */
	public void printAllPalindromes(StringBuffer str) {
		/**
		 * for odd number of characters , Holding the centre character and comparing previous and next characters
		 * */
		
		for(int i = 1; i < str.length()-1; ++i ) {
			for(int j = i -1,k=i+1;j>=0&&k<str.length()-1;--j,++k) {
				if(str.charAt(j) == str.charAt(k))
					System.out.println("found : " + str.substring(j, k+1));
				else break;
			}
		}
		for(int i = 1; i < str.length(); ++i ) {
			for(int j = i,k=i+1;j>=0&&k<str.length();--j,++k) {
				if(str.charAt(j) == str.charAt(k))
					System.out.println("found : " + str.substring(j, k+1));
				else break;
			}
		}
	}
	
	
	public static String getPalindrome(String str) {
        
        int [] chars = new int[27];
        
        char[] charArray = str.toCharArray(); //.forEach(c -> chars[c-'a']++);
        for(char c : charArray) {
        	chars[c-'a']++;
        }
        
        StringBuilder buf = new StringBuilder();
        
        for (int i = 0; i < 27; i++) {
            if (chars[i] >= 2) {
                int count = chars[i] / 2;
                chars[i] -= count*2;
                while (count > 0) {
                    buf.append((char) (i+'a'));
                    count--;
                }
            }
        }
        
        String end = buf.toString();
        
        buf.reverse();
        
        for (int i = 0; i < 27; i++) {
            if (chars[i] >= 1) {
                buf.append((char) (i+'a'));
                break;
            }
        }
        
        return buf.toString() + end;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("forgeeksskeegfor");
		
		//new JavaTestExamples().printAllPalindromes(str);;
		//System.out.println(getPalindrome("gggaaa"));
		//System.out.println(getPalindrome("ttaatta"));
		//System.out.println(getPalindrome("abc"));
		String[] strings = {"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo" };
		String needle = "Wo";
		StringBuilder strb = new StringBuilder();
		if(needle.charAt(0) >= 'a') {
			System.out.println("Not a CamelCase");
			return;
		}
		strb.append(needle.charAt(0));
		for(int i=1;i<needle.length();i++) {
			if(needle.charAt(i)>='a') {
				strb.append(needle.charAt(i));
			}else {
				strb.append(",");
				strb.append(needle.charAt(i));
			}
		  }
		//System.out.println(strb);
		String[] resultList = new String[strings.length];
		int k=0,count=0;
		String[] strsArray = strb.toString().split(",");
		for(String list : strings) {
			for(String s : strsArray) {
				if(list.indexOf(s) == -1) {
					break;
				}
				count++;
			}
			if(count==strsArray.length)
				resultList[k++] = list;
			count=0;
		}
		for(String s : resultList) {
			if(s != null)
				System.out.println(s);
		}
				
		//new JavaTestExamples().runLengthEncoding(str);;
	}
}





