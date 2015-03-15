//package com.game.testing.d3.pilone;
//
///*
//Essential Java 3D Fast
//
//Ian Palmer
//
//Publisher: Springer-Verlag
//
//ISBN: 1-85233-394-4
//
//http://www.java2s.com/Code/Java/3D/SphereSample.htm
//http://www.java2s.com/Code/Java/3D/AredsphereusingtheSphereutilityclass.htm
//(Java 3D Tutorial- How to make a 3D Shape (Sphere/ball) Swing GUI) http://www.youtube.com/watch?v=pW5pPHQ-tYk
//
//(tank game made in java code)
//http://www.youtube.com/watch?v=ZV4Dsandc6w
//http://www.ehow.com/how_4578745_programming-d-games-java.html
//http://www.gosur.com/map/?gclid=CKru4M-e5MACFeHPcgodchAAZw
//*/
//
//import com.sun.j3d.utils.geometry.Sphere;
//
//import javax.media.j3d.*;
//import javax.vecmath.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * This builds a red sphere using the Sphere utility class and adds lights so
// * that you can see it shape. It creates a material for the sphere, creates an
// * ambient light and a one directional light.
// *
// * @author I.J.Palmer
// * @version 1.0
// */
//public class SimpleSphere extends Frame implements ActionListener {
//    protected Canvas3D myCanvas3D = new Canvas3D(null);
//
//    protected Button myButton = new Button("Exit");
//
//    /**
//     * This function builds the view branch of the scene graph. It creates a
//     * branch group and then creates the necessary view elements to give a
//     * useful view of our content.
//     *
//     * @param c
//     *            Canvas3D that will display the view
//     * @return BranchGroup that is the root of the view elements
//     */
//    protected BranchGroup buildViewBranch(Canvas3D c) {
//        BranchGroup viewBranch = new BranchGroup();
//        Transform3D viewXfm = new Transform3D();
//        viewXfm.set(new Vector3f(0.0f, 0.0f, 10.0f));
//        TransformGroup viewXfmGroup = new TransformGroup(viewXfm);
//        ViewPlatform myViewPlatform = new ViewPlatform();
//        PhysicalBody myBody = new PhysicalBody();
//        PhysicalEnvironment myEnvironment = new PhysicalEnvironment();
//        viewXfmGroup.addChild(myViewPlatform);
//        viewBranch.addChild(viewXfmGroup);
//        View myView = new View();
//        myView.addCanvas3D(c);
//        myView.attachViewPlatform(myViewPlatform);
//        myView.setPhysicalBody(myBody);
//        myView.setPhysicalEnvironment(myEnvironment);
//        return viewBranch;
//    }
//
//    protected void addLights(BranchGroup b) {
//        // Create a bounds for the lights
//        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
//                100.0);
//        // Set up the global lights
//        Color3f lightColour1 = new Color3f(1.0f, 1.0f, 1.0f);
//        Vector3f lightDir1 = new Vector3f(-1.0f, -1.0f, -1.0f);
//        Color3f lightColour2 = new Color3f(1.0f, 1.0f, 1.0f);
//        Point3f lightPosition2 = new Point3f(3.0f, 3.0f, 3.0f);
//        Point3f lightAtten2 = new Point3f(0.0f, 0.0f, 1.0f);
//        Vector3f lightDir2 = new Vector3f(-1.0f, -1.0f, -1.0f);
//        Color3f ambientColour = new Color3f(0.2f, 0.2f, 0.2f);
//        AmbientLight ambientLight1 = new AmbientLight(ambientColour);
//        ambientLight1.setInfluencingBounds(bounds);
//        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
//        light1.setInfluencingBounds(bounds);
//        PointLight light2 = new PointLight(lightColour2, lightPosition2,
//                lightAtten2);
//        light2.setInfluencingBounds(bounds);
//        b.addChild(ambientLight1);
//        b.addChild(light1);
//        //b.addChild(light2);
//    }
//
//    protected BranchGroup buildContentBranch() {
//        BranchGroup contentBranch = new BranchGroup();
//        Transform3D rotateCube = new Transform3D();
//        rotateCube.set(new AxisAngle4d(1.0, 1.0, 0.0, Math.PI / 4.0));
//        //                rotateCube.set(new AxisAngle4d(1.0,0.0,0.0,Math.PI/2.0));
//        TransformGroup rotationGroup = new TransformGroup(rotateCube);
//        contentBranch.addChild(rotationGroup);
//        Appearance app = new Appearance();
//        Color3f ambientColour = new Color3f(1.0f, 0.0f, 0.0f);
//        Color3f diffuseColour = new Color3f(1.0f, 0.0f, 0.0f);
//        Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
//        Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
//        float shininess = 20.0f;
//        app.setMaterial(new Material(ambientColour, emissiveColour,
//                diffuseColour, specularColour, shininess));
//        rotationGroup.addChild(new Sphere(2.0f, Sphere.GENERATE_NORMALS, 120,
//                app));
//        addLights(contentBranch);
//        return contentBranch;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        dispose();
//        System.exit(0);
//    }
//
//    public SimpleSphere() {
//        VirtualUniverse myUniverse = new VirtualUniverse();
//        Locale myLocale = new Locale(myUniverse);
//        myLocale.addBranchGraph(buildViewBranch(myCanvas3D));
//        myLocale.addBranchGraph(buildContentBranch());
//        setTitle("SimpleWorld");
//        setSize(400, 400);
//        setLayout(new BorderLayout());
//        add("Center", myCanvas3D);
//        add("South", myButton);
//        myButton.addActionListener(this);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SimpleSphere sw = new SimpleSphere();
//    }
//}
//
