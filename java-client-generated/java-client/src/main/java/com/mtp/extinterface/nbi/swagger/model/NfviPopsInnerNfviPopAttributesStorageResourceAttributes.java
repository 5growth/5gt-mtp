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

/**
 * NfviPopsInnerNfviPopAttributesStorageResourceAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class NfviPopsInnerNfviPopAttributesStorageResourceAttributes {
  @SerializedName("availableCapacity")
  private String availableCapacity = null;

  @SerializedName("reservedCapacity")
  private String reservedCapacity = null;

  @SerializedName("totalCapacity")
  private String totalCapacity = null;

  @SerializedName("allocatedCapacity")
  private String allocatedCapacity = null;

  public NfviPopsInnerNfviPopAttributesStorageResourceAttributes availableCapacity(String availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

   /**
   * The free capacity available for allocation and reservation of storage resources.
   * @return availableCapacity
  **/
  @ApiModelProperty(required = true, value = "The free capacity available for allocation and reservation of storage resources.")
  public String getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(String availableCapacity) {
    this.availableCapacity = availableCapacity;
  }

  public NfviPopsInnerNfviPopAttributesStorageResourceAttributes reservedCapacity(String reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
    return this;
  }

   /**
   * The reserved capacity of storage resources.
   * @return reservedCapacity
  **/
  @ApiModelProperty(required = true, value = "The reserved capacity of storage resources.")
  public String getReservedCapacity() {
    return reservedCapacity;
  }

  public void setReservedCapacity(String reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
  }

  public NfviPopsInnerNfviPopAttributesStorageResourceAttributes totalCapacity(String totalCapacity) {
    this.totalCapacity = totalCapacity;
    return this;
  }

   /**
   * The total capacity of storage resources.
   * @return totalCapacity
  **/
  @ApiModelProperty(required = true, value = "The total capacity of storage resources.")
  public String getTotalCapacity() {
    return totalCapacity;
  }

  public void setTotalCapacity(String totalCapacity) {
    this.totalCapacity = totalCapacity;
  }

  public NfviPopsInnerNfviPopAttributesStorageResourceAttributes allocatedCapacity(String allocatedCapacity) {
    this.allocatedCapacity = allocatedCapacity;
    return this;
  }

   /**
   * The allocated capacity of storage resources.
   * @return allocatedCapacity
  **/
  @ApiModelProperty(required = true, value = "The allocated capacity of storage resources.")
  public String getAllocatedCapacity() {
    return allocatedCapacity;
  }

  public void setAllocatedCapacity(String allocatedCapacity) {
    this.allocatedCapacity = allocatedCapacity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfviPopsInnerNfviPopAttributesStorageResourceAttributes nfviPopsInnerNfviPopAttributesStorageResourceAttributes = (NfviPopsInnerNfviPopAttributesStorageResourceAttributes) o;
    return Objects.equals(this.availableCapacity, nfviPopsInnerNfviPopAttributesStorageResourceAttributes.availableCapacity) &&
        Objects.equals(this.reservedCapacity, nfviPopsInnerNfviPopAttributesStorageResourceAttributes.reservedCapacity) &&
        Objects.equals(this.totalCapacity, nfviPopsInnerNfviPopAttributesStorageResourceAttributes.totalCapacity) &&
        Objects.equals(this.allocatedCapacity, nfviPopsInnerNfviPopAttributesStorageResourceAttributes.allocatedCapacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableCapacity, reservedCapacity, totalCapacity, allocatedCapacity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfviPopsInnerNfviPopAttributesStorageResourceAttributes {\n");
    
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    reservedCapacity: ").append(toIndentedString(reservedCapacity)).append("\n");
    sb.append("    totalCapacity: ").append(toIndentedString(totalCapacity)).append("\n");
    sb.append("    allocatedCapacity: ").append(toIndentedString(allocatedCapacity)).append("\n");
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

