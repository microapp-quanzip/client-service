package com.viettel.project.service.dto;

import lombok.Data;

@Data
public class ClientDetailDTO {
    private String clientId;
    private String clientSecret;
    private String resourceIds;
    private String grantType;
    private String redirectUrl;
    private String authorities;
    private String scopes;
    private int accessTokenTimeout;
    private int refreshTokenTimeout;
    private String additionalInformation;
    private int autoApprove;
}
