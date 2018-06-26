	
CREATE TABLE public.code_table (
	code_table_id serial NOT NULL,
	code_group varchar(100) NOT NULL,
	code_id varchar(80) NOT NULL,
	code_name varchar(100) NOT null,
CONSTRAINT code_table_pkey PRIMARY KEY (code_table_id)

)