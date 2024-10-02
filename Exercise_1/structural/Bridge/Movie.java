public class Movie implements Content {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public void stream(StreamingDevice device) {
        System.out.println("Streaming Movie: " + title + " on " + device.getDeviceName());
    }
}
