# FaceDetection
Simple project which uses [OpenCV](http://opencv.org/) with its [Java bindings](http://docs.opencv.org/doc/tutorials/introduction/desktop_java/java_dev_intro.html) to detect faces on a photo.

# Installation
Clone this repository, and copy a photo with faces in `src/main/resources/test.JPG`.

# Troubleshoots
Using OpenJDK 7, there can be a segfault of the JVM when trying to open the JPG file. Use Oracle JDK instead and you will be good.