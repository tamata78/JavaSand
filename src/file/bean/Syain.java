package file.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Syain {
	@JsonProperty("id")
	private int id;

	// @JsonPropertyの値がJSONの項目になる
	// (nではなくnameになる)
	@JsonProperty("name")
	private String n;

	@JsonProperty("sikaku")
	private List<String> sikaku; // 資格

	public void setId(int id) {
		this.id = id;
	}

	public void setN(String n) {
		this.n = n;
	}

	public void setSikaku(List<String> sikaku) {
		this.sikaku = sikaku;
	}

}