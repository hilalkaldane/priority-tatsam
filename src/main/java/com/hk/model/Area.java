package com.hk.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hilal Kaldane
 */
public class Area implements Serializable {
	@JsonProperty("areaId")
	private Long areaId = null;

	@JsonProperty("areaName")
	private String areaName = null;

	public Area areaId(Long areaId) {
		this.areaId = areaId;
		return this;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Area areaName(String areaName) {
		this.areaName = areaName;
		return this;
	}

	/**
	 * Get areaName
	 * @return areaName
	 **/

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Area area = (Area) o;
		return Objects.equals(this.areaId, area.areaId) &&
				Objects.equals(this.areaName, area.areaName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaId, areaName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Area {\n");

		sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
		sb.append("    areaName: ").append(toIndentedString(areaName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
