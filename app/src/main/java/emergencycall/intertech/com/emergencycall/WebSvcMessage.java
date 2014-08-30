package emergencycall.intertech.com.emergencycall;

import android.location.Location;

import org.json.*;

/**
 * Created by justin on 30/08/14.
 */
public class WebSvcMessage extends JSONObject {

    public static String uniqID = ""; //TODO: ID

    private static JSONArray convertLocation(Location location) throws JSONException {
        JSONArray ar = new JSONArray();

        ar.put(Location.convert(location.getLatitude(), Location.FORMAT_DEGREES));
        ar.put(Location.convert(location.getLongitude(), Location.FORMAT_DEGREES));

        return ar;
    }

    private static JSONArray arrayJSONify(Object[] destinations) throws JSONException {
        JSONArray ar = new JSONArray();

        for(Object destination : destinations)
            ar.put(destination);

        return ar;
    }

    public WebSvcMessage(Configuration.Mode mode, Location location, String[] destinations) throws JSONException {
        super();

        put("mode", mode.name().toLowerCase());
        put("uniqID", uniqID);
        put("gpsCoords", convertLocation(location));
        put("numbersToCall", arrayJSONify(destinations));
    }
}
