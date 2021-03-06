# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.location_info import LocationInfo  # noqa: F401,E501
from swagger_server import util


class MECRegionInfoMECRegionInfo(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """

    def __init__(self, region_id: str=None, location_info: LocationInfo=None):  # noqa: E501
        """MECRegionInfoMECRegionInfo - a model defined in Swagger

        :param region_id: The region_id of this MECRegionInfoMECRegionInfo.  # noqa: E501
        :type region_id: str
        :param location_info: The location_info of this MECRegionInfoMECRegionInfo.  # noqa: E501
        :type location_info: LocationInfo
        """
        self.swagger_types = {
            'region_id': str,
            'location_info': LocationInfo
        }

        self.attribute_map = {
            'region_id': 'RegionId',
            'location_info': 'LocationInfo'
        }

        self._region_id = region_id
        self._location_info = location_info

    @classmethod
    def from_dict(cls, dikt) -> 'MECRegionInfoMECRegionInfo':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The MECRegionInfo_MECRegionInfo of this MECRegionInfoMECRegionInfo.  # noqa: E501
        :rtype: MECRegionInfoMECRegionInfo
        """
        return util.deserialize_model(dikt, cls)

    @property
    def region_id(self) -> str:
        """Gets the region_id of this MECRegionInfoMECRegionInfo.

        Identifier of the region.  # noqa: E501

        :return: The region_id of this MECRegionInfoMECRegionInfo.
        :rtype: str
        """
        return self._region_id

    @region_id.setter
    def region_id(self, region_id: str):
        """Sets the region_id of this MECRegionInfoMECRegionInfo.

        Identifier of the region.  # noqa: E501

        :param region_id: The region_id of this MECRegionInfoMECRegionInfo.
        :type region_id: str
        """

        self._region_id = region_id

    @property
    def location_info(self) -> LocationInfo:
        """Gets the location_info of this MECRegionInfoMECRegionInfo.


        :return: The location_info of this MECRegionInfoMECRegionInfo.
        :rtype: LocationInfo
        """
        return self._location_info

    @location_info.setter
    def location_info(self, location_info: LocationInfo):
        """Sets the location_info of this MECRegionInfoMECRegionInfo.


        :param location_info: The location_info of this MECRegionInfoMECRegionInfo.
        :type location_info: LocationInfo
        """

        self._location_info = location_info
