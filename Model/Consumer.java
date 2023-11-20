package Model;
import java.util.Random;

public class Consumer implements  Runnable{
    Product product;
    Long startTime;
    Long endTime;
    boolean random;
    int sleepTime;

    public Consumer(Product product, boolean random, int sleepTime) {
        this.product=product;
        this.random=random;
        this.sleepTime=sleepTime;
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
            this.product.consume();
            try {
                Random rand = new Random();
                int sleepTime= rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        // this.counter.updateCustomersTimes(endTime,startTime);

    }
    private void consumirValorEspecifico(){
        this.startTime =  System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.product.consume();
            try {
                Thread.sleep(this.sleepTime); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis() - startTime;
        // this.counter.updateCustomersTimes(endTime,startTime);

    }
}
