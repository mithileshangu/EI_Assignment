public class TVShow implements Content {
    private String title;

    public TVShow(String title) {
        this.title = title;
    }

    @Override
    public void stream(StreamingDevice device) {
        System.out.println("Streaming TV Show: " + title + " on " + device.getDeviceName());
    }
}
