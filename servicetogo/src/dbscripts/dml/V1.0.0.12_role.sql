INSERT INTO public."role"
(role_name, role_description, created_on, created_by, updated_on, updated_by)
values ('role_manager', 'manager role', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
        ('role_appadmin', 'appadmin role', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
        ('role_sysadmin', 'sysadmin role', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
        ('role_customer', 'customer role', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin'),
        ('role_employee', 'employee role', current_timestamp, 'sysadmin', current_timestamp, 'sysadmin')