package com.game.testing.d3.pilone;import com.sun.j3d.utils.behaviors.mouse.MouseRotate;import com.sun.j3d.utils.geometry.ColorCube;import com.sun.j3d.utils.universe.SimpleUniverse;import javax.media.j3d.*;import javax.swing.*;import javax.vecmath.Point3d;import javax.vecmath.Vector3d;import java.awt.*;public class BehaviorDemo {  public static void main(String[] args) {    new BehaviorDemo();  }    public BehaviorDemo() {        // Create the canvas to draw in, and initialize our SimpleUniverse    mCanvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());    mUniverse = new SimpleUniverse(mCanvas);        // Create a transform group to move the cube 50 meters along the Z axis    Transform3D transform = new Transform3D();    transform.set(new Vector3d(0.0, 0.0, -50.0));    TransformGroup translationGroup = new TransformGroup(transform);        // Create a transform group to rotate 20 degrees around X    Transform3D rotXTransform = new Transform3D();    rotXTransform.rotX(Math.toRadians(20.0));        // Create a transform to rotate 20 degrees around Y    Transform3D rotYTransform = new Transform3D();    rotYTransform.rotY(Math.toRadians(20.0));        // Combine the rotations into one transform then make a TransformGroup    Transform3D rotationTransform = new Transform3D(rotXTransform);    rotationTransform.mul(rotYTransform);    TransformGroup rotationGroup = new TransformGroup(rotationTransform);        // Attach the rotation group to the translation group.  (Do the    // rotation after the translation)    translationGroup.addChild(rotationGroup);        // Add a new Color Cube after the rotation    ColorCube cube = new ColorCube(5);    rotationGroup.addChild(cube);        // Put all of this in a BranchGroup and add it to the scenegraph    BranchGroup branchGroup = new BranchGroup();    branchGroup.addChild(translationGroup);        // Create a MouseRotate Behavior    rotationGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);    rotationGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);        MouseRotate mouseRotate = new MouseRotate(rotationGroup);    mouseRotate.setSchedulingBounds(new BoundingSphere(new Point3d(0, 0, 0), Double.MAX_VALUE));    branchGroup.addChild(mouseRotate);        branchGroup.compile();    mUniverse.addBranchGraph(branchGroup);        // Create a frame to display it and set the canvas as the center component    JFrame frame = new JFrame();    frame.setTitle("Behavior Demo");    frame.getContentPane().add(mUniverse.getCanvas(), BorderLayout.CENTER);    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    frame.setSize(300, 200);    frame.show();  }      private SimpleUniverse mUniverse;  private Canvas3D mCanvas;}