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

/**
 * MECAppDInfoInnerAppDAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-28T11:44:14.596Z")
public class MECAppDInfoInnerAppDAttributes {
  @SerializedName("APPDInfo")
  private String apPDInfo = null;

  @SerializedName("MECAppDId")
  private String meCAppDId = null;

  public MECAppDInfoInnerAppDAttributes apPDInfo(String apPDInfo) {
    this.apPDInfo = apPDInfo;
    return this;
  }

   /**
   * It provides information about MEC APPD (TBD)
   * @return apPDInfo
  **/
  @ApiModelProperty(required = true, value = "It provides information about MEC APPD (TBD)")
  public String getApPDInfo() {
    return apPDInfo;
  }

  public void setApPDInfo(String apPDInfo) {
    this.apPDInfo = apPDInfo;
  }

  public MECAppDInfoInnerAppDAttributes meCAppDId(String meCAppDId) {
    this.meCAppDId = meCAppDId;
    return this;
  }

   /**
   * Identification of the MEC APPdId
   * @return meCAppDId
  **/
  @ApiModelProperty(required = true, value = "Identification of the MEC APPdId")
  public String getMeCAppDId() {
    return meCAppDId;
  }

  public void setMeCAppDId(String meCAppDId) {
    this.meCAppDId = meCAppDId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MECAppDInfoInnerAppDAttributes meCAppDInfoInnerAppDAttributes = (MECAppDInfoInnerAppDAttributes) o;
    return Objects.equals(this.apPDInfo, meCAppDInfoInnerAppDAttributes.apPDInfo) &&
        Objects.equals(this.meCAppDId, meCAppDInfoInnerAppDAttributes.meCAppDId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apPDInfo, meCAppDId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MECAppDInfoInnerAppDAttributes {\n");
    
    sb.append("    apPDInfo: ").append(toIndentedString(apPDInfo)).append("\n");
    sb.append("    meCAppDId: ").append(toIndentedString(meCAppDId)).append("\n");
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
