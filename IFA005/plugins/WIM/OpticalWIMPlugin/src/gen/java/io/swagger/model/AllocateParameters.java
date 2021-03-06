/*
 * VIM Manager API
 * VIM Manager API
 *
 * OpenAPI spec version: 0.0.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.*;

/**
 * AllocateParameters
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-11-29T11:25:16.593Z")
public class AllocateParameters   {
  @JsonProperty("locationConstraints")
  private String locationConstraints = null;

  @JsonProperty("reservationId")
  private String reservationId = null;

  @JsonProperty("typeNetworkData")
  private String typeNetworkData = null;

  @JsonProperty("affinityOrAntiAffinityConstraints")
  private String affinityOrAntiAffinityConstraints = null;

  @JsonProperty("typeNetworkPortData")
  private String typeNetworkPortData = null;

  @JsonProperty("resourceGroupId")
  private String resourceGroupId = null;

  @JsonProperty("metadata")
  private String metadata = null;

  @JsonProperty("networkResourceType")
  private String networkResourceType = null;

  @JsonProperty("networkResourceName")
  private String networkResourceName = null;

  @JsonProperty("typeSubnetData")
  private String typeSubnetData = null;

  @JsonProperty("bandwidth")
  private BigDecimal bandwidth = null;

  @JsonProperty("delay")
  private String delay = null;

  @JsonProperty("networkType")
  private String networkType = null;

  @JsonProperty("segmentType")
  private String segmentType = null;

  @JsonProperty("networkQoS")
  private String networkQoS = null;

  @JsonProperty("isShared")
  private Boolean isShared = null;

  @JsonProperty("sharingCriteria")
  private String sharingCriteria = null;

  @JsonProperty("layer3Attributes")
  private String layer3Attributes = null;

  @JsonProperty("portType")
  private String portType = null;

  @JsonProperty("networkId")
  private String networkId = null;

  @JsonProperty("segmentId")
  private String segmentId = null;

  @JsonProperty("ingressPointIPAddress")
  private String ingressPointIPAddress = null;

  @JsonProperty("ingressPointPortAddress")
  private String ingressPointPortAddress = null;

  @JsonProperty("egressPointIPAddress")
  private String egressPointIPAddress = null;

  @JsonProperty("egressPointPortAddress")
  private String egressPointPortAddress = null;

  @JsonProperty("wanLinkId")
  private String wanLinkId = null;

  public AllocateParameters locationConstraints(String locationConstraints) {
    this.locationConstraints = locationConstraints;
    return this;
  }

  /**
   * Controls the visibility of the image. In case of \&quot;private\&quot; value the image is available only for the tenant assigned to the provided resourceGroupId and the administrator tenants of the VIM while in case of \&quot;public\&quot; value, all tenants of the VIM can use the image.
   * @return locationConstraints
   **/
  @JsonProperty("locationConstraints")
  @ApiModelProperty(required = true, value = "Controls the visibility of the image. In case of \"private\" value the image is available only for the tenant assigned to the provided resourceGroupId and the administrator tenants of the VIM while in case of \"public\" value, all tenants of the VIM can use the image.")
  @NotNull
  public String getLocationConstraints() {
    return locationConstraints;
  }

  public void setLocationConstraints(String locationConstraints) {
    this.locationConstraints = locationConstraints;
  }

  public AllocateParameters reservationId(String reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Identifier of the resource reservation applicable to this virtualised resource management operation.
   * @return reservationId
   **/
  @JsonProperty("reservationId")
  @ApiModelProperty(required = true, value = "Identifier of the resource reservation applicable to this virtualised resource management operation.")
  @NotNull
  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public AllocateParameters typeNetworkData(String typeNetworkData) {
    this.typeNetworkData = typeNetworkData;
    return this;
  }

  /**
   * The network data provides information about the particular virtual network resource to create. Cardinality can be \&quot;0\&quot; depending on the value of networkResourceType.
   * @return typeNetworkData
   **/
  @JsonProperty("typeNetworkData")
  @ApiModelProperty(required = true, value = "The network data provides information about the particular virtual network resource to create. Cardinality can be \"0\" depending on the value of networkResourceType.")
  @NotNull
  public String getTypeNetworkData() {
    return typeNetworkData;
  }

  public void setTypeNetworkData(String typeNetworkData) {
    this.typeNetworkData = typeNetworkData;
  }

  public AllocateParameters affinityOrAntiAffinityConstraints(String affinityOrAntiAffinityConstraints) {
    this.affinityOrAntiAffinityConstraints = affinityOrAntiAffinityConstraints;
    return this;
  }

  /**
   * The binary software image file.
   * @return affinityOrAntiAffinityConstraints
   **/
  @JsonProperty("affinityOrAntiAffinityConstraints")
  @ApiModelProperty(required = true, value = "The binary software image file.")
  @NotNull
  public String getAffinityOrAntiAffinityConstraints() {
    return affinityOrAntiAffinityConstraints;
  }

  public void setAffinityOrAntiAffinityConstraints(String affinityOrAntiAffinityConstraints) {
    this.affinityOrAntiAffinityConstraints = affinityOrAntiAffinityConstraints;
  }

  public AllocateParameters typeNetworkPortData(String typeNetworkPortData) {
    this.typeNetworkPortData = typeNetworkPortData;
    return this;
  }

  /**
   * The binary software image file.
   * @return typeNetworkPortData
   **/
  @JsonProperty("typeNetworkPortData")
  @ApiModelProperty(required = true, value = "The binary software image file.")
  @NotNull
  public String getTypeNetworkPortData() {
    return typeNetworkPortData;
  }

  public void setTypeNetworkPortData(String typeNetworkPortData) {
    this.typeNetworkPortData = typeNetworkPortData;
  }

  public AllocateParameters resourceGroupId(String resourceGroupId) {
    this.resourceGroupId = resourceGroupId;
    return this;
  }

  /**
   * Unique identifier of the \&quot;infrastructure resource group\&quot;, logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
   * @return resourceGroupId
   **/
  @JsonProperty("resourceGroupId")
  @ApiModelProperty(required = true, value = "Unique identifier of the \"infrastructure resource group\", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.")
  @NotNull
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  public void setResourceGroupId(String resourceGroupId) {
    this.resourceGroupId = resourceGroupId;
  }

  public AllocateParameters metadata(String metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * The binary software image file.
   * @return metadata
   **/
  @JsonProperty("metadata")
  @ApiModelProperty(required = true, value = "The binary software image file.")
  @NotNull
  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  public AllocateParameters networkResourceType(String networkResourceType) {
    this.networkResourceType = networkResourceType;
    return this;
  }

  /**
   * Type of virtualised network resource. Possible values are: \&quot;network\&quot;, \&quot;subnet\&quot; or network-port.
   * @return networkResourceType
   **/
  @JsonProperty("networkResourceType")
  @ApiModelProperty(required = true, value = "Type of virtualised network resource. Possible values are: \"network\", \"subnet\" or network-port.")
  @NotNull
  public String getNetworkResourceType() {
    return networkResourceType;
  }

  public void setNetworkResourceType(String networkResourceType) {
    this.networkResourceType = networkResourceType;
  }

  public AllocateParameters networkResourceName(String networkResourceName) {
    this.networkResourceName = networkResourceName;
    return this;
  }

  /**
   * Name provided by the consumer for the virtualised network resource to allocate. It can be used for identifying resources from consumer side.
   * @return networkResourceName
   **/
  @JsonProperty("networkResourceName")
  @ApiModelProperty(required = true, value = "Name provided by the consumer for the virtualised network resource to allocate. It can be used for identifying resources from consumer side.")
  @NotNull
  public String getNetworkResourceName() {
    return networkResourceName;
  }

  public void setNetworkResourceName(String networkResourceName) {
    this.networkResourceName = networkResourceName;
  }

  public AllocateParameters typeSubnetData(String typeSubnetData) {
    this.typeSubnetData = typeSubnetData;
    return this;
  }

  /**
   * The subnet data provides information about the particular sub-network resource to create.
   * @return typeSubnetData
   **/
  @JsonProperty("typeSubnetData")
  @ApiModelProperty(required = true, value = "The subnet data provides information about the particular sub-network resource to create.")
  @NotNull
  public String getTypeSubnetData() {
    return typeSubnetData;
  }

  public void setTypeSubnetData(String typeSubnetData) {
    this.typeSubnetData = typeSubnetData;
  }

  public AllocateParameters bandwidth(BigDecimal bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

  /**
   * The bandwidth of the virtual network interface (in Mbps).
   * @return bandwidth
   **/
  @JsonProperty("bandwidth")
  @ApiModelProperty(required = true, value = "The bandwidth of the virtual network interface (in Mbps).")
  @NotNull
  public BigDecimal getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(BigDecimal bandwidth) {
    this.bandwidth = bandwidth;
  }

  public AllocateParameters delay(String delay) {
    this.delay = delay;
    return this;
  }

  /**
   * Transmission delay.
   * @return delay
   **/
  @JsonProperty("delay")
  @ApiModelProperty(required = true, value = "Transmission delay.")
  @NotNull
  public String getDelay() {
    return delay;
  }

  public void setDelay(String delay) {
    this.delay = delay;
  }

  public AllocateParameters networkType(String networkType) {
    this.networkType = networkType;
    return this;
  }

  /**
   * The type of network that maps to the virtualised network.
   * @return networkType
   **/
  @JsonProperty("networkType")
  @ApiModelProperty(required = true, value = "The type of network that maps to the virtualised network.")
  @NotNull
  public String getNetworkType() {
    return networkType;
  }

  public void setNetworkType(String networkType) {
    this.networkType = networkType;
  }

  public AllocateParameters segmentType(String segmentType) {
    this.segmentType = segmentType;
    return this;
  }

  /**
   * The isolated segment for the virtualised network.
   * @return segmentType
   **/
  @JsonProperty("segmentType")
  @ApiModelProperty(required = true, value = "The isolated segment for the virtualised network.")
  @NotNull
  public String getSegmentType() {
    return segmentType;
  }

  public void setSegmentType(String segmentType) {
    this.segmentType = segmentType;
  }

  public AllocateParameters networkQoS(String networkQoS) {
    this.networkQoS = networkQoS;
    return this;
  }

  /**
   * Element providing information about Quality of Service attributes that the network shall support.
   * @return networkQoS
   **/
  @JsonProperty("networkQoS")
  @ApiModelProperty(required = true, value = "Element providing information about Quality of Service attributes that the network shall support.")
  @NotNull
  public String getNetworkQoS() {
    return networkQoS;
  }

  public void setNetworkQoS(String networkQoS) {
    this.networkQoS = networkQoS;
  }

  public AllocateParameters isShared(Boolean isShared) {
    this.isShared = isShared;
    return this;
  }

  /**
   * It defines whether the virtualised network is shared among consumers.
   * @return isShared
   **/
  @JsonProperty("isShared")
  @ApiModelProperty(required = true, value = "It defines whether the virtualised network is shared among consumers.")
  @NotNull
  public Boolean isIsShared() {
    return isShared;
  }

  public void setIsShared(Boolean isShared) {
    this.isShared = isShared;
  }

  public AllocateParameters sharingCriteria(String sharingCriteria) {
    this.sharingCriteria = sharingCriteria;
    return this;
  }

  /**
   * Only present for shared networks. Indicate the sharing criteria for this network. These criteria might be a list of authorized consumers.
   * @return sharingCriteria
   **/
  @JsonProperty("sharingCriteria")
  @ApiModelProperty(required = true, value = "Only present for shared networks. Indicate the sharing criteria for this network. These criteria might be a list of authorized consumers.")
  @NotNull
  public String getSharingCriteria() {
    return sharingCriteria;
  }

  public void setSharingCriteria(String sharingCriteria) {
    this.sharingCriteria = sharingCriteria;
  }

  public AllocateParameters layer3Attributes(String layer3Attributes) {
    this.layer3Attributes = layer3Attributes;
    return this;
  }

  /**
   * The attribute allows setting up a network providing defined layer 3 connectivity.
   * @return layer3Attributes
   **/
  @JsonProperty("layer3Attributes")
  @ApiModelProperty(required = true, value = "The attribute allows setting up a network providing defined layer 3 connectivity.")
  @NotNull
  public String getLayer3Attributes() {
    return layer3Attributes;
  }

  public void setLayer3Attributes(String layer3Attributes) {
    this.layer3Attributes = layer3Attributes;
  }

  public AllocateParameters portType(String portType) {
    this.portType = portType;
    return this;
  }

  /**
   * Type of network port.
   * @return portType
   **/
  @JsonProperty("portType")
  @ApiModelProperty(required = true, value = "Type of network port.")
  @NotNull
  public String getPortType() {
    return portType;
  }

  public void setPortType(String portType) {
    this.portType = portType;
  }

  public AllocateParameters networkId(String networkId) {
    this.networkId = networkId;
    return this;
  }

  /**
   * Identifier of the network that the port belongs to.
   * @return networkId
   **/
  @JsonProperty("networkId")
  @ApiModelProperty(required = true, value = "Identifier of the network that the port belongs to.")
  @NotNull
  public String getNetworkId() {
    return networkId;
  }

  public void setNetworkId(String networkId) {
    this.networkId = networkId;
  }

  public AllocateParameters segmentId(String segmentId) {
    this.segmentId = segmentId;
    return this;
  }

  /**
   * The isolated segment the network port belongs to.
   * @return segmentId
   **/
  @JsonProperty("segmentId")
  @ApiModelProperty(required = true, value = "The isolated segment the network port belongs to.")
  @NotNull
  public String getSegmentId() {
    return segmentId;
  }

  public void setSegmentId(String segmentId) {
    this.segmentId = segmentId;
  }

  public AllocateParameters ingressPointIPAddress(String ingressPointIPAddress) {
    this.ingressPointIPAddress = ingressPointIPAddress;
    return this;
  }

  /**
   * The ingress point IP Address.
   * @return ingressPointIPAddress
   **/
  @JsonProperty("ingressPointIPAddress")
  @ApiModelProperty(required = true, value = "The ingress point IP Address.")
  @NotNull
  public String getIngressPointIPAddress() {
    return ingressPointIPAddress;
  }

  public void setIngressPointIPAddress(String ingressPointIPAddress) {
    this.ingressPointIPAddress = ingressPointIPAddress;
  }

  public AllocateParameters ingressPointPortAddress(String ingressPointPortAddress) {
    this.ingressPointPortAddress = ingressPointPortAddress;
    return this;
  }

  /**
   * The ingress point Port(interface) Address.
   * @return ingressPointPortAddress
   **/
  @JsonProperty("ingressPointPortAddress")
  @ApiModelProperty(required = true, value = "The ingress point Port(interface) Address.")
  @NotNull
  public String getIngressPointPortAddress() {
    return ingressPointPortAddress;
  }

  public void setIngressPointPortAddress(String ingressPointPortAddress) {
    this.ingressPointPortAddress = ingressPointPortAddress;
  }

  public AllocateParameters egressPointIPAddress(String egressPointIPAddress) {
    this.egressPointIPAddress = egressPointIPAddress;
    return this;
  }

  /**
   * The engress point IP Address.
   * @return egressPointIPAddress
   **/
  @JsonProperty("egressPointIPAddress")
  @ApiModelProperty(value = "The engress point IP Address.")
  public String getEgressPointIPAddress() {
    return egressPointIPAddress;
  }

  public void setEgressPointIPAddress(String egressPointIPAddress) {
    this.egressPointIPAddress = egressPointIPAddress;
  }

  public AllocateParameters egressPointPortAddress(String egressPointPortAddress) {
    this.egressPointPortAddress = egressPointPortAddress;
    return this;
  }

  /**
   * The engress point Port(interface) Address.
   * @return egressPointPortAddress
   **/
  @JsonProperty("egressPointPortAddress")
  @ApiModelProperty(required = true, value = "The engress point Port(interface) Address.")
  @NotNull
  public String getEgressPointPortAddress() {
    return egressPointPortAddress;
  }

  public void setEgressPointPortAddress(String egressPointPortAddress) {
    this.egressPointPortAddress = egressPointPortAddress;
  }

  public AllocateParameters wanLinkId(String wanLinkId) {
    this.wanLinkId = wanLinkId;
    return this;
  }

  /**
   * The logical link ID between two nodes.
   * @return wanLinkId
   **/
  @JsonProperty("wanLinkId")
  @ApiModelProperty(required = true, value = "The logical link ID between two nodes.")
  @NotNull
  public String getWanLinkId() {
    return wanLinkId;
  }

  public void setWanLinkId(String wanLinkId) {
    this.wanLinkId = wanLinkId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocateParameters allocateParameters = (AllocateParameters) o;
    return Objects.equals(this.locationConstraints, allocateParameters.locationConstraints) &&
        Objects.equals(this.reservationId, allocateParameters.reservationId) &&
        Objects.equals(this.typeNetworkData, allocateParameters.typeNetworkData) &&
        Objects.equals(this.affinityOrAntiAffinityConstraints, allocateParameters.affinityOrAntiAffinityConstraints) &&
        Objects.equals(this.typeNetworkPortData, allocateParameters.typeNetworkPortData) &&
        Objects.equals(this.resourceGroupId, allocateParameters.resourceGroupId) &&
        Objects.equals(this.metadata, allocateParameters.metadata) &&
        Objects.equals(this.networkResourceType, allocateParameters.networkResourceType) &&
        Objects.equals(this.networkResourceName, allocateParameters.networkResourceName) &&
        Objects.equals(this.typeSubnetData, allocateParameters.typeSubnetData) &&
        Objects.equals(this.bandwidth, allocateParameters.bandwidth) &&
        Objects.equals(this.delay, allocateParameters.delay) &&
        Objects.equals(this.networkType, allocateParameters.networkType) &&
        Objects.equals(this.segmentType, allocateParameters.segmentType) &&
        Objects.equals(this.networkQoS, allocateParameters.networkQoS) &&
        Objects.equals(this.isShared, allocateParameters.isShared) &&
        Objects.equals(this.sharingCriteria, allocateParameters.sharingCriteria) &&
        Objects.equals(this.layer3Attributes, allocateParameters.layer3Attributes) &&
        Objects.equals(this.portType, allocateParameters.portType) &&
        Objects.equals(this.networkId, allocateParameters.networkId) &&
        Objects.equals(this.segmentId, allocateParameters.segmentId) &&
        Objects.equals(this.ingressPointIPAddress, allocateParameters.ingressPointIPAddress) &&
        Objects.equals(this.ingressPointPortAddress, allocateParameters.ingressPointPortAddress) &&
        Objects.equals(this.egressPointIPAddress, allocateParameters.egressPointIPAddress) &&
        Objects.equals(this.egressPointPortAddress, allocateParameters.egressPointPortAddress) &&
        Objects.equals(this.wanLinkId, allocateParameters.wanLinkId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationConstraints, reservationId, typeNetworkData, affinityOrAntiAffinityConstraints, typeNetworkPortData, resourceGroupId, metadata, networkResourceType, networkResourceName, typeSubnetData, bandwidth, delay, networkType, segmentType, networkQoS, isShared, sharingCriteria, layer3Attributes, portType, networkId, segmentId, ingressPointIPAddress, ingressPointPortAddress, egressPointIPAddress, egressPointPortAddress, wanLinkId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocateParameters {\n");
    
    sb.append("    locationConstraints: ").append(toIndentedString(locationConstraints)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    typeNetworkData: ").append(toIndentedString(typeNetworkData)).append("\n");
    sb.append("    affinityOrAntiAffinityConstraints: ").append(toIndentedString(affinityOrAntiAffinityConstraints)).append("\n");
    sb.append("    typeNetworkPortData: ").append(toIndentedString(typeNetworkPortData)).append("\n");
    sb.append("    resourceGroupId: ").append(toIndentedString(resourceGroupId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    networkResourceType: ").append(toIndentedString(networkResourceType)).append("\n");
    sb.append("    networkResourceName: ").append(toIndentedString(networkResourceName)).append("\n");
    sb.append("    typeSubnetData: ").append(toIndentedString(typeSubnetData)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
    sb.append("    networkType: ").append(toIndentedString(networkType)).append("\n");
    sb.append("    segmentType: ").append(toIndentedString(segmentType)).append("\n");
    sb.append("    networkQoS: ").append(toIndentedString(networkQoS)).append("\n");
    sb.append("    isShared: ").append(toIndentedString(isShared)).append("\n");
    sb.append("    sharingCriteria: ").append(toIndentedString(sharingCriteria)).append("\n");
    sb.append("    layer3Attributes: ").append(toIndentedString(layer3Attributes)).append("\n");
    sb.append("    portType: ").append(toIndentedString(portType)).append("\n");
    sb.append("    networkId: ").append(toIndentedString(networkId)).append("\n");
    sb.append("    segmentId: ").append(toIndentedString(segmentId)).append("\n");
    sb.append("    ingressPointIPAddress: ").append(toIndentedString(ingressPointIPAddress)).append("\n");
    sb.append("    ingressPointPortAddress: ").append(toIndentedString(ingressPointPortAddress)).append("\n");
    sb.append("    egressPointIPAddress: ").append(toIndentedString(egressPointIPAddress)).append("\n");
    sb.append("    egressPointPortAddress: ").append(toIndentedString(egressPointPortAddress)).append("\n");
    sb.append("    wanLinkId: ").append(toIndentedString(wanLinkId)).append("\n");
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

