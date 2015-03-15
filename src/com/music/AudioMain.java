package com.music;


/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 20/08/2014
 * {@link http://www.sql.ru/forum/198343/jmf-mp3}
 * {@link http://www.cs.uccs.edu/~cs525/jmf/jmf.html}
 */
import javax.media.*;
import javax.media.Player;
import javax.media.format.AudioFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioMain extends JFrame implements ControllerListener {

    private Player        player = null;
    private JPanel progressPanel = new JPanel(new FlowLayout());


    public static void main(String[] args){
        AudioMain audioMain = new AudioMain();
        audioMain.setTitle("Play MP3-File in Java");
        audioMain.setSize(1000, 100);
        audioMain.setLocation(150, 50);
        audioMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        classAudio = this;
        audioMain.panelMP3();
        audioMain.setVisible(true);
    }


    public void panelMP3() {
        JPanel   panelChooserMP3 = new JPanel(new FlowLayout());
        Container      container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(progressPanel);
        container.add(panelChooserMP3);
        JButton buttonChooserMP3 = new JButton("Chooser MP3");
        buttonChooserMP3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser      chooser = new JFileChooser();
                chooser.showOpenDialog(progressPanel);
                MediaLocator mediaLocator = null;
                URL                   url = null;
                String            strFile = "file://"+chooser.getSelectedFile().getAbsolutePath();
                try {
                    url     = new URL(strFile);
                    strFile = url.toExternalForm();
                } catch (MalformedURLException mue) {
                    System.out.println(mue.toString());
                }
                System.out.println(url);
                try {
                    // Create a media locator from the file name
                    if ((mediaLocator = new MediaLocator(strFile)) == null)
                        fatal("Can't build URL for " + strFile);

                    try {
                        Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
                        Format input2 = new AudioFormat(AudioFormat.MPEG);
                        Format output = new AudioFormat(AudioFormat.LINEAR);
                        PlugInManager.addPlugIn(
                                "com.sun.media.codec.audio.mp3.JavaDecoder",
                                new Format[]{input1, input2},
                                new Format[]{output},
                                PlugInManager.CODEC
                        );

                        player = Manager.createPlayer(mediaLocator);
                    } catch (NoPlayerException e) {
                        System.out.println(e);
                        fatal("Could not create player for " + mediaLocator);
                    }

                    // Add ourselves as a listener for a player's events
//                    player.addControllerListener(classAudio);
                    player.addControllerListener(AudioMain.this);

                } catch (MalformedURLException e) {
                    fatal("Invalid media file URL!");
                } catch (IOException e) {
                    fatal("IO exception creating player for " + mediaLocator);
                }
                startPlay();
            }

        });
        panelChooserMP3.add(buttonChooserMP3);
    }

    public void controllerUpdate(ControllerEvent event) {
        Component  visualComponent = null;
        Component controlComponent = null;
        Component      progressBar = null;
        int     controlPanelHeight = 0;
        int             videoWidth = 0;
        int            videoHeight = 0;

        // If we're getting messages from a dead player, just leave
        if (player == null)
            return;

        // When the player is Realized, get the visual and control components and add them to the Applet
        if (event instanceof RealizeCompleteEvent) {
            if (progressBar != null) {
                progressPanel.remove(progressBar);
                progressBar = null;
            }

            int width = 400;
            int height = 0;
            if (controlComponent == null) {
                if ((controlComponent = player.getControlPanelComponent()) != null) {
                    controlPanelHeight = controlComponent.getPreferredSize().height;
                    progressPanel.add(controlComponent);
                    height += controlPanelHeight;
                }
            }
//            if (visualComponent == null) {
//                if ((visualComponent = player.getVisualComponent()) != null) {
//                    progressPanel.add(visualComponent);
//                    Dimension videoSize = visualComponent.getPreferredSize();
//                    videoWidth = videoSize.width;
//                    videoHeight = videoSize.height;
//                    width = videoWidth;
//                    height += videoHeight;
//                    visualComponent.setBounds(0, 0, videoWidth, videoHeight);
//                }
//            }
            progressPanel.setBounds(10, 20, width, height);
            if (controlComponent != null) {
                controlComponent.setBounds(0, videoHeight, width, controlPanelHeight);
                controlComponent.invalidate();
            }
//        } else if (event instanceof CachingControlEvent) {
//            if (player.getState() > Controller.Realizing)
//                return;
//            // Put a progress bar up when downloading starts, take it down when downloading ends.
//            CachingControlEvent e = (CachingControlEvent) event;
//            CachingControl cc = e.getCachingControl();
//
//            // Add the bar if not already there ...
//            if (progressBar == null) {
//                if ((progressBar = cc.getControlComponent()) != null) {
//                    progressPanel.add(progressBar);
//                    progressPanel.setSize(progressBar.getPreferredSize());
//                    validate();
//                }
//            }
//        } else if (event instanceof EndOfMediaEvent) {
//            // We've reached the end of the media; rewind and start over
//            player.setMediaTime(new Time(0));
//            player.start();
//        } else if (event instanceof ControllerErrorEvent) {
//            // Tell TypicalPlayerApplet.start() to call it a day
//            player = null;
//            fatal(((ControllerErrorEvent) event).getMessage());
//        } else if (event instanceof ControllerClosedEvent) {
//            progressPanel.removeAll();
        }
    }


    public void startPlay(){
        player.realize();
    }

    void fatal(String s) {
        // Applications will make various choices about what to do here. We print a message
        System.err.println("FATAL ERROR: " + s);
        // Invoke the uncaught exception handler System.exit() is another choice.
        throw new Error(s);
    }

}