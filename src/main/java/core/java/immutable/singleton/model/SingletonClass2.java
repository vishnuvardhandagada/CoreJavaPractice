package core.java.immutable.singleton.model;

public class SingletonClass2 {

	private static SingletonClass2 INSTANCE = null;
	private static Object lock = new Object();

	private SingletonClass2() {
	}

	public static SingletonClass2 getInstance() {
		synchronized (lock) {
			if (null == INSTANCE)
				INSTANCE = new SingletonClass2();
		}
		return INSTANCE;
	}
}
