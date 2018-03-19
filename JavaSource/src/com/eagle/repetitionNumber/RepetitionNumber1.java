package com.eagle.repetitionNumber;

/**
 * 找出数组中重复的数字，对应题目一
 * @author EagleHao
 *
 */
public class RepetitionNumber1 {

	
	public static void main(String[] args) {
		int[] numbers = {2,5,1,0,2,5,3};
		for (int i = 0; i < numbers.length; i++) {
			//将下标和下标对应的值比较
			if (i != numbers[i]) {
				int value = numbers[i];
				//再将下标对应的值和数组中以该值为下标的值进行比较
				if (value != numbers[value]) {
					//如果下标对应的值和数组中以该值为下标的值不相等，则交换两者的值
					int temp = numbers[i];
					numbers[i] = numbers[value];
					numbers[value] = temp;
					//交换之后，将下标置零
					i = 0;
				} else {
					System.out.println("找到相同的值：" + numbers[i]);
				}
			}
		}
	}
}
