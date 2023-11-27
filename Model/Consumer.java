package Model;

import java.util.Random;
import DTO.LabParameters;
import DTO.LabResults;

public class Consumer implements Runnable {
    Product product;
    LabResults labResults;
    LabParameters labParameters;

    public Consumer(Product product, LabParameters labParameters, LabResults labResults) {
        this.product = product;
        this.labParameters = labParameters;
        this.labResults = labResults;

    }

    @Override
    public void run() {
        this.labResults.hilosProcesandoConsumidor++;
        if (labParameters.preventNegativeStocks) {
            consumerPreventNegative();
        } else {
            consumir();
        }

        this.labResults.hilosFinalizadosConsumidor++;
    }

    private void consumerPreventNegative() {
        this.labResults.CustomerStartTime = System.currentTimeMillis();

        for (int i = 0; i < labParameters.itemConsumidor; i++) {
            synchronized (product) {
                while (product.getStock() <= 0) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product.consume(true);
                esperar();
            }  
        }
        this.labResults.CustomerEndTime = System.currentTimeMillis() - this.labResults.CustomerStartTime;
    }

    private void consumir() {
        this.labResults.CustomerStartTime = System.currentTimeMillis();
        for (int i = 0; i < this.labParameters.itemConsumidor; i++) {
            this.labResults.itemsConsumidos++;
            this.product.consume(labParameters.protectCriticalRegions);
            esperar();
        }
        this.labResults.CustomerEndTime = System.currentTimeMillis() - this.labResults.CustomerStartTime;

    }

    private void esperarRandom() {
        Random ran = new Random();
        try {
            Thread.sleep(ran.nextInt(100));
        } catch (Exception e) {
            System.err.println("errors");
        }
    }

    private void esperarValorEspecifico() {
        try {
            Thread.sleep(labParameters.sliderConsumer);
        } catch (Exception e) {
            System.err.println("errors");
        }
    }

    private void esperar() {
        if (this.labParameters.timeConsumeRandom) {
            esperarRandom();
        } else {
            esperarValorEspecifico();
        }
    }
}
