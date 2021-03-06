/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not
 * use this file except in compliance with the License. A copy of the License is
 * located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.ec2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * CreateNetworkInterfaceRequest Marshaller
 */

public class CreateNetworkInterfaceRequestMarshaller
        implements
        Marshaller<Request<CreateNetworkInterfaceRequest>, CreateNetworkInterfaceRequest> {

    public Request<CreateNetworkInterfaceRequest> marshall(
            CreateNetworkInterfaceRequest createNetworkInterfaceRequest) {

        if (createNetworkInterfaceRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<CreateNetworkInterfaceRequest> request = new DefaultRequest<CreateNetworkInterfaceRequest>(
                createNetworkInterfaceRequest, "AmazonEC2");
        request.addParameter("Action", "CreateNetworkInterface");
        request.addParameter("Version", "2016-04-01");
        request.setHttpMethod(HttpMethodName.POST);

        if (createNetworkInterfaceRequest.getSubnetId() != null) {
            request.addParameter("SubnetId", StringUtils
                    .fromString(createNetworkInterfaceRequest.getSubnetId()));
        }

        if (createNetworkInterfaceRequest.getDescription() != null) {
            request.addParameter("Description", StringUtils
                    .fromString(createNetworkInterfaceRequest.getDescription()));
        }

        if (createNetworkInterfaceRequest.getPrivateIpAddress() != null) {
            request.addParameter("PrivateIpAddress", StringUtils
                    .fromString(createNetworkInterfaceRequest
                            .getPrivateIpAddress()));
        }

        com.amazonaws.internal.SdkInternalList<String> groupsList = (com.amazonaws.internal.SdkInternalList<String>) createNetworkInterfaceRequest
                .getGroups();
        if (!groupsList.isEmpty() || !groupsList.isAutoConstruct()) {
            int groupsListIndex = 1;

            for (String groupsListValue : groupsList) {
                if (groupsListValue != null) {
                    request.addParameter("SecurityGroupId." + groupsListIndex,
                            StringUtils.fromString(groupsListValue));
                }
                groupsListIndex++;
            }
        }

        com.amazonaws.internal.SdkInternalList<PrivateIpAddressSpecification> privateIpAddressesList = (com.amazonaws.internal.SdkInternalList<PrivateIpAddressSpecification>) createNetworkInterfaceRequest
                .getPrivateIpAddresses();
        if (!privateIpAddressesList.isEmpty()
                || !privateIpAddressesList.isAutoConstruct()) {
            int privateIpAddressesListIndex = 1;

            for (PrivateIpAddressSpecification privateIpAddressesListValue : privateIpAddressesList) {

                if (privateIpAddressesListValue.getPrivateIpAddress() != null) {
                    request.addParameter(
                            "PrivateIpAddresses." + privateIpAddressesListIndex
                                    + ".PrivateIpAddress", StringUtils
                                    .fromString(privateIpAddressesListValue
                                            .getPrivateIpAddress()));
                }

                if (privateIpAddressesListValue.getPrimary() != null) {
                    request.addParameter("PrivateIpAddresses."
                            + privateIpAddressesListIndex + ".Primary",
                            StringUtils.fromBoolean(privateIpAddressesListValue
                                    .getPrimary()));
                }
                privateIpAddressesListIndex++;
            }
        }

        if (createNetworkInterfaceRequest.getSecondaryPrivateIpAddressCount() != null) {
            request.addParameter("SecondaryPrivateIpAddressCount", StringUtils
                    .fromInteger(createNetworkInterfaceRequest
                            .getSecondaryPrivateIpAddressCount()));
        }

        return request;
    }

}
