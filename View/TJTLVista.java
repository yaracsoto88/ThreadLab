package View;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Controller.TJTLController;
import DTO.LabParameters;
import DTO.LabResults;

public class TJTLVista extends JFrame implements ActionListener, ChangeListener, Listener, Runnable {
    ControlPanel controlPanel;
    GeneralConfiguration generalConfiguration;
    ResultsViewer resultsViewer;
    LabParameters labParameters;
    LabResults labResults;
    TJTLController tjtlController;
    JToggleButton playPause;

    public TJTLVista(LabParameters labParameters, LabResults labResults, TJTLController tjtlController) {
        this.tjtlController = tjtlController;
        this.labParameters = labParameters;
        this.labResults = labResults;
        this.controlPanel = new ControlPanel();
        this.generalConfiguration = new GeneralConfiguration();
        this.resultsViewer = new ResultsViewer(labResults);
        this.playPause = controlPanel.playPause;
        this.playPause.addActionListener(this);
        this.configureJFrame();
        this.setVisible(true);

    }

    private void configureJFrame() {
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.addComponentsToPane(this.getContentPane());
    }

    private void addComponentsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(controlPanel, c);
        c.gridy++;
        c.gridx = 0;

        panel.add(generalConfiguration, c);
        c.gridy++;
        c.gridx = 0;

        panel.add(resultsViewer, c);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                this.resultsViewer.getContador().setText((String.valueOf(this.tjtlController.getModel().getProduct().getStock())));
                this.resultsViewer.getObjectTimeThread().setText(String.valueOf(labResults.threadTime));
                this.resultsViewer.getStartThread().setText(String.valueOf(labResults.startTime));
                this.resultsViewer.getQuantityItemsConsumed().setText(String.valueOf(labResults.itemsConsumidos));
                this.resultsViewer.getQuantityItemsProduced().setText(String.valueOf(labResults.itemsProducidos));
                this.resultsViewer.getConsumerTimeThread().setText(String.valueOf(labResults.AvgThreadCreacion));
                this.resultsViewer.getProducerTimeThread().setText(String.valueOf(labResults.avgStart));
                this.resultsViewer.getProcessingProductors().setText(String.valueOf(labResults.hilosProcesandoProductor));
                this.resultsViewer.getFinishedProductors().setText(String.valueOf(labResults.hilosFinalizadosProductor));
                this.resultsViewer.getPendingProductors().setText(String.valueOf(labParameters.productores-labResults.hilosFinalizadosProductor));
                this.resultsViewer.getProcessingConsumers().setText(String.valueOf(labResults.hilosProcesandoConsumidor));
                this.resultsViewer.getFinishedConsumers().setText(String.valueOf(labResults.hilosFinalizadosConsumidor));
                this.resultsViewer.getPendingConsumers().setText(String.valueOf(labParameters.consumidores-labResults.hilosFinalizadosConsumidor));

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play-Pause":
                labParameters.productores = Integer.parseInt(generalConfiguration.getProductorsNumber().getText());
                labParameters.consumidores = Integer.parseInt(generalConfiguration.getConsumersNumber().getText());
                labParameters.itemConsumidor = Integer.parseInt(generalConfiguration.getQuantityItemPerConsumer().getText());
                labParameters.itemProductor = Integer.parseInt(generalConfiguration.getQuantityItemPerProducer().getText());
                labParameters.sliderConsumer = generalConfiguration.sliderConsumer.getValue();
                labParameters.sliderProducer = generalConfiguration.sliderProducer.getValue();
                labParameters.protectCriticalRegions = controlPanel.protectCriticalRegions.isSelected();
                labParameters.preventNegativeStocks = controlPanel.preventNegativeStocks.isSelected();
                labParameters.timeConsumeRandom = generalConfiguration.timeConsumeRandom.isSelected();
                labParameters.timeProduceRandom = generalConfiguration.timeProduceRandom.isSelected();
                labParameters.preventNegativeStocks = controlPanel.preventNegativeStocks.isSelected();
                labParameters.protectCriticalRegions = controlPanel.protectCriticalRegions.isSelected();
                tjtlController.play();

                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }
}
