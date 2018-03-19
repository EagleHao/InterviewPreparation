package com.eagle.singleton;

/**
 * ����ģʽ
 * �̰߳�ȫ����̬�ڲ���
 * �Ƿ� Lazy ��ʼ������
 * �Ƿ���̰߳�ȫ����
 * ʵ���Ѷȣ�һ��
 * ���������ַ�ʽ�ܴﵽ˫������ʽһ���Ĺ�Ч����ʵ�ָ��򵥡��Ծ�̬��ʹ���ӳٳ�ʼ����Ӧʹ�����ַ�ʽ������˫������ʽ�����ַ�ʽֻ�����ھ�̬��������˫������ʽ����ʵ������Ҫ�ӳٳ�ʼ��ʱʹ�á�
 * ���ַ�ʽͬ�������� classloader��������֤��ʼ�� instanceʱֻ��һ���̣߳���������ʽ(Singleton3)��ͬ���ǣ�����ʽ(Singleton3)ֻҪ Singleton�౻װ���ˣ���ô instance�ͻᱻʵ������û�дﵽ lazy loadingЧ������
 * �����ַ�ʽ�� Singleton �౻װ���ˣ�instance ��һ������ʼ������Ϊ GetSingleton2 ��û�б�����ʹ�ã�ֻ��ͨ����ʽ���� getInstance ����ʱ���Ż���ʽװ�� GetSingleton2 �࣬
 * �Ӷ�ʵ���� instance������һ�£����ʵ���� instance ��������Դ�������������ӳټ��أ�����һ���棬�ֲ�ϣ���� Singleton �����ʱ��ʵ��������Ϊ����ȷ�� Singleton �໹�����������ĵط�������ʹ�ôӶ������أ�
 * ��ô���ʱ��ʵ���� instance ��Ȼ�ǲ����ʵġ����ʱ�����ַ�ʽ��ȶ���ʽ(Singleton3)���Եúܺ���
 * @author EagleHao
 */
public class Singleton2 {

	/**
	 * ��̬�ڲ���
	 * @author EagleHao
	 */
	private static class GetSingleton2 {
		private static final Singleton2 singleton = new Singleton2();
	}
	
	/**
	 * ����������������ж���̵߳���getInstance()��������һ���̻߳�ȡ�÷������������̱߳���ȴ���������Դ��
	 * @return Singleton����
	 */
	public synchronized static Singleton2 getInstance() {
		return GetSingleton2.singleton;
	}
	
	/**
	 * �����캯��˽�л�����������Ͳ��ᱻnewʵ����
	 */
	private Singleton2() {

	}
}
