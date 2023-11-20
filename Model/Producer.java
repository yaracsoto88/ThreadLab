package Model;

import java.util.Random;

public class Producer implements Runnable {
    Product product;
    boolean random;
    int sleepTime;
    long startTime;
    long endTime;

    public Producer(Product product, boolean random, int sleepTime) {
        this.product = product;
        this.random=random;
        this.sleepTime=sleepTime;

    }

    @Override
    public void run() {
        if (this.random) {
            producirRandom();
        } else {
            producirValorEspecifico();
        }

    }

    private void producirRandom() {
        this.startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.product.produce();

            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        // this.counter.updateProducersTimes(endTime, startTime);

    }

    private void producirValorEspecifico() {
        this.startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.product.produce();
            try {
                Thread.sleep(this.sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;

    }
}
