import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TrackPointTest {
    private StandardTrackPoint trackPoint;

    @BeforeEach
    public void setup() {
        trackPoint = new StandardTrackPoint(56.1939430, 10.2117330, 53, "2025-05-09T07:09:23Z");
    }

    @Test
    public void shouldHaveLatitude56dot1939430() {
        assertThat(trackPoint.getLatitude(), is(56.1939430));
    }

    @Test
    public void shouldHaveLongitude10dot2117330() {
        assertThat(trackPoint.getLongitude(), is(10.2117330));
    }

    @Test
    public void shouldHaveElevation53() {
        assertThat(trackPoint.getElevation(), is(53.0));
    }

    @Test
    public void shouldHaveTimestamp070923() {
        assertThat(trackPoint.getTimestamp(), is("07:09:23"));
    }
}
