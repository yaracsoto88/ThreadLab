package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GeneralConfiguration extends JPanel {
    JTextField productorsNumber;

    JTextField consumersNumber;

    JCheckBox timeProduceRandom;

    JCheckBox timeConsumeRandom;

    JSlider sliderProducer;

    JSlider sliderConsumer;

    JTextField quantityItemPerConsumer;

    JTextField quantityItemPerProducer;

    public GeneralConfiguration() {
        productorsNumber = new JTextField("0");
        consumersNumber = new JTextField("0");
        timeProduceRandom = new JCheckBox();
        timeConsumeRandom = new JCheckBox();
        sliderProducer = new JSlider(0, 1000, 500);
        sliderConsumer = new JSlider(0, 1000, 500);
        quantityItemPerConsumer = new JTextField("0");
        quantityItemPerProducer = new JTextField("0");  
        this.setLayout(new GridBagLayout());
        addComponentsToPane();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(BorderFactory.createTitledBorder(border, "General Configuration "));
    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();
        JLabel lProductorNumber = new JLabel("Numero de productores");
        JLabel lConsumerNumber = new JLabel("Numero de consumidores");
        JLabel ltimeConsumeRandom = new JLabel("Tiempo consumidor aleatorio");
        JLabel ltimeProduceRandom = new JLabel("Tiempo productor aleatorio");
        JLabel lSliderProducer=new JLabel("Slider de Productor");
        JLabel lSliderConsumer=new JLabel("Slider de Consumidor");
        JLabel lQuantityItemPerConsumer=new JLabel("Cantidad de items a consumir por consumidor");
        JLabel lQuantityItemPerProducer=new JLabel("Cantidad de items a producir por productor");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(4, 30, 4, 4);       
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.add(lProductorNumber, c);
        c.gridx++;
        this.add(this.productorsNumber, c);
       c.gridx = 0;
       c.gridy++;
   
        this.add(lConsumerNumber, c);
        c.gridx = 1;
     
        this.add(this.consumersNumber, c);
        c.gridx = 0;
        c.gridy++;
        this.add(ltimeConsumeRandom, c);
        c.gridx = 1;
    
        this.add(this.timeConsumeRandom, c);
        c.gridx = 0;
        c.gridy++;

        this.add(ltimeProduceRandom, c);
        c.gridx = 1;
        this.add(this.timeProduceRandom, c);

        c.gridx = 0;
        c.gridy++;
        this.add(lSliderConsumer, c);
        c.gridx = 1;
        this.add(this.sliderConsumer, c);

        c.gridx = 0;
        c.gridy++;
        this.add(lSliderProducer, c);
        c.gridx = 1;
        this.add(this.sliderProducer, c);

        c.gridx = 0;
        c.gridy++;
        this.add(lQuantityItemPerConsumer, c);
        c.gridx = 1;
        this.add(this.quantityItemPerConsumer, c);

        c.gridx = 0;
        c.gridy++;
        this.add(lQuantityItemPerProducer, c);
        c.gridx = 1;
        this.add(this.quantityItemPerProducer, c);

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

    public JTextField getQuantityItemPerConsumer() {
        return this.quantityItemPerConsumer;
    }

    public void setQuantityItemPerConsumer(JTextField quantityItemPerConsumer) {
        this.quantityItemPerConsumer = quantityItemPerConsumer;
    }

    public JTextField getQuantityItemPerProducer() {
        return this.quantityItemPerProducer;
    }

    public void setQuantityItemPerProducer(JTextField quantityItemPerProducer) {
        this.quantityItemPerProducer = quantityItemPerProducer;
    }


}