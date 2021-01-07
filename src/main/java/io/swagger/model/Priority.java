package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Satisfaction;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Priority
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-07T10:48:56.568Z")




public class Priority   {
  @JsonProperty("priorities")
  @Valid
  private List<Satisfaction> priorities = null;

  public Priority priorities(List<Satisfaction> priorities) {
    this.priorities = priorities;
    return this;
  }

  public Priority addPrioritiesItem(Satisfaction prioritiesItem) {
    if (this.priorities == null) {
      this.priorities = new ArrayList<Satisfaction>();
    }
    this.priorities.add(prioritiesItem);
    return this;
  }

  /**
   * Get priorities
   * @return priorities
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Satisfaction> getPriorities() {
    return priorities;
  }

  public void setPriorities(List<Satisfaction> priorities) {
    this.priorities = priorities;
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
    return Objects.equals(this.priorities, priority.priorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priorities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Priority {\n");
    
    sb.append("    priorities: ").append(toIndentedString(priorities)).append("\n");
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

