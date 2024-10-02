public class Main {
    public static void main(String[] args) {
        Video video1 = new VideoProxy("Inception");
        Video video2 = new VideoProxy("The Matrix");

        // Video is not loaded until it's played
        video1.play();  // Output: Loading video: Inception \n Playing video: Inception
        video2.play();  // Output: Loading video: The Matrix \n Playing video: The Matrix

        // Playing the same video again
        video1.play();  // Output: Playing video: Inception (no loading)
    }
}
