package com.game.testing.d3;

import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.awt.*;

/**
 * Created by Саша on 05.09.2014.
 */
public class LightDemo extends JFrame {
    public LightDemo(){
        super("Appearance and Light");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        BranchGroup        main = new BranchGroup();
        DirectionalLight light1 = new DirectionalLight(new Color3f(1.0f, 1.0f, 1.0f), new Vector3f(1.0f, 0.0f, -1.0f));
        light1.setInfluencingBounds(new BoundingSphere(new Point3d(0, 0, 0), 10));
        light1.setEnable(true);
        main.addChild(light1);
        AmbientLight     light2 = new AmbientLight(new Color3f(1.0f, 1.0f, 1.0f));
        light2.setInfluencingBounds(new BoundingSphere(new Point3d(), 10));
        light2.setEnable(true);
        main.addChild(light2);
        Sphere           sphere = new Sphere(0.3f);
        Appearance          app = new Appearance();
        Material              m = new Material();
        m.setAmbientColor(new Color3f(1.0f, 0.0f, 0.0f));
        m.setDiffuseColor(new Color3f(0.0f, 1.0f, 0.0f));
        m.setSpecularColor(new Color3f(0.0f, 0.0f, 1.0f));
        app.setMaterial(m);
        sphere.setAppearance(app);
        main.addChild(sphere);
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D          canvas = new Canvas3D(gc);
        SimpleUniverse        su = new SimpleUniverse(canvas);
        su.getViewingPlatform().setNominalViewingTransform();
        su.addBranchGraph(main);
        add(canvas, BorderLayout.CENTER);
        setSize(640, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LightDemo();
    }
}
