# Copyright 2018 b<>com. All rights reserved.
# This software is the confidential intellectual property of b<>com. You shall
# not disclose it and shall use it only in accordance with the terms of the
# license agreement you entered into with b<>com.
# IDDN number:
#
# -*- coding: utf-8 -*-

from flasgger import fields
from flasgger import Schema


# Compute Quota

class VirtualComputeQuotaData(Schema):
    numVCPUs = fields.Int(
        required=True,
        description='Number of CPU cores to be restricted by the quota. The '
                    'cardinality can be 0 if no specific number of CPU cores '
                    'is to be restricted by the quota or the quota for CPU '
                    'cores is not to be update.')
    numVcInstances = fields.Int(
        required=True,
        description='Number of virtualisation container instances to be '
                    'restricted by the quota. The cardinality can be 0 if no '
                    'specific number of virtualisation container instances is '
                    'to be restricted by the quota or the quota for '
                    'virtualisation container instances is not to be update.')
    virtualMemSize = fields.Number(
        required=True,
        description='Size of virtual memory to be restricted by the quota. '
                    'The cardinality can be 0 if no specific size of virtual '
                    'memory is to be restricted by the quota or the quota for '
                    'virtual memory is not to be update.')


class VirtualComputeQuota(Schema):
    resourceGroupId = fields.Str(
        required=True,
        description='Unique identifier of the "infrastructure resource '
                    'group", logical grouping of virtual resources assigned '
                    'to a tenant within an Infrastructure Domain.')
    numVCPUs = fields.Int(
        required=True,
        description='Number of CPU cores that have been restricted by the '
                    'quota. The cardinality can be 0 if no specific number of '
                    'CPU cores has been requested to be restricted by the '
                    'quota.')
    numVcInstances = fields.Int(
        required=True,
        description='Number of virtualisation container instances that have '
                    'been restricted by the quota. The cardinality can be 0 '
                    'if no specific number of CPU cores has been requested to '
                    'be restricted by the quota.')
    virtualMemSize = fields.Number(
        required=True,
        description='Size of virtual memory that has been restricted by the '
                    'quota. The cardinality can be 0 if no specific number of '
                    'CPU cores has been requested to be restricted by the '
                    'quota.')


# Network Quota


class VirtualNetworkQuotaData(Schema):
    numPublicIps = fields.Int(
        required=True,
        description='Number of public IP addresses to be restricted by the '
                    'quota. The cardinality can be 0 if no specific number of '
                    'public IP addresses is to be restricted by the quota or '
                    'the quota for public IP addresses is not to be update.')
    numPorts = fields.Int(
        required=True,
        description='Number of ports to be restricted by the quota. The '
                    'cardinality can be 0 if no specific number of ports is '
                    'to be restricted by the quota or the quota for ports is '
                    'not to be update.')
    numSubnets = fields.Int(
        required=True,
        description='Number of subnets to be restricted by the quota. The '
                    'cardinality can be 0 if no specific number of subnets is '
                    'to be restricted by the quota or the quota for subnets '
                    'is not to be update.')


class VirtualNetworkQuota(Schema):
    resourceGroupId = fields.Str(
        required=True,
        description='Unique identifier of the "infrastructure resource '
                    'group", logical grouping of virtual resources assigned '
                    'to a tenant within an Infrastructure Domain.')
    numPublicIps = fields.Int(
        required=True,
        description='Number of public IP addresses that have been restricted '
                    'by the quota. The cardinality can be 0 if no specific '
                    'number of public IP addresses has been requested to be '
                    'restricted by the quota.')
    numPorts = fields.Int(
        required=True,
        description='Number of ports that have been restricted by the quota. '
                    'The cardinality can be 0 if no specific number of ports '
                    'has been requested to be restricted by the quota.')
    numSubnets = fields.Int(
        required=True,
        description='Number of subnets that have been restricted by the '
                    'quota. The cardinality can be 0 if no specific number of '
                    'subnets has been requested to be restricted by the '
                    'quota.')


class ResourceGroupIds(Schema):
    resourceGroupId = fields.Str(
        required=True,
        many=True,
        description='Unique identifier of the "infrastructure resource '
                    'group", logical grouping of virtual resources assigned '
                    'to a tenant within an Infrastructure Domain.')
