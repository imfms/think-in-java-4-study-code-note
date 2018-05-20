package cn.f_ms.study.think_in_java_4;

public class c4t9 {

	public static void main(String[] args) {
		
		doIt(5);
		
	}
	
	public static void doIt(int num) {
		
		if (num < 0) {
			throw new IllegalArgumentException("num can't less 0, but found '" + num + "'");
		}
		
		int result = 1;
		int lastResult = 0;
		int tempValue;
		
		for (int i = 1; i <= num; i++) {
			
			System.out.println(result);
			
			if (i == num) {
				continue;
			}
			
			tempValue = lastResult;
			lastResult = result;
			result += tempValue;
		}
	}
	
}
