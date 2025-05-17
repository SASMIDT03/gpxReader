import framework.GPXParser;
import framework.TrackPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GPXParserTest {
   private GPXParser gpxParser;

   @BeforeEach
   public void setup() {
       gpxParser = new StandardGPXParser();
   }

   @Test
   public void shouldOpenFile50kRun() {
       gpxParser.readGPXFromPath("50kRun.gpx");
   }

   @Test
   public void shouldHaveLatitude56dot1939430ForFirstTrackPointForTestGPXFile() {
       List<TrackPoint> trackPoints = gpxParser.readGPXFromPath("testGPXfile.gpx");
       assertThat(trackPoints.get(0).getLatitude(), is(56.1939430));
   }

   @Test
   public void shouldHaveLongitude10dot2117330ForFirstTrackPointForTestGPXFile() {
       List<TrackPoint> trackPoints = gpxParser.readGPXFromPath("testGPXfile.gpx");
       assertThat(trackPoints.get(0).getLongitude(), is(10.2117330));
   }

   @Test
   public void shouldHaveElevation53ForFirstTrackPointForTestGPXFile() {
       List<TrackPoint> trackPoints = gpxParser.readGPXFromPath("testGPXfile.gpx");
       assertThat(trackPoints.get(0).getElevation(), is(53.0));
   }

   @Test
   public void shouldHaveTimestap070923ForFirstTrackPointForTestGPXFile() {
       List<TrackPoint> trackPoints = gpxParser.readGPXFromPath("testGPXfile.gpx");
       assertThat(trackPoints.get(0).getTimestamp(), is("07:09:23"));
   }

}
