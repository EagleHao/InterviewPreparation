package com.eagle.singleton;

/**
 * ����ģʽ
 * ˫����/˫��У������DCL���� double-checked locking��
 * JDK �汾��JDK1.5 ��
 * �Ƿ� Lazy ��ʼ������
 * �Ƿ���̰߳�ȫ����
 * ʵ���Ѷȣ��ϸ���
 * ���������ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
 * getInstance() �����ܶ�Ӧ�ó���ܹؼ���
 * @author EagleHao
 */
public class Singleton1 {

	/**
	 * ���������synchronized������synchronized����ָֹ�������򣬿��ܻ����������volatile
	 * synchronized�������ǣ���֤ԭ����
	 * volatile�������ǣ���֤�ɼ��ԡ���ָֹ�������򣬵����ܱ�֤ԭ����
	 * 
	 * ��ʵ����һ���������������������̡� 
	 * ����singleton = new Singleton()���ⲻ��һ��ԭ�Ӳ������� JVM �а������������̡�
	 * 1>�� singleton �����ڴ�
	 * 2>���� Singleton �Ĺ��캯������ʼ����Ա�������γ�ʵ��
	 * 3>��singleton����ָ�������ڴ�ռ䣨ִ�����ⲽ singleton���Ƿ� null�ˣ�
	 * ���ǣ�����JVM�����ָ����������������ĵڶ����͵�������˳���ǲ��ܱ�֤�ģ����յ�ִ��˳������� 1-2-3 Ҳ������ 1-3-2������� 1-3-2��
	 * ���� 3 ִ����ϡ�2 δִ��֮ǰ����l��һ���߳���ռ�ˣ���ʱ instance �Ѿ��Ƿ� null �ˣ���ȴû�г�ʼ��������������̻߳�ֱ�ӷ��� instance��Ȼ��ʹ�ã��ǿ϶��ͻᱨ���ˡ�
	 */
	private volatile static Singleton1 singleton;
	
	/**
	 * ����������������ж���̵߳���getInstance()��������һ���̻߳�ȡ�÷������������̱߳���ȴ���������Դ��
	 * @return Singleton����
	 */
	public synchronized static Singleton1 getInstance() {
		/**
		 * ˫�ؼ����
		 * Ϊʲô��Ҫ˫�ؼ�����أ���Ϊ��һ�μ����ȷ��֮ǰ��һ���ն��󣬶��ǿն���Ͳ���Ҫͬ���ˣ��ն�����߳�Ȼ�����ͬ������飬������ӵڶ��οն����飬�����߳�ͬʱ��ȡͬ������飬
		 * һ���߳̽���ͬ������飬��һ���߳̾ͻ�ȴ������������߳̾ͻᴴ������ʵ��������������Ҫ���߳̽���ͬ���������ٴν��пն����飬����ȷ��ֻ����һ��ʵ��������
		 */
		if (singleton == null) {
			synchronized (Singleton1.class) {
				if (singleton == null) {
					singleton = new Singleton1();
				}
			}
		}
		return singleton;
	}
	
	/**
	 * �����캯��˽�л�����������Ͳ��ᱻnewʵ����
	 */
	private Singleton1() {
		
	}
}
