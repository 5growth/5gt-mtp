/***************************** APPD SAMPLE DATA *****************************/
/*------------------ appD robotics -------------------------*/

/*insert AppD global info */
INSERT INTO `mtpappddb`.`appd`
(`appDId`,
`appName`,
`appProvider`,
`appSoftVersion`,
`appDVersion`,
`mecVersion`,
`appInfoName`,
`appDescription`)
VALUES
(1,
"robot-control-app",
"pfrag",
"1.0",
"1.0",
"1.0",
"robot-control-app",
"app for controlling mobile robot");

/*insert virtual compute descriptor*/

INSERT INTO `mtpappddb`.`virtualcomputedescriptor`
(`virtualComputeDescId`,
`appDId`)
VALUES
("1c0897de-bc1a-4730-9d99-364fa83d7643",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualmemory`
(`virtualMemSize`,
`numaEnabled`,
`virtualMemOversubscriptionPolicy`,
`appDId`)
VALUES
(1024,
0,
"none",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualcpu`
(`cpuArchitecture`,
`numVirtualCpu`,
`virtualCpuClock`,
`virtualCpuOversubscriptionPolicy`,
`appDId`)
VALUES
("x86_64",
"1",
"0",
"string",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualcpupinning`
(`cpuPinningPolicy`,
`cpuPinningMap`,
`appDId`)
VALUES
("static",
"",
1); /*appdid key*/

/*insert sofware image descriptor*/
INSERT INTO `mtpappddb`.`swimagedescriptor`
(`id`,
`name`,
`version`,
`checksum_`,
`containerFormat`,
`diskFormat`,
`minDisk`,
`minRam`,
`size_`,
`swImage`,
`operatingSystem`,
`supportedVirtualizationEnvironment`,
`appDId`)
VALUES
(10,  /*id used as key in db*/
"robotctrl",
"1.0",
"",
"lxd_unified",
"rootfs",
"1",
"512",
"512",
"http://127.0.0.1/lxdimages/robotctrl.tar.gz",
"",
"lxd",
1); /*appdid key*/


/*insert storage image descriptor*/
INSERT INTO `mtpappddb`.`virtualstoragedescriptor`
(`id`,
`typeOfStorage`,
`sizeOfStorage`,
`rdmaEnabled`,
`swImageDesc`,
`appDId`)
VALUES
(11, /*used as key in DB*/
"",
"1",
1,
"",
1); /*appdid key*/

/*insert app service required*/
INSERT INTO `mtpappddb`.`appservicerequired`
(`serviceRequiredId`,
`serName`,
`version`,
`requestedPermissions`,
`appDId`)
VALUES
(10, /*key if DB*/
"RNIS",
"1.0",
"",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`sertransportdependencies`
(`serTransportDependenciesId`,
`serializers`,
`labels`,
`serviceRequiredId`)
VALUES
(20,
"JSON",
"",
10); /*key of service required id table*/

INSERT INTO `mtpappddb`.`sertransport`
(`transportType`,
`protocol`,
`version`,
`security`,
`serTransportDependenciesId`)
VALUES
("REST_HTTP",
"",
"",
"",
20); /*key of serTransportDependenciesId table*/

INSERT INTO `mtpappddb`.`sercategory`
(`href`,
`id`,
`name`,
`version`,
`serviceRequiredId`)
VALUES
("",
"",
"",
"",
10); /*key of service required id table*/

/*insert app service optional*/
INSERT INTO `mtpappddb`.`appserviceoptional`
(`serviceRequiredId`,
`serName`,
`version`,
`requestedPermissions`,
`appDId`)
VALUES
(30,
"",
"",
"",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`sertransportdependenciesoptional`
(`serTransportDependenciesId`,
`serializers`,
`labels`,
`serviceRequiredId`)
VALUES
(31,
"JSON",
"",
30); /*key of service required id optional table*/

INSERT INTO `mtpappddb`.`transportdescriptoroptional`
(`transportType`,
`protocol`,
`version`,
`security`,
`serTransportDependenciesId`)
VALUES
("REST_HTTP",
"",
"",
"",
31); /*key of serTransportDependenciesId optional table*/

INSERT INTO `mtpappddb`.`sercategoryoptional`
(`href`,
`id`,
`name`,
`version`,
`serviceRequiredId`)
VALUES
("",
"",
"",
"",
30); /*key of service required id optional table*/

/*insert transport dependencies*/
INSERT INTO `mtpappddb`.`transportdependencies`
(`transportdependenciesId`,
`serializers`,
`labels`,
`appDId`)
VALUES
(40,
"JSON",
"",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`transport`
(`transportType`,
`protocol`,
`version`,
`security`,
`transportDependenciesId`)
VALUES
("REST_HTTP",
"",
"",
"",
40); /*key of sTransportDependenciesId  table*/

/*insert app traffic rules*/
INSERT INTO `mtpappddb`.`apptrafficrule`
(`trafficRuleId`,
`filterType`,
`priority`,
`action`,
`appDId`)
VALUES
(15, /*key of the DB*/
"FLOW",
"0",
"FORWARD",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`trafficfilter`
(`trafficFilterId`,
`srcAddress`,
`dstAddress`,
`srcPort`,
`dstPort`,
`protocol`,
`token`,
`srcTunnelAddress`,
`dstTunnelAddress`,
`srcTunnelPort`,
`dstTunnelPort`,
`qci`,
`dscp`,
`tc`,
`trafficRuleId`)
VALUES
(16,
"208930100001114",
"172.16.0.100",
"",
"9990",
"tcp",
"",
"",
"",
"",
"",
"",
"",
"",
15); /*key of traffic rule id table*/

/*INSERT INTO `mtpappddb`.`dstinterface`
(`dstInterfaceId`,
`interfaceType`,
`srcMACAddress`,
`dstMACAddress`,
`dstIPAddress`,
`trafficRuleId`)
VALUES
(<{dstInterfaceId: }>,
<{interfaceType: }>,
<{srcMACAddress: }>,
<{dstMACAddress: }>,
<{dstIPAddress: }>,
<{trafficRuleId: }>);

INSERT INTO `mtpappddb`.`tunnelinfo`
(`tunnelType`,
`tunnelDstAddress`,
`tunnelSrcAddress`,
`tunnelSpecificData`,
`dstInterfaceId`)
VALUES
(<{tunnelType: }>,
<{tunnelDstAddress: }>,
<{tunnelSrcAddress: }>,
<{tunnelSpecificData: }>,
<{dstInterfaceId: }>); */

/*insert app DNS rules*/
INSERT INTO `mtpappddb`.`appdnsrule`
(`dnsRuleId`,
`domainName`,
`ipAddressType`,
`ipAddress`,
`ttl`,
`appDId`)
VALUES
(61, /*key of dns rules*/
"robot.control",
"IP_V4",
"0.0.0.0",
"0",
1); /*appdid key*/

INSERT INTO `mtpappddb`.`appdnsrule`
(`dnsRuleId`,
`domainName`,
`ipAddressType`,
`ipAddress`,
`ttl`,
`appDId`)
VALUES
(62, /*key of dns rules*/
"sfr.fr",
"IP_V4",
"0.0.0.0",
"0",
1); /*appdid key*/


/*insert app latency rules*/
INSERT INTO `mtpappddb`.`applatency`
(`timeUnit`,
`latency`,
`appDId`)
VALUES
("ms",
"100",
1); /*appdid key*/


/*insert terminate app instance config*/
INSERT INTO `mtpappddb`.`terminateappinstanceopconfig`
(`minGracefulTerminationTimeout`,
`macRecommendedGracefulTerminationTimeout`,
`appDId`)
VALUES
("0",
"0",
1); /*appdid key*/

/*insert change app instance config*/
INSERT INTO `mtpappddb`.`changeappinstancestateopconfig`
(`minGracefulTerminationTimeout`,
`macRecommendedGracefulTerminationTimeout`,
`appDId`)
VALUES
("0",
"0",
1); /*appdid key*/



/*------------------ appD edge-cache -------------------------*/
/*insert AppD global info */
INSERT INTO `mtpappddb`.`appd`
(`appDId`,
`appName`,
`appProvider`,
`appSoftVersion`,
`appDVersion`,
`mecVersion`,
`appInfoName`,
`appDescription`)
VALUES
(2,
"edgecache",
"pfrag",
"1.0",
"1.0",
"1.0",
"edgecache",
"edge cache application");

/*insert virtual compute descriptor*/

INSERT INTO `mtpappddb`.`virtualcomputedescriptor`
(`virtualComputeDescId`,
`appDId`)
VALUES
("1c0897de-bc1a-4730-9d99-364fa83d7643",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualmemory`
(`virtualMemSize`,
`numaEnabled`,
`virtualMemOversubscriptionPolicy`,
`appDId`)
VALUES
(1024,
0,
"none",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualcpu`
(`cpuArchitecture`,
`numVirtualCpu`,
`virtualCpuClock`,
`virtualCpuOversubscriptionPolicy`,
`appDId`)
VALUES
("x86_64",
"1",
"0",
"string",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`virtualcpupinning`
(`cpuPinningPolicy`,
`cpuPinningMap`,
`appDId`)
VALUES
("static",
"",
2); /*appdid key*/

/*insert sofware image descriptor*/
INSERT INTO `mtpappddb`.`swimagedescriptor`
(`id`,
`name`,
`version`,
`checksum_`,
`containerFormat`,
`diskFormat`,
`minDisk`,
`minRam`,
`size_`,
`swImage`,
`operatingSystem`,
`supportedVirtualizationEnvironment`,
`appDId`)
VALUES
(12,  /*id used as key in db*/
"robotctrl",
"1.0",
"",
"lxd_unified",
"rootfs",
"1",
"512",
"512",
"http://path-to-edge-cache-image.tar.gz",
"",
"lxd",
2); /*appdid key*/


/*insert storage image descriptor*/
INSERT INTO `mtpappddb`.`virtualstoragedescriptor`
(`id`,
`typeOfStorage`,
`sizeOfStorage`,
`rdmaEnabled`,
`swImageDesc`,
`appDId`)
VALUES
(12, /*used as key in DB*/
"",
"1",
1,
"",
2); /*appdid key*/

/*insert app traffic rules*/
INSERT INTO `mtpappddb`.`apptrafficrule`
(`trafficRuleId`,
`filterType`,
`priority`,
`action`,
`appDId`)
VALUES
(22, /*key of the DB*/
"FLOW",
"0",
"FORWARD",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`trafficfilter`
(`trafficFilterId`,
`srcAddress`,
`dstAddress`,
`srcPort`,
`dstPort`,
`protocol`,
`token`,
`srcTunnelAddress`,
`dstTunnelAddress`,
`srcTunnelPort`,
`dstTunnelPort`,
`qci`,
`dscp`,
`tc`,
`trafficRuleId`)
VALUES
(32,
"208930100001114",
"172.16.0.100",
"",
"9990",
"tcp",
"",
"",
"",
"",
"",
"",
"",
"",
22); /*key of traffic rule id table*/

/*INSERT INTO `mtpappddb`.`dstinterface`
(`dstInterfaceId`,
`interfaceType`,
`srcMACAddress`,
`dstMACAddress`,
`dstIPAddress`,
`trafficRuleId`)
VALUES
(<{dstInterfaceId: }>,
<{interfaceType: }>,
<{srcMACAddress: }>,
<{dstMACAddress: }>,
<{dstIPAddress: }>,
<{trafficRuleId: }>);

INSERT INTO `mtpappddb`.`tunnelinfo`
(`tunnelType`,
`tunnelDstAddress`,
`tunnelSrcAddress`,
`tunnelSpecificData`,
`dstInterfaceId`)
VALUES
(<{tunnelType: }>,
<{tunnelDstAddress: }>,
<{tunnelSrcAddress: }>,
<{tunnelSpecificData: }>,
<{dstInterfaceId: }>); */

/*insert app DNS rules*/
INSERT INTO `mtpappddb`.`appdnsrule`
(`dnsRuleId`,
`domainName`,
`ipAddressType`,
`ipAddress`,
`ttl`,
`appDId`)
VALUES
(71, /*key of dns rules*/
"edge.cache.cdn",
"IP_V4",
"0.0.0.0",
"0",
2); /*appdid key*/




/*insert app latency rules*/
INSERT INTO `mtpappddb`.`applatency`
(`timeUnit`,
`latency`,
`appDId`)
VALUES
("ms",
"100",
2); /*appdid key*/


/*insert terminate app instance config*/
INSERT INTO `mtpappddb`.`terminateappinstanceopconfig`
(`minGracefulTerminationTimeout`,
`macRecommendedGracefulTerminationTimeout`,
`appDId`)
VALUES
("0",
"0",
2); /*appdid key*/

/*insert change app instance config*/
INSERT INTO `mtpappddb`.`changeappinstancestateopconfig`
(`minGracefulTerminationTimeout`,
`macRecommendedGracefulTerminationTimeout`,
`appDId`)
VALUES
("0",
"0",
2); /*appdid key*/

/*insert app ext CPD*/
INSERT INTO `mtpappddb`.`appextcpd`
(`cpdId`,
`layerProtocol`,
`cpRole`,
`description`,
`appDId`)
VALUES
(92, /*key of DB**/
"Ethernet",
"ROOT",
"MEC CPD",
2); /*appdid key*/

/*INSERT INTO `mtpappddb`.`virtualnetworkinterfacerequirements`
(`virtualNetworkInterfaceRequirementsId`,
`name`,
`description`,
`supportMandatory`,
`requirement`,
`cpdId`)
VALUES
(<{virtualNetworkInterfaceRequirementsId: }>,
<{name: }>,
<{description: }>,
<{supportMandatory: }>,
<{requirement: }>,
<{cpdId: }>);

INSERT INTO `mtpappddb`.`addressdata`
(`addressdataId`,
`addressType`,
`l2AddressData`,
`l3AddressData`,
`cpdId`)
VALUES
(<{addressdataId: }>,
<{addressType: }>,
<{l2AddressData: }>,
<{l3AddressData: }>,
<{cpdId: }>); */

INSERT INTO `mtpappddb`.`appextcpd`
(`cpdId`,
`layerProtocol`,
`cpRole`,
`description`,
`appDId`)
VALUES
(93, /*key of DB*/
"Ethernet",
"ROOT",
"CP retrieving origin server data",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`appextcpd`
(`cpdId`,
`layerProtocol`,
`cpRole`,
`description`,
`appDId`)
VALUES
(94, /*key of DB**/
"Ethernet",
"ROOT",
"CP for delivering video to clients",
2); /*appdid key*/

INSERT INTO `mtpappddb`.`appextcpd`
(`cpdId`,
`layerProtocol`,
`cpRole`,
`description`,
`appDId`)
VALUES
(95, /*key of DB**/
"Ethernet",
"ROOT",
"CP management network",
2); /*appdid key*/