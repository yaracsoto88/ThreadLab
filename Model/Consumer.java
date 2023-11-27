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
        if (this.labParameters.timeConsumeRandom) {
            consumirRandom();
        } else {
            consumirValorEspecifico();
        }
        this.labResults.hilosFinalizadosConsumidor++;
    }

    private void consumirRandom() {
        this.labResults.CustomerStartTime = System.currentTimeMillis();
        for (int i = 0; i < this.labParameters.itemConsumidor; i++) {
            this.labResults.itemsConsumidos++;
            this.product.consume(labParameters.protectCriticalRegions);
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.labResults.CustomerEndTime = System.currentTimeMillis() - this.labResults.CustomerStartTime;
        // this.counter.updateCustomersTimes(endTime,startTime);

    }

    private void consumirValorEspecifico() {
        this.labResults.CustomerStartTime = System.currentTimeMillis();
        for (int i = 0; i < this.labParameters.itemConsumidor; i++) {
            this.labResults.itemsConsumidos++;
            this.product.consume(labParameters.protectCriticalRegions);
            try {
                Thread.sleep(this.labParameters.sliderConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.labResults.CustomerEndTime = System.currentTimeMillis() - this.labResults.CustomerStartTime;
        // this.counter.updateCustomersTimes(endTime,startTime);

    }
}
