
DROP TABLE AttachFile CASCADE CONSTRAINTS PURGE;

DROP TABLE Member CASCADE CONSTRAINTS PURGE;

DROP TABLE Company CASCADE CONSTRAINTS PURGE;

DROP TABLE Notice CASCADE CONSTRAINTS PURGE;

DROP TABLE Announce CASCADE CONSTRAINTS PURGE;

DROP TABLE ConsultComment CASCADE CONSTRAINTS PURGE;

DROP TABLE Consult CASCADE CONSTRAINTS PURGE;

DROP TABLE Board CASCADE CONSTRAINTS PURGE;

/* 2017-02-10 기존 시퀀스 생성문 변경함. DB insert ddl 수정. 확인 후 삭제하면 됨.
BEGIN EXECUTE IMMEDIATE 'DROP SEQUENCE SEQUENCE_NOTICE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
BEGIN EXECUTE IMMEDIATE 'DROP SEQUENCE SEQUENCE_ANNOUNCE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
BEGIN EXECUTE IMMEDIATE 'DROP SEQUENCE SEQUENCE_ATTACH'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
CREATE SEQUENCE SEQUENCE_NOTICE MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 12 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
CREATE SEQUENCE SEQUENCE_ANNOUNCE  MINVALUE 1 MAXVALUE 100000000 INCREMENT BY 1 START WITH 21 NOCACHE NOORDER  NOCYCLE  NOPARTITION ;
CREATE SEQUENCE SEQUENCE_ATTACH  MINVALUE 1 MAXVALUE 100000000 INCREMENT BY 1 START WITH 21 NOCACHE NOORDER  NOCYCLE  NOPARTITION ;
*/

CREATE TABLE Announce
(
    AnnNum               NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    AnnCopName           VARCHAR2(20) NULL ,
    AnnCopDivisinon      VARCHAR2(20) NULL ,
    AnnTel               VARCHAR2(20) NULL ,

    AnnStartDT           VARCHAR2(20) NULL ,
    AnnEndDT             VARCHAR2(20) NULL ,
    AnnCategory          VARCHAR2(20) NULL ,
    ANNDEPART            VARCHAR2(20) NULL , 
    AnnTitle             VARCHAR2(100) NULL ,
    AnnContent           VARCHAR2(2000) NULL ,
    InsertUID            VARCHAR2(20) NULL ,
    InsertDT             DATE NULL ,
    UpdateUID            VARCHAR2(20) NULL ,
    UpdateDT             DATE NULL ,
    UseYN                NUMBER(1,0) default 0 NOT NULL , 

    lat              NUMBER(15,10) NULL ,
    lng           NUMBER(15,10) NULL ,
    Location             VARCHAR2(50) NULL ,
    JOB                  VARCHAR2(20) NULL ,
    Target               VARCHAR2(50) NULL ,
    Age                  VARCHAR2(50) NULL ,

    boardCd              VARCHAR2(20) NOT NULL


);

CREATE UNIQUE INDEX XPKAnnounce ON Announce
(AnnNum   ASC);

ALTER TABLE Announce
    ADD CONSTRAINT  XPKAnnounce PRIMARY KEY (AnnNum);

CREATE TABLE Board
(
    boardCd              VARCHAR2(20) NOT NULL ,
    boardNm              VARCHAR2(50) NULL 
);

CREATE UNIQUE INDEX XPKBoard ON Board
(boardCd   ASC);

ALTER TABLE Board
    ADD CONSTRAINT  XPKBoard PRIMARY KEY (boardCd);

CREATE TABLE Company
(
    companyID            NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    compName             VARCHAR2(50) NULL ,
    compCorpRegNum       NUMBER(15) NULL ,
    compDivision         VARCHAR2(20) NULL ,
    compOccupGroup       VARCHAR2(30) NULL ,
    compDepartment       VARCHAR2(20) NULL ,
    compPosition         VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKCompany ON Company
(companyID   ASC);

ALTER TABLE Company
    ADD CONSTRAINT  XPKCompany PRIMARY KEY (companyID);

CREATE TABLE Consult
(
    ConNum               NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    ConTitle             VARCHAR2(100) NULL ,
    ConContent           VARCHAR2(2000) NULL ,
    ConWriter            VARCHAR2(20) NULL ,
    InsertDT             DATE NULL ,
    InsertUID            VARCHAR2(20) NULL ,
    UpdateDT             DATE NULL ,
    UpdateUID            VARCHAR2(20) NULL ,
    UseYN                NUMBER(1,0) NULL ,
    ReciptStatus         VARCHAR2(20) NULL ,
    ConDepartment        VARCHAR2(20) NULL ,
    Consulter            VARCHAR2(20) NULL ,
    ReplyDeadline        DATE NULL ,
    ReplyDate            DATE NULL ,
    boardCd              VARCHAR2(20) NOT NULL 
);

CREATE UNIQUE INDEX XPKConsult ON Consult
(ConNum   ASC);

ALTER TABLE Consult
    ADD CONSTRAINT  XPKConsult PRIMARY KEY (ConNum);

CREATE TABLE ConsultComment
(
    CommNum              NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    CommTitle            VARCHAR2(100) NULL ,
    CommContent          VARCHAR2(2000) NULL ,
    CommWriter           VARCHAR2(20) NULL ,
    InsertUID            VARCHAR2(20) NULL ,
    InsertDT             DATE NULL ,
    UseYN                NUMBER(1, 0) NULL ,
    ConNum               NUMBER(20) NOT NULL
);

CREATE TABLE Member
(
    memberID             NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,

    memName              VARCHAR2(50)  NOT NULL ,
    memID                VARCHAR2(50)  NOT NULL ,
    memPasswd            VARCHAR2(20)  NOT NULL ,
    oldMemPasswd         VARCHAR2(20)  NOT NULL ,
    memPasswdQst         VARCHAR2(50)  NOT NULL ,
    memPasswdQstReply    VARCHAR2(50)  NOT NULL ,
    memEmail             VARCHAR2(50)  NOT NULL ,
    memMobile            VARCHAR2(20)  NOT NULL ,
    joinDT               DATE          NOT NULL ,
    UseYN                NUMBER(1, 0)  NOT NULL ,
    memTel01             VARCHAR2(20)  NULL ,
    memFax               VARCHAR2(20)  NULL ,
    memEngName           VARCHAR2(50)  NULL ,
    memResRegNum         VARCHAR2(50)  NULL ,
    memNation            VARCHAR2(30)  NULL ,
    memLocation          VARCHAR2(30)  NULL ,
    memTel02             VARCHAR2(20)  NULL ,
    memPostCode          VARCHAR2(20)  NULL ,
    memAddr              VARCHAR2(50)  NULL ,
    memDetailedAddr      VARCHAR2(50)  NULL ,
    memGrade             VARCHAR2(20)  NULL ,
    secedeReason         VARCHAR2(500) NULL ,
    secedeDT             DATE          NULL ,
    UpdateDT             DATE          NULL ,
    companyID            NUMBER(10)    NULL 
);

CREATE UNIQUE INDEX XPKMember ON Member
(memberID   ASC);

ALTER TABLE Member
    ADD CONSTRAINT  XPKMember PRIMARY KEY (memberID);

CREATE TABLE Notice
(
    NoticeNum            NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    Ntitle               VARCHAR2(100) NULL ,
    NContent             VARCHAR2(2000) NULL ,
    InsertUID            VARCHAR2(20) NULL ,
    InsertDT             DATE NULL ,
    UpdateUID            VARCHAR2(20) NULL ,
    UpdateDT             DATE NULL ,
    UseYN                NUMBER(1,0) default 0 NULL,
    Hit                  NUMBER(5,0) default 0 NULL,
    boardCd              VARCHAR2(20) NOT NULL 
);

CREATE UNIQUE INDEX XPKNotice ON Notice
(NoticeNum   ASC);

ALTER TABLE Notice
    ADD CONSTRAINT  XPKNotice PRIMARY KEY (NoticeNum);

CREATE TABLE AttachFile
(
    AttachFileNo        NUMBER(10 ,0) GENERATED AS IDENTITY (MINVALUE 1 MAXVALUE 99999999 start with 1 increment by 1 NOCACHE ORDER) NOT NULL ENABLE,
    FileName            VARCHAR2(100) NOT NULL ,
    FileSize            NUMBER(10) NOT NULL ,
    memberID            INTEGER NULL ,
    AnnNum              NUMBER(10) NULL ,
    NoticeNum           NUMBER(10) NULL ,
    ConNum              NUMBER(20) NULL,
    FileType            VARCHAR2(20) NULL ,
    contentType         VARCHAR(50) NULL,
    imageBytes          BLOB NULL
);

CREATE UNIQUE INDEX XPKAttachFile ON AttachFile
(AttachFileNo   ASC);

ALTER TABLE AttachFile
    ADD CONSTRAINT  XPKAttachFile PRIMARY KEY (AttachFileNo);

ALTER TABLE Announce
    ADD (CONSTRAINT R_26 FOREIGN KEY (boardCd) REFERENCES Board (boardCd));

ALTER TABLE Consult
    ADD (CONSTRAINT R_24 FOREIGN KEY (boardCd) REFERENCES Board (boardCd));

ALTER TABLE ConsultComment
    ADD (CONSTRAINT R_6 FOREIGN KEY (ConNum) REFERENCES Consult (ConNum));

ALTER TABLE Member
    ADD (CONSTRAINT R_11 FOREIGN KEY (companyID) REFERENCES Company (companyID));

ALTER TABLE Notice
    ADD (CONSTRAINT R_25 FOREIGN KEY (boardCd) REFERENCES Board (boardCd));

ALTER TABLE AttachFile
    ADD (CONSTRAINT R_7 FOREIGN KEY (AnnNum) REFERENCES Announce (AnnNum));

ALTER TABLE AttachFile
    ADD (CONSTRAINT R_8 FOREIGN KEY (NoticeNum) REFERENCES Notice (NoticeNum));

ALTER TABLE AttachFile
    ADD (CONSTRAINT R_9 FOREIGN KEY (ConNum) REFERENCES Consult (ConNum));

ALTER TABLE AttachFile
    ADD (CONSTRAINT R_10 FOREIGN KEY (memberID) REFERENCES Member (memberID));

Insert into BOARD (BOARDCD,BOARDNM) values ('anno','공고게시판');
Insert into BOARD (BOARDCD,BOARDNM) values ('login','로그인');
Insert into BOARD (BOARDCD,BOARDNM) values ('service','고객센터');

Insert 
  into MEMBER (MEMNAME,MEMID,MEMPASSWD,OLDMEMPASSWD,MEMPASSWDQST,MEMPASSWDQSTREPLY,MEMEMAIL,MEMMOBILE,MEMTEL01,MEMFAX,MEMENGNAME,MEMRESREGNUM,MEMNATION,MEMLOCATION,MEMTEL02,MEMPOSTCODE,MEMADDR,MEMDETAILEDADDR,USEYN,MEMGRADE,JOINDT,SECEDEDT,UPDATEDT,COMPANYID,SECEDEREASON) 
       values ('admin0','admin0','!!admin0','!!admin0','admin0','admin0','admin0@admin0.com','010-0000-0000',null,null,null,null,null,null,null,null,null,null,0,'관리자',to_date('17/02/08','RR/MM/DD'),null,null,null,null);

Insert 
  into MEMBER (MEMNAME,MEMID,MEMPASSWD,OLDMEMPASSWD,MEMPASSWDQST,MEMPASSWDQSTREPLY,MEMEMAIL,MEMMOBILE,MEMTEL01,MEMFAX,MEMENGNAME,MEMRESREGNUM,MEMNATION,MEMLOCATION,MEMTEL02,MEMPOSTCODE,MEMADDR,MEMDETAILEDADDR,USEYN,MEMGRADE,JOINDT,SECEDEDT,UPDATEDT,COMPANYID,SECEDEREASON) 
       values ('권범주','first01','!first01','!first01','인상 깊게 읽은 책 이름은?','다빈치코드','first01@gmail.com','010-1234-5678','02-345-6789','02-123-4567',null,null,null,null,null,null,null,null,0,'일반회원',to_date('17/02/08','RR/MM/DD'),null,null,null,null);

Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('abcdefg','abcdefg','권범주',to_date('17/01/18','RR/MM/DD'),'MemID01',to_date('17/01/18','RR/MM/DD'),'MemID01',1,'처리 완료','유지보수팀','admin0',to_date('17/01/23','RR/MM/DD'),to_date('17/01/18','RR/MM/DD'),'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('noname','nosubsript','admin0',to_date('17/02/03','RR/MM/DD'),'admin0',to_date('17/02/03','RR/MM/DD'),'admin0',1,'처리 완료',null,null,to_date('17/02/08','RR/MM/DD'),to_date('17/02/03','RR/MM/DD'),'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test1','test1','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test2','test2','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test3','test3','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test4','test4','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test5','test5','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test6','test6','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test7','test7','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test8','test8','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test9','test9','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test10','test10','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test11','test11','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test12','test12','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test13','test13','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test14','test14','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');
Insert 
    into CONSULT (CONTITLE,CONCONTENT,CONWRITER,INSERTDT,INSERTUID,UPDATEDT,UPDATEUID,USEYN,RECIPTSTATUS,CONDEPARTMENT,CONSULTER,REPLYDEADLINE,REPLYDATE,BOARDCD) 
        values ('test15','test15','권범주',to_date('17/02/14','RR/MM/DD'),'MemID01',to_date('17/02/14','RR/MM/DD'),'MemID01',1,'답변대기',null,null,to_date('17/02/19','RR/MM/DD'),null,'service');

INSERT
    INTO CONSULTCOMMENT(COMMTITLE, COMMCONTENT, COMMWRITER, INSERTUID, INSERTDT, USEYN, CONNUM)
         VALUES('testreply01', 'testreply01', 'admin0', 'admin0', to_date('17/02/14','RR/MM/DD'), 1, 1);
  
INSERT 
  INTO COMPANY (COMPNAME, COMPCORPREGNUM, COMPDIVISION, COMPOCCUPGROUP, COMPDEPARTMENT, COMPPOSITION)
        VALUES ('창업진흥원', '11111111', '산', '커뮤니케이션', '유지보수팀', '평사원');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터1', '공공기관', '02-123-4567', '20170514', '20170614', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56683, 126.97866, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터2', '공공기관', '02-123-4567', '20170514', '20170604', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56783, 126.97864, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터3', '공공기관', '02-123-4567', '20170514', '20170624', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56673, 126.86866, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터4', '공공기관', '02-123-4567', '20170514', '20170610', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56690, 126.92866, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터5', '공공기관', '02-123-4567', '20170514', '20170626', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56983, 126.97806, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터6', '공공기관', '02-123-4567', '20170514', '20170614', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.55583, 126.97266, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터7', '공공기관', '02-123-4567', '20170514', '20170414', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56633, 126.97126, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터8', '공공기관', '02-123-4567', '20170514', '20170406', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.56213, 126.97436, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터9', '공공기관', '02-123-4567', '20170514', '20170421', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.59983, 126.99966, '서울', '청년', '20대', 'anno', '창업부', '전문가');
INSERT
  INTO ANNOUNCE (ANNCOPNAME, ANNCOPDIVISINON, ANNTEL, ANNSTARTDT, ANNENDDT, ANNCATEGORY, ANNTITLE, ANNCONTENT, INSERTUID, INSERTDT, UPDATEUID, UPDATEDT, USEYN, lat, lng, LOCATION, TARGET, AGE, BOARDCD, ANNDEPART, JOB)
         VALUES ('창업센터10', '공공기관', '02-123-4567', '20170514', '20170521', 'IT전문가', 'IT전문가창업', '전문가 구합니다', null, null, null, null, 0, 37.50083, 126.97865, '서울', '청년', '20대', 'anno', '창업부', '전문가');

Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항1','공지합니다',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항2','공지합니다',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항3','공지합니다3',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항4','공지합니다4',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항5','공지합니다5',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항6','공지합니다6',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항7','공지합니다7',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항8','공지합니다8',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항9','공지합니다9',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항10','공지합니다10',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항11','공지합니다11',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항12','공지합니다12',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항13','공지합니다13',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항14','공지합니다14',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항15','공지합니다15',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항16','공지합니다16',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항17','공지합니다17',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항18','공지합니다18',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항19','공지합니다19',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항20','공지합니다20',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항21','공지합니다21',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항22','공지합니다22',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항23','공지합니다23',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항24','공지합니다24',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항25','공지합니다25',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항26','공지합니다26',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항27','공지합니다27',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항28','공지합니다28',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항29','공지합니다29',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항30','공지합니다30',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항31','공지합니다31',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항32','공지합니다32',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항33','공지합니다33',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항34','공지합니다34',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항35','공지합니다35',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항36','공지합니다36',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항37','공지합니다37',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항38','공지합니다38',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항39','공지합니다39',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항40','공지합니다40',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항41','공지합니다41',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항42','공지합니다42',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항43','공지합니다43',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항44','공지합니다44',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항45','공지합니다45',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항46','공지합니다46',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항47','공지합니다47',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항48','공지합니다48',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항49','공지합니다49',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항50','공지합니다50',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항51','공지합니다51',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항52','공지합니다52',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항53','공지합니다53',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항54','공지합니다54',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항55','공지합니다55',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항56','공지합니다56',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항57','공지합니다57',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항58','공지합니다58',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항59','공지합니다59',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항60','공지합니다60',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항61','공지합니다61',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항62','공지합니다62',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항63','공지합니다63',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항64','공지합니다64',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항65','공지합니다65',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항66','공지합니다66',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항67','공지합니다67',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항68','공지합니다68',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항69','공지합니다69',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항70','공지합니다70',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항71','공지합니다71',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항72','공지합니다72',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항73','공지합니다73',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항74','공지합니다74',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항75','공지합니다75',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항76','공지합니다76',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항77','공지합니다77',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항78','공지합니다78',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항79','공지합니다79',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항80','공지합니다80',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항81','공지합니다81',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항82','공지합니다82',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항83','공지합니다83',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항84','공지합니다84',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항85','공지합니다85',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항86','공지합니다86',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항87','공지합니다87',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항88','공지합니다88',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항89','공지합니다89',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항90','공지합니다90',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항91','공지합니다91',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항92','공지합니다92',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항93','공지합니다93',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항94','공지합니다94',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항95','공지합니다95',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항96','공지합니다96',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항97','공지합니다97',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항98','공지합니다98',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항99','공지합니다99',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항100','공지합니다100',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항101','공지합니다101',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항102','공지합니다102',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항103','공지합니다103',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항104','공지합니다104',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항105','공지합니다105',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항106','공지합니다106',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항107','공지합니다107',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항108','공지합니다108',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항109','공지합니다109',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항110','공지합니다110',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항111','공지합니다111',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항112','공지합니다112',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항113','공지합니다113',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항114','공지합니다114',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항115','공지합니다115',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항116','공지합니다116',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항117','공지합니다117',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항118','공지합니다118',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항119','공지합니다119',null,null,null,null,0,0,'anno');
Insert into NOTICE (NTITLE,NCONTENT,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT,USEYN,HIT,BOARDCD) values ('공지사항120','공지합니다120',null,null,null,null,0,0,'anno');

commit;
