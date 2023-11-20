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
        this.model = new TJTLModel(labParameters, labResults);
        this.tjtlVista = new TJTLVista(this.labParameters, this.labResults, this);

    }

    public void play() {

        this.model.play();
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
