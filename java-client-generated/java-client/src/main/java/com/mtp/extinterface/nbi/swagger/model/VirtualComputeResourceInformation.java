/*
 * MTP Manager API
 * MTP Manager API
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mtp.extinterface.nbi.swagger.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeResourceInformationVirtualCPU;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeResourceInformationVirtualMemory;
import java.io.IOException;

/**
 * VirtualComputeResourceInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class VirtualComputeResourceInformation {
  @SerializedName("accelerationCapability")
  private String accelerationCapability = null;

  @SerializedName("computeResourceTypeId")
  private String computeResourceTypeId = null;

  @SerializedName("virtualCPU")
  private VirtualComputeResourceInformationVirtualCPU virtualCPU = null;

  @SerializedName("virtualMemory")
  private VirtualComputeResourceInformationVirtualMemory virtualMemory = null;

  public VirtualComputeResourceInformation accelerationCapability(String accelerationCapability) {
    this.accelerationCapability = accelerationCapability;
    return this;
  }

   /**
   * Acceleration capabilities (e.g. crypto, GPU) for the consumable virtualised compute resources from the set of capabilities offered by the compute node acceleration resources. The cardinality can be 0, if no particular acceleration capability is provided.
   * @return accelerationCapability
  **/
  @ApiModelProperty(required = true, value = "Acceleration capabilities (e.g. crypto, GPU) for the consumable virtualised compute resources from the set of capabilities offered by the compute node acceleration resources. The cardinality can be 0, if no particular acceleration capability is provided.")
  public String getAccelerationCapability() {
    return accelerationCapability;
  }

  public void setAccelerationCapability(String accelerationCapability) {
    this.accelerationCapability = accelerationCapability;
  }

  public VirtualComputeResourceInformation computeResourceTypeId(String computeResourceTypeId) {
    this.computeResourceTypeId = computeResourceTypeId;
    return this;
  }

   /**
   * Identifier of the consumable virtualised compute resource type.
   * @return computeResourceTypeId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the consumable virtualised compute resource type.")
  public String getComputeResourceTypeId() {
    return computeResourceTypeId;
  }

  public void setComputeResourceTypeId(String computeResourceTypeId) {
    this.computeResourceTypeId = computeResourceTypeId;
  }

  public VirtualComputeResourceInformation virtualCPU(VirtualComputeResourceInformationVirtualCPU virtualCPU) {
    this.virtualCPU = virtualCPU;
    return this;
  }

   /**
   * Get virtualCPU
   * @return virtualCPU
  **/
  @ApiModelProperty(required = true, value = "")
  public VirtualComputeResourceInformationVirtualCPU getVirtualCPU() {
    return virtualCPU;
  }

  public void setVirtualCPU(VirtualComputeResourceInformationVirtualCPU virtualCPU) {
    this.virtualCPU = virtualCPU;
  }

  public VirtualComputeResourceInformation virtualMemory(VirtualComputeResourceInformationVirtualMemory virtualMemory) {
    this.virtualMemory = virtualMemory;
    return this;
  }

   /**
   * Get virtualMemory
   * @return virtualMemory
  **/
  @ApiModelProperty(required = true, value = "")
  public VirtualComputeResourceInformationVirtualMemory getVirtualMemory() {
    return virtualMemory;
  }

  public void setVirtualMemory(VirtualComputeResourceInformationVirtualMemory virtualMemory) {
    this.virtualMemory = virtualMemory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualComputeResourceInformation virtualComputeResourceInformation = (VirtualComputeResourceInformation) o;
    return Objects.equals(this.accelerationCapability, virtualComputeResourceInformation.accelerationCapability) &&
        Objects.equals(this.computeResourceTypeId, virtualComputeResourceInformation.computeResourceTypeId) &&
        Objects.equals(this.virtualCPU, virtualComputeResourceInformation.virtualCPU) &&
        Objects.equals(this.virtualMemory, virtualComputeResourceInformation.virtualMemory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accelerationCapability, computeResourceTypeId, virtualCPU, virtualMemory);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualComputeResourceInformation {\n");
    
    sb.append("    accelerationCapability: ").append(toIndentedString(accelerationCapability)).append("\n");
    sb.append("    computeResourceTypeId: ").append(toIndentedString(computeResourceTypeId)).append("\n");
    sb.append("    virtualCPU: ").append(toIndentedString(virtualCPU)).append("\n");
    sb.append("    virtualMemory: ").append(toIndentedString(virtualMemory)).append("\n");
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
