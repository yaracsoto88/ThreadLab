package View;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.LabResults;

public class ResultsViewer extends JPanel implements Runnable {
    LabResults labResults;
    JTextField counter;

    JTextField ProducerStartTime;

    JTextField CustomerStartTime;

    JTextField ProducerEndTime;

    JTextField CustomerEndTime;

    JTextField sumaTotalCreacionHilos;

    JTextField mediaCreacionHilos;

    JTextField sumaStart;

    JTextField mediaStart;

    public ResultsViewer(LabResults labResults) {
        this.labResults = labResults;
        this.counter = new JTextField("0");
        this.ProducerStartTime = new JTextField("0");
        this.CustomerStartTime = new JTextField("0");
        this.ProducerEndTime = new JTextField("0");
        this.CustomerEndTime = new JTextField("0");
        this.sumaTotalCreacionHilos=new JTextField("0");
        this.mediaCreacionHilos=new JTextField("0");

        this.sumaStart=new JTextField("0");
        this.mediaStart=new JTextField("0");

        this.setLayout(new GridBagLayout());
        addComponentsToPane();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private void addComponentsToPane(){
        GridBagConstraints c=new GridBagConstraints();
        JLabel lCounter = new JLabel("Valor del contador: ");
        JLabel lProducerStarTime =new JLabel("Producer start time : ");
        JLabel lProducerEndTime =new JLabel("Producer end time : ");
        JLabel lCustomerStarTime =new JLabel("Customer start time : ");
        JLabel lCustomerEndTime =new JLabel("Customer end time : ");
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
        c.gridx++;
        this.add(lCounter, c);
        c.gridx++;
        this.add(this.counter, c);
        c.gridx=1;
        c.gridy++;
        this.add(lProducerStarTime,c);
        c.gridx++;
        this.add(ProducerStartTime,c);
        c.gridx=1;
        c.gridy++;
        this.add(lCustomerStarTime,c);
        c.gridx++;
        this.add(CustomerStartTime,c);
        c.gridx=1;
        c.gridy++;
        this.add(lProducerEndTime,c);
        c.gridx++;
        this.add(ProducerEndTime,c);
        c.gridx=1;
        c.gridy++;
        this.add(lCustomerEndTime,c);
        c.gridx++;
        this.add(CustomerEndTime,c);
        
        c.gridx=1;
        c.gridy++;
        this.add(lSumaCreacion, c);
        c.gridx++;
        this.add(sumaTotalCreacionHilos,c);

        c.gridx=1;
        c.gridy++;
        this.add(lMediaCreacion, c);
        c.gridx++;
        this.add(mediaCreacionHilos,c);

        c.gridx=1;
        c.gridy++;
        this.add(lSumaStart, c);
        c.gridx++;
        this.add(sumaStart,c);

        c.gridx=1;
        c.gridy++;
        this.add(lmediaStart, c);
        c.gridx++;
        this.add(mediaStart,c);



    }

}
