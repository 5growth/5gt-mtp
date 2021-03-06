# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from mtp_plugin_kubernetes.models.base_model_ import Model
from mtp_plugin_kubernetes.models.reserved_virtual_network_network_attributes import ReservedVirtualNetworkNetworkAttributes  # noqa: F401,E501
from mtp_plugin_kubernetes.models.reserved_virtual_network_network_ports import ReservedVirtualNetworkNetworkPorts  # noqa: F401,E501
from mtp_plugin_kubernetes import util


class ReservedVirtualNetwork(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """

    def __init__(self, end_time: datetime=None, expiry_time: datetime=None, network_attributes: ReservedVirtualNetworkNetworkAttributes=None, network_ports: List[ReservedVirtualNetworkNetworkPorts]=None, public_ips: str=None, reservation_id: str=None, reservation_status: str=None, start_time: datetime=None, zone_id: str=None):  # noqa: E501
        """ReservedVirtualNetwork - a model defined in Swagger

        :param end_time: The end_time of this ReservedVirtualNetwork.  # noqa: E501
        :type end_time: datetime
        :param expiry_time: The expiry_time of this ReservedVirtualNetwork.  # noqa: E501
        :type expiry_time: datetime
        :param network_attributes: The network_attributes of this ReservedVirtualNetwork.  # noqa: E501
        :type network_attributes: ReservedVirtualNetworkNetworkAttributes
        :param network_ports: The network_ports of this ReservedVirtualNetwork.  # noqa: E501
        :type network_ports: List[ReservedVirtualNetworkNetworkPorts]
        :param public_ips: The public_ips of this ReservedVirtualNetwork.  # noqa: E501
        :type public_ips: str
        :param reservation_id: The reservation_id of this ReservedVirtualNetwork.  # noqa: E501
        :type reservation_id: str
        :param reservation_status: The reservation_status of this ReservedVirtualNetwork.  # noqa: E501
        :type reservation_status: str
        :param start_time: The start_time of this ReservedVirtualNetwork.  # noqa: E501
        :type start_time: datetime
        :param zone_id: The zone_id of this ReservedVirtualNetwork.  # noqa: E501
        :type zone_id: str
        """
        self.swagger_types = {
            'end_time': datetime,
            'expiry_time': datetime,
            'network_attributes': ReservedVirtualNetworkNetworkAttributes,
            'network_ports': List[ReservedVirtualNetworkNetworkPorts],
            'public_ips': str,
            'reservation_id': str,
            'reservation_status': str,
            'start_time': datetime,
            'zone_id': str
        }

        self.attribute_map = {
            'end_time': 'endTime',
            'expiry_time': 'expiryTime',
            'network_attributes': 'networkAttributes',
            'network_ports': 'networkPorts',
            'public_ips': 'publicIps',
            'reservation_id': 'reservationId',
            'reservation_status': 'reservationStatus',
            'start_time': 'startTime',
            'zone_id': 'zoneId'
        }

        self._end_time = end_time
        self._expiry_time = expiry_time
        self._network_attributes = network_attributes
        self._network_ports = network_ports
        self._public_ips = public_ips
        self._reservation_id = reservation_id
        self._reservation_status = reservation_status
        self._start_time = start_time
        self._zone_id = zone_id

    @classmethod
    def from_dict(cls, dikt) -> 'ReservedVirtualNetwork':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The ReservedVirtualNetwork of this ReservedVirtualNetwork.  # noqa: E501
        :rtype: ReservedVirtualNetwork
        """
        return util.deserialize_model(dikt, cls)

    @property
    def end_time(self) -> datetime:
        """Gets the end_time of this ReservedVirtualNetwork.

        Indication when the reservation ends (when it is expected that the resources will no longer be needed) and used by the VIM to schedule the reservation. If not present, resources are reserved for unlimited usage time.  # noqa: E501

        :return: The end_time of this ReservedVirtualNetwork.
        :rtype: datetime
        """
        return self._end_time

    @end_time.setter
    def end_time(self, end_time: datetime):
        """Sets the end_time of this ReservedVirtualNetwork.

        Indication when the reservation ends (when it is expected that the resources will no longer be needed) and used by the VIM to schedule the reservation. If not present, resources are reserved for unlimited usage time.  # noqa: E501

        :param end_time: The end_time of this ReservedVirtualNetwork.
        :type end_time: datetime
        """
        if end_time is None:
            raise ValueError("Invalid value for `end_time`, must not be `None`")  # noqa: E501

        self._end_time = end_time

    @property
    def expiry_time(self) -> datetime:
        """Gets the expiry_time of this ReservedVirtualNetwork.

        Indication when the VIM can release the reservation in case no allocation request against this reservation was made.  # noqa: E501

        :return: The expiry_time of this ReservedVirtualNetwork.
        :rtype: datetime
        """
        return self._expiry_time

    @expiry_time.setter
    def expiry_time(self, expiry_time: datetime):
        """Sets the expiry_time of this ReservedVirtualNetwork.

        Indication when the VIM can release the reservation in case no allocation request against this reservation was made.  # noqa: E501

        :param expiry_time: The expiry_time of this ReservedVirtualNetwork.
        :type expiry_time: datetime
        """
        if expiry_time is None:
            raise ValueError("Invalid value for `expiry_time`, must not be `None`")  # noqa: E501

        self._expiry_time = expiry_time

    @property
    def network_attributes(self) -> ReservedVirtualNetworkNetworkAttributes:
        """Gets the network_attributes of this ReservedVirtualNetwork.


        :return: The network_attributes of this ReservedVirtualNetwork.
        :rtype: ReservedVirtualNetworkNetworkAttributes
        """
        return self._network_attributes

    @network_attributes.setter
    def network_attributes(self, network_attributes: ReservedVirtualNetworkNetworkAttributes):
        """Sets the network_attributes of this ReservedVirtualNetwork.


        :param network_attributes: The network_attributes of this ReservedVirtualNetwork.
        :type network_attributes: ReservedVirtualNetworkNetworkAttributes
        """
        if network_attributes is None:
            raise ValueError("Invalid value for `network_attributes`, must not be `None`")  # noqa: E501

        self._network_attributes = network_attributes

    @property
    def network_ports(self) -> List[ReservedVirtualNetworkNetworkPorts]:
        """Gets the network_ports of this ReservedVirtualNetwork.

        List of specific network ports that have been reserved.  # noqa: E501

        :return: The network_ports of this ReservedVirtualNetwork.
        :rtype: List[ReservedVirtualNetworkNetworkPorts]
        """
        return self._network_ports

    @network_ports.setter
    def network_ports(self, network_ports: List[ReservedVirtualNetworkNetworkPorts]):
        """Sets the network_ports of this ReservedVirtualNetwork.

        List of specific network ports that have been reserved.  # noqa: E501

        :param network_ports: The network_ports of this ReservedVirtualNetwork.
        :type network_ports: List[ReservedVirtualNetworkNetworkPorts]
        """
        if network_ports is None:
            raise ValueError("Invalid value for `network_ports`, must not be `None`")  # noqa: E501

        self._network_ports = network_ports

    @property
    def public_ips(self) -> str:
        """Gets the public_ips of this ReservedVirtualNetwork.

        List of public IP addresses that have been reserved.  # noqa: E501

        :return: The public_ips of this ReservedVirtualNetwork.
        :rtype: str
        """
        return self._public_ips

    @public_ips.setter
    def public_ips(self, public_ips: str):
        """Sets the public_ips of this ReservedVirtualNetwork.

        List of public IP addresses that have been reserved.  # noqa: E501

        :param public_ips: The public_ips of this ReservedVirtualNetwork.
        :type public_ips: str
        """
        if public_ips is None:
            raise ValueError("Invalid value for `public_ips`, must not be `None`")  # noqa: E501

        self._public_ips = public_ips

    @property
    def reservation_id(self) -> str:
        """Gets the reservation_id of this ReservedVirtualNetwork.

        Identifier of the resource reservation.  # noqa: E501

        :return: The reservation_id of this ReservedVirtualNetwork.
        :rtype: str
        """
        return self._reservation_id

    @reservation_id.setter
    def reservation_id(self, reservation_id: str):
        """Sets the reservation_id of this ReservedVirtualNetwork.

        Identifier of the resource reservation.  # noqa: E501

        :param reservation_id: The reservation_id of this ReservedVirtualNetwork.
        :type reservation_id: str
        """
        if reservation_id is None:
            raise ValueError("Invalid value for `reservation_id`, must not be `None`")  # noqa: E501

        self._reservation_id = reservation_id

    @property
    def reservation_status(self) -> str:
        """Gets the reservation_status of this ReservedVirtualNetwork.

        Status of the network resource reservation, e.g. to indicate if a reservation is being used.  # noqa: E501

        :return: The reservation_status of this ReservedVirtualNetwork.
        :rtype: str
        """
        return self._reservation_status

    @reservation_status.setter
    def reservation_status(self, reservation_status: str):
        """Sets the reservation_status of this ReservedVirtualNetwork.

        Status of the network resource reservation, e.g. to indicate if a reservation is being used.  # noqa: E501

        :param reservation_status: The reservation_status of this ReservedVirtualNetwork.
        :type reservation_status: str
        """
        if reservation_status is None:
            raise ValueError("Invalid value for `reservation_status`, must not be `None`")  # noqa: E501

        self._reservation_status = reservation_status

    @property
    def start_time(self) -> datetime:
        """Gets the start_time of this ReservedVirtualNetwork.

        Indication when the consumption of the resources starts. If the value is 0, resources are reserved for immediate use.  # noqa: E501

        :return: The start_time of this ReservedVirtualNetwork.
        :rtype: datetime
        """
        return self._start_time

    @start_time.setter
    def start_time(self, start_time: datetime):
        """Sets the start_time of this ReservedVirtualNetwork.

        Indication when the consumption of the resources starts. If the value is 0, resources are reserved for immediate use.  # noqa: E501

        :param start_time: The start_time of this ReservedVirtualNetwork.
        :type start_time: datetime
        """
        if start_time is None:
            raise ValueError("Invalid value for `start_time`, must not be `None`")  # noqa: E501

        self._start_time = start_time

    @property
    def zone_id(self) -> str:
        """Gets the zone_id of this ReservedVirtualNetwork.

        References the resource zone where the virtual network resources have been reserved. Cardinality can be 0 to cover the case where reserved network resources are not bound to a specific resource zone.  # noqa: E501

        :return: The zone_id of this ReservedVirtualNetwork.
        :rtype: str
        """
        return self._zone_id

    @zone_id.setter
    def zone_id(self, zone_id: str):
        """Sets the zone_id of this ReservedVirtualNetwork.

        References the resource zone where the virtual network resources have been reserved. Cardinality can be 0 to cover the case where reserved network resources are not bound to a specific resource zone.  # noqa: E501

        :param zone_id: The zone_id of this ReservedVirtualNetwork.
        :type zone_id: str
        """
        if zone_id is None:
            raise ValueError("Invalid value for `zone_id`, must not be `None`")  # noqa: E501

        self._zone_id = zone_id
