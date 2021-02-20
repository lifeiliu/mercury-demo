--------------------------------------------------------
--  File created - Sunday-November-12-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MSI_ORDER_PRODUCT
--------------------------------------------------------

  CREATE TABLE "MSI_ORDER_PRODUCT" 
   (	"ID" NUMBER, 
	"QTY" NUMBER, 
	"ORDER_ID" NUMBER, 
	"PRODUCT_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence MSI_ORDER_PRODUCT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MSI_ORDER_PRODUCT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into MSI_ORDER_PRODUCT
SET DEFINE OFF;
Insert into MSI_ORDER_PRODUCT (ID,QTY,ORDER_ID,PRODUCT_ID) values (1,10,1,1);
Insert into MSI_ORDER_PRODUCT (ID,QTY,ORDER_ID,PRODUCT_ID) values (2,20,1,2);
Insert into MSI_ORDER_PRODUCT (ID,QTY,ORDER_ID,PRODUCT_ID) values (3,30,1,3);
--------------------------------------------------------
--  DDL for Index MSI_ORDER_PRODUCT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSI_ORDER_PRODUCT_PK" ON "MSI_ORDER_PRODUCT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger MSI_ORDER_PRODUCT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSI_ORDER_PRODUCT_TRG" 
BEFORE INSERT ON MSI_ORDER_PRODUCT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT MSI_ORDER_PRODUCT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "MSI_ORDER_PRODUCT_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table MSI_ORDER_PRODUCT
--------------------------------------------------------

  ALTER TABLE "MSI_ORDER_PRODUCT" ADD CONSTRAINT "MSI_ORDER_PRODUCT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "MSI_ORDER_PRODUCT" MODIFY ("PRODUCT_ID" NOT NULL ENABLE);
  ALTER TABLE "MSI_ORDER_PRODUCT" MODIFY ("ORDER_ID" NOT NULL ENABLE);
  ALTER TABLE "MSI_ORDER_PRODUCT" MODIFY ("QTY" NOT NULL ENABLE);
  ALTER TABLE "MSI_ORDER_PRODUCT" MODIFY ("ID" NOT NULL ENABLE);