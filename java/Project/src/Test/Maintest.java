package Test;

import java.util.Calendar;

public class Maintest {

	public static void main(String[] args) {
		
		
		
	
		
	}
	
	public int getAge(int birthYear, int birthMonth, int birthDay)
	{
	        Calendar current = Calendar.getInstance();
	        int currentYear  = current.get(Calendar.YEAR);
	        int currentMonth = current.get(Calendar.MONTH) + 1;
	        int currentDay   = current.get(Calendar.DAY_OF_MONTH);
	       
	        int age = currentYear - birthYear;
	        // 생일 안 지난 경우 -1
	        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)  
	            age--;
	       
	        return age;
	}
	
}
