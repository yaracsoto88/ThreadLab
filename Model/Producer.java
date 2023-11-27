package Model;

import java.util.Random;
import DTO.LabParameters;
import DTO.LabResults;

public class Producer implements Runnable {
    Product product;
    LabParameters labParameters;
    LabResults labResults;


    public Producer(Product product, LabParameters labParameters, LabResults labResults) {
        this.product = product;
        this.labParameters = labParameters;
        this.labResults = labResults;

    }

    @Override
    public void run() {
        this.labResults.hilosProcesandoProductor++;
        if (labParameters.preventNegativeStocks) {
            producePreventNegative();
        } else {
            producir();
        }

        this.labResults.hilosFinalizadosProductor++;
    }

    private void producePreventNegative() {
        this.labResults.ProducerStartTime= System.currentTimeMillis();

        for (int i = 0; i < labParameters.itemProductor; i++) {
            synchronized (product) {
                labResults.itemsProducidos++;
                product.produce(true);
                esperar();
                product.notifyAll();
            }  
        }
        this.labResults.ProducerEndTime = System.currentTimeMillis() - this.labResults.ProducerStartTime;
    }

    private void producir() {
        this.labResults.ProducerStartTime = System.currentTimeMillis();
        for (int i = 0; i < this.labParameters.itemProductor; i++) {
            this.labResults.itemsProducidos++;
            this.product.produce(labParameters.protectCriticalRegions);
            esperar();
        }
        this.labResults.ProducerEndTime = System.currentTimeMillis() - this.labResults.ProducerStartTime;

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
            Thread.sleep(labParameters.sliderProducer);
        } catch (Exception e) {
            System.err.println("errors");
        }
    }

    private void esperar() {
        if (this.labParameters.timeProduceRandom) {
            esperarRandom();
        } else {
            esperarValorEspecifico();
        }
    }
}
