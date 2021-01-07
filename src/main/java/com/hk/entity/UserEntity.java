package com.hk.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Hilal Kaldane
 */

/**
 * This Entity is created so as to keep track of Priorities User-wise.
 * Since one user can create priority only once , hence this entity is made parent of all other entities
 * This gives functionality to save all the objects in one save call.
 */
@Entity
public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId = null;

	@JsonProperty("priorities")
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<PriorityEntity> priorityList = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<PriorityEntity> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List<PriorityEntity> priorityList) {
		this.priorityList = priorityList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserEntity user = (UserEntity) o;
		return Objects.equals(this.priorityList, user.priorityList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(priorityList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Priority {\n");

		sb.append("    priorities: ").append(toIndentedString(priorityList)).append("\n");
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
