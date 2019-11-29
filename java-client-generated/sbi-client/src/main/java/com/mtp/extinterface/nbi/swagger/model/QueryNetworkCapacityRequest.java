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
import com.mtp.extinterface.nbi.swagger.model.QueryComputeCapacityRequestTimePeriod;
import java.io.IOException;

/**
 * QueryNetworkCapacityRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class QueryNetworkCapacityRequest {
  @SerializedName("attributeSelector")
  private String attributeSelector = null;

  @SerializedName("networkResourceTypeId")
  private String networkResourceTypeId = null;

  @SerializedName("resourceCriteria")
  private String resourceCriteria = null;

  @SerializedName("timePeriod")
  private QueryComputeCapacityRequestTimePeriod timePeriod = null;

  @SerializedName("zoneId")
  private String zoneId = null;

  public QueryNetworkCapacityRequest attributeSelector(String attributeSelector) {
    this.attributeSelector = attributeSelector;
    return this;
  }

   /**
   * Input parameter for selecting which capacity information (i.e. available, total, reserved and/or allocated capacity) is queried. When not present, all four values are requested.
   * @return attributeSelector
  **/
  @ApiModelProperty(required = true, value = "Input parameter for selecting which capacity information (i.e. available, total, reserved and/or allocated capacity) is queried. When not present, all four values are requested.")
  public String getAttributeSelector() {
    return attributeSelector;
  }

  public void setAttributeSelector(String attributeSelector) {
    this.attributeSelector = attributeSelector;
  }

  public QueryNetworkCapacityRequest networkResourceTypeId(String networkResourceTypeId) {
    this.networkResourceTypeId = networkResourceTypeId;
    return this;
  }

   /**
   * Identifier of the resource type for which the issuer wants to know the available, total, reserved and/or allocated capacity.
   * @return networkResourceTypeId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the resource type for which the issuer wants to know the available, total, reserved and/or allocated capacity.")
  public String getNetworkResourceTypeId() {
    return networkResourceTypeId;
  }

  public void setNetworkResourceTypeId(String networkResourceTypeId) {
    this.networkResourceTypeId = networkResourceTypeId;
  }

  public QueryNetworkCapacityRequest resourceCriteria(String resourceCriteria) {
    this.resourceCriteria = resourceCriteria;
    return this;
  }

   /**
   * Input capacity computation parameter for selecting the characteristics of the virtual network for which the issuer wants to know the available, total, reserved and/or allocated capacity. Selecting parameters/attributes that shall be used are defined in the VirtualNetworkResourceInformation information element. This information element and the networkResourceTypeID are mutually exclusive.
   * @return resourceCriteria
  **/
  @ApiModelProperty(required = true, value = "Input capacity computation parameter for selecting the characteristics of the virtual network for which the issuer wants to know the available, total, reserved and/or allocated capacity. Selecting parameters/attributes that shall be used are defined in the VirtualNetworkResourceInformation information element. This information element and the networkResourceTypeID are mutually exclusive.")
  public String getResourceCriteria() {
    return resourceCriteria;
  }

  public void setResourceCriteria(String resourceCriteria) {
    this.resourceCriteria = resourceCriteria;
  }

  public QueryNetworkCapacityRequest timePeriod(QueryComputeCapacityRequestTimePeriod timePeriod) {
    this.timePeriod = timePeriod;
    return this;
  }

   /**
   * Get timePeriod
   * @return timePeriod
  **/
  @ApiModelProperty(required = true, value = "")
  public QueryComputeCapacityRequestTimePeriod getTimePeriod() {
    return timePeriod;
  }

  public void setTimePeriod(QueryComputeCapacityRequestTimePeriod timePeriod) {
    this.timePeriod = timePeriod;
  }

  public QueryNetworkCapacityRequest zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * When specified this parameter identifies the resource zone for which the capacity is requested. When not specified the total capacity managed by the VIM instance will be returned.
   * @return zoneId
  **/
  @ApiModelProperty(required = true, value = "When specified this parameter identifies the resource zone for which the capacity is requested. When not specified the total capacity managed by the VIM instance will be returned.")
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
    QueryNetworkCapacityRequest queryNetworkCapacityRequest = (QueryNetworkCapacityRequest) o;
    return Objects.equals(this.attributeSelector, queryNetworkCapacityRequest.attributeSelector) &&
        Objects.equals(this.networkResourceTypeId, queryNetworkCapacityRequest.networkResourceTypeId) &&
        Objects.equals(this.resourceCriteria, queryNetworkCapacityRequest.resourceCriteria) &&
        Objects.equals(this.timePeriod, queryNetworkCapacityRequest.timePeriod) &&
        Objects.equals(this.zoneId, queryNetworkCapacityRequest.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeSelector, networkResourceTypeId, resourceCriteria, timePeriod, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryNetworkCapacityRequest {\n");
    
    sb.append("    attributeSelector: ").append(toIndentedString(attributeSelector)).append("\n");
    sb.append("    networkResourceTypeId: ").append(toIndentedString(networkResourceTypeId)).append("\n");
    sb.append("    resourceCriteria: ").append(toIndentedString(resourceCriteria)).append("\n");
    sb.append("    timePeriod: ").append(toIndentedString(timePeriod)).append("\n");
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

