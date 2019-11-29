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
 * VirtualComputeQuota
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class VirtualComputeQuota {
  @SerializedName("numVCPUs")
  private Integer numVCPUs = null;

  @SerializedName("numVcInstances")
  private Integer numVcInstances = null;

  @SerializedName("resourceGroupId")
  private String resourceGroupId = null;

  @SerializedName("virtualMemSize")
  private BigDecimal virtualMemSize = null;

  public VirtualComputeQuota numVCPUs(Integer numVCPUs) {
    this.numVCPUs = numVCPUs;
    return this;
  }

   /**
   * Number of CPU cores that have been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.
   * @return numVCPUs
  **/
  @ApiModelProperty(required = true, value = "Number of CPU cores that have been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.")
  public Integer getNumVCPUs() {
    return numVCPUs;
  }

  public void setNumVCPUs(Integer numVCPUs) {
    this.numVCPUs = numVCPUs;
  }

  public VirtualComputeQuota numVcInstances(Integer numVcInstances) {
    this.numVcInstances = numVcInstances;
    return this;
  }

   /**
   * Number of virtualisation container instances that have been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.
   * @return numVcInstances
  **/
  @ApiModelProperty(required = true, value = "Number of virtualisation container instances that have been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.")
  public Integer getNumVcInstances() {
    return numVcInstances;
  }

  public void setNumVcInstances(Integer numVcInstances) {
    this.numVcInstances = numVcInstances;
  }

  public VirtualComputeQuota resourceGroupId(String resourceGroupId) {
    this.resourceGroupId = resourceGroupId;
    return this;
  }

   /**
   * Unique identifier of the \&quot;infrastructure resource group\&quot;, logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
   * @return resourceGroupId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the \"infrastructure resource group\", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.")
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  public void setResourceGroupId(String resourceGroupId) {
    this.resourceGroupId = resourceGroupId;
  }

  public VirtualComputeQuota virtualMemSize(BigDecimal virtualMemSize) {
    this.virtualMemSize = virtualMemSize;
    return this;
  }

   /**
   * Size of virtual memory that has been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.
   * @return virtualMemSize
  **/
  @ApiModelProperty(required = true, value = "Size of virtual memory that has been restricted by the quota. The cardinality can be 0 if no specific number of CPU cores has been requested to be restricted by the quota.")
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
    VirtualComputeQuota virtualComputeQuota = (VirtualComputeQuota) o;
    return Objects.equals(this.numVCPUs, virtualComputeQuota.numVCPUs) &&
        Objects.equals(this.numVcInstances, virtualComputeQuota.numVcInstances) &&
        Objects.equals(this.resourceGroupId, virtualComputeQuota.resourceGroupId) &&
        Objects.equals(this.virtualMemSize, virtualComputeQuota.virtualMemSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numVCPUs, numVcInstances, resourceGroupId, virtualMemSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualComputeQuota {\n");
    
    sb.append("    numVCPUs: ").append(toIndentedString(numVCPUs)).append("\n");
    sb.append("    numVcInstances: ").append(toIndentedString(numVcInstances)).append("\n");
    sb.append("    resourceGroupId: ").append(toIndentedString(resourceGroupId)).append("\n");
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

