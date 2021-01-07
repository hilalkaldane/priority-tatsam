package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Area;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Satisfaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-07T10:48:56.568Z")




public class Satisfaction   {
  @JsonProperty("priority")
  private Long priority = null;

  @JsonProperty("priorityRating")
  private Long priorityRating = null;

  @JsonProperty("priorityArea")
  private Area priorityArea = null;

  public Satisfaction priority(Long priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getPriority() {
    return priority;
  }

  public void setPriority(Long priority) {
    this.priority = priority;
  }

  public Satisfaction priorityRating(Long priorityRating) {
    this.priorityRating = priorityRating;
    return this;
  }

  /**
   * Get priorityRating
   * @return priorityRating
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getPriorityRating() {
    return priorityRating;
  }

  public void setPriorityRating(Long priorityRating) {
    this.priorityRating = priorityRating;
  }

  public Satisfaction priorityArea(Area priorityArea) {
    this.priorityArea = priorityArea;
    return this;
  }

  /**
   * Get priorityArea
   * @return priorityArea
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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
    Satisfaction satisfaction = (Satisfaction) o;
    return Objects.equals(this.priority, satisfaction.priority) &&
        Objects.equals(this.priorityRating, satisfaction.priorityRating) &&
        Objects.equals(this.priorityArea, satisfaction.priorityArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, priorityRating, priorityArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Satisfaction {\n");
    
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

