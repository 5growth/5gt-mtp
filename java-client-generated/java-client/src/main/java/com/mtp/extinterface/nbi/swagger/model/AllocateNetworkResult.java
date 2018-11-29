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
import com.mtp.extinterface.nbi.swagger.model.AllocateNetworkResultNetworkData;
import com.mtp.extinterface.nbi.swagger.model.AllocateNetworkResultNetworkPortData;
import com.mtp.extinterface.nbi.swagger.model.AllocateNetworkResultSubnetData;
import java.io.IOException;

/**
 * AllocateNetworkResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class AllocateNetworkResult {
  @SerializedName("networkData")
  private AllocateNetworkResultNetworkData networkData = null;

  @SerializedName("networkPortData")
  private AllocateNetworkResultNetworkPortData networkPortData = null;

  @SerializedName("subnetData")
  private AllocateNetworkResultSubnetData subnetData = null;

  public AllocateNetworkResult networkData(AllocateNetworkResultNetworkData networkData) {
    this.networkData = networkData;
    return this;
  }

   /**
   * Get networkData
   * @return networkData
  **/
  @ApiModelProperty(required = true, value = "")
  public AllocateNetworkResultNetworkData getNetworkData() {
    return networkData;
  }

  public void setNetworkData(AllocateNetworkResultNetworkData networkData) {
    this.networkData = networkData;
  }

  public AllocateNetworkResult networkPortData(AllocateNetworkResultNetworkPortData networkPortData) {
    this.networkPortData = networkPortData;
    return this;
  }

   /**
   * Get networkPortData
   * @return networkPortData
  **/
  @ApiModelProperty(required = true, value = "")
  public AllocateNetworkResultNetworkPortData getNetworkPortData() {
    return networkPortData;
  }

  public void setNetworkPortData(AllocateNetworkResultNetworkPortData networkPortData) {
    this.networkPortData = networkPortData;
  }

  public AllocateNetworkResult subnetData(AllocateNetworkResultSubnetData subnetData) {
    this.subnetData = subnetData;
    return this;
  }

   /**
   * Get subnetData
   * @return subnetData
  **/
  @ApiModelProperty(required = true, value = "")
  public AllocateNetworkResultSubnetData getSubnetData() {
    return subnetData;
  }

  public void setSubnetData(AllocateNetworkResultSubnetData subnetData) {
    this.subnetData = subnetData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocateNetworkResult allocateNetworkResult = (AllocateNetworkResult) o;
    return Objects.equals(this.networkData, allocateNetworkResult.networkData) &&
        Objects.equals(this.networkPortData, allocateNetworkResult.networkPortData) &&
        Objects.equals(this.subnetData, allocateNetworkResult.subnetData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkData, networkPortData, subnetData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocateNetworkResult {\n");
    
    sb.append("    networkData: ").append(toIndentedString(networkData)).append("\n");
    sb.append("    networkPortData: ").append(toIndentedString(networkPortData)).append("\n");
    sb.append("    subnetData: ").append(toIndentedString(subnetData)).append("\n");
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

