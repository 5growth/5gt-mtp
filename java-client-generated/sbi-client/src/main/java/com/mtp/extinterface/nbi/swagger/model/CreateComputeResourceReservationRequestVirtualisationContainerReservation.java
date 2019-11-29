/*
 * MTP Manager API
 * MTP Manager API
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mtp.extinterface.nbi.swagger.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavour;
import java.io.IOException;

/**
 * CreateComputeResourceReservationRequestVirtualisationContainerReservation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class CreateComputeResourceReservationRequestVirtualisationContainerReservation {
  @SerializedName("containerFlavour")
  private CreateComputeResourceReservationRequestContainerFlavour containerFlavour = null;

  @SerializedName("containerId")
  private String containerId = null;

  public CreateComputeResourceReservationRequestVirtualisationContainerReservation containerFlavour(CreateComputeResourceReservationRequestContainerFlavour containerFlavour) {
    this.containerFlavour = containerFlavour;
    return this;
  }

   /**
   * Get containerFlavour
   * @return containerFlavour
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateComputeResourceReservationRequestContainerFlavour getContainerFlavour() {
    return containerFlavour;
  }

  public void setContainerFlavour(CreateComputeResourceReservationRequestContainerFlavour containerFlavour) {
    this.containerFlavour = containerFlavour;
  }

  public CreateComputeResourceReservationRequestVirtualisationContainerReservation containerId(String containerId) {
    this.containerId = containerId;
    return this;
  }

   /**
   * The identifier of the virtualisation container to be reserved.
   * @return containerId
  **/
  @ApiModelProperty(required = true, value = "The identifier of the virtualisation container to be reserved.")
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateComputeResourceReservationRequestVirtualisationContainerReservation createComputeResourceReservationRequestVirtualisationContainerReservation = (CreateComputeResourceReservationRequestVirtualisationContainerReservation) o;
    return Objects.equals(this.containerFlavour, createComputeResourceReservationRequestVirtualisationContainerReservation.containerFlavour) &&
        Objects.equals(this.containerId, createComputeResourceReservationRequestVirtualisationContainerReservation.containerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerFlavour, containerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateComputeResourceReservationRequestVirtualisationContainerReservation {\n");
    
    sb.append("    containerFlavour: ").append(toIndentedString(containerFlavour)).append("\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
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

