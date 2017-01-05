package core.java.threads.model;

public class Thread20 implements Runnable {

    private ProducerConsumer producerConsumer;

    public Thread20(ProducerConsumer producerConsumer) {
	this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
	producerConsumer.produce();
    }

}
