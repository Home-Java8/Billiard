package com.game.music;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 28/08/2014
 * {@link http://stackoverflow.com/questions/14373999/jprogressbar-changing-bar-color-dynamically}
 */
import javax.swing.*;
import java.awt.*;

public class LoadingProgress extends JPanel {
	public static int                value = 0;
    public static JProgressBar progressBar;

    public LoadingProgress(int maxValue) {
        progressBar = new JProgressBar(0, maxValue);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBorderPainted(false);
        progressBar.setBackground(new Color(201, 201, 201));
        progressBar.setForeground(new Color(0, 151, 0));

        setLayout(new BorderLayout());
        setBackground(new Color(0, 70, 0));
        add(progressBar, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(360, 500, 330, 500));
    }

    public static LoadingProgress loading(int maxValue) {
        return new LoadingProgress(maxValue);
    }

}
