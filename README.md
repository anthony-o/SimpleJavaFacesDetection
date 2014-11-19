# FaceDetection
Simple project which uses [OpenCV](http://opencv.org/) with its [Java bindings](http://docs.opencv.org/doc/tutorials/introduction/desktop_java/java_dev_intro.html) to detect faces on a photo.

# Installation
 1. Clone this repository, and copy a photo with faces in `src/main/resources/test.JPG`.
 2. Unzip the content of [`opencv-2.4.9-0.9-<your_OS>-<your_architecture>.jar`](http://search.maven.org/#artifactdetails%7Corg.bytedeco.javacpp-presets%7Copencv%7C2.4.9-0.9%7Cjar) and put the content of `org/bytedeco/javacpp/<your_OS>-<your_architecture>` in your a folder of your `$PATH` environment variable.

# Troubleshoots
Using OpenJDK 7, there can be a segfault of the JVM when trying to open the JPG file. Use Oracle JDK instead and you will be good.
