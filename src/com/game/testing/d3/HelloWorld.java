package com.game.testing.d3;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Саша on 04.09.2014.
 */
public class HelloWorld extends JFrame {
    public HelloWorld(){
        super("Hello World - Java3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(640,480);
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D        canvas3D = new Canvas3D(gc);
        add(canvas3D,BorderLayout.CENTER);
        SimpleUniverse        su = new SimpleUniverse(canvas3D);
        BranchGroup           bg = new BranchGroup();
        ///
//        Transform3D t1 = new Transform3D();
//        t1.rotY(Math.toRadians(30));
//        Transform3D t2 = new Transform3D();
//        t2.rotX(Math.toRadians(30));
//        t1.mul(t2);
//        TransformGroup tg = new TransformGroup(t1);
//        bg.addChild(tg);
        ///
        ColorCube           cube = new ColorCube(0.3f);
        bg.addChild(cube);
        bg.compile();

        su.addBranchGraph(bg);

        su.getViewingPlatform().setNominalViewingTransform();
        setVisible(true);
    }

    public static void main(String[] args) {
        new HelloWorld();
    }
}
