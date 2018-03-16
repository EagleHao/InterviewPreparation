package com.eagle.singleton;

/**
 * 单例模式
 * 线程安全：静态内部类
 * @author EagleHao
 */
public class Singleton2 {

	/**
	 * 静态内部类
	 * @author EagleHao
	 */
	private static class GetSingleton2 {
		private static Singleton2 singleton = new Singleton2();
	}
	
	/**
	 * 给方法加锁：如果有多个线程调用getInstance()方法，当一个线程获取该方法，而其它线程必须等待，消耗资源。
	 * @return Singleton对象
	 */
	public synchronized static Singleton2 getInstance() {
		return GetSingleton2.singleton;
	}
}
