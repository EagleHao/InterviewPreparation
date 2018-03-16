package com.eagle.singleton;

/**
 * ����ģʽ
 * �̰߳�ȫ����̬�ڲ���
 * @author EagleHao
 */
public class Singleton2 {

	/**
	 * ��̬�ڲ���
	 * @author EagleHao
	 */
	private static class GetSingleton2 {
		private static Singleton2 singleton = new Singleton2();
	}
	
	/**
	 * ����������������ж���̵߳���getInstance()��������һ���̻߳�ȡ�÷������������̱߳���ȴ���������Դ��
	 * @return Singleton����
	 */
	public synchronized static Singleton2 getInstance() {
		return GetSingleton2.singleton;
	}
}
