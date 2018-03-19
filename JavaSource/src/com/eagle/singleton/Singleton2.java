package com.eagle.singleton;

/**
 * 单例模式
 * 线程安全：静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 这种方式同样利用了 classloader机制来保证初始化 instance时只有一个线程，它跟饿汉式(Singleton3)不同的是：饿汉式(Singleton3)只要 Singleton类被装载了，那么 instance就会被实例化（没有达到 lazy loading效果），
 * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 GetSingleton2 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 GetSingleton2 类，
 * 从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比饿汉式(Singleton3)就显得很合理。
 * @author EagleHao
 */
public class Singleton2 {

	/**
	 * 静态内部类
	 * @author EagleHao
	 */
	private static class GetSingleton2 {
		private static final Singleton2 singleton = new Singleton2();
	}
	
	/**
	 * 给方法加锁：如果有多个线程调用getInstance()方法，当一个线程获取该方法，而其它线程必须等待，消耗资源。
	 * @return Singleton对象
	 */
	public synchronized static Singleton2 getInstance() {
		return GetSingleton2.singleton;
	}
	
	/**
	 * 将构造函数私有化，这样该类就不会被new实例化
	 */
	private Singleton2() {

	}
}
