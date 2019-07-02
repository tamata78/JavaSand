package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

public class JsonUtil {
	final static ObjectMapper mapper = new ObjectMapper().registerModule(new AfterburnerModule());

}
