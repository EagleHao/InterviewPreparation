package com.eagle.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatileʵ���̵߳�ԭ����
 * �ο����ϣ�http://www.cnblogs.com/dolphin0520/p/3920373.html
 * @author EagleHao
 *
 */
public class VolatileTest{

//	private volatile boolean isStop = false;
	private int i = 0;
	Lock lock = new ReentrantLock();
	
//	@Override
//	public void run() {
//		while (!isStop) {
//			System.out.println("test" + (i++));
//		}
//	}
	
//	public void setStop() {
//		isStop = true;
//	}
	
	public synchronized void increase() {
		lock.lock();
		try {
			i++;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final VolatileTest volatileTest = new VolatileTest();
//			volatileTest.start();
//			new Thread(){
//				public void run() {
//					System.out.println("-----------------------");
//					volatileTest.setStop();
//				};
//			}.start();
		
		for (int i = 0; i < 10; i++) {
			new Thread(){
				public void run() {
					for (int j = 0; j < 1000; j++) {
						volatileTest.increase();
					}
				};
			}.start();
		}
		
		//��֤ǰ����̶߳�ִ����
		while (Thread.activeCount() > 1) {
			/**
			 * Java�߳��е�Thread.yield( )��������Ϊ�߳��ò�������˼�壬����˵��һ���߳�ʹ�����������֮�����ͻ���Լ�CPUִ�е�ʱ���õ������Լ������������߳����У�
			 * ע�������Լ����������߳����У������ǵ������ø������̡߳�yield()���������ò��������õ�ǰ�߳��ɡ�����״̬�����뵽������״̬�����Ӷ�������������ͬ���ȼ��ĵȴ��̻߳�ȡִ��Ȩ��
			 * ���ǣ������ܱ�֤�ڵ�ǰ�̵߳���yield()֮������������ͬ���ȼ����߳̾�һ���ܻ��ִ��Ȩ��Ҳ�п����ǵ�ǰ�߳��ֽ��뵽������״̬���������У�
			 * �ٸ����ӣ�һ���������Ŷ��Ϲ��������ֵ�Yield��ʱ����ͻȻ˵���Ҳ�������ȥ�ˣ����Ǵ���������Ϲ�������Ȼ�������˾�һ����򹫽������п��������������ϳ��ˣ�Ҳ�п�����Yield���ϳ��ˡ�
			 * �����߳��������ȼ��ģ����ȼ�Խ�ߵ��ˣ���һ���ܵ�һ���ϳ������ǲ�һ���ģ����ȼ��ߵ��˽���ֻ�ǵ�һ���ϳ��ĸ��ʴ���һ����ѣ�
			 * ���յ�һ���ϳ��ģ�Ҳ�п��������ȼ���͵��ˡ�������ν�����ȼ�ִ�У����ڴ���ִ�д����в������ֳ����ġ�
			 */
			Thread.yield();
		}
		System.out.println(volatileTest.i);
	}
}
