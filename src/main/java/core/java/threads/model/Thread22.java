package core.java.threads.model;

public class Thread22 implements Runnable {

    private ProducerConsumer2 producerConsumer2;

    public Thread22(ProducerConsumer2 producerConsumer2) {
	this.producerConsumer2 = producerConsumer2;
    }

    @Override
    public void run() {
	producerConsumer2.produce();
    }

}
