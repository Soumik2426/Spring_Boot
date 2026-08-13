INSERT INTO department (title, is_active, password, created_at, updated_at) VALUES
('Research & Development', true, 'R&D_Innovate_2026!', NOW(), NOW()),
('Legal & Compliance', true, 'Lgl_@ud_Pr0tect#', NOW(), NOW()),
('Human Resources', true, 'HR_Talent_Mngt$26', NOW(), NOW()),
('Public Relations', true, 'PR_Br@nd_AwaRe!', NOW(), NOW()),
('Quality Assurance', true, 'QA_Zero_Bugs_99#', NOW(), NOW()),
('Procurement & Sourcing', true, 'Procure_Svc_77$', NOW(), NOW()),
('Data Analytics', true, 'Data_Insight_88!', NOW(), NOW()),
('Product Management', true, 'Prod_Mngr_Roadmap!', NOW(), NOW()),
('Cyber Security', true, 'Sec_Secured_99@', NOW(), NOW()),
('Executive Suite', false, 'Exec_Archived_v2', NOW(), NOW());


INSERT INTO employees (first_name, last_name, email, phn_number, joining_date, salary, role, yoe, active) VALUES
('John', 'Doe', 'john.doe@company.com', '+15550192', '2024-01-15', 75000, 'Software Engineer', 3, true),
('Jane', 'Smith', 'jane.smith@company.com', '+15550193', '2022-06-01', 110000, 'Senior Developer', 6, true),
('Michael', 'Brown', 'michael.b@company.com', '+15550194', '2025-03-10', 60000, 'Junior QA Engineer', 1, true),
('Emily', 'Davis', 'emily.davis@company.com', '+15550195', '2020-11-20', '135000', 'Tech Lead', 9, true),
('David', 'Wilson', 'david.w@company.com', '+15550196', '2023-08-15', 90000, 'DevOps Specialist', 5, false);
