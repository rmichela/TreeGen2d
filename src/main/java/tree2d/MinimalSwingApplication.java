package tree2d;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 Simple harness for testing GUI code.

 <P>To use this class, edit the code to suit your needs.  
 */
public class MinimalSwingApplication {


    // PRIVATE //

    public void buildAndDisplayGui(){
        JFrame frame = new JFrame("L-System Tree Generator");

        Dimension size = new Dimension(700, 700);

        final TreePanel treePanel = new TreePanel();

        Dimension spinnerDimension = new Dimension(70, 20);

        final JSpinner seed = new JSpinner();
        seed.setMaximumSize(spinnerDimension);
        seed.setMinimumSize(spinnerDimension);
        seed.setValue(treePanel.getSeed());
        seed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                treePanel.setSeed((Integer) seed.getValue());
            }
        });

        final JSpinner generations = new JSpinner();
        generations.setMaximumSize(spinnerDimension);
        generations.setMinimumSize(spinnerDimension);
        generations.setValue(treePanel.getGenerations());
        generations.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                treePanel.setGenerations((Integer) generations.getValue());
            }
        });

        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.X_AXIS));
        spinnerPanel.add(new JLabel("Seed:"));
        spinnerPanel.add(Box.createHorizontalStrut(4));
        spinnerPanel.add(seed);
        spinnerPanel.add(Box.createHorizontalStrut(10));
        spinnerPanel.add(new JLabel("Generations:"));
        spinnerPanel.add(Box.createHorizontalStrut(4));
        spinnerPanel.add(generations);

        frame.add(spinnerPanel, BorderLayout.NORTH);
        frame.add(treePanel, BorderLayout.CENTER);

        frame.setSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}