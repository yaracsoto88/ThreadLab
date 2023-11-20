package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

    public TJTLVista(LabParameters labParameters, LabResults labResults, TJTLController tjtlController) {
        this.tjtlController=tjtlController;
        this.labParameters=labParameters;
        this.labResults=labResults;
        this.controlPanel=new ControlPanel();
        this.generalConfiguration=new GeneralConfiguration();
        this.resultsViewer=new ResultsViewer(labResults);
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
        GridBagConstraints c=new GridBagConstraints();

        JLabel lControlPanel=new JLabel("Control Panel");
        lControlPanel.setOpaque(true);
        lControlPanel.setBackground(new Color(240,211,165));

        JLabel lGeneralConfiguration=new JLabel("General Configuration");
        lGeneralConfiguration.setOpaque(true);
        lGeneralConfiguration.setBackground(new Color(240,211,165));

        JLabel lResultsViewer=new JLabel("Results Viewer");
        lResultsViewer.setOpaque(true);
        lResultsViewer.setBackground(new Color(240,211,165));

        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(2, 0, 0, 0); 
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(lControlPanel,c);
        c.gridy++;
        panel.add(controlPanel,c);
        c.gridy++;
        c.gridx=0;

        panel.add(lGeneralConfiguration,c);
        c.gridy++;
        panel.add(generalConfiguration,c);
        c.gridy++;
        c.gridx=0;

        panel.add(lResultsViewer,c);
        c.gridy++;
        panel.add(resultsViewer,c);


    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

   

}
