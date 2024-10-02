public class Main {
    public static void main(String[] args) {
        // Creating content instances
        Content movie = new Movie("Inception");
        Content tvShow = new TVShow("Breaking Bad");

        // Creating device instances
        StreamingDevice smartTV = new SmartTV();
        StreamingDevice mobileApp = new MobileApp();

        // Streaming content on different devices
        movie.stream(smartTV);     // Output: Streaming Movie: Inception on Smart TV
        movie.stream(mobileApp);   // Output: Streaming Movie: Inception on Mobile App

        tvShow.stream(smartTV);    // Output: Streaming TV Show: Breaking Bad on Smart TV
        tvShow.stream(mobileApp);  // Output: Streaming TV Show: Breaking Bad on Mobile App
    }
}
