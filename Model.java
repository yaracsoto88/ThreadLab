public class Model {
    Counter counter;

    public  Model (){
        counter = new Counter();
    }

    public  void play( int productors, int sliderProductor,boolean producerRandom, int consumidors, int sliderConsumidor, boolean consumerRandom){
        Thread []  customersThreads = new Thread[consumidors];
        Thread []  producersThreads = new Thread[productors];

        for (int i = 0; i < customersThreads.length; i++) {
            
            customersThreads[i] = new Thread(new Customer(counter, consumerRandom, sliderConsumidor ));
            customersThreads[i].start();
        }

        for (int i = 0; i < producersThreads.length; i++) {
            producersThreads[i] = new Thread(new Producer(counter, producerRandom, sliderProductor));
            producersThreads[i].start();
        }

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
