package file.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Syain {
	@JsonProperty("id")
	public int id;

	// @JsonPropertyの値がJSONの項目になる
	// (nではなくnameになる)
	@JsonProperty("name")
	public String n;

	@JsonProperty("sikaku")
	public List<String> sikaku; // 資格

	@JsonProperty("position")
	public Map<String, String> position;

}