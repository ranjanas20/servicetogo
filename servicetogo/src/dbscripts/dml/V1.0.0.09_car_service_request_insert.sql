INSERT INTO public.car_service_request(
    tenant_id, customer_id, customer_first_name, customer_last_name, customer_middle_name, 
    customer_email, customer_phone, preferred_contact_method, vehicle_make, vehicle_model, vehicle_year, 
    vehicle_vin, address_line1, address_line2, address_city, address_state, address_zip, symptoms, user_comments, 
    requested_date, vehicle_location, service_status, assigned_employee_id, assigned_priority, 
    service_schedule_datetime, service_completion_datetime, service_completed_by,created_on, created_by, updated_on, updated_by)
    VALUES 
    (1,1,'Sanjay', 'Singh', 'Kumar', 
    'sanjay@gmail.com','415-505-0272','phone','Ford','Explorer',2010,
        'VIN1234','1606 Ridge View Ave', '#201','San Ramon','CA','85643','Squaking Brake','No Comments',
        '2018-01-01','home','NEW','1','HIGH',
        '2018-01-01','2018-01-01','1','2018-06-22','user1','2018-06-22','user1'),
    (1,1,'Sanjay', 'Singh', 'Kumar', 'sanjay@gmail.com','415-505-0272','phone','Ford','Explorer',2010,
        'VIN1234','1606 Ridge View Ave', '#201','San Ramon','CA','85643','Squaking Brake','No Comments',
        '2018-01-01','home','NEW','1','HIGH','2018-01-01','2018-01-01','1','2018-06-22','user1','2018-06-22','user1'),
    (1,1,'Sanjay', 'Singh', 'Kumar', 'sanjay@gmail.com','415-505-0272','phone','Ford','Explorer',2010,
        'VIN1234','1606 Ridge View Ave', '#201','San Ramon','CA','85643','Squaking Brake','No Comments',
        '2018-01-01','home','NEW','1','HIGH','2018-01-01','2018-01-01','1','2018-06-22','user1','2018-06-22','user1');
    