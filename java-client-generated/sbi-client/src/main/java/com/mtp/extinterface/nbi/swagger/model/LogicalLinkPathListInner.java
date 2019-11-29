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
import com.mtp.extinterface.nbi.swagger.model.LogicalLinkAttributes;
import com.mtp.extinterface.nbi.swagger.model.MetaData;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * LogicalLinkPathListInner
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class LogicalLinkPathListInner {
  @SerializedName("logicalLinkAttributes")
  private LogicalLinkAttributes logicalLinkAttributes = null;

  @SerializedName("reqBandwidth")
  private BigDecimal reqBandwidth = null;

  @SerializedName("reqLatency")
  private BigDecimal reqLatency = null;

  @SerializedName("metaData")
  private MetaData metaData = null;

  public LogicalLinkPathListInner logicalLinkAttributes(LogicalLinkAttributes logicalLinkAttributes) {
    this.logicalLinkAttributes = logicalLinkAttributes;
    return this;
  }

   /**
   * Get logicalLinkAttributes
   * @return logicalLinkAttributes
  **/
  @ApiModelProperty(required = true, value = "")
  public LogicalLinkAttributes getLogicalLinkAttributes() {
    return logicalLinkAttributes;
  }

  public void setLogicalLinkAttributes(LogicalLinkAttributes logicalLinkAttributes) {
    this.logicalLinkAttributes = logicalLinkAttributes;
  }

  public LogicalLinkPathListInner reqBandwidth(BigDecimal reqBandwidth) {
    this.reqBandwidth = reqBandwidth;
    return this;
  }

   /**
   * requested bandwidth (in Mbps).
   * @return reqBandwidth
  **/
  @ApiModelProperty(required = true, value = "requested bandwidth (in Mbps).")
  public BigDecimal getReqBandwidth() {
    return reqBandwidth;
  }

  public void setReqBandwidth(BigDecimal reqBandwidth) {
    this.reqBandwidth = reqBandwidth;
  }

  public LogicalLinkPathListInner reqLatency(BigDecimal reqLatency) {
    this.reqLatency = reqLatency;
    return this;
  }

   /**
   * 5GT - requested maximum end-to-end latency (expressed in ms)
   * @return reqLatency
  **/
  @ApiModelProperty(required = true, value = "5GT - requested maximum end-to-end latency (expressed in ms)")
  public BigDecimal getReqLatency() {
    return reqLatency;
  }

  public void setReqLatency(BigDecimal reqLatency) {
    this.reqLatency = reqLatency;
  }

  public LogicalLinkPathListInner metaData(MetaData metaData) {
    this.metaData = metaData;
    return this;
  }

   /**
   * Get metaData
   * @return metaData
  **/
  @ApiModelProperty(value = "")
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
    LogicalLinkPathListInner logicalLinkPathListInner = (LogicalLinkPathListInner) o;
    return Objects.equals(this.logicalLinkAttributes, logicalLinkPathListInner.logicalLinkAttributes) &&
        Objects.equals(this.reqBandwidth, logicalLinkPathListInner.reqBandwidth) &&
        Objects.equals(this.reqLatency, logicalLinkPathListInner.reqLatency) &&
        Objects.equals(this.metaData, logicalLinkPathListInner.metaData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logicalLinkAttributes, reqBandwidth, reqLatency, metaData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogicalLinkPathListInner {\n");
    
    sb.append("    logicalLinkAttributes: ").append(toIndentedString(logicalLinkAttributes)).append("\n");
    sb.append("    reqBandwidth: ").append(toIndentedString(reqBandwidth)).append("\n");
    sb.append("    reqLatency: ").append(toIndentedString(reqLatency)).append("\n");
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

