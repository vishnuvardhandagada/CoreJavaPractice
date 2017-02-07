package core.java.threads.model;

import java.util.concurrent.Callable;

public class Thread25 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
	throw new Exception("Thread25 -> call() -> Exception thrown");
    }

}
