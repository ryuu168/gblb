-- create database gblb;
-- CREATE USER gblb_master@localhost IDENTIFIED BY "1Qazxsw2#";
-- GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@localhost;
CREATE USER gblb_master@localhost IDENTIFIED BY "1Qazxsw2#";
GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@localhost;
CREATE USER gblb_master@"%" IDENTIFIED BY "1Qazxsw2#";
GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@"%";
create database gblb;