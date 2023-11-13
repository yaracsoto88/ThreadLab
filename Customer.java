import java.util.Random;

public class Customer implements  Runnable{
    Counter counter;
    Long startTime;
    Long endTime;
    public Customer(Counter counter) {
        this.setCounter(counter);
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        this.startTime =  System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.counter.decrement();
            try {
                Random rand = new Random();
                int sleepTime= rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        this.counter.updateCustomersTimes(endTime,startTime);
    }
}
