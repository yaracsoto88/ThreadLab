package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class ControlPanel extends JPanel {
    JToggleButton playPause;
    JButton reiniciar;
    JCheckBox protectCriticalRegions;
    JCheckBox preventNegativeStocks;

    public ControlPanel() {
        this.playPause = new JToggleButton("Play-Pause");
        this.reiniciar=new JButton("Reiniciar");
        this.protectCriticalRegions = new JCheckBox();
        this.preventNegativeStocks = new JCheckBox();
        this.setLayout(new GridBagLayout());
        addComponentsToPane();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(BorderFactory.createTitledBorder(border, "Control Panel  "));

    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbuttonPlaypause = new JLabel("Botón Play Pause");
        JLabel lbuttonReiniciar=new JLabel("Botón Reiniciar");
    
        JLabel lProtectCriticalRegions = new JLabel("Proteger Regiones Críticas");
        JLabel lPreventNegativeStocks = new JLabel("Prevenir resultados negativos");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(0, 30, 0, 4); 
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.add(lbuttonPlaypause, c);
        c.gridx++;
        this.add(this.playPause, c);
        c.gridy++;
        c.gridx=0;

        this.add(lbuttonReiniciar, c);
        c.gridx++;
        this.add(this.reiniciar, c);
        c.gridy++;
        c.gridx=0;

        this.add(lProtectCriticalRegions, c);
        
        c.gridx++;
        this.add(this.protectCriticalRegions, c);
        c.gridy++;
        c.gridx=0;
        this.add(lPreventNegativeStocks, c);
        
        c.gridx++;
        this.add(this.preventNegativeStocks, c);

    }

    public JToggleButton getPlayPause() {
        return this.playPause;
    }

    public void setPlayPause(JToggleButton playPause) {
        this.playPause = playPause;
    }

    public JCheckBox getProtectCriticalRegions() {
        return this.protectCriticalRegions;
    }

    public void setProtectCriticalRegions(JCheckBox protectCriticalRegions) {
        this.protectCriticalRegions = protectCriticalRegions;
    }

    public JCheckBox getPreventNegativeStocks() {
        return this.preventNegativeStocks;
    }

    public void setPreventNegativeStocks(JCheckBox preventNegativeStocks) {
        this.preventNegativeStocks = preventNegativeStocks;
    }

    public JButton getReiniciar() {
        return this.reiniciar;
    }

    public void setReiniciar(JButton reiniciar) {
        this.reiniciar = reiniciar;
    }


}
