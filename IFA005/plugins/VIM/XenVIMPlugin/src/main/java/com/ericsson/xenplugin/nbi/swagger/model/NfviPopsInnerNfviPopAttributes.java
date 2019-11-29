package com.ericsson.xenplugin.nbi.swagger.model;

import com.ericsson.xenplugin.nbi.swagger.model.MECRegionInfo;
import com.ericsson.xenplugin.nbi.swagger.model.NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint;
import com.ericsson.xenplugin.nbi.swagger.model.NfviPopsInnerNfviPopAttributesRadioCoverageAreas;
import com.ericsson.xenplugin.nbi.swagger.model.NfviPopsInnerNfviPopAttributesResourceZoneAttributes;
import com.ericsson.xenplugin.nbi.swagger.model.PNFlist;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NfviPopsInnerNfviPopAttributes   {
  
  private @Valid PNFlist pnflist = null;
  private @Valid String geographicalLocationInfo = null;
  private @Valid String vimId = null;
  private @Valid String federatedVimId = null;
  private @Valid List<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint> networkConnectivityEndpoint = new ArrayList<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint>();
  private @Valid String nfviPopId = null;
  private @Valid List<NfviPopsInnerNfviPopAttributesResourceZoneAttributes> resourceZoneAttributes = new ArrayList<NfviPopsInnerNfviPopAttributesResourceZoneAttributes>();
  private @Valid String mecCapable = null;
  private @Valid List<MECRegionInfo> mecRegions = new ArrayList<MECRegionInfo>();
  private @Valid String radioCapable = null;
  private @Valid List<NfviPopsInnerNfviPopAttributesRadioCoverageAreas> radioCoverageAreas = new ArrayList<NfviPopsInnerNfviPopAttributesRadioCoverageAreas>();

  /**
   **/
  public NfviPopsInnerNfviPopAttributes pnflist(PNFlist pnflist) {
    this.pnflist = pnflist;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("pnflist")
  @NotNull
  public PNFlist getPnflist() {
    return pnflist;
  }
  public void setPnflist(PNFlist pnflist) {
    this.pnflist = pnflist;
  }

  /**
   * It provides information about the geographic location (e.g. geographic coordinates or address of the building, etc.) of the NFVI resources that the VIM manages.
   **/
  public NfviPopsInnerNfviPopAttributes geographicalLocationInfo(String geographicalLocationInfo) {
    this.geographicalLocationInfo = geographicalLocationInfo;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "It provides information about the geographic location (e.g. geographic coordinates or address of the building, etc.) of the NFVI resources that the VIM manages.")
  @JsonProperty("geographicalLocationInfo")
  @NotNull
  public String getGeographicalLocationInfo() {
    return geographicalLocationInfo;
  }
  public void setGeographicalLocationInfo(String geographicalLocationInfo) {
    this.geographicalLocationInfo = geographicalLocationInfo;
  }

  /**
   * Identification of the VIM.
   **/
  public NfviPopsInnerNfviPopAttributes vimId(String vimId) {
    this.vimId = vimId;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identification of the VIM.")
  @JsonProperty("vimId")
  @NotNull
  public String getVimId() {
    return vimId;
  }
  public void setVimId(String vimId) {
    this.vimId = vimId;
  }

  /**
   * Identification of the Federated VIM.
   **/
  public NfviPopsInnerNfviPopAttributes federatedVimId(String federatedVimId) {
    this.federatedVimId = federatedVimId;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identification of the Federated VIM.")
  @JsonProperty("federatedVimId")
  @NotNull
  public String getFederatedVimId() {
    return federatedVimId;
  }
  public void setFederatedVimId(String federatedVimId) {
    this.federatedVimId = federatedVimId;
  }

  /**
   **/
  public NfviPopsInnerNfviPopAttributes networkConnectivityEndpoint(List<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint> networkConnectivityEndpoint) {
    this.networkConnectivityEndpoint = networkConnectivityEndpoint;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("networkConnectivityEndpoint")
  @NotNull
  public List<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint> getNetworkConnectivityEndpoint() {
    return networkConnectivityEndpoint;
  }
  public void setNetworkConnectivityEndpoint(List<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint> networkConnectivityEndpoint) {
    this.networkConnectivityEndpoint = networkConnectivityEndpoint;
  }

  /**
   * Identification of the NFVI-PoP.
   **/
  public NfviPopsInnerNfviPopAttributes nfviPopId(String nfviPopId) {
    this.nfviPopId = nfviPopId;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identification of the NFVI-PoP.")
  @JsonProperty("nfviPopId")
  @NotNull
  public String getNfviPopId() {
    return nfviPopId;
  }
  public void setNfviPopId(String nfviPopId) {
    this.nfviPopId = nfviPopId;
  }

  /**
   **/
  public NfviPopsInnerNfviPopAttributes resourceZoneAttributes(List<NfviPopsInnerNfviPopAttributesResourceZoneAttributes> resourceZoneAttributes) {
    this.resourceZoneAttributes = resourceZoneAttributes;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("resourceZoneAttributes")
  @NotNull
  public List<NfviPopsInnerNfviPopAttributesResourceZoneAttributes> getResourceZoneAttributes() {
    return resourceZoneAttributes;
  }
  public void setResourceZoneAttributes(List<NfviPopsInnerNfviPopAttributesResourceZoneAttributes> resourceZoneAttributes) {
    this.resourceZoneAttributes = resourceZoneAttributes;
  }

  /**
   * Set if PoP contains MEC attributes
   **/
  public NfviPopsInnerNfviPopAttributes mecCapable(String mecCapable) {
    this.mecCapable = mecCapable;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Set if PoP contains MEC attributes")
  @JsonProperty("MecCapable")
  @NotNull
  public String getMecCapable() {
    return mecCapable;
  }
  public void setMecCapable(String mecCapable) {
    this.mecCapable = mecCapable;
  }

  /**
   **/
  public NfviPopsInnerNfviPopAttributes mecRegions(List<MECRegionInfo> mecRegions) {
    this.mecRegions = mecRegions;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("MecRegions")
  @NotNull
  public List<MECRegionInfo> getMecRegions() {
    return mecRegions;
  }
  public void setMecRegions(List<MECRegionInfo> mecRegions) {
    this.mecRegions = mecRegions;
  }

  /**
   * Set if PoP contains Radio attributes
   **/
  public NfviPopsInnerNfviPopAttributes radioCapable(String radioCapable) {
    this.radioCapable = radioCapable;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Set if PoP contains Radio attributes")
  @JsonProperty("RadioCapable")
  @NotNull
  public String getRadioCapable() {
    return radioCapable;
  }
  public void setRadioCapable(String radioCapable) {
    this.radioCapable = radioCapable;
  }

  /**
   **/
  public NfviPopsInnerNfviPopAttributes radioCoverageAreas(List<NfviPopsInnerNfviPopAttributesRadioCoverageAreas> radioCoverageAreas) {
    this.radioCoverageAreas = radioCoverageAreas;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("RadioCoverageAreas")
  public List<NfviPopsInnerNfviPopAttributesRadioCoverageAreas> getRadioCoverageAreas() {
    return radioCoverageAreas;
  }
  public void setRadioCoverageAreas(List<NfviPopsInnerNfviPopAttributesRadioCoverageAreas> radioCoverageAreas) {
    this.radioCoverageAreas = radioCoverageAreas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfviPopsInnerNfviPopAttributes nfviPopsInnerNfviPopAttributes = (NfviPopsInnerNfviPopAttributes) o;
    return Objects.equals(pnflist, nfviPopsInnerNfviPopAttributes.pnflist) &&
        Objects.equals(geographicalLocationInfo, nfviPopsInnerNfviPopAttributes.geographicalLocationInfo) &&
        Objects.equals(vimId, nfviPopsInnerNfviPopAttributes.vimId) &&
        Objects.equals(federatedVimId, nfviPopsInnerNfviPopAttributes.federatedVimId) &&
        Objects.equals(networkConnectivityEndpoint, nfviPopsInnerNfviPopAttributes.networkConnectivityEndpoint) &&
        Objects.equals(nfviPopId, nfviPopsInnerNfviPopAttributes.nfviPopId) &&
        Objects.equals(resourceZoneAttributes, nfviPopsInnerNfviPopAttributes.resourceZoneAttributes) &&
        Objects.equals(mecCapable, nfviPopsInnerNfviPopAttributes.mecCapable) &&
        Objects.equals(mecRegions, nfviPopsInnerNfviPopAttributes.mecRegions) &&
        Objects.equals(radioCapable, nfviPopsInnerNfviPopAttributes.radioCapable) &&
        Objects.equals(radioCoverageAreas, nfviPopsInnerNfviPopAttributes.radioCoverageAreas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pnflist, geographicalLocationInfo, vimId, federatedVimId, networkConnectivityEndpoint, nfviPopId, resourceZoneAttributes, mecCapable, mecRegions, radioCapable, radioCoverageAreas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfviPopsInnerNfviPopAttributes {\n");
    
    sb.append("    pnflist: ").append(toIndentedString(pnflist)).append("\n");
    sb.append("    geographicalLocationInfo: ").append(toIndentedString(geographicalLocationInfo)).append("\n");
    sb.append("    vimId: ").append(toIndentedString(vimId)).append("\n");
    sb.append("    federatedVimId: ").append(toIndentedString(federatedVimId)).append("\n");
    sb.append("    networkConnectivityEndpoint: ").append(toIndentedString(networkConnectivityEndpoint)).append("\n");
    sb.append("    nfviPopId: ").append(toIndentedString(nfviPopId)).append("\n");
    sb.append("    resourceZoneAttributes: ").append(toIndentedString(resourceZoneAttributes)).append("\n");
    sb.append("    mecCapable: ").append(toIndentedString(mecCapable)).append("\n");
    sb.append("    mecRegions: ").append(toIndentedString(mecRegions)).append("\n");
    sb.append("    radioCapable: ").append(toIndentedString(radioCapable)).append("\n");
    sb.append("    radioCoverageAreas: ").append(toIndentedString(radioCoverageAreas)).append("\n");
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

