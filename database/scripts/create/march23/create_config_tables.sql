create table role_apis (id integer not null, id_active bit, id_deleted bit, created_date datetime(6), version integer, description varchar(255), updated_date datetime(6), app_api_id integer, role_id integer, primary key (id));
create table sn_apis (id integer not null, id_active bit, id_deleted bit, created_date datetime(6), version integer, description varchar(255), updated_date datetime(6), urls varchar(255), primary key (id));
create table sn_role (id integer not null, id_active bit, id_deleted bit, created_date datetime(6), version integer, description varchar(255), updated_date datetime(6), role varchar(255), primary key (id));
create table sn_user (id integer not null, id_active bit, id_deleted bit, created_date datetime(6), version integer, description varchar(255), updated_date datetime(6), password varchar(255), user_name varchar(255), primary key (id)) ;
create table user_role (id integer not null, id_active bit, id_deleted bit, created_date datetime(6), version integer, description varchar(255), updated_date datetime(6), role_id integer, user_id integer, primary key (id));
alter table role_apis add constraint FK1ew5w5uawiw9fn6itavx6cqh9 foreign key (app_api_id) references sn_apis (id);
alter table role_apis add constraint FKsdfpaerli5y9jbnp4mt8sf6wi foreign key (role_id) references sn_role (id);
alter table user_role add constraint FKemc7pwtidshc4xb7o7e21u0qc foreign key (role_id) references sn_role (id);
alter table user_role add constraint FK2avfqglpbdq1kw8rkwn92q3le foreign key (user_id) references sn_user (id);