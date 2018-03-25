# --- !Ups
CREATE TABLE `character_has_lbs` (
`lb_id` int(11) NOT NULL,
`character_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_bin;

insert into character_has_lbs(lb_id, character_id) values(1, 1);
insert into character_has_lbs(lb_id, character_id) values(5, 1);
insert into character_has_lbs(lb_id, character_id) values(9, 1);
insert into character_has_lbs(lb_id, character_id) values(77, 1);
insert into character_has_lbs(lb_id, character_id) values(27, 1);
insert into character_has_lbs(lb_id, character_id) values(2, 1);
insert into character_has_lbs(lb_id, character_id) values(6, 1);
insert into character_has_lbs(lb_id, character_id) values(78, 1);
insert into character_has_lbs(lb_id, character_id) values(81, 1);
insert into character_has_lbs(lb_id, character_id) values(33, 1);
insert into character_has_lbs(lb_id, character_id) values(79, 1);
insert into character_has_lbs(lb_id, character_id) values(80, 1);
insert into character_has_lbs(lb_id, character_id) values(82, 1);
insert into character_has_lbs(lb_id, character_id) values(12, 1);
insert into character_has_lbs(lb_id, character_id) values(113, 1);


# --- !Downs
DROP TABLE `character_has_lbs`;