package javaBasic;

import org.testng.annotations.Test;

public class Topic_01_For {

	int number[] = { 2, 17, 5, 10, 30, 20, 50, 2, 2, 5, 10 };

	@Test
	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];

			}
		}
		System.out.println(x);
	}

}
