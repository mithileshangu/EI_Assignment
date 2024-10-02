public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        MobileAppDisplay appDisplay = new MobileAppDisplay("WeatherApp");
        TVDisplay tvDisplay = new TVDisplay("News Channel");

        weatherStation.addObserver(appDisplay);
        weatherStation.addObserver(tvDisplay);

        weatherStation.setTemperature(25.5f);  // Notify observers of temperature change
        weatherStation.setTemperature(30.0f);  // Notify observers of temperature change
    }
}
