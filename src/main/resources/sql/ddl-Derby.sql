DROP TABLE oauth_user_authority;
DROP TABLE oauth_authority;
DROP TABLE oauth_access_token;
DROP TABLE oauth_refresh_token;
DROP TABLE oauth_code;
DROP TABLE oauth_approvals;
DROP TABLE oauth_client_details;
DROP TABLE oauth_user;

CREATE TABLE oauth_user (
    username VARCHAR(63) PRIMARY KEY,
    email VARCHAR(63),
    password VARCHAR(511),
    activated BOOLEAN DEFAULT FALSE,
    activation_key VARCHAR(63),
    reset_password_key VARCHAR(63)
);

CREATE TABLE oauth_authority (
    name VARCHAR(63) PRIMARY KEY
);

CREATE TABLE oauth_user_authority (
    username VARCHAR(63) NOT NULL,
    authority VARCHAR(63) NOT NULL
);

CREATE TABLE oauth_access_token (
    token_id VARCHAR(255),
    token BLOB,
    authentication_id VARCHAR(255),
    user_name VARCHAR(255),
    client_id VARCHAR(255),
    authentication BLOB,
    refresh_token VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
    token_id VARCHAR(255),
    token BLOB,
    authentication BLOB
);

CREATE TABLE oauth_code (
    code VARCHAR(256), 
    authentication BLOB
);

CREATE TABLE oauth_approvals (
    userId VARCHAR(256),
    clientId VARCHAR(256),
    scope VARCHAR(256),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

CREATE TABLE oauth_client_details (
    client_id VARCHAR(255) PRIMARY KEY,
    resource_ids VARCHAR(255),
    client_secret VARCHAR(255),
    scope VARCHAR(255),
    authorized_grant_types VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities VARCHAR(255),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4095),
    autoapprove VARCHAR(255)
);
