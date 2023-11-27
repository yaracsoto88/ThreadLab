
package Model;

import DTO.LabParameters;
import DTO.LabResults;

public class TJTLModel {
    private Product product;
    private LabParameters labParameters;
    private LabResults labResults;

    public TJTLModel(LabParameters labParameters, LabResults labResults) {
        product = new Product(" ", 0, 0);
        this.labParameters = labParameters;
        this.labResults = labResults;
    }

    public void play() {
        // los pasamos desde el dto en vez de por parámetro
        int consumidors = labParameters.consumidores;
        int productors = labParameters.productores;

        Thread[] customersThreads = new Thread[consumidors];
        Thread[] producersThreads = new Thread[productors];

        for (int i = 0; i < customersThreads.length; i++) {
            long timeThreadC = System.currentTimeMillis();
            customersThreads[i] = new Thread(new Consumer(product, labParameters, labResults));
            timeThreadC = System.currentTimeMillis() - timeThreadC;
            this.labResults.threadTime = timeThreadC + this.labResults.threadTime;
            // this.counter.setThreadTime(timeThreadC+this.counter.getThreadTime());

            long duracionStart = System.currentTimeMillis();
            customersThreads[i].start();
            duracionStart = System.currentTimeMillis() - duracionStart;
            this.labResults.startTime = duracionStart + this.labResults.startTime;

        }

        for (int i = 0; i < producersThreads.length; i++) {
            long timeThreadP = System.currentTimeMillis();
            producersThreads[i] = new Thread(new Producer(product, labParameters, labResults));
            timeThreadP = System.currentTimeMillis() - timeThreadP;
            this.labResults.threadTime = timeThreadP + this.labResults.threadTime;
            // this.counter.setThreadTime(timeThreadP+this.counter.getThreadTime());

            long duracionStart = System.currentTimeMillis();
            producersThreads[i].start();
            duracionStart = System.currentTimeMillis() - duracionStart;
            this.labResults.startTime = duracionStart + this.labResults.startTime;
        }

        this.labResults.AvgThreadCreacion = this.labResults.threadTime / (float) (consumidors + productors);
        this.labResults.avgStart = this.labResults.startTime / (float) (consumidors + productors);

    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LabParameters getLabParameters() {
        return this.labParameters;
    }

    public void setLabParameters(LabParameters labParameters) {
        this.labParameters = labParameters;
    }

    public LabResults getLabResults() {
        return this.labResults;
    }

    public void setLabResults(LabResults labResults) {
        this.labResults = labResults;
    }



}
