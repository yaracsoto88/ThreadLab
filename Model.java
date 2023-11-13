public class Model {
    Counter counter;

    public  Model (){
        counter = new Counter();
    }

    public  void play(){
        Thread []  customersThreads = new Thread[400];
        Thread []  producersThreads = new Thread[200];

        for (int i = 0; i < customersThreads.length; i++) {
            customersThreads[i] = new Thread(new Customer(counter));
            customersThreads[i].start();
        }

        for (int i = 0; i < producersThreads.length; i++) {
            producersThreads[i] = new Thread(new Producer(counter));
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
