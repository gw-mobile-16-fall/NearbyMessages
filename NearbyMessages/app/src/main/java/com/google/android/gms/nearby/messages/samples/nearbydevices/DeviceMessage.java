package com.google.android.gms.nearby.messages.samples.nearbydevices;
import com.google.android.gms.nearby.messages.Message;
import com.google.gson.Gson;

import java.nio.charset.Charset;

/**
 * Used to prepare the payload for a Nearby Message
 */
public class DeviceMessage {
    private static final Gson gson = new Gson();

    private final String mUUID;
    private final String mMessageBody;

    /**
     * Builds a new object using a unique identifier.
     */
    public static Message newNearbyMessage(String instanceId) {
        DeviceMessage deviceMessage = new DeviceMessage(instanceId);
        return new Message(gson.toJson(deviceMessage).getBytes(Charset.forName("UTF-8")));
    }

    /*Creates a object from the string used to construct the payload
     */
    public static DeviceMessage fromNearbyMessage(Message message) {
        String nearbyMessageString = new String(message.getContent()).trim();
        return gson.fromJson(
                (new String(nearbyMessageString.getBytes(Charset.forName("UTF-8")))),
                DeviceMessage.class);
    }

    private DeviceMessage(String uuid) {
        mUUID = uuid;
        mMessageBody = "Hi! This is Device 1.";
        // TODO(developer): add other fields that must be included in the Nearby Message payload.
    }

    protected String getMessageBody() {
        return mMessageBody;
    }
}