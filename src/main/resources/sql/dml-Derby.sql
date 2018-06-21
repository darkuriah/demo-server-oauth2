DELETE FROM oauth_user_authority;
DELETE FROM oauth_authority;
DELETE FROM oauth_user;
DELETE FROM oauth_client_details;

INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, access_token_validity, refresh_token_validity, additional_information) 
VALUES ('demo-client', '$2a$10$oTRfll.BUFUOI5KJHlpYZOC5WM3R.tJ6wQEV2ja6YF3AFAp7eaQ1q', 'read,write,trust', 'password,authorization_code,refresh_token,implicit', 3600, 21600, '{}');

INSERT INTO oauth_user (username, password, activated) 
VALUES ('hiro', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', true);
INSERT INTO oauth_user (username, password, activated) 
VALUES ('hiroyuki', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', true);

INSERT INTO oauth_authority (name)
VALUES ('ROLE_USER');

INSERT INTO oauth_authority (name)
VALUES ('ROLE_ADMIN');

INSERT INTO oauth_user_authority (username, authority)
VALUES ('hiro', 'ROLE_USER');

INSERT INTO oauth_user_authority (username, authority)
VALUES ('hiroyuki', 'ROLE_ADMIN');