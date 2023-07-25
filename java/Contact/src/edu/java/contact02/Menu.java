package edu.java.contact02;

public enum Menu {
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	

	public static Menu getValue(int n) {
		Menu[] m = Menu.values();  
		
		int len = m.length;
		if(n >=0 && n < len) {
			return m[n];
		} else {
			return m[len-1]; 
		}
		
	
	}
}
	
	
	
	
	
	
	
	

