-- SCHEMA: issue

-- DROP SCHEMA IF EXISTS issue ;

CREATE SCHEMA IF NOT EXISTS issue
    AUTHORIZATION postgres;
	
-- Table: issue.user

-- DROP TABLE IF EXISTS issue.users;

CREATE TABLE IF NOT EXISTS issue.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    designation character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS issue.users
    OWNER to postgres;

-- Table: issue.team

-- DROP TABLE IF EXISTS issue.team;

CREATE TABLE IF NOT EXISTS issue.team
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1)PRIMARY KEY,
    name character varying COLLATE pg_catalog."default"
		)
		
TABLESPACE pg_default;

ALTER TABLE IF EXISTS issue.team
    OWNER to postgres;

-- Table: issue.team_users

-- DROP TABLE IF EXISTS issue.team_users;
	
CREATE TABLE IF NOT EXISTS issue.team_users (
    team_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY(team_id) REFERENCES issue.team(id) ON DELETE CASCADE,
    FOREIGN KEY(user_id) REFERENCES issue.users(id) ON DELETE CASCADE,
    UNIQUE(team_id, user_id)
);

ALTER TABLE IF EXISTS issue.team_users
    OWNER to postgres;
/* -- Table: issue.team_member

-- DROP TABLE IF EXISTS issue.team_member;

CREATE TABLE IF NOT EXISTS issue.team_member
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1) PRIMARY KEY,
    team_id INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_team
        FOREIGN KEY (team_id)
        REFERENCES issue.team (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES issue.users (id)
        ON DELETE CASCADE,
    CONSTRAINT unique_team_user UNIQUE (team_id, user_id)	
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS issue.team_member
    OWNER to postgres; */

-- Table: issue.project

-- DROP TABLE IF EXISTS issue.project;

CREATE TABLE IF NOT EXISTS issue.project
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    description character varying,
	created_by integer,
	updated_by integer,
	team_id integer,
    CONSTRAINT project_pkey PRIMARY KEY (id),
	CONSTRAINT created_by_fkey FOREIGN KEY (created_by)
		REFERENCES issue.users(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT updated_by_fkey FOREIGN KEY (updated_by)
		REFERENCES issue.users(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT unique_issue UNIQUE (name),
	CONSTRAINT team_pkey FOREIGN KEY(team_id)
	REFERENCES issue.team(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS issue.project
    OWNER to postgres;
	
-- Table: issue.issue

-- DROP TABLE IF EXISTS issue.issue;

CREATE TABLE IF NOT EXISTS issue.issue
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    assignee_id integer,
    reporter_id integer,
	status_id integer,
	story_point integer,
	priority_level character varying,
	created_by integer,
	created_date TIMESTAMP(6) WITHOUT TIME ZONE,
	activated_date TIMESTAMP(6) WITHOUT TIME ZONE,
    project_id INT NOT NULL,
   CONSTRAINT fk_issue_project
        FOREIGN KEY (project_id)
        REFERENCES issue.project (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_issue_assignee
        FOREIGN KEY (assignee_id)
        REFERENCES issue.users (id)
        ON DELETE SET NULL
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS issue.issue
    OWNER to postgres;
	
