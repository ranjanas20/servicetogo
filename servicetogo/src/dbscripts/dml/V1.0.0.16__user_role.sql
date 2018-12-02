INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, 
tenant_id, created_on,  created_by, updated_on, updated_by) 
VALUES('john', 'john', 'customer', '', '', '', '', 'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');

INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, tenant_id, created_on, created_by, updated_on, updated_by) 
VALUES('terry', 'terry', 'customer', '', '', '', '',  'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');

INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, tenant_id, created_on, created_by, updated_on, updated_by) 
VALUES('bob', 'job', 'employee', '', '', '', '',  'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');

INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, tenant_id, created_on, created_by, updated_on, updated_by) 
VALUES('joe', 'joe', 'employee', '', '', '', '',  'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');

INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, tenant_id, created_on, created_by, updated_on, updated_by) 
VALUES('rob', 'rob', 'employee', '', '', '', '',  'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');

INSERT INTO public.user_credentials (login_id, login_password, user_type, secretquestion1_code_id, secretquestion2_code_id, secretanswer1, secretanswer2, tenant_id, created_on, created_by, updated_on, updated_by) 
VALUES('trish', 'trish', 'employee', '', '', '', '',  'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');


INSERT INTO public.user_role
(credential_id, role_name)
VALUES ( (select credential_id from user_credentials where login_id='john'), 'role_customer'),
( (select credential_id from user_credentials where login_id='terry'), 'role_customer'),
( (select credential_id from user_credentials where login_id='bob'), 'role_employee'),
( (select credential_id from user_credentials where login_id='joe'), 'role_manager'),
( (select credential_id from user_credentials where login_id='rob'), 'role_appadmin')

