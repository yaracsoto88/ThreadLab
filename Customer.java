import java.util.Random;

public class Customer implements  Runnable{
    Counter counter;
    Long startTime;
    Long endTime;
    boolean random;
    int sleepTime;

    public Customer(Counter counter, boolean random, int sleepTime) {
        this.setCounter(counter);
        this.random=random;
        this.sleepTime=sleepTime;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        if(this.random){
            consumirRandom();
        }
        else{
            consumirValorEspecifico();
        }
    }
    private void consumirRandom(){
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
    private void consumirValorEspecifico(){
        this.startTime =  System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.counter.decrement();
            try {
                Thread.sleep(this.sleepTime); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        this.counter.updateCustomersTimes(endTime,startTime);

    }
}
