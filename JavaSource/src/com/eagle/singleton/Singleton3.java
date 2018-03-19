package com.eagle.singleton;

/**
 * ����ģʽ(����ʽ����)
 * �Ƿ� Lazy ��ʼ������
 * �Ƿ���̰߳�ȫ����
 * ʵ���Ѷȣ���
 * ���������ַ�ʽ�Ƚϳ��ã������ײ�����������
 * �ŵ㣺û�м�����ִ��Ч�ʻ���ߡ�
 * ȱ�㣺�����ʱ�ͳ�ʼ�����˷��ڴ档
 * ������ classloder ���Ʊ����˶��̵߳�ͬ�����⣬������instance ����װ��ʱ��ʵ��������Ȼ������װ�ص�ԭ���кܶ��֣��ڵ���ģʽ�д�������ǵ��� getInstance ������ 
 * ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ���ʱ���ʼ�� instance ��Ȼû�дﵽ lazy loading ��Ч����
 * @author EagleHao
 *
 */
public class Singleton3 {
	/**
	 * ������ص�ʱ���ʼ��
	 */
	private static Singleton3 instance = new Singleton3();

	/**
	 * ÿ�ε���getInstance()���������ʱ��ʼ����ʵ������
	 */
	public static Singleton3 getInstance() {
		return instance;
	}
	
	/**
	 * �����캯��˽�л�����������Ͳ��ᱻnewʵ����
	 */
	private Singleton3() {
		
	}
}
