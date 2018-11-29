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
import com.mtp.extinterface.nbi.swagger.model.InterNfviPopConnnectivityIdList;
import com.mtp.extinterface.nbi.swagger.model.MetaData;
import java.io.IOException;

/**
 * DeleteInterNfviPopConnectivityRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class DeleteInterNfviPopConnectivityRequest {
  @SerializedName("interNfviPopConnnectivityIdList")
  private InterNfviPopConnnectivityIdList interNfviPopConnnectivityIdList = null;

  @SerializedName("metaData")
  private MetaData metaData = null;

  public DeleteInterNfviPopConnectivityRequest interNfviPopConnnectivityIdList(InterNfviPopConnnectivityIdList interNfviPopConnnectivityIdList) {
    this.interNfviPopConnnectivityIdList = interNfviPopConnnectivityIdList;
    return this;
  }

   /**
   * Get interNfviPopConnnectivityIdList
   * @return interNfviPopConnnectivityIdList
  **/
  @ApiModelProperty(required = true, value = "")
  public InterNfviPopConnnectivityIdList getInterNfviPopConnnectivityIdList() {
    return interNfviPopConnnectivityIdList;
  }

  public void setInterNfviPopConnnectivityIdList(InterNfviPopConnnectivityIdList interNfviPopConnnectivityIdList) {
    this.interNfviPopConnnectivityIdList = interNfviPopConnnectivityIdList;
  }

  public DeleteInterNfviPopConnectivityRequest metaData(MetaData metaData) {
    this.metaData = metaData;
    return this;
  }

   /**
   * Get metaData
   * @return metaData
  **/
  @ApiModelProperty(required = true, value = "")
  public MetaData getMetaData() {
    return metaData;
  }

  public void setMetaData(MetaData metaData) {
    this.metaData = metaData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteInterNfviPopConnectivityRequest deleteInterNfviPopConnectivityRequest = (DeleteInterNfviPopConnectivityRequest) o;
    return Objects.equals(this.interNfviPopConnnectivityIdList, deleteInterNfviPopConnectivityRequest.interNfviPopConnnectivityIdList) &&
        Objects.equals(this.metaData, deleteInterNfviPopConnectivityRequest.metaData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interNfviPopConnnectivityIdList, metaData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteInterNfviPopConnectivityRequest {\n");
    
    sb.append("    interNfviPopConnnectivityIdList: ").append(toIndentedString(interNfviPopConnnectivityIdList)).append("\n");
    sb.append("    metaData: ").append(toIndentedString(metaData)).append("\n");
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

