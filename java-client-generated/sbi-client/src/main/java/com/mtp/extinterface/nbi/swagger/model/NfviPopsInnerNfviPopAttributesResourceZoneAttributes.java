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
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesCpuResourceAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesMemoryResourceAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesStorageResourceAttributes;
import java.io.IOException;

/**
 * NfviPopsInnerNfviPopAttributesResourceZoneAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class NfviPopsInnerNfviPopAttributesResourceZoneAttributes {
  @SerializedName("zoneId")
  private String zoneId = null;

  @SerializedName("zoneName")
  private String zoneName = null;

  @SerializedName("zoneState")
  private String zoneState = null;

  @SerializedName("zoneProperty")
  private String zoneProperty = null;

  @SerializedName("metadata")
  private String metadata = null;

  @SerializedName("memoryResourceAttributes")
  private NfviPopsInnerNfviPopAttributesMemoryResourceAttributes memoryResourceAttributes = null;

  @SerializedName("cpuResourceAttributes")
  private NfviPopsInnerNfviPopAttributesCpuResourceAttributes cpuResourceAttributes = null;

  @SerializedName("storageResourceAttributes")
  private NfviPopsInnerNfviPopAttributesStorageResourceAttributes storageResourceAttributes = null;

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * The identifier of the Resource Zone.
   * @return zoneId
  **/
  @ApiModelProperty(required = true, value = "The identifier of the Resource Zone.")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes zoneName(String zoneName) {
    this.zoneName = zoneName;
    return this;
  }

   /**
   * The name of the Resource Zone.
   * @return zoneName
  **/
  @ApiModelProperty(required = true, value = "The name of the Resource Zone.")
  public String getZoneName() {
    return zoneName;
  }

  public void setZoneName(String zoneName) {
    this.zoneName = zoneName;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes zoneState(String zoneState) {
    this.zoneState = zoneState;
    return this;
  }

   /**
   * Information about the current state of the Resource Zone, e.g. if the Resource Zone is available.
   * @return zoneState
  **/
  @ApiModelProperty(required = true, value = "Information about the current state of the Resource Zone, e.g. if the Resource Zone is available.")
  public String getZoneState() {
    return zoneState;
  }

  public void setZoneState(String zoneState) {
    this.zoneState = zoneState;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes zoneProperty(String zoneProperty) {
    this.zoneProperty = zoneProperty;
    return this;
  }

   /**
   * Set of properties that define the capabilities associated to the Resource Zone. Examples of capabilities may include: support of certain compute resource types (e.g. low performance, acceleration capabilities, etc. association to certain NFVI-PoP physical segregation (e.g. different power or network sub-systems, availability of redundancy power sub-systems), etc.
   * @return zoneProperty
  **/
  @ApiModelProperty(required = true, value = "Set of properties that define the capabilities associated to the Resource Zone. Examples of capabilities may include: support of certain compute resource types (e.g. low performance, acceleration capabilities, etc. association to certain NFVI-PoP physical segregation (e.g. different power or network sub-systems, availability of redundancy power sub-systems), etc.")
  public String getZoneProperty() {
    return zoneProperty;
  }

  public void setZoneProperty(String zoneProperty) {
    this.zoneProperty = zoneProperty;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes metadata(String metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * List of metadata key-value pairs used to associate meaningful metadata to the NFVI-PoP Zone.
   * @return metadata
  **/
  @ApiModelProperty(required = true, value = "List of metadata key-value pairs used to associate meaningful metadata to the NFVI-PoP Zone.")
  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes memoryResourceAttributes(NfviPopsInnerNfviPopAttributesMemoryResourceAttributes memoryResourceAttributes) {
    this.memoryResourceAttributes = memoryResourceAttributes;
    return this;
  }

   /**
   * Get memoryResourceAttributes
   * @return memoryResourceAttributes
  **/
  @ApiModelProperty(required = true, value = "")
  public NfviPopsInnerNfviPopAttributesMemoryResourceAttributes getMemoryResourceAttributes() {
    return memoryResourceAttributes;
  }

  public void setMemoryResourceAttributes(NfviPopsInnerNfviPopAttributesMemoryResourceAttributes memoryResourceAttributes) {
    this.memoryResourceAttributes = memoryResourceAttributes;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes cpuResourceAttributes(NfviPopsInnerNfviPopAttributesCpuResourceAttributes cpuResourceAttributes) {
    this.cpuResourceAttributes = cpuResourceAttributes;
    return this;
  }

   /**
   * Get cpuResourceAttributes
   * @return cpuResourceAttributes
  **/
  @ApiModelProperty(required = true, value = "")
  public NfviPopsInnerNfviPopAttributesCpuResourceAttributes getCpuResourceAttributes() {
    return cpuResourceAttributes;
  }

  public void setCpuResourceAttributes(NfviPopsInnerNfviPopAttributesCpuResourceAttributes cpuResourceAttributes) {
    this.cpuResourceAttributes = cpuResourceAttributes;
  }

  public NfviPopsInnerNfviPopAttributesResourceZoneAttributes storageResourceAttributes(NfviPopsInnerNfviPopAttributesStorageResourceAttributes storageResourceAttributes) {
    this.storageResourceAttributes = storageResourceAttributes;
    return this;
  }

   /**
   * Get storageResourceAttributes
   * @return storageResourceAttributes
  **/
  @ApiModelProperty(required = true, value = "")
  public NfviPopsInnerNfviPopAttributesStorageResourceAttributes getStorageResourceAttributes() {
    return storageResourceAttributes;
  }

  public void setStorageResourceAttributes(NfviPopsInnerNfviPopAttributesStorageResourceAttributes storageResourceAttributes) {
    this.storageResourceAttributes = storageResourceAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfviPopsInnerNfviPopAttributesResourceZoneAttributes nfviPopsInnerNfviPopAttributesResourceZoneAttributes = (NfviPopsInnerNfviPopAttributesResourceZoneAttributes) o;
    return Objects.equals(this.zoneId, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.zoneId) &&
        Objects.equals(this.zoneName, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.zoneName) &&
        Objects.equals(this.zoneState, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.zoneState) &&
        Objects.equals(this.zoneProperty, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.zoneProperty) &&
        Objects.equals(this.metadata, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.metadata) &&
        Objects.equals(this.memoryResourceAttributes, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.memoryResourceAttributes) &&
        Objects.equals(this.cpuResourceAttributes, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.cpuResourceAttributes) &&
        Objects.equals(this.storageResourceAttributes, nfviPopsInnerNfviPopAttributesResourceZoneAttributes.storageResourceAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zoneId, zoneName, zoneState, zoneProperty, metadata, memoryResourceAttributes, cpuResourceAttributes, storageResourceAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfviPopsInnerNfviPopAttributesResourceZoneAttributes {\n");
    
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
    sb.append("    zoneName: ").append(toIndentedString(zoneName)).append("\n");
    sb.append("    zoneState: ").append(toIndentedString(zoneState)).append("\n");
    sb.append("    zoneProperty: ").append(toIndentedString(zoneProperty)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    memoryResourceAttributes: ").append(toIndentedString(memoryResourceAttributes)).append("\n");
    sb.append("    cpuResourceAttributes: ").append(toIndentedString(cpuResourceAttributes)).append("\n");
    sb.append("    storageResourceAttributes: ").append(toIndentedString(storageResourceAttributes)).append("\n");
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

