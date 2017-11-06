package soap;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.UUID;

/**
 * Created by Meyttt on 04.11.2017.
 */
public class UUID_Adapter extends XmlAdapter<String,UUID> {
    @Override
    public UUID unmarshal(String v) throws Exception {
        return UUID.fromString(v);
    }

    @Override
    public String marshal(UUID v) throws Exception {
        return v.toString();
    }
}
