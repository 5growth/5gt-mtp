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
import com.mtp.extinterface.nbi.swagger.model.ReservedVirtualComputeComputePoolReservedComputeAttributes;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Information about compute resources that have been reserved, e.g. {\&quot;cpu_cores\&quot;: 90, \&quot;vm_instances\&quot;: 10, \&quot;ram\&quot;: 10000}
 */
@ApiModel(description = "Information about compute resources that have been reserved, e.g. {\"cpu_cores\": 90, \"vm_instances\": 10, \"ram\": 10000}")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-28T11:44:14.596Z")
public class ReservedVirtualComputeComputePoolReserved {
  @SerializedName("computeAttributes")
  private ReservedVirtualComputeComputePoolReservedComputeAttributes computeAttributes = null;

  @SerializedName("numCpuCores")
  private Integer numCpuCores = null;

  @SerializedName("numVcInstances")
  private Integer numVcInstances = null;

  @SerializedName("virtualMemSize")
  private BigDecimal virtualMemSize = null;

  @SerializedName("zoneId")
  private String zoneId = null;

  public ReservedVirtualComputeComputePoolReserved computeAttributes(ReservedVirtualComputeComputePoolReservedComputeAttributes computeAttributes) {
    this.computeAttributes = computeAttributes;
    return this;
  }

   /**
   * Get computeAttributes
   * @return computeAttributes
  **/
  @ApiModelProperty(required = true, value = "")
  public ReservedVirtualComputeComputePoolReservedComputeAttributes getComputeAttributes() {
    return computeAttributes;
  }

  public void setComputeAttributes(ReservedVirtualComputeComputePoolReservedComputeAttributes computeAttributes) {
    this.computeAttributes = computeAttributes;
  }

  public ReservedVirtualComputeComputePoolReserved numCpuCores(Integer numCpuCores) {
    this.numCpuCores = numCpuCores;
    return this;
  }

   /**
   * Number of CPU cores that have been reserved.
   * @return numCpuCores
  **/
  @ApiModelProperty(required = true, value = "Number of CPU cores that have been reserved.")
  public Integer getNumCpuCores() {
    return numCpuCores;
  }

  public void setNumCpuCores(Integer numCpuCores) {
    this.numCpuCores = numCpuCores;
  }

  public ReservedVirtualComputeComputePoolReserved numVcInstances(Integer numVcInstances) {
    this.numVcInstances = numVcInstances;
    return this;
  }

   /**
   * Number of virtual container instances that have been reserved.
   * @return numVcInstances
  **/
  @ApiModelProperty(required = true, value = "Number of virtual container instances that have been reserved.")
  public Integer getNumVcInstances() {
    return numVcInstances;
  }

  public void setNumVcInstances(Integer numVcInstances) {
    this.numVcInstances = numVcInstances;
  }

  public ReservedVirtualComputeComputePoolReserved virtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
    return this;
  }

   /**
   * Size of virtual memory that has been reserved.
   * @return virtualMemSize
  **/
  @ApiModelProperty(required = true, value = "Size of virtual memory that has been reserved.")
  public BigDecimal getVirtualMemSize() {
    return virtualMemSize;
  }

  public void setVirtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
  }

  public ReservedVirtualComputeComputePoolReserved zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * References the resource zone where the virtual compute resources have been reserved. Cardinality can be 0 to cover the case where reserved compute resources are not bound to a specific resource zone.
   * @return zoneId
  **/
  @ApiModelProperty(required = true, value = "References the resource zone where the virtual compute resources have been reserved. Cardinality can be 0 to cover the case where reserved compute resources are not bound to a specific resource zone.")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservedVirtualComputeComputePoolReserved reservedVirtualComputeComputePoolReserved = (ReservedVirtualComputeComputePoolReserved) o;
    return Objects.equals(this.computeAttributes, reservedVirtualComputeComputePoolReserved.computeAttributes) &&
        Objects.equals(this.numCpuCores, reservedVirtualComputeComputePoolReserved.numCpuCores) &&
        Objects.equals(this.numVcInstances, reservedVirtualComputeComputePoolReserved.numVcInstances) &&
        Objects.equals(this.virtualMemSize, reservedVirtualComputeComputePoolReserved.virtualMemSize) &&
        Objects.equals(this.zoneId, reservedVirtualComputeComputePoolReserved.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeAttributes, numCpuCores, numVcInstances, virtualMemSize, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservedVirtualComputeComputePoolReserved {\n");
    
    sb.append("    computeAttributes: ").append(toIndentedString(computeAttributes)).append("\n");
    sb.append("    numCpuCores: ").append(toIndentedString(numCpuCores)).append("\n");
    sb.append("    numVcInstances: ").append(toIndentedString(numVcInstances)).append("\n");
    sb.append("    virtualMemSize: ").append(toIndentedString(virtualMemSize)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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
