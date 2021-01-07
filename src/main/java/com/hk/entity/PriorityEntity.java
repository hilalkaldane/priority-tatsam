package com.hk.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hilal Kaldane
 */

/**
 * Unique constraints on columns user_id and area_id to prevent user
 * from adding multiple areas more than one
 */
@Table(
		uniqueConstraints =
		@UniqueConstraint(columnNames = { "user_id", "area_id" })
)
@Entity
public class PriorityEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * This is the actual priority users will be assigning to their priority area.
	 */
	@JsonProperty("priority")
	private Long priority = null;

	/**
	 * This is the satisfaction rating users will be providing for each priority area.
	 * It should range between 1-5
	 */
	@JsonProperty("priorityRating")
	private Long priorityRating = null;

	/**
	 * JoinColumn is used to avoid creation of extra table for mapping.
	 */
	@JsonProperty("priorityArea")
	@OneToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity priorityArea = null;

	/**
	 * JoinColumn is used to avoid creation of extra table for mapping.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private UserEntity userId;


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

	public AreaEntity getPriorityArea() {
		return priorityArea;
	}

	public void setPriorityArea(AreaEntity priorityArea) {
		this.priorityArea = priorityArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
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
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
