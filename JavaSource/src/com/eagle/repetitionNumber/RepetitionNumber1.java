package com.eagle.repetitionNumber;

/**
 * �ҳ��������ظ������֣���Ӧ��Ŀһ
 * @author EagleHao
 *
 */
public class RepetitionNumber1 {

	
	public static void main(String[] args) {
		int[] numbers = {2,5,1,0,2,5,3};
		for (int i = 0; i < numbers.length; i++) {
			//���±���±��Ӧ��ֵ�Ƚ�
			if (i != numbers[i]) {
				int value = numbers[i];
				//�ٽ��±��Ӧ��ֵ���������Ը�ֵΪ�±��ֵ���бȽ�
				if (value != numbers[value]) {
					//����±��Ӧ��ֵ���������Ը�ֵΪ�±��ֵ����ȣ��򽻻����ߵ�ֵ
					int temp = numbers[i];
					numbers[i] = numbers[value];
					numbers[value] = temp;
					//����֮�󣬽��±�����
					i = 0;
				} else {
					System.out.println("�ҵ���ͬ��ֵ��" + numbers[i]);
				}
			}
		}
	}
}
