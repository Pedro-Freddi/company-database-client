CREATE ROLE company_manager WITH NOSUPERUSER CREATEDB NOCREATEROLE LOGIN PASSWORD 'password123';

CREATE DATABASE company_test WITH OWNER company_manager; 

\c company_test company_manager;

CREATE TABLE TAB_EMPLOYEE (
  EMPLOYEE_ID int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  NAME varchar(255) NOT NULL,
  EMAIL varchar(255),
  SALARY numeric,
  HIRE_DATE date
);

INSERT INTO tab_employee(name, email, salary, hire_date)
VALUES 
  ('Peter Parker', 'peter.parker@example.com', 5000, TO_DATE('20150515', 'YYYYMMDD')),
  ('Bruce Wayne', 'bruce.wayne@example.com', 8000, TO_DATE('20121223', 'YYYYMMDD')),
  ('Harley Quinn', 'harley.quinn@example.com', 6500, TO_DATE('20140212', 'YYYYMMDD'));

CREATE OR REPLACE PROCEDURE sp_update_employee_salary("Employee_Id" integer, "Salary" numeric)
LANGUAGE SQL
AS $$
UPDATE public.tab_employee SET salary = "Salary" WHERE employee_id = "Employee_Id";
$$;
