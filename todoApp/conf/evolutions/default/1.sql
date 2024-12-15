# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tasks (
  id                        bigint not null,
  label                     varchar(255),
  editable                  boolean,
  constraint pk_tasks primary key (id))
;

create sequence tasks_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tasks;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tasks_seq;

