package View;
import javax.swing.*;

import Controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements  ActionListener,Runnable{
    JButton startButton;

    JTextField counter;

    JTextField ProducerStartTime;

    JTextField CustomerStartTime;

    JTextField ProducerEndTime;

    JTextField CustomerEndTime;

    Controller controller;

    JTextField productorsNumber;

    JTextField consumersNumber;

    JCheckBox timeProduceRandom;

    JCheckBox timeConsumeRandom;

    JSlider sliderProducer;

    JSlider sliderConsumer;

    JTextField sumaTotalCreacionHilos;

    JTextField mediaCreacionHilos;

    JTextField sumaStart;

    JTextField mediaStart;


    public View(Controller controller) {
        this.controller = controller;

        this.startButton = new JButton("Play");
        this.startButton.addActionListener(this);

        this.counter = new JTextField("0");
        this.ProducerStartTime = new JTextField("0");
        this.CustomerStartTime = new JTextField("0");
        this.ProducerEndTime = new JTextField("0");
        this.CustomerEndTime = new JTextField("0");
        this.productorsNumber=new JTextField("0");
        this.consumersNumber=new JTextField("0");
        this.timeConsumeRandom=new JCheckBox();
        this.timeProduceRandom=new JCheckBox();
        this.sliderConsumer=new JSlider(0,1000,500);
        this.sliderProducer=new JSlider(0,1000, 500);

        this.sumaTotalCreacionHilos=new JTextField("0");
        this.mediaCreacionHilos=new JTextField("0");

        this.sumaStart=new JTextField("0");
        this.mediaStart=new JTextField("0");


        this.configureJFrame();

        this.setVisible(true);
    }

    private void addComponentsToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        JLabel lCounter = new JLabel("Valor del contador: ");
        JLabel lProducerStarTime =new JLabel("Producer start time : ");
        JLabel lProducerEndTime =new JLabel("Producer end time : ");
        JLabel lCustomerStarTime =new JLabel("Customer start time : ");
        JLabel lCustomerEndTime =new JLabel("Customer end time : ");
        JLabel lProductorNumber=new JLabel("Productors number");
        JLabel lConsumerNumber=new JLabel("Consumers number");
        JLabel ltimeConsumeRandom=new JLabel("Tiempo consumidor aleatorio");
        JLabel ltimeProduceRandom=new JLabel("Tiempo productor aleatorio");

        JLabel lSumaCreacion=new JLabel("Tiempo total creacion hilos");

        JLabel lMediaCreacion=new JLabel ("Media creación hilos");

        JLabel lSumaStart=new JLabel("Tiempo total del start");
        JLabel lmediaStart=new JLabel("Media del tiempo del start");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(this.startButton, c);

        c.gridx++;
        panel.add(lCounter, c);
        c.gridx++;
        panel.add(this.counter, c);
        c.gridx=1;
        c.gridy++;
        panel.add(lProducerStarTime,c);
        c.gridx++;
        panel.add(ProducerStartTime,c);
        c.gridx=1;
        c.gridy++;
        panel.add(lCustomerStarTime,c);
        c.gridx++;
        panel.add(CustomerStartTime,c);
        c.gridx=1;
        c.gridy++;
        panel.add(lProducerEndTime,c);
        c.gridx++;
        panel.add(ProducerEndTime,c);
        c.gridx=1;
        c.gridy++;
        panel.add(lCustomerEndTime,c);
        c.gridx++;
        panel.add(CustomerEndTime,c);
        c.gridx=1;
        c.gridy++;
        panel.add(lProductorNumber, c);
        c.gridx++;
        panel.add(productorsNumber,c);
        c.gridx=1;
        c.gridy++;
        panel.add(lConsumerNumber, c);
        c.gridx++;
        panel.add(consumersNumber,c);
        c.gridx=1;
        c.gridy++;
        panel.add(ltimeConsumeRandom, c);
        c.gridx++;
        panel.add(timeConsumeRandom,c);
        c.gridx++;
        panel.add(sliderConsumer, c);
        c.gridx=1;
        c.gridy++;
        panel.add(ltimeProduceRandom, c);
        c.gridx++;
        panel.add(timeProduceRandom,c);
        c.gridx++;
        panel.add(sliderProducer, c);

        c.gridx=1;
        c.gridy++;
        panel.add(lSumaCreacion, c);
        c.gridx++;
        panel.add(sumaTotalCreacionHilos,c);

        c.gridx=1;
        c.gridy++;
        panel.add(lMediaCreacion, c);
        c.gridx++;
        panel.add(mediaCreacionHilos,c);

        c.gridx=1;
        c.gridy++;
        panel.add(lSumaStart, c);
        c.gridx++;
        panel.add(sumaStart,c);

        c.gridx=1;
        c.gridy++;
        panel.add(lmediaStart, c);
        c.gridx++;
        panel.add(mediaStart,c);
    

        }

    private void configureJFrame(){
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.addComponentsToPane(this.getContentPane());
    }

    public void run() {
        while(true){
            try{
                Thread.sleep(100);
                this.getTextField().setText(String.valueOf(controller.model.getCounter().getCount()));
                this.getProducerStartTime().setText(String.valueOf(controller.model.getCounter().getProducerStartTime()));
                this.getCustomerStartTime().setText(String.valueOf(controller.model.getCounter().getCustomerStartTime()));
                this.getProducerEndTime().setText(String.valueOf(controller.model.getCounter().getProducerEndTime()));
                
                this.getCustomerEndTime().setText(String.valueOf(controller.model.getCounter().getCustomerEndTime()));
                this.getSumaTotalCreacionHilos().setText(String.valueOf(controller.model.getCounter().getThreadTime()));
                this.getMediaCreacionHilos().setText(String.valueOf(controller.model.getCounter().getAvgThreadCreacion()));
                this.getSumaStart().setText(String.valueOf(controller.model.getCounter().getStartTime()));
                this.getMediaStart().setText(String.valueOf(controller.model.getCounter().getAvgStart()));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.getTextField().setText("0");
                this.getProducerStartTime().setText("0");
                this.getProducerEndTime().setText("0");
                this.getCustomerStartTime().setText("0");
                this.getCustomerEndTime().setText("0");
                int productors=Integer.parseInt(productorsNumber.getText());
                int consumidors=Integer.parseInt(consumersNumber.getText());
                int sliderConsumidor=sliderConsumer.getValue();
                int sliderProductor=sliderProducer.getValue();
                boolean consumerRandom=timeConsumeRandom.isSelected();
                boolean producerRandom=timeProduceRandom.isSelected();
                controller.play(productors, sliderProductor, producerRandom, consumidors, sliderConsumidor, consumerRandom);

                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }



    public JTextField getTextField() {
        return counter;
    }

    public JTextField getProducerStartTime() {
        return ProducerStartTime;
    }

    public JTextField getCustomerStartTime() {
        return CustomerStartTime;
    }

    public JTextField getProducerEndTime() {
        return ProducerEndTime;
    }

    public JTextField getCustomerEndTime() {
        return CustomerEndTime;
    }

    public JButton getStartButton() {
        return this.startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getCounter() {
        return this.counter;
    }

    public void setCounter(JTextField counter) {
        this.counter = counter;
    }
    public void setProducerStartTime(JTextField ProducerStartTime) {
        this.ProducerStartTime = ProducerStartTime;
    }
    public void setCustomerStartTime(JTextField CustomerStartTime) {
        this.CustomerStartTime = CustomerStartTime;
    }
    public void setProducerEndTime(JTextField ProducerEndTime) {
        this.ProducerEndTime = ProducerEndTime;
    }
    public void setCustomerEndTime(JTextField CustomerEndTime) {
        this.CustomerEndTime = CustomerEndTime;
    }

    public Controller getController() {
        return this.controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JTextField getProductorsNumber() {
        return this.productorsNumber;
    }

    public void setProductorsNumber(JTextField productorsNumber) {
        this.productorsNumber = productorsNumber;
    }

    public JTextField getConsumersNumber() {
        return this.consumersNumber;
    }

    public void setConsumersNumber(JTextField consumersNumber) {
        this.consumersNumber = consumersNumber;
    }

    public JCheckBox getTimeProduceRandom() {
        return this.timeProduceRandom;
    }

    public void setTimeProduceRandom(JCheckBox timeProduceRandom) {
        this.timeProduceRandom = timeProduceRandom;
    }

    public JCheckBox getTimeConsumeRandom() {
        return this.timeConsumeRandom;
    }

    public void setTimeConsumeRandom(JCheckBox timeConsumeRandom) {
        this.timeConsumeRandom = timeConsumeRandom;
    }

    public JSlider getSliderProducer() {
        return this.sliderProducer;
    }

    public void setSliderProducer(JSlider sliderProducer) {
        this.sliderProducer = sliderProducer;
    }

    public JSlider getSliderConsumer() {
        return this.sliderConsumer;
    }

    public void setSliderConsumer(JSlider sliderConsumer) {
        this.sliderConsumer = sliderConsumer;
    }

    public JTextField getSumaTotalCreacionHilos() {
        return this.sumaTotalCreacionHilos;
    }

    public void setSumaTotalCreacionHilos(JTextField sumaTotalCreacionHilos) {
        this.sumaTotalCreacionHilos = sumaTotalCreacionHilos;
    }

    public JTextField getMediaCreacionHilos() {
        return this.mediaCreacionHilos;
    }

    public void setMediaCreacionHilos(JTextField mediaCreacionHilos) {
        this.mediaCreacionHilos = mediaCreacionHilos;
    }

    public JTextField getSumaStart() {
        return this.sumaStart;
    }

    public void setSumaStart(JTextField sumaStart) {
        this.sumaStart = sumaStart;
    }

    public JTextField getMediaStart() {
        return this.mediaStart;
    }

    public void setMediaStart(JTextField mediaStart) {
        this.mediaStart = mediaStart;
    }


}