public class VideoProxy implements Video {
    private RealVideo realVideo;
    private String title;

    public VideoProxy(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(title); // Load video only when requested
        }
        realVideo.play();
    }
}
