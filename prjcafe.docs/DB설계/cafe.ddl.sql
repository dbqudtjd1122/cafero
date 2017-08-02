
-- cafeboard 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS cafeboard;

CREATE DATABASE cafeboard DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 사용자 추가
GRANT ALL ON *.* TO tester1@localhost IDENTIFIED BY '1234';

-- 데이터베이스 변경
USE cafeboard;

-- 유저테이블

DROP TABLE IF EXISTS TB_cafe_user;
CREATE TABLE TB_cafe_user (
      userno        INT             AUTO_INCREMENT
    , userlevel     INT             DEFAULT 1
    , email         NVARCHAR(40)    NOT NULL
    , passwd        NVARCHAR(30)    NOT NULL 
    , userphone     NVARCHAR(30)    NOT NULL 
    , useraddr      VARCHAR(100)        
    , sex           NVARCHAR(30)   
                                     
    , emailselect   NVARCHAR(30)    DEFAULT 0                           
    , usernickname  NVARCHAR(30)    NOT NULL                           
    , PRIMARY KEY(userno)

)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

Insert into TB_cafe_user (email, passwd, userphone, useraddr, sex, emailselect, usernickname) values ('dshhi89@nate.com','123123','01038192704','고담씨티','남자','0','하계동메시');
Insert into TB_cafe_user (email, passwd, userphone, useraddr, sex, emailselect, usernickname) values ('aa@nate.com','123123','01012342704','군함도','여자','0','하계동호날두');
Insert into TB_cafe_user (email, passwd, userphone, useraddr, sex, emailselect, usernickname) values ('bb@nate.com','123123','01056782704','발리','남자','1','하계동배트맨');
Insert into TB_cafe_user (email, passwd, userphone, useraddr, sex, emailselect, usernickname) values ('cc@nate.com','123123','01032142704','우리집','여자','1','하계동스파이더맨');

select * from TB_cafe_user;

-- 카페정보 테이블
DROP TABLE IF EXISTS TB_cafe_cafeinfo;
CREATE TABLE TB_cafe_cafeinfo (
      cafeno        INT             AUTO_INCREMENT
    , brand         NVARCHAR(50)
    , cafename      NVARCHAR(30)    NOT NULL
    , cafeaddr      NVARCHAR(100)   NOT NULL 
    , cafephone     NVARCHAR(30)            
    , avg_grade     FLOAT           DEFAULT 0                                     
    , review_count  INT             DEFAULT 0
    , like_count    INT             DEFAULT 0           
    , PRIMARY KEY(cafeno, cafename)

)


ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

Insert into TB_cafe_cafeinfo (brand, cafename, cafeaddr, cafephone) values ('이디야','이디야_노원역점','노원역 9번출구 앞','1577-1212');
Insert into TB_cafe_cafeinfo (brand, cafename, cafeaddr, cafephone) values ('할리스','할리스_상계역점','상계역 2번출구 나와서 앞으로 삼보','1577-1213');
Insert into TB_cafe_cafeinfo (brand, cafename, cafeaddr, cafephone) values ('스타벅스','스타벅스_하계역점','하계동 4번출구 나와서 뒤로 삼보','1577-1210');


select * from TB_cafe_cafeinfo;



-- 카페 리뷰 테이블
DROP TABLE IF EXISTS TB_cafe_review;
CREATE TABLE IF NOT EXISTS  TB_cafe_review (
      commentno     INT        AUTO_INCREMENT
    , userno        INT
    , cafeno        INT        
    , content       NVARCHAR(40)   NOT NULL           
    , grade         FLOAT          NOT NULL
    , regdate       DateTime                                     
    , PRIMARY KEY(commentno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


-- 카페 관리 데이터 테이블
DROP TABLE IF EXISTS TB_cafe_management_data;

CREATE TABLE IF NOT EXISTS  TB_cafe_management_data (
      cafefileno     INT          AUTO_INCREMENT
    , filename       NVARCHAR(50)     
    , filetype       NVARCHAR(30)    
    , filesize       INT             
    , menu_id        INT                      
    , tempfilename   VARCHAR(40)                      
    , imageData      LONGBLOB                                      
    
    , PRIMARY KEY(cafefileno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


-- 카페 리뷰 이미지데이터 테이블
DROP TABLE IF EXISTS TB_cafe_reviewimg_data;
CREATE TABLE IF NOT EXISTS  TB_cafe_reviewimg_data (
      reviewfileno   INT             AUTO_INCREMENT
    , filename       NVARCHAR(50)    
    , filetype       NVARCHAR(30)    
    , filesize       INT             
    , commentno      INT                 
    , tempfilename   VARCHAR(40)                                    
    , imageData      LONGBLOB        
    
    , PRIMARY KEY(reviewfileno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

-- 카페 메뉴 테이블
DROP TABLE IF EXISTS TB_cafe_menu;
CREATE TABLE IF NOT EXISTS  TB_cafe_menu (
      cafeno         INT             
    , menu_id        INT             AUTO_INCREMENT
    , menu_name      NVARCHAR(50)    
    , price          INT             
    , descrption     NVARCHAR(50)
    
    ,PRIMARY KEY(menu_id)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


-- 카페 별점 테이블
DROP TABLE IF EXISTS TB_cafe_star_point;
CREATE TABLE IF NOT EXISTS  TB_cafe_star_point (
      starno         INT             AUTO_INCREMENT
    , cafeno         INT             
    , grade          FLOAT
    
    ,PRIMARY KEY(starno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


-- foreign key 설정

alter table TB_cafe_review add constraint cafereview_cafeinfo_fk foreign key(cafeno) references TB_cafe_cafeinfo(cafeno);
alter table TB_cafe_management_data add constraint cafemanagement_cafemenu_fk foreign key(menu_id) references TB_cafe_menu(menu_id);
alter table TB_cafe_menu add constraint cafemenu_cafeinfo_fk foreign key(cafeno) references TB_cafe_cafeinfo(cafeno);
alter table TB_cafe_reviewimg_data add constraint reviewdata_cafeeview_fk foreign key(commentno) references TB_cafe_review(commentno);
alter table TB_cafe_star_point add constraint starpoint_cafeinfo_fk foreign key(cafeno) references TB_cafe_cafeinfo(cafeno);

alter table TB_cafe_review add constraint cafereview_cafeuser_fk foreign key(userno) references TB_cafe_user(userno);
-- alter table TB_cafe_star_point add constraint starpoint_cafereview_fk foreign key(commentno) references TB_cafe_review(commentno);