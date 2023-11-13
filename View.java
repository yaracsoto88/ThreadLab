import javax.swing.*;

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
        c.gridy++;
        panel.add(sliderConsumer, c);
        c.gridx=1;
        c.gridy++;
        panel.add(ltimeProduceRandom, c);
        c.gridx++;
        panel.add(timeProduceRandom,c);
        c.gridy++;
        panel.add(sliderProducer, c);
    

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

                controller.play(productors, consumidors);
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
}