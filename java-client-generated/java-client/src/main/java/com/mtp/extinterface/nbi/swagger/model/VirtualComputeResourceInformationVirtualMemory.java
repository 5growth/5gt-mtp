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
 * It defines the virtual memory characteristics of the consumable virtualised compute resource.
 */
@ApiModel(description = "It defines the virtual memory characteristics of the consumable virtualised compute resource.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class VirtualComputeResourceInformationVirtualMemory {
  @SerializedName("numaSupported")
  private Boolean numaSupported = null;

  @SerializedName("virtualMemOversubscriptionPolicy")
  private String virtualMemOversubscriptionPolicy = null;

  @SerializedName("virtualMemSize")
  private BigDecimal virtualMemSize = null;

  public VirtualComputeResourceInformationVirtualMemory numaSupported(Boolean numaSupported) {
    this.numaSupported = numaSupported;
    return this;
  }

   /**
   * It specifies if the memory allocation can be cognisant of the relevant process/core allocation.
   * @return numaSupported
  **/
  @ApiModelProperty(required = true, value = "It specifies if the memory allocation can be cognisant of the relevant process/core allocation.")
  public Boolean isNumaSupported() {
    return numaSupported;
  }

  public void setNumaSupported(Boolean numaSupported) {
    this.numaSupported = numaSupported;
  }

  public VirtualComputeResourceInformationVirtualMemory virtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
    return this;
  }

   /**
   * The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 if no concrete policy is defined.
   * @return virtualMemOversubscriptionPolicy
  **/
  @ApiModelProperty(required = true, value = "The memory core oversubscription policy in terms of virtual memory to physical memory on the platform. The cardinality can be 0 if no concrete policy is defined.")
  public String getVirtualMemOversubscriptionPolicy() {
    return virtualMemOversubscriptionPolicy;
  }

  public void setVirtualMemOversubscriptionPolicy(String virtualMemOversubscriptionPolicy) {
    this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
  }

  public VirtualComputeResourceInformationVirtualMemory virtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
    return this;
  }

   /**
   * Amount of virtual memory (e.g. in MB). Cardinality \&quot;1\&quot; covers the case where a specific configuration for the consumable resource is advertised.
   * @return virtualMemSize
  **/
  @ApiModelProperty(required = true, value = "Amount of virtual memory (e.g. in MB). Cardinality \"1\" covers the case where a specific configuration for the consumable resource is advertised.")
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
    VirtualComputeResourceInformationVirtualMemory virtualComputeResourceInformationVirtualMemory = (VirtualComputeResourceInformationVirtualMemory) o;
    return Objects.equals(this.numaSupported, virtualComputeResourceInformationVirtualMemory.numaSupported) &&
        Objects.equals(this.virtualMemOversubscriptionPolicy, virtualComputeResourceInformationVirtualMemory.virtualMemOversubscriptionPolicy) &&
        Objects.equals(this.virtualMemSize, virtualComputeResourceInformationVirtualMemory.virtualMemSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numaSupported, virtualMemOversubscriptionPolicy, virtualMemSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualComputeResourceInformationVirtualMemory {\n");
    
    sb.append("    numaSupported: ").append(toIndentedString(numaSupported)).append("\n");
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

