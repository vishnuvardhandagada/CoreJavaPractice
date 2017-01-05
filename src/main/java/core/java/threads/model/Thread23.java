package core.java.threads.model;

public class Thread23 implements Runnable {

    private ProducerConsumer2 producerConsumer2;

    public Thread23(ProducerConsumer2 producerConsumer2) {
	this.producerConsumer2 = producerConsumer2;
    }

    @Override
    public void run() {
	producerConsumer2.consume();
    }

}
