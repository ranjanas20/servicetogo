INSERT INTO public.customer
(customer_fname, customer_lname, customer_mname, login_id, customer_email, customer_phone, 
address_line1, address_line2, address_city, address_state, address_zip, tenant_id, created_on, created_by, updated_on, updated_by)
VALUES('John', 'Brophy', 'P', 'john', 'john@gmail.com', '9256754328', 
'122 forget me drive', '201', 'San Ramon', 'CA', '94582', 'sys', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
('Terry', 'Jones', 'P', 'terry', 'terry@gmail.com', '8006754328', 
'122 Not here drive', '201', 'Santa Clara', 'CA', '94592', 'sys', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin')
