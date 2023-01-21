


CREATE TABLE affective_domain (
    "Level"         VARCHAR2(30) NOT NULL,
    a_description   VARCHAR2(30) NOT NULL
);

ALTER TABLE affective_domain ADD CONSTRAINT affective_domain_pk PRIMARY KEY ( "Level" );

CREATE TABLE allocate (
    course_outcome_co_num        VARCHAR2(30) NOT NULL,
    psychomotor_domain_p_level   VARCHAR2(30) NOT NULL
);

ALTER TABLE allocate ADD CONSTRAINT allocate_pk PRIMARY KEY ( course_outcome_co_num,
psychomotor_domain_p_level );

CREATE TABLE board (
    board_number   VARCHAR2(8) NOT NULL,
    time_slot      DATE NOT NULL
);

ALTER TABLE board ADD CONSTRAINT board_pk PRIMARY KEY ( board_number );

CREATE TABLE cognitive_domain (
    c_subdomain             VARCHAR2(30) NOT NULL,
    c_description           VARCHAR2(10) NOT NULL,
    course_outcome_co_num   VARCHAR2(30) NOT NULL
);

ALTER TABLE cognitive_domain ADD CONSTRAINT cognitive_domain_pk PRIMARY KEY ( c_subdomain );

CREATE TABLE course (
    course_id     VARCHAR2(30) NOT NULL,
    course_name   VARCHAR2(30) NOT NULL,
    credits       NUMBER(1)
);

ALTER TABLE course ADD CONSTRAINT course_pk PRIMARY KEY ( course_id );

CREATE TABLE course_outcome (
    co_num                     VARCHAR2(30) NOT NULL,
    description                VARCHAR2(30) NOT NULL,
    supervisor_supervisor_id   NUMBER NOT NULL
);

ALTER TABLE course_outcome ADD CONSTRAINT course_outcome_pk PRIMARY KEY ( co_num );

CREATE TABLE instructor (
    instructor_id        VARCHAR2(30) NOT NULL,
    instructor_name      VARCHAR2(30) NOT NULL,
    board_board_number   VARCHAR2(8)
);

ALTER TABLE instructor ADD CONSTRAINT instructor_pk PRIMARY KEY ( instructor_id );

CREATE TABLE marks_distribution (
    sl_no                          NUMBER NOT NULL,
    total_marks                    NUMBER(3),
    garde                          VARCHAR2(30) NOT NULL,
    gpa                            NUMBER(3,2) NOT NULL,
    course_course_id               VARCHAR2(30) NOT NULL,
    supervisor_supervisor_id       NUMBER NOT NULL,
    categories_marks               NUMBER(2) NOT NULL,
    project_group_group_no         NUMBER NOT NULL,
    course_outcome_co_num          VARCHAR2(30) NOT NULL,
    cognitive_domain_c_subdomain   VARCHAR2(30) NOT NULL,
    psychomotor_domain_p_level     VARCHAR2(30) NOT NULL,
    "Program_Outcome(PO)_PO_num"   VARCHAR2(30) NOT NULL,
    affective_domain_level         VARCHAR2(30) NOT NULL,
    instructor_instructor_id       VARCHAR2(30) NOT NULL
);

ALTER TABLE marks_distribution ADD CONSTRAINT marks_distribution_pk PRIMARY KEY ( sl_no );

CREATE TABLE "Program_Outcome(PO)" (
    po_num        VARCHAR2(30) NOT NULL,
    description   VARCHAR2(30) NOT NULL
);

ALTER TABLE "Program_Outcome(PO)" ADD CONSTRAINT "Program_Outcome(PO)_PK" PRIMARY KEY ( po_num );

CREATE TABLE project (
    project_id               NUMBER NOT NULL,
    project_name             VARCHAR2(30) NOT NULL,
    description              VARCHAR2(30) NOT NULL,
    project_group_group_no   NUMBER NOT NULL
);

CREATE UNIQUE INDEX project__idx ON
    project ( project_group_group_no ASC );

ALTER TABLE project ADD CONSTRAINT project_pk PRIMARY KEY ( project_id );

CREATE TABLE project_group (
    group_no                   NUMBER NOT NULL,
    supervisor_supervisor_id   NUMBER NOT NULL,
    section_course_id          VARCHAR2(30) NOT NULL,
    section_year               NUMBER NOT NULL,
    section_semester           VARCHAR2(30) NOT NULL,
    project_project_id         NUMBER NOT NULL,
    board_board_number         VARCHAR2(8) NOT NULL
);

CREATE UNIQUE INDEX project_group__idx ON
    project_group ( project_project_id ASC );

ALTER TABLE project_group ADD CONSTRAINT project_group_pk PRIMARY KEY ( group_no );

CREATE TABLE psychomotor_domain (
    p_level                        VARCHAR2(30) NOT NULL,
    p_description                  VARCHAR2(10) NOT NULL,
    "Program_Outcome(PO)_PO_num"   VARCHAR2(30) NOT NULL
);

ALTER TABLE psychomotor_domain ADD CONSTRAINT psychomotor_domain_pk PRIMARY KEY ( p_level );

CREATE TABLE registation (
    student_stduent_id   NUMBER NOT NULL,
    course_course_id     VARCHAR2(30) NOT NULL
);

ALTER TABLE registation ADD CONSTRAINT registation_pk PRIMARY KEY ( student_stduent_id,
course_course_id );

CREATE TABLE section (
    semester           VARCHAR2(30) NOT NULL,
    year               NUMBER NOT NULL,
    course_course_id   VARCHAR2(30) NOT NULL
);

ALTER TABLE section
    ADD CONSTRAINT section_pk PRIMARY KEY ( course_course_id,
    year,
    semester );

CREATE TABLE "set" (
    affective_domain_level   VARCHAR2(30) NOT NULL,
    course_outcome_co_num    VARCHAR2(30) NOT NULL
);

ALTER TABLE "set" ADD CONSTRAINT set_pk PRIMARY KEY ( affective_domain_level,
course_outcome_co_num );

CREATE TABLE student (
    stduent_id                 NUMBER NOT NULL,
    name                       VARCHAR2(30) NOT NULL,
    major                      VARCHAR2(30) NOT NULL,
    cgpa                       NUMBER(3,2) NOT NULL,
    completed_credit           NUMBER(4,1) NOT NULL,
    dob                        DATE NOT NULL,
    blood_group                VARCHAR2(30) NOT NULL,
    phone_number               NUMBER(11) NOT NULL,
    project_group_group_no     NUMBER NOT NULL,
    student_result_serial_no   NUMBER NOT NULL,
    marks_distribution_sl_no   NUMBER NOT NULL
);

ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( stduent_id );

CREATE TABLE student_result (
    serial_no                  NUMBER NOT NULL,
    course_course_id           VARCHAR2(30) NOT NULL,
    marks_distribution_sl_no   NUMBER NOT NULL
);

ALTER TABLE student_result ADD CONSTRAINT student_result_pk PRIMARY KEY ( serial_no );

CREATE TABLE supervisor (
    supervisor_id        NUMBER NOT NULL,
    supervisor_name      VARCHAR2(30) NOT NULL,
    board_board_number   VARCHAR2(8) NOT NULL
);

ALTER TABLE supervisor ADD CONSTRAINT supervisor_pk PRIMARY KEY ( supervisor_id );

ALTER TABLE allocate
    ADD CONSTRAINT allocate_course_outcome_fk FOREIGN KEY ( course_outcome_co_num )
        REFERENCES course_outcome ( co_num );

ALTER TABLE allocate
    ADD CONSTRAINT allocate_psychomotor_domain_fk FOREIGN KEY ( psychomotor_domain_p_level )
        REFERENCES psychomotor_domain ( p_level );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE cognitive_domain
    ADD CONSTRAINT cognitive_domain_course_outcome_fk FOREIGN KEY ( course_outcome_co_num )
        REFERENCES course_outcome ( co_num );

ALTER TABLE course_outcome
    ADD CONSTRAINT course_outcome_supervisor_fk FOREIGN KEY ( supervisor_supervisor_id )
        REFERENCES supervisor ( supervisor_id );

ALTER TABLE instructor
    ADD CONSTRAINT instructor_board_fk FOREIGN KEY ( board_board_number )
        REFERENCES board ( board_number );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_affective_domain_fk FOREIGN KEY ( affective_domain_level )
        REFERENCES affective_domain ( "Level" );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_cognitive_domain_fk FOREIGN KEY ( cognitive_domain_c_subdomain )
        REFERENCES cognitive_domain ( c_subdomain );

ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_course_outcome_fk FOREIGN KEY ( course_outcome_co_num )
        REFERENCES course_outcome ( co_num );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_instructor_fk FOREIGN KEY ( instructor_instructor_id )
        REFERENCES instructor ( instructor_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT "Marks_distribution_Program_Outcome(PO)_FK" FOREIGN KEY ( "Program_Outcome(PO)_PO_num" )
        REFERENCES "Program_Outcome(PO)" ( po_num );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_project_group_fk FOREIGN KEY ( project_group_group_no )
        REFERENCES project_group ( group_no );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_psychomotor_domain_fk FOREIGN KEY ( psychomotor_domain_p_level )
        REFERENCES psychomotor_domain ( p_level );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE marks_distribution
    ADD CONSTRAINT marks_distribution_supervisor_fk FOREIGN KEY ( supervisor_supervisor_id )
        REFERENCES supervisor ( supervisor_id );

ALTER TABLE project_group
    ADD CONSTRAINT project_group_board_fk FOREIGN KEY ( board_board_number )
        REFERENCES board ( board_number );

ALTER TABLE project_group
    ADD CONSTRAINT project_group_project_fk FOREIGN KEY ( project_project_id )
        REFERENCES project ( project_id );

ALTER TABLE project_group
    ADD CONSTRAINT project_group_section_fk FOREIGN KEY ( section_course_id,
    section_year,
    section_semester )
        REFERENCES section ( course_course_id,
        year,
        semester );

ALTER TABLE project_group
    ADD CONSTRAINT project_group_supervisor_fk FOREIGN KEY ( supervisor_supervisor_id )
        REFERENCES supervisor ( supervisor_id );

ALTER TABLE project
    ADD CONSTRAINT project_project_group_fk FOREIGN KEY ( project_group_group_no )
        REFERENCES project_group ( group_no );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE psychomotor_domain
    ADD CONSTRAINT "psychomotor_Domain_Program_Outcome(PO)_FK" FOREIGN KEY ( "Program_Outcome(PO)_PO_num" )
        REFERENCES "Program_Outcome(PO)" ( po_num );

ALTER TABLE registation
    ADD CONSTRAINT registation_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

ALTER TABLE registation
    ADD CONSTRAINT registation_student_fk FOREIGN KEY ( student_stduent_id )
        REFERENCES student ( stduent_id );

ALTER TABLE section
    ADD CONSTRAINT section_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

ALTER TABLE "set"
    ADD CONSTRAINT set_affective_domain_fk FOREIGN KEY ( affective_domain_level )
        REFERENCES affective_domain ( "Level" );

ALTER TABLE "set"
    ADD CONSTRAINT set_course_outcome_fk FOREIGN KEY ( course_outcome_co_num )
        REFERENCES course_outcome ( co_num );

ALTER TABLE student
    ADD CONSTRAINT student_marks_distribution_fk FOREIGN KEY ( marks_distribution_sl_no )
        REFERENCES marks_distribution ( sl_no );

ALTER TABLE student
    ADD CONSTRAINT student_project_group_fk FOREIGN KEY ( project_group_group_no )
        REFERENCES project_group ( group_no );

ALTER TABLE student_result
    ADD CONSTRAINT student_result_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE student_result
    ADD CONSTRAINT student_result_marks_distribution_fk FOREIGN KEY ( marks_distribution_sl_no )
        REFERENCES marks_distribution ( sl_no );

ALTER TABLE student
    ADD CONSTRAINT student_student_result_fk FOREIGN KEY ( student_result_serial_no )
        REFERENCES student_result ( serial_no );

ALTER TABLE supervisor
    ADD CONSTRAINT supervisor_board_fk FOREIGN KEY ( board_board_number )
        REFERENCES board ( board_number );


