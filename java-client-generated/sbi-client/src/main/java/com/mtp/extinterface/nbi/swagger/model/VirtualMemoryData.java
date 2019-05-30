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
import java.io.IOException;
import java.math.BigDecimal;

/**
 * The virtual memory of the virtualised compute.
 */
@ApiModel(description = "The virtual memory of the virtualised compute.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-28T11:44:14.596Z")
public class VirtualMemoryData {
  @SerializedName("virtualMemSize")
  private BigDecimal virtualMemSize = null;

  @SerializedName("numaEnabled")
  private Boolean numaEnabled = null;

  @SerializedName("virtualMemOversubscriptionPolicy")
  private String virtualMemOversubscriptionPolicy = null;

  public VirtualMemoryData virtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
    return this;
  }

   /**
   * Amount of virtual memory (e.g. in MB).
   * @return virtualMemSize
  **/
  @ApiModelProperty(required = true, value = "Amount of virtual memory (e.g. in MB).")
  public BigDecimal getVirtualMemSize() {
    return virtualMemSize;
  }

  public void setVirtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
  }

  public VirtualMemoryData numaEnabled(Boolean numaEnabled) {
    this.numaEnabled = numaEnabled;
    return this;
  }

   /**
   * It specifies the memory allocation to be  cognisant of the relevant process/core allocation. The cardinality can be 0 during the allocation request, if no particular value is requested.
   * @return numaEnabled
  **/
  @ApiModelProperty(value = "It specifies the memory allocation to be  cognisant of the relevant process/core allocation. The cardinality can be 0 during the allocation request, if no particular value is requested.")
  public Boolean isNumaEnabled() {
    return numaEnabled;
  }

  public void setNumaEnabled(Boolean numaEnabled) {
    this.numaEnabled = numaEnabled;
  }

  public VirtualMemoryData virtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
    return this;
  }

   /**
   * The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 during the allocation request, if no particular value is requested.
   * @return virtualMemOversubscriptionPolicy
  **/
  @ApiModelProperty(value = "The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 during the allocation request, if no particular value is requested.")
  public String getVirtualMemOversubscriptionPolicy() {
    return virtualMemOversubscriptionPolicy;
  }

  public void setVirtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualMemoryData virtualMemoryData = (VirtualMemoryData) o;
    return Objects.equals(this.virtualMemSize, virtualMemoryData.virtualMemSize) &&
        Objects.equals(this.numaEnabled, virtualMemoryData.numaEnabled) &&
        Objects.equals(this.virtualMemOversubscriptionPolicy, virtualMemoryData.virtualMemOversubscriptionPolicy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(virtualMemSize, numaEnabled, virtualMemOversubscriptionPolicy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualMemoryData {\n");
    
    sb.append("    virtualMemSize: ").append(toIndentedString(virtualMemSize)).append("\n");
    sb.append("    numaEnabled: ").append(toIndentedString(numaEnabled)).append("\n");
    sb.append("    virtualMemOversubscriptionPolicy: ").append(toIndentedString(virtualMemOversubscriptionPolicy)).append("\n");
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
