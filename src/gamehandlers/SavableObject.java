package gamehandlers;

import org.json.*;

public interface SavableObject extends HasSaveJson {
    public String getSaveFileName();
    public String getAddress();
    public String className();
    public String getNome();
}
