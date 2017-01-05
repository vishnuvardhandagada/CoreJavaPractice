package core.java.threads.model;

public class Thread21 implements Runnable {

    private ProducerConsumer producerConsumer;

    public Thread21(ProducerConsumer producerConsumer) {
	this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
	producerConsumer.consume();
    }

}
