import framework.GPXParser;

import framework.TrackPoint;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StandardGPXParser implements GPXParser {

    private Namespace namespace = Namespace.getNamespace("http://www.topografix.com/GPX/1/1");
    private List<TrackPoint> trackPoints = new ArrayList<>();

    @Override
    public List<TrackPoint> readGPXFromPath(String filename) {
        try {
            File gpxFile = new File("gpx files/"+filename);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(gpxFile);

            Element rootElement = document.getRootElement();
            Element trk = rootElement.getChild("trk", namespace);
            Element trkseg = trk.getChild("trkseg", namespace);

            for (Element element : trkseg.getChildren()) {
                trackPoints.add(new StandardTrackPoint(
                        Double.parseDouble(element.getAttributeValue("lat")),
                        Double.parseDouble(element.getAttributeValue("lon")),
                        Double.parseDouble(element.getChildText("ele", namespace)),
                        element.getChildText("time", namespace)
                ));
            }

        } catch (JDOMException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return trackPoints;
    }
}
