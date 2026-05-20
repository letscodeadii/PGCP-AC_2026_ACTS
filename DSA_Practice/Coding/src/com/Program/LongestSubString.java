package com.Program;

import java.util.HashSet;

public class LongestSubString {
	
	private static void longest(String str) {
		HashSet<Character> set=new HashSet<>();
		String longestTillnow="";
		String longestOverall="";
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(set.contains(c)) {
				longestTillnow="";
				set.clear();
			}
			set.add(c);
			longestTillnow+=c;
		}
		if(longestTillnow.length()>longestOverall.length()) {
			longestOverall=longestTillnow;
		}
		
	}

	public static void main(String[] args) {
		String str="abcdab";
		longest(str);
		// TODO Auto-generated method stub
	}

}
