package com.eagle.singleton;

/**
 * 单例模式
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @author EagleHao
 */
public class Singleton1 {

	/**
	 * 这里可以用synchronized，但是synchronized不禁止指令重排序，可能会出错，所以用volatile
	 * synchronized的作用是：保证原子性
	 * volatile的作用是：保证可见性、禁止指令重排序，但不能保证原子性
	 * 
	 * 其实创建一个对象，往往包含三个过程。 
	 * 对于singleton = new Singleton()，这不是一个原子操作，在 JVM 中包含的三个过程。
	 * 1>给 singleton 分配内存
	 * 2>调用 Singleton 的构造函数来初始化成员变量，形成实例
	 * 3>将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null了）
	 * 但是，由于JVM会进行指令重排序，所以上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是 1-3-2，
	 * 则在 3 执行完毕、2 未执行之前，被l另一个线程抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以这个线程会直接返回 instance，然后使用，那肯定就会报错了。
	 */
	private volatile static Singleton1 singleton;
	
	/**
	 * 给方法加锁：如果有多个线程调用getInstance()方法，当一个线程获取该方法，而其它线程必须等待，消耗资源。
	 * @return Singleton对象
	 */
	public synchronized static Singleton1 getInstance() {
		/**
		 * 双重检查锁
		 * 为什么需要双重检查锁呢？因为第一次检查是确保之前是一个空对象，而非空对象就不需要同步了，空对象的线程然后进入同步代码块，如果不加第二次空对象检查，两个线程同时获取同步代码块，
		 * 一个线程进入同步代码块，另一个线程就会等待，而这两个线程就会创建两个实例化对象，所以需要在线程进入同步代码块后再次进行空对象检查，才能确保只创建一个实例化对象。
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
	 * 将构造函数私有化，这样该类就不会被new实例化
	 */
	private Singleton1() {
		
	}
}
