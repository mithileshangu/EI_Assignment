public class RealVideo implements Video {
    private String title;

    public RealVideo(String title) {
        this.title = title;
        loadVideo();
    }

    private void loadVideo() {
        System.out.println("Loading video: " + title);
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + title);
    }
}
