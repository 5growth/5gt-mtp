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
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestAffinityOrAntiAffinityConstraints;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestInterfaceData;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestUserData;
import com.mtp.extinterface.nbi.swagger.model.MetaDataInner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * VIMAllocateComputeRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class VIMAllocateComputeRequest {
  @SerializedName("affinityOrAntiAffinityConstraints")
  private List<AllocateComputeRequestAffinityOrAntiAffinityConstraints> affinityOrAntiAffinityConstraints = new ArrayList<AllocateComputeRequestAffinityOrAntiAffinityConstraints>();

  @SerializedName("computeFlavourId")
  private String computeFlavourId = null;

  @SerializedName("computeName")
  private String computeName = null;

  @SerializedName("interfaceData")
  private List<AllocateComputeRequestInterfaceData> interfaceData = new ArrayList<AllocateComputeRequestInterfaceData>();

  @SerializedName("locationConstraints")
  private String locationConstraints = null;

  @SerializedName("metadata")
  private List<MetaDataInner> metadata = new ArrayList<MetaDataInner>();

  @SerializedName("reservationId")
  private String reservationId = null;

  @SerializedName("resourceGroupId")
  private String resourceGroupId = null;

  @SerializedName("userData")
  private AllocateComputeRequestUserData userData = null;

  @SerializedName("vcImageId")
  private String vcImageId = null;

  public VIMAllocateComputeRequest affinityOrAntiAffinityConstraints(List<AllocateComputeRequestAffinityOrAntiAffinityConstraints> affinityOrAntiAffinityConstraints) {
    this.affinityOrAntiAffinityConstraints = affinityOrAntiAffinityConstraints;
    return this;
  }

  public VIMAllocateComputeRequest addAffinityOrAntiAffinityConstraintsItem(AllocateComputeRequestAffinityOrAntiAffinityConstraints affinityOrAntiAffinityConstraintsItem) {
    this.affinityOrAntiAffinityConstraints.add(affinityOrAntiAffinityConstraintsItem);
    return this;
  }

   /**
   * A list of elements with affinity or anti affinity information of the virtualised compute resource to allocate. There should be a relation between the constraints defined in the different elements of the list.
   * @return affinityOrAntiAffinityConstraints
  **/
  @ApiModelProperty(required = true, value = "A list of elements with affinity or anti affinity information of the virtualised compute resource to allocate. There should be a relation between the constraints defined in the different elements of the list.")
  public List<AllocateComputeRequestAffinityOrAntiAffinityConstraints> getAffinityOrAntiAffinityConstraints() {
    return affinityOrAntiAffinityConstraints;
  }

  public void setAffinityOrAntiAffinityConstraints(List<AllocateComputeRequestAffinityOrAntiAffinityConstraints> affinityOrAntiAffinityConstraints) {
    this.affinityOrAntiAffinityConstraints = affinityOrAntiAffinityConstraints;
  }

  public VIMAllocateComputeRequest computeFlavourId(String computeFlavourId) {
    this.computeFlavourId = computeFlavourId;
    return this;
  }

   /**
   * Identifier of the Compute Flavour that provides information about the particular memory, CPU and disk resources for virtualised compute resource to allocate. The Compute Flavour is created with Create Compute Flavour operation
   * @return computeFlavourId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the Compute Flavour that provides information about the particular memory, CPU and disk resources for virtualised compute resource to allocate. The Compute Flavour is created with Create Compute Flavour operation")
  public String getComputeFlavourId() {
    return computeFlavourId;
  }

  public void setComputeFlavourId(String computeFlavourId) {
    this.computeFlavourId = computeFlavourId;
  }

  public VIMAllocateComputeRequest computeName(String computeName) {
    this.computeName = computeName;
    return this;
  }

   /**
   * Name provided by the consumer for the virtualised compute resource to allocate. It can be used for identifying resources from consumer side.
   * @return computeName
  **/
  @ApiModelProperty(required = true, value = "Name provided by the consumer for the virtualised compute resource to allocate. It can be used for identifying resources from consumer side.")
  public String getComputeName() {
    return computeName;
  }

  public void setComputeName(String computeName) {
    this.computeName = computeName;
  }

  public VIMAllocateComputeRequest interfaceData(List<AllocateComputeRequestInterfaceData> interfaceData) {
    this.interfaceData = interfaceData;
    return this;
  }

  public VIMAllocateComputeRequest addInterfaceDataItem(AllocateComputeRequestInterfaceData interfaceDataItem) {
    this.interfaceData.add(interfaceDataItem);
    return this;
  }

   /**
   * The data of network interfaces which are specific to a Virtual Compute Resource instance.
   * @return interfaceData
  **/
  @ApiModelProperty(required = true, value = "The data of network interfaces which are specific to a Virtual Compute Resource instance.")
  public List<AllocateComputeRequestInterfaceData> getInterfaceData() {
    return interfaceData;
  }

  public void setInterfaceData(List<AllocateComputeRequestInterfaceData> interfaceData) {
    this.interfaceData = interfaceData;
  }

  public VIMAllocateComputeRequest locationConstraints(String locationConstraints) {
    this.locationConstraints = locationConstraints;
    return this;
  }

   /**
   * If present, it defines location constraints for the resource(s) is (are) requested to be allocated, e.g. in what particular Resource Zone.
   * @return locationConstraints
  **/
  @ApiModelProperty(required = true, value = "If present, it defines location constraints for the resource(s) is (are) requested to be allocated, e.g. in what particular Resource Zone.")
  public String getLocationConstraints() {
    return locationConstraints;
  }

  public void setLocationConstraints(String locationConstraints) {
    this.locationConstraints = locationConstraints;
  }

  public VIMAllocateComputeRequest metadata(List<MetaDataInner> metadata) {
    this.metadata = metadata;
    return this;
  }

  public VIMAllocateComputeRequest addMetadataItem(MetaDataInner metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

   /**
   * The binary software image file.
   * @return metadata
  **/
  @ApiModelProperty(required = true, value = "The binary software image file.")
  public List<MetaDataInner> getMetadata() {
    return metadata;
  }

  public void setMetadata(List<MetaDataInner> metadata) {
    this.metadata = metadata;
  }

  public VIMAllocateComputeRequest reservationId(String reservationId) {
    this.reservationId = reservationId;
    return this;
  }

   /**
   * Identifier of the resource reservation applicable to this virtualised resource management operation. Cardinality can be 0 if no resource reservation was used.
   * @return reservationId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the resource reservation applicable to this virtualised resource management operation. Cardinality can be 0 if no resource reservation was used.")
  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public VIMAllocateComputeRequest resourceGroupId(String resourceGroupId) {
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

  public VIMAllocateComputeRequest userData(AllocateComputeRequestUserData userData) {
    this.userData = userData;
    return this;
  }

   /**
   * Get userData
   * @return userData
  **/
  @ApiModelProperty(required = true, value = "")
  public AllocateComputeRequestUserData getUserData() {
    return userData;
  }

  public void setUserData(AllocateComputeRequestUserData userData) {
    this.userData = userData;
  }

  public VIMAllocateComputeRequest vcImageId(String vcImageId) {
    this.vcImageId = vcImageId;
    return this;
  }

   /**
   * Identifier of the virtualisation container software image (e.g. a virtual machine image). Cardinality can be 0 if an \&quot;empty\&quot; virtualisation container is allocated. 
   * @return vcImageId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the virtualisation container software image (e.g. a virtual machine image). Cardinality can be 0 if an \"empty\" virtualisation container is allocated. ")
  public String getVcImageId() {
    return vcImageId;
  }

  public void setVcImageId(String vcImageId) {
    this.vcImageId = vcImageId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VIMAllocateComputeRequest viMAllocateComputeRequest = (VIMAllocateComputeRequest) o;
    return Objects.equals(this.affinityOrAntiAffinityConstraints, viMAllocateComputeRequest.affinityOrAntiAffinityConstraints) &&
        Objects.equals(this.computeFlavourId, viMAllocateComputeRequest.computeFlavourId) &&
        Objects.equals(this.computeName, viMAllocateComputeRequest.computeName) &&
        Objects.equals(this.interfaceData, viMAllocateComputeRequest.interfaceData) &&
        Objects.equals(this.locationConstraints, viMAllocateComputeRequest.locationConstraints) &&
        Objects.equals(this.metadata, viMAllocateComputeRequest.metadata) &&
        Objects.equals(this.reservationId, viMAllocateComputeRequest.reservationId) &&
        Objects.equals(this.resourceGroupId, viMAllocateComputeRequest.resourceGroupId) &&
        Objects.equals(this.userData, viMAllocateComputeRequest.userData) &&
        Objects.equals(this.vcImageId, viMAllocateComputeRequest.vcImageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(affinityOrAntiAffinityConstraints, computeFlavourId, computeName, interfaceData, locationConstraints, metadata, reservationId, resourceGroupId, userData, vcImageId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VIMAllocateComputeRequest {\n");
    
    sb.append("    affinityOrAntiAffinityConstraints: ").append(toIndentedString(affinityOrAntiAffinityConstraints)).append("\n");
    sb.append("    computeFlavourId: ").append(toIndentedString(computeFlavourId)).append("\n");
    sb.append("    computeName: ").append(toIndentedString(computeName)).append("\n");
    sb.append("    interfaceData: ").append(toIndentedString(interfaceData)).append("\n");
    sb.append("    locationConstraints: ").append(toIndentedString(locationConstraints)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    resourceGroupId: ").append(toIndentedString(resourceGroupId)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    vcImageId: ").append(toIndentedString(vcImageId)).append("\n");
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

