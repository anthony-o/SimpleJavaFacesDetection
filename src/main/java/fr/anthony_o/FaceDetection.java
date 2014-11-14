package fr.anthony_o;

import org.apache.commons.io.IOUtils;
import org.bytedeco.javacpp.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FaceDetection {

    public static void main(String[] args) throws IOException {
        // First detect faces
        File frontalFaceXml = extractResource("/haarcascade_frontalface_default.xml");
        File photo = extractResource("/test.JPG");
        String photoPath = photo.getPath();
        opencv_objdetect.CascadeClassifier faceCascade = new opencv_objdetect.CascadeClassifier(frontalFaceXml.getAbsolutePath());
        opencv_core.Mat img = opencv_highgui.imread(photoPath);
        opencv_core.Mat grayImg = new opencv_core.Mat();
        opencv_imgproc.cvtColor(img, grayImg, opencv_imgproc.COLOR_BGR2GRAY);
        final opencv_core.Rect faces = new opencv_core.Rect();
        faceCascade.detectMultiScale(grayImg, faces, 1.3, 5, 0, new opencv_core.Size(), new opencv_core.Size());

        // Display the photo & faces
        JFrame frame = createJFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (int i = 0; i < faces.limit(); i++) {
                    opencv_core.Rect face = faces.position(i);
                    g.drawRect(face.x(), face.y(), face.width(), face.height());
                }
            }
        };
        frame.add(panel, BorderLayout.CENTER);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(photoPath));
        panel.add(label);

        frame.setSize(label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        frame.setVisible(true);
    }

    private static File extractResource(String resourceName) throws IOException {
        File frontalFaceXml = File.createTempFile(FaceDetection.class.getSimpleName(), ".xml");
        frontalFaceXml.deleteOnExit();
        IOUtils.copy(FaceDetection.class.getResourceAsStream(resourceName), new FileOutputStream(frontalFaceXml));
        return frontalFaceXml;
    }

    private static JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        //frame.setSize(800, 800);
        //frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

}
