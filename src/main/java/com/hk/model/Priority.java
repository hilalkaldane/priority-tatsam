package com.hk.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hilal Kaldane
 */
public class Priority implements Serializable {

	@JsonProperty("priority")
	private Long priority = null;

	@JsonProperty("priorityRating")
	private Long priorityRating = null;

	@JsonProperty("priorityArea")

	private Area priorityArea = null;

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Long getPriorityRating() {
		return priorityRating;
	}

	public void setPriorityRating(Long priorityRating) {
		this.priorityRating = priorityRating;
	}

	public Area getPriorityArea() {
		return priorityArea;
	}

	public void setPriorityArea(Area priorityArea) {
		this.priorityArea = priorityArea;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Priority priority = (Priority) o;
		return Objects.equals(this.priority, priority.priority) &&
				Objects.equals(this.priorityRating, priority.priorityRating) &&
				Objects.equals(this.priorityArea, priority.priorityArea);
	}

	@Override
	public int hashCode() {
		return Objects.hash(priority, priorityRating, priorityArea);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Priority {\n");

		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    priorityRating: ").append(toIndentedString(priorityRating)).append("\n");
		sb.append("    priorityArea: ").append(toIndentedString(priorityArea)).append("\n");
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
