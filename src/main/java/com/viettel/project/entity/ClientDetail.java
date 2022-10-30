package com.viettel.project.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class ClientDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Column(name = "authorized_grant_types")
    private String grantType;

    @Column(name = "web_server_redirect_uri")
    private String redirectUrl;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "scope")
    private String scopes;

    @Column(name = "access_token_validity")
    private int accessTokenTimeout;

    @Column(name = "refresh_token_validity")
    private int refreshTokenTimeout;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "autoapprove")
    private int autoApprove;
}
