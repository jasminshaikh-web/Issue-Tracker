-- Table: Issue.user

-- DROP TABLE IF EXISTS "Issue"."user";

CREATE TABLE IF NOT EXISTS "Issue"."user"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    designation character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue"."user"
    OWNER to postgres;

-- Table: Issue.team

-- DROP TABLE IF EXISTS "Issue"."team";

CREATE TABLE IF NOT EXISTS "Issue"."team"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT team_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue"."team"
    OWNER to postgres;
	
-- Table: Issue.team_member

-- DROP TABLE IF EXISTS "Issue"."team_member";

CREATE TABLE IF NOT EXISTS "Issue"."team_member"
(
    team_id integer,
	user_id integer,
    CONSTRAINT team_member_pkey PRIMARY KEY (team_id,user_id),
	CONSTRAINT team_id_fkey FOREIGN KEY (team_id)
		REFERENCES "Issue"."team"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT user_id_fkey FOREIGN KEY (user_id)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION		
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue"."team_member"
    OWNER to postgres;
	
-- Table: Issue.project

-- DROP TABLE IF EXISTS "Issue".project;

CREATE TABLE IF NOT EXISTS "Issue".project
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2134562123 CACHE 1),
    name character varying COLLATE pg_catalog."default",
    decription character varying,
	created_by integer,
	updated_by integer,
	team_id integer,
    CONSTRAINT project_pkey PRIMARY KEY (id),
	CONSTRAINT created_by_fkey FOREIGN KEY (created_by)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT updated_by_fkey FOREIGN KEY (updated_by)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT unique_issue UNIQUE (name)

)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue".project
    OWNER to postgres;
	
-- Table: Issue.status

-- DROP TABLE IF EXISTS "Issue".status;

CREATE TABLE IF NOT EXISTS "Issue".status
(
    id integer,
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT status_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue".status
    OWNER to postgres;
	
-- Table: Issue.issue

-- DROP TABLE IF EXISTS "Issue".issue;

CREATE TABLE IF NOT EXISTS "Issue".issue
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
	project_id integer,
    CONSTRAINT issue_pkey PRIMARY KEY (id),
	CONSTRAINT created_by_fkey FOREIGN KEY (created_by)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT assignee_id_fkey FOREIGN KEY (assignee_id)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT reporter_id_fkey FOREIGN KEY (reporter_id)
		REFERENCES "Issue"."user"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT project_id_fkey FOREIGN KEY (project_id)
		REFERENCES "Issue"."project"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT status_id_fkey FOREIGN KEY (status_id)
		REFERENCES "Issue"."status"(id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION,
	CONSTRAINT unique_issue UNIQUE (id)

)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "Issue".issue
    OWNER to postgres;
	
