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
import com.mtp.extinterface.nbi.swagger.model.MECRegionInfoMecRegionInfo;
import java.io.IOException;

/**
 * Information about a region.
 */
@ApiModel(description = "Information about a region.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class MECRegionInfo {
  @SerializedName("mecRegionInfo")
  private MECRegionInfoMecRegionInfo mecRegionInfo = null;

  public MECRegionInfo mecRegionInfo(MECRegionInfoMecRegionInfo mecRegionInfo) {
    this.mecRegionInfo = mecRegionInfo;
    return this;
  }

   /**
   * Get mecRegionInfo
   * @return mecRegionInfo
  **/
  @ApiModelProperty(value = "")
  public MECRegionInfoMecRegionInfo getMecRegionInfo() {
    return mecRegionInfo;
  }

  public void setMecRegionInfo(MECRegionInfoMecRegionInfo mecRegionInfo) {
    this.mecRegionInfo = mecRegionInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MECRegionInfo meCRegionInfo = (MECRegionInfo) o;
    return Objects.equals(this.mecRegionInfo, meCRegionInfo.mecRegionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mecRegionInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MECRegionInfo {\n");
    
    sb.append("    mecRegionInfo: ").append(toIndentedString(mecRegionInfo)).append("\n");
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

