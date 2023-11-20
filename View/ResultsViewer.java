package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.LabResults;

public class ResultsViewer extends JPanel implements Runnable {
    LabResults labResults;

    JTextField objectTimeThread;
    JTextField startThread;

    JTextField consumerTimeThread;
    JTextField producerTimeThread;

    JTextField quantityItemsProduced;
    JTextField quantityItemsConsumed;

    JTextField processingProductors;
    JTextField finishedProductors;
    JTextField pendingProductors;

    JTextField processingConsumers;
    JTextField finishedConsumers;
    JTextField pendingConsumers;

    public ResultsViewer(LabResults labResults) {
        this.labResults = labResults;

        this.objectTimeThread = new JTextField("0");
        this.startThread = new JTextField("0");

        this.consumerTimeThread = new JTextField("0");
        this.producerTimeThread = new JTextField("0");

        this.quantityItemsProduced = new JTextField("0");
        this.quantityItemsConsumed = new JTextField("0");

        this.processingProductors = new JTextField("0");
        this.finishedProductors = new JTextField("0");
        this.pendingProductors = new JTextField("0");
        
        this.processingConsumers = new JTextField("0");
        this.finishedConsumers = new JTextField("0");
        this.pendingConsumers = new JTextField("0");

        this.setLayout(new GridBagLayout());
        addComponentsToPane();
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(BorderFactory.createTitledBorder(border, "Results Viewer "));
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();
        JLabel lObjectTimeThread = new JLabel("Milisegundos en crear objetos Thread");
        JLabel lStartThread = new JLabel("Milisegundos en arrancar los hilos");

        JLabel lConsumerTimeThread = new JLabel("Milisegundos en procesamiento de los hilos consumidores");
        JLabel lProducerTimeThread = new JLabel("Milisegundos en procesamiento de los hilos productores");

        JLabel lQuantityItemsProduced = new JLabel("Cantidad de items producidos por cada uno de los productos");
        JLabel lQuantityItemsConsumed = new JLabel("Cantidad de items consumidos por cada uno de los productos");

        JLabel lProcessingProductors = new JLabel("Cantidad de hilos productores procesando");
        JLabel lFinishedProductors= new JLabel("Cantidad de hilos productores que han finalizado");
        JLabel lPendingProductors = new JLabel("Cantidad de hilos productores pendientes");

        JLabel lProcessingConsumers = new JLabel("Cantidad de hilos consumidores procesando");
        JLabel lFinishedConsumers = new JLabel("Cantidad de hilos consumidores que han finalizado");
        JLabel lPendingConsumers = new JLabel("Cantidad de hilos consumidores pendientes");


        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 30, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx++;
        this.add(lObjectTimeThread, c);
        c.gridx++;
        this.add(this.objectTimeThread, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lStartThread, c);
        c.gridx++;
        this.add(startThread, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lConsumerTimeThread, c);
        c.gridx++;
        this.add(consumerTimeThread, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lProducerTimeThread, c);
        c.gridx++;
        this.add(producerTimeThread, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lQuantityItemsProduced, c);
        c.gridx++;
        this.add(quantityItemsProduced, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lQuantityItemsConsumed, c);
        c.gridx++;
        this.add(quantityItemsConsumed, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lProcessingProductors, c);
        c.gridx++;
        this.add(processingProductors, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lFinishedProductors, c);
        c.gridx++;
        this.add(finishedProductors, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lPendingProductors, c);
        c.gridx++;
        this.add(pendingProductors, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lProcessingConsumers, c);
        c.gridx++;
        this.add(processingConsumers, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lFinishedConsumers, c);
        c.gridx++;
        this.add(finishedConsumers, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lPendingConsumers, c);
        c.gridx++;
        this.add(pendingConsumers, c);

    }

    public LabResults getLabResults() {
        return this.labResults;
    }

    public void setLabResults(LabResults labResults) {
        this.labResults = labResults;
    }

    public JTextField getObjectTimeThread() {
        return this.objectTimeThread;
    }

    public void setObjectTimeThread(JTextField counter) {
        this.objectTimeThread = counter;
    }

    public JTextField getStartThread() {
        return this.startThread;
    }

    public void setStartThread(JTextField ProducerStartTime) {
        this.startThread = ProducerStartTime;
    }

    public JTextField getConsumerTimeThread() {
        return this.consumerTimeThread;
    }

    public void setConsumerTimeThread(JTextField CustomerStartTime) {
        this.consumerTimeThread = CustomerStartTime;
    }

    public JTextField getProducerTimeThread() {
        return this.producerTimeThread;
    }

    public void setProducerTimeThread(JTextField ProducerEndTime) {
        this.producerTimeThread = ProducerEndTime;
    }

    public JTextField getQuantityItemsProduced() {
        return this.quantityItemsProduced;
    }

    public void setQuantityItemsProduced(JTextField CustomerEndTime) {
        this.quantityItemsProduced = CustomerEndTime;
    }

    public JTextField getQuantityItemsConsumed() {
        return this.quantityItemsConsumed;
    }

    public void setQuantityItemsConsumed(JTextField sumaTotalCreacionHilos) {
        this.quantityItemsConsumed = sumaTotalCreacionHilos;
    }

    public JTextField getProcessingProductors() {
        return this.processingProductors;
    }

    public void setProcessingProductors(JTextField mediaCreacionHilos) {
        this.processingProductors = mediaCreacionHilos;
    }

    public JTextField getFinishedProductors() {
        return this.finishedProductors;
    }

    public void setFinishedProductors(JTextField sumaStart) {
        this.finishedProductors = sumaStart;
    }

    public JTextField getPendingProductors() {
        return this.pendingProductors;
    }

    public void setPendingProductors(JTextField mediaStart) {
        this.pendingProductors = mediaStart;
    }


    public JTextField getProcessingConsumers() {
        return this.processingConsumers;
    }

    public void setProcessingConsumers(JTextField processingConsumers) {
        this.processingConsumers = processingConsumers;
    }

    public JTextField getFinishedConsumers() {
        return this.finishedConsumers;
    }

    public void setFinishedConsumers(JTextField finishedConsumers) {
        this.finishedConsumers = finishedConsumers;
    }

    public JTextField getPendingConsumers() {
        return this.pendingConsumers;
    }

    public void setPendingConsumers(JTextField pendingConsumers) {
        this.pendingConsumers = pendingConsumers;
    }

}
