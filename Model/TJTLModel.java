

package Model;
public class TJTLModel {
    public ProtectedCounter counter;

    public  TJTLModel (){
        counter = new ProtectedCounter();
    }

    public  void play( int productors, int sliderProductor,boolean producerRandom, int consumidors, int sliderConsumidor, boolean consumerRandom){
        Thread []  customersThreads = new Thread[consumidors];
        Thread []  producersThreads = new Thread[productors];


        for (int i = 0; i < customersThreads.length; i++) {
            long timeThreadC=System.currentTimeMillis();
            customersThreads[i] = new Thread(new Customer(counter, consumerRandom, sliderConsumidor ));
            timeThreadC=System.currentTimeMillis()-timeThreadC;
            this.counter.setThreadTime(timeThreadC+this.counter.getThreadTime());
        
            long duracionStart=System.currentTimeMillis();
            customersThreads[i].start();
            duracionStart=System.currentTimeMillis()-duracionStart;
            this.counter.setStartTime(duracionStart+this.counter.getStartTime());



        }

        for (int i = 0; i < producersThreads.length; i++) {
            long timeThreadP=System.currentTimeMillis();
            producersThreads[i] = new Thread(new Producer(counter, producerRandom, sliderProductor));
            timeThreadP=System.currentTimeMillis()-timeThreadP;
            this.counter.setThreadTime(timeThreadP+this.counter.getThreadTime());
            

            long duracionStart=System.currentTimeMillis();
            producersThreads[i].start();
            duracionStart=System.currentTimeMillis()-duracionStart;
            this.counter.setStartTime(duracionStart+this.counter.getStartTime());
        }

        this.counter.setAvgThreadCreacion(this.counter.getThreadTime()/(float)(consumidors+productors));
        this.counter.setAvgStart(this.counter.getStartTime()/(float)(consumidors+productors));

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

    public ProtectedCounter getCounter() {
        return counter;
    }

}
