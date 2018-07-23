INSERT INTO public.employee
(employee_fname, employee_lname, employee_mname, login_id, tenant_id, created_on, created_by, updated_on, updated_by)
VALUES('Bob', 'Employee', 'The', 'emp', 'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'), 
('Joe', 'Manager', 'The', 'mgr', 'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'), 
('Rob', 'AppAdmin', 'The', 'appadmin', 'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
('Trish', 'Sysadmin', 'The', 'sysadmin', 'sys',current_timestamp, 'sysadmin', current_timestamp, 'sysadmin');