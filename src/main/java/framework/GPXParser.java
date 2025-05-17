package framework;

import java.util.List;

public interface GPXParser {
    /*
     * Parse the gpx-file into a list of TrackPoints
     * @params The filename of the gpx-file including the file extension .gpx
     * @return A list of TrackPoints
     */
    List<TrackPoint> readGPXFromPath(String filename);
}
