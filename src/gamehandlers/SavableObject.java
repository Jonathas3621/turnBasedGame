package gamehandlers;

import org.json.*;

public interface SavableObject {
    public JSONObject getSaveJson();
    public String getSaveFileName();
    public String getAddress();
    public String className();
    public String getNome();
}
