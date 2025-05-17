import framework.TrackPoint;

public class StandardTrackPoint implements TrackPoint {
    private double latitude;
    private double longitude;
    private double elevation;
    private String timestamp;
    public StandardTrackPoint(double latitude, double longitude, double elevation, String timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.timestamp = timestamp;
    }
    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public double getElevation() {
        return elevation;
    }

    @Override
    public String getTimestamp() {
        return timestamp.substring(11, 19);
    }
}
