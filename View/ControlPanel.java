package View;

import java.awt.*;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ControlPanel extends JPanel {
    JToggleButton playPause;
    JCheckBox protectCriticalRegions;
    JCheckBox preventNegativeStocks;

    public ControlPanel() {
        this.playPause = new JToggleButton("Play-Pause");
        this.protectCriticalRegions = new JCheckBox();
        this.preventNegativeStocks = new JCheckBox();
        this.setLayout(new GridBagLayout());
        addComponentsToPane();

    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbuttonPlaypause = new JLabel("Botón Play Pause");
        JLabel lProtectCriticalRegions = new JLabel("Proteger Regiones Críticas");
        JLabel lPreventNegativeStocks = new JLabel("Prevenir resultados negativos");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.add(lbuttonPlaypause, c);
        c.gridx++;
        this.add(this.playPause, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lProtectCriticalRegions, c);
        c.gridx = 1;
        c.gridy++;
        this.add(this.protectCriticalRegions, c);
        c.gridx = 1;
        c.gridy++;
        this.add(lPreventNegativeStocks, c);
        c.gridx = 1;
        c.gridy++;
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

}
