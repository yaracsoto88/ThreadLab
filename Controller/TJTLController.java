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
        this.labParameters = new LabParameters();
        this.labResults = new LabResults();
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

    public TJTLModel getModel() {
        return this.model;
    }

    public void setModel(TJTLModel model) {
        this.model = model;
    }

    public TJTLVista getTjtlVista() {
        return this.tjtlVista;
    }

    public void setTjtlVista(TJTLVista tjtlVista) {
        this.tjtlVista = tjtlVista;
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
