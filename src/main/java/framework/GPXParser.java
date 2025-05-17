package framework;

import java.util.List;

public interface GPXParser {
    List<TrackPoint> readGPXFromPath(String filename);
}
