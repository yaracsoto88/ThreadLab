public class Model {
    Counter counter;

    public  Model (){
        counter = new Counter();
    }

    public  void play( int productors, int sliderProductor,boolean producerRandom, int consumidors, int sliderConsumidor, boolean consumerRandom){
        Thread []  customersThreads = new Thread[consumidors];
        Thread []  producersThreads = new Thread[productors];


        for (int i = 0; i < customersThreads.length; i++) {
            long timeThreadC=System.currentTimeMillis();
            customersThreads[i] = new Thread(new Customer(counter, consumerRandom, sliderConsumidor ));
            timeThreadC=System.currentTimeMillis()-timeThreadC;
            this.counter.setThreadTime(timeThreadC+this.counter.getThreadTime());
        
            customersThreads[i].start();

        }

        for (int i = 0; i < producersThreads.length; i++) {
            long timeThreadP=System.currentTimeMillis();
            producersThreads[i] = new Thread(new Producer(counter, producerRandom, sliderProductor));
            timeThreadP=System.currentTimeMillis()-timeThreadP;
            this.counter.setThreadTime(timeThreadP+this.counter.getThreadTime());
            
            producersThreads[i].start();
        }

        this.counter.setAvgThreadCreacion(this.counter.getThreadTime()/(long)(consumidors+productors));

//        try {
//            for( Thread hilo:customersThreads){
//                hilo.join();
//            }
//        } catch (Exception e) {}
//
//        try {
//            for( Thread hilo:producersThreads){
//                hilo.join();
//            }
//        } catch (Exception e) {}
    }

    public Counter getCounter() {
        return counter;
    }

}
