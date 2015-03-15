package com.game.testing;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 28/08/2014
 * {@link http://stackoverflow.com/questions/14373999/jprogressbar-changing-bar-color-dynamically}
 */
import javax.swing.*;
import java.awt.*;

public class LoadingProgress extends JPanel {
//    final static int       interval = 100;
	public static int                value = 0;
//	public JLabel         labelText = new JLabel("<html>" + "<font color=\"#008000\">" + "<b>" + "Loading..." + "</b>" + "</font>" + "</html>");
//    public JLabel         labelText = new JLabel();
    public static JProgressBar progressBar;

    public LoadingProgress(int maxValue) {
        progressBar = new JProgressBar(0, maxValue);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBorderPainted(false);
        progressBar.setBackground(new Color(201, 201, 201));
        progressBar.setForeground(new Color(0, 151, 0));

        setLayout(new BorderLayout());
        add(progressBar, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(300, 500, 330, 500));
    }

    public static LoadingProgress loading(int maxValue) {
        return new LoadingProgress(maxValue);
    }

}
