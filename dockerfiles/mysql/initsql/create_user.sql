-- create database kodo;
-- CREATE USER gblb_master@localhost IDENTIFIED BY "1Qaxsw2#";
-- GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@localhost;
CREATE USER gblb_master@localhost IDENTIFIED BY "1Qaxsw2#";
GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@localhost;
CREATE USER gblb_master@"%" IDENTIFIED BY "1Qaxsw2#";
GRANT ALL PRIVILEGES ON gblb.* TO gblb_master@"%";
create database gblb;