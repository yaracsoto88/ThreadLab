package Controller;

import DTO.LabParameters;
import DTO.LabResults;
import Model.TJTLModel;
import View.TJTLVista;


public class TJTLController {

    public TJTLModel model;
    TJTLVista tjtlVista;
    LabParameters labParameters;
    LabResults labResults;

    public TJTLController() {
        this.model = new TJTLModel();
        this.tjtlVista = new TJTLVista(this.labParameters, this.labResults, this);

    }

    public void play(int productors, int sliderProductor, boolean producerRandom, int consumidors, int sliderConsumidor,
            boolean consumerRandom) {

        this.model.counter.setCount(0);
        this.model.counter.setProducerStartTime(0);
        this.model.counter.setProducerEndTime(0);
        this.model.counter.setCustomerStartTime(0);
        this.model.counter.setCustomerEndTime(0);
        this.model.counter.setThreadTime(0);
        this.model.counter.setAvgThreadCreacion(0);

        this.model.play(productors, sliderProductor, producerRandom, consumidors, sliderConsumidor, consumerRandom);
    }

    public TJTLVista getView() {
        return tjtlVista;
    }

    public static void main(String[] args) {
        TJTLController controller = new TJTLController();

        Thread thread = new Thread(controller.getView());
        thread.start();

    }
}
