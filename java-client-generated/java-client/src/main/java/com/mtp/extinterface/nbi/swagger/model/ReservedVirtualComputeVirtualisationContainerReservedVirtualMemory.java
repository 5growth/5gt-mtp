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
import java.io.IOException;
import java.math.BigDecimal;

/**
 * The virtual memory of the reserved virtualisation container.
 */
@ApiModel(description = "The virtual memory of the reserved virtualisation container.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory {
  @SerializedName("numaEnabled")
  private Boolean numaEnabled = null;

  @SerializedName("virtualMemOversubscriptionPolicy")
  private String virtualMemOversubscriptionPolicy = null;

  @SerializedName("virtualMemSize")
  private BigDecimal virtualMemSize = null;

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory numaEnabled(Boolean numaEnabled) {
    this.numaEnabled = numaEnabled;
    return this;
  }

   /**
   * It specifies the memory allocation to be cognisant of the relevant process/core allocation.
   * @return numaEnabled
  **/
  @ApiModelProperty(required = true, value = "It specifies the memory allocation to be cognisant of the relevant process/core allocation.")
  public Boolean isNumaEnabled() {
    return numaEnabled;
  }

  public void setNumaEnabled(Boolean numaEnabled) {
    this.numaEnabled = numaEnabled;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory virtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
    return this;
  }

   /**
   * The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 if no policy has been defined during the allocation request.
   * @return virtualMemOversubscriptionPolicy
  **/
  @ApiModelProperty(required = true, value = "The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 if no policy has been defined during the allocation request.")
  public String getVirtualMemOversubscriptionPolicy() {
    return virtualMemOversubscriptionPolicy;
  }

  public void setVirtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory virtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
    return this;
  }

   /**
   * Amount of virtual Memory (e.g. in MB).
   * @return virtualMemSize
  **/
  @ApiModelProperty(required = true, value = "Amount of virtual Memory (e.g. in MB).")
  public BigDecimal getVirtualMemSize() {
    return virtualMemSize;
  }

  public void setVirtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory reservedVirtualComputeVirtualisationContainerReservedVirtualMemory = (ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory) o;
    return Objects.equals(this.numaEnabled, reservedVirtualComputeVirtualisationContainerReservedVirtualMemory.numaEnabled) &&
        Objects.equals(this.virtualMemOversubscriptionPolicy, reservedVirtualComputeVirtualisationContainerReservedVirtualMemory.virtualMemOversubscriptionPolicy) &&
        Objects.equals(this.virtualMemSize, reservedVirtualComputeVirtualisationContainerReservedVirtualMemory.virtualMemSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numaEnabled, virtualMemOversubscriptionPolicy, virtualMemSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservedVirtualComputeVirtualisationContainerReservedVirtualMemory {\n");
    
    sb.append("    numaEnabled: ").append(toIndentedString(numaEnabled)).append("\n");
    sb.append("    virtualMemOversubscriptionPolicy: ").append(toIndentedString(virtualMemOversubscriptionPolicy)).append("\n");
    sb.append("    virtualMemSize: ").append(toIndentedString(virtualMemSize)).append("\n");
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

