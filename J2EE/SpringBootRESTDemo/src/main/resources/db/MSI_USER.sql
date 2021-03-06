--------------------------------------------------------
--  File created - Sunday-November-12-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MSI_USER
--------------------------------------------------------

  CREATE TABLE "MSI_USER" 
   (	"USERNAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence MSI_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MSI_USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into MSI_USER
SET DEFINE OFF;
Insert into MSI_USER (USERNAME,PASSWORD,ID) values ('bob','$2a$11$q1sf5mUd1XwOmn6JQu6Zme0vs.ovSe2wU8TqlCFkcpOs89RUgObXG',1);
Insert into MSI_USER (USERNAME,PASSWORD,ID) values ('admin','$2a$11$MUm8qXqbWK0F3NqPoZzGme7lsCzuj7gROE5PWpqjwQ/1p7czRx3Ae',2);
Insert into MSI_USER (USERNAME,PASSWORD,ID) values ('user','$2a$11$GFOqKK8jG3xG0aM4pOHjr.V3pa504tSDUAu6sm6sfFH3vegtEqfcS',3);
--------------------------------------------------------
--  DDL for Index MSI_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSI_USER_PK" ON "MSI_USER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index MSI_USER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSI_USER_UK1" ON "MSI_USER" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger MSI_USER_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSI_USER_TRG" 
BEFORE INSERT ON MSI_USER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USERNAME IS NULL THEN
      SELECT MSI_USER_SEQ.NEXTVAL INTO :NEW.USERNAME FROM SYS.DUAL;
    END IF;
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT MSI_USER_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "MSI_USER_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table MSI_USER
--------------------------------------------------------

  ALTER TABLE "MSI_USER" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "MSI_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "MSI_USER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "MSI_USER" ADD CONSTRAINT "MSI_USER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "MSI_USER" ADD CONSTRAINT "MSI_USER_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
