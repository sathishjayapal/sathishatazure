create sequence job_id_seq start with 1 increment by 50;

create table jobapplications
(
    id       bigint DEFAULT nextval('job_id_seq') not null,
    job_company_name varchar(100) not null,
    job_description     varchar(255) not null,
    joburl    varchar(100) not null,
    resumeurl varchar (100) not null,
    created_at timestamp,
    primary key (id)
);
create table emails
(
    id       bigint DEFAULT nextval('job_id_seq') not null,
    emailID varchar(100) not null,
    name     varchar(255) not null,
    primary key (id)
);

INSERT INTO jobapplications (job_company_name, job_description, joburl, resumeurl, created_at) VALUES
('Amfam Corp', 'Cloud Resource- Be an awesome resource','https://www.myworkday.com/amfam/','https://sathishjayapal.me', CURRENT_TIMESTAMP()),
('USBank Corp', 'Cloud Engineer- Be an awesome awesome cloud engineer with Python','https://www.myworkday.com/usbank/', 'https://sathishjayapal.me',CURRENT_TIMESTAMP()),
('State of WI Corp', 'Cloud Manager- Be an awesome cloud manager','https://www.myworkday.com/stateofwi/','https://sathishjayapal.me', CURRENT_TIMESTAMP());
