	
CREATE TABLE public.zip_lookup (
	zip_code varchar(5) NOT NULL,
	city varchar(100) NOT NULL,
	state_code varchar(10) NOT null,
CONSTRAINT zip_lookup_pkey PRIMARY KEY (zip_code)
)

	
CREATE TABLE public.states (
	state_code varchar(10) NOT NULL,
	state_name varchar(100) NOT NULL,
CONSTRAINT states_pkey PRIMARY KEY (state_code)

)