CREATE TABLE "ig".RECPTION (
    RID INTEGER NOT NULL,
    RNAME VARCHAR(128),
    RAPPORGID VARCHAR(32),
    RETIME VARCHAR(16),
    RSTIME VARCHAR(16),
    RSCALE VARCHAR(4),
    RSTANDARD VARCHAR(4),
    RPPORG VARCHAR(256),
    RDESCRIPTION VARCHAR(256),
    RDATE VARCHAR(10),
    RSTATUS CHAR(1),
    RLODGESTANDARD VARCHAR(4),
    RLODGECOST NUMERIC(12,2) DEFAULT 0.00,
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (RID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".DEAL (
		  RID INTEGER NOT NULL , 
		  DEPTNAME VARCHAR(128) , 
		  RAPPORGID VARCHAR(32) , 
		  DEALTIME VARCHAR(16) , 
		  DEALSCALE VARCHAR(4), 
		  DEALCASH NUMERIC(12,2) DEFAULT 0.00, 
		  INVOICENUMBER VARCHAR(64) , 
		  OTHERJOINER VARCHAR(128) , 
		  DEALDESC VARCHAR(256) , 
		  RSTATUS CHAR(1) , 
		  FINGERPRINT VARCHAR(256),
		  PRIMARY KEY (RID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".RECPTIONGUEST (
    RGID INTEGER NOT NULL,
    RID INTEGER,
    RGNAME VARCHAR(32),
    RGPOST VARCHAR(64),
    RGUNIT VARCHAR(128),
    RGTEL VARCHAR(128),
    RGDATE CHAR(10),
    FINGERPRINT VARCHAR(256),
	PRIMARY KEY (RGID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".GOODS (
    GID INTEGER NOT NULL,
    GCATEGORY VARCHAR(40),
    GNAME VARCHAR(120),
    GCODE VARCHAR(32),
    GWARNINGNUM INTEGER,
    GPRICE NUMERIC(12,2) DEFAULT 0.00,
    GSTATUS CHAR(1),
    GUNIT VARCHAR(4),
    GREASON VARCHAR(40),
    FINGERPRINT VARCHAR(256),
	PRIMARY KEY (GID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".GSTOCK (
    GSID INTEGER NOT NULL,
    GSCATEGORY VARCHAR(40),
    GSNAME VARCHAR(120),
    GSCODE VARCHAR(32),
    GSNUM INTEGER,
    GSORG VARCHAR(32),
    GSAVGPRICE NUMERIC(12,2) DEFAULT 0.00,
    GSFREEZENUM INTEGER,
    GSUSERID VARCHAR(16),
    GSUSERNAME VARCHAR(32),
    GSDATE CHAR(16),
    FINGERPRINT VARCHAR(256),
	PRIMARY KEY (GSID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".GINOUTSTOCKDETAIL (
    GIODID INTEGER NOT NULL,
    GIODTYPE CHAR(1),
    GIODORG VARCHAR(32),
    GIODCATEGORY VARCHAR(40),
    GIODNAME VARCHAR(32),
    GIODTIME VARCHAR(16),
    GIODCODE VARCHAR(32),
    GIODREQNUM VARCHAR(32),
    GIODINPRICE NUMERIC(12,2) DEFAULT 0.00,
    GIODINNUM INTEGER,
    GIODUNIT VARCHAR(4),
    GIODPROVIDER VARCHAR(128),
    GIODPURCHASER VARCHAR(32),
    GIODRELIEFPRICE NUMERIC(12,2) DEFAULT 0.00,
    GIODRELIEFNUM INTEGER,
    GIODREQUSER VARCHAR(16),
    GIODREQUSERNAME VARCHAR(32),
    GIODSTATUS CHAR(1),
    GIODREQORG VARCHAR(32),
    GIODUSER VARCHAR(16),
    GIODUSERNAME VARCHAR(32),
    GIODCHKNUM INTEGER,
    GIODCHKID VARCHAR(16),
    GIODCHKKNAME VARCHAR(32),
    GOID INTEGER,
    GIOID INTEGER,
    GIODOUTNUM INTEGER,
    GIODHAVOCNUM INTEGER,
    GSNUM INTEGER,
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (GIODID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".GOUTSTOCK (
    GOID INTEGER NOT NULL,
    GOTYPE CHAR(1),
    GOORG VARCHAR(32),
    GOCATEGORY VARCHAR(40),
    GONAME VARCHAR(120),
    GOCODE VARCHAR(32),
    GOTIME VARCHAR(16),
    GOREQNUM VARCHAR(32),
    GOOUTPRICE NUMERIC(12,2) DEFAULT 0.00,
    GOINNUM INTEGER,
    GOUNIT VARCHAR(4),
    GOPROVIDER VARCHAR(128),
    GOPURCHASER VARCHAR(32),
    GORELIEFPRICE NUMERIC(12,2) DEFAULT 0.00,
    GORELIEFNUM INTEGER,
    GOSTATUS CHAR(1),
    GOREQORG VARCHAR(32),
    GOREQUSER VARCHAR(16),
    GOREQUSERNAME VARCHAR(32),
    GOUSER VARCHAR(16),
    GOUSERNAME VARCHAR(32),
    GOCHKNUM INTEGER,
    GOCHKID VARCHAR(16),
    GOCHKKNAME VARCHAR(32),
    RID INTEGER,
    GOREASON VARCHAR(40),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (GOID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".ADVANCESUMMARY (
    ASYEAR VARCHAR(4) NOT NULL,
    ASMONTH VARCHAR(2) NOT NULL,
    ASPREBALANCE NUMERIC(12,2) DEFAULT 0.00,
    ASADVANCESCOST NUMERIC(12,2) DEFAULT 0.00,
    ASLOAN NUMERIC(12,2) DEFAULT 0.00,
    ASINVOICE NUMERIC(12,2) DEFAULT 0.00,
    ASPAY NUMERIC(12,2) DEFAULT 0.00,
    ASBALANCE NUMERIC(12,2) DEFAULT 0.00,
    ASFREEZE NUMERIC(12,2) DEFAULT 0.00,
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (ASYEAR,ASMONTH)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".ADVANCESCOST (
    ACID INTEGER NOT NULL,
    ACAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    ACDATE VARCHAR(16),
    ACTYPE VARCHAR(4),
    ACCHEQUENUM VARCHAR(16),
    ACSERIAL VARCHAR(32),
    ACCOMMENT VARCHAR(256),
    ACSTATUS CHAR(1),
    ACFREEZEAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    ACINVOICEAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    ACSTOCKAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    ACINSDATE CHAR(10),
    ACCREDITDATE CHAR(10),
    ACUSERID VARCHAR(16),
    ACUSERNAME VARCHAR(32),
    ACINSTIME CHAR(19),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (ACID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".LOANPAYDETAIL (
    LPDID INTEGER NOT NULL,
    ACID INTEGER,
    LPDTYPE CHAR(1),
    LPDUSER VARCHAR(32),
    LPDDATE VARCHAR(16),
    LPDAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    LPDCOMMENT VARCHAR(256),
    LPDSTATUS CHAR(1),
    LPDPERSION VARCHAR(16),
    LPDPERSIONNAME VARCHAR(32),
    LPDINVOICEDATE CHAR(10),
    LPDINVOICENUM VARCHAR(16),
    LPDINVOICECOR VARCHAR(64),
    LPDINVOICEAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    LPDINVOICECOMMENT VARCHAR(256),
    LDID INTEGER,
    RID INTEGER,
    LPDSTOCKAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    LPDUSERORG VARCHAR(32),
    LPDACTINVOICE NUMERIC(12,2) DEFAULT 0.00,
    LPDACTUSER VARCHAR(32),
    LPDTIME CHAR(19),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (LPDID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".INVOICE (
    IID INTEGER NOT NULL,
    ITYPE CHAR(1),
    IDATE CHAR(10),
    INUM VARCHAR(16),
    IAMOUNT NUMERIC(12,2) DEFAULT 0.00,
    ICOMMENT VARCHAR(256),
    ICONTRACTSERIAL VARCHAR(16),
    ICONTRACTNAME VARCHAR(64),
    ICORPORATION VARCHAR(64),
    IBANK VARCHAR(64),
    IACCOUNT VARCHAR(16),
    IREQEMP VARCHAR(32),
    IREQUSER VARCHAR(16),
    IREQUSERNAME VARCHAR(32),
    ISTATUS CHAR(1),
    IPAYMENTTYPE CHAR(1),
    IPAYMENTTYPECODE VARCHAR(16),
    IPAYMENTDATE CHAR(10),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (IID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".EATERY (
    EID INTEGER NOT NULL,
    EDATE CHAR(10),
    ESTAPLECOST NUMERIC(12,2) DEFAULT 0.00,
    EFLAVOURINGCOST NUMERIC(12,2) DEFAULT 0.00,
    EOTHERCOST NUMERIC(12,2) DEFAULT 0.00,
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (EID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".EWORKINGLUNCH(
    EWLID INTEGER NOT NULL,
    EWLDATE CHAR(10),
    LUNCHCARDNAME VARCHAR(256),
    LUNCHCARDNUM INTEGER,
    LUNCHCARDPRINCE DECIMAL(10, 2),
    ICID	        INTEGER,
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (EWLID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".EENTERTAINMENT (
    EEID INTEGER NOT NULL,
    RID INTEGER,
    EEUSER VARCHAR(32),
    EETABLEPRICE NUMERIC(12,2) DEFAULT 0.00,
    EETABLENUM INTEGER,
    EEDRINKPRICE NUMERIC(12,2) DEFAULT 0.00,
    EESMOKEPRICE NUMERIC(12,2) DEFAULT 0.00,
    EEOTHERPRICE NUMERIC(12,2) DEFAULT 0.00,
    EEDATE CHAR(10),
    FINGERPRINT VARCHAR(256),
    PRIMARY KEY (EEID)
) TABLESPACE "IG_SPACE";

CREATE TABLE "ig".INVENTORY (
    INID INTEGER NOT NULL,
    INVENTORYDATE VARCHAR(7),
    GOODSNAME VARCHAR(60),
    GOODSCATEGORY VARCHAR(40),
    GOODSCODE VARCHAR(32),
    LMINVENTORYAMOUNT INTEGER DEFAULT 0,
    LMINVENTORYMONEY NUMERIC(12,2) DEFAULT 0.00,
    CMINPUTAMOUNT INTEGER DEFAULT 0,
    CMINPUTMONEY NUMERIC(12,2) DEFAULT 0.00,
    AVERAGE NUMERIC(12,2) DEFAULT 0.00,
    CMOUTAMOUNT INTEGER DEFAULT 0,
    CMOUTMONEY NUMERIC(12,2) DEFAULT 0.00,
    CMHAVOAMOUNT INTEGER DEFAULT 0,
    CMHAVOMONEY NUMERIC(12,2) DEFAULT 0.00,
    CMSURPLUSAMOUNT INTEGER DEFAULT 0,
    CMSURPLUSMONEY  NUMERIC(12,2) DEFAULT 0.00,
    REMARK VARCHAR(256),
    FINGERPRINT VARCHAR(256),
    CMREGAMOUNT INTEGER DEFAULT 0,
    CMREGMONEY NUMERIC(12,2) DEFAULT 0.00,
    PRIMARY KEY (INID)
) TABLESPACE "IG_SPACE";

CREATE VIEW "ig".GOutStockVW AS
    SELECT  A.GOID,
            A.GOTYPE, 
            A.GOORG, 
            A.GOCATEGORY, 
            A.GONAME, 
            A.GOCODE,
            A.GOTIME, 
            A.GOREQNUM, 
            A.GOOUTPRICE,
            A.GOINNUM, 
            A.GOUNIT, 
            A.GOPROVIDER, 
            A.GOPURCHASER, 
            A.GORELIEFPRICE, 
            A.GORELIEFNUM, 
            A.GOSTATUS,
            A.GOREQORG, 
            A.GOREQUSER,
            A.GOREQUSERNAME,
            A.GOUSER, 
            A.GOUSERNAME,
            A.GOCHKNUM, 
            A.GOCHKID, 
            A.GOCHKKNAME, 
            A.GOREASON,
            B.GSID,
            B.GSNUM,
            B.GSORG,
            B.GSAVGPRICE,
            B.GSFREEZENUM
    FROM "ig".GOutStock A
    LEFT OUTER JOIN "ig".GStock B ON(A.GOCATEGORY = B.GSCATEGORY and A.GOCODE = B.GSCODE and A.GOORG = B.GSORG);

CREATE VIEW "ig".GinoutStockDetailVW AS
     SELECT  A.GIODID,
            A.GIODTYPE, 
            A.GIODORG, 
            A.GIODCATEGORY, 
            A.GIODNAME, 
            A.GIODCODE,
            A.GIODINNUM, 
            A.GIODRELIEFNUM, 
            A.GIODHAVOCNUM, 
            A.GIODTIME,
            A.GIODREQNUM,
            A.GIODOUTNUM,
            A.GIODUNIT,
            A.GIODINPRICE, 
            B.GSID,
            B.GSNUM,
            B.GSORG,
            B.GSAVGPRICE,
            B.GSFREEZENUM
    FROM    "ig".GINOUTSTOCKDETAIL A
    LEFT OUTER JOIN "ig".GStock B ON(A.GIODCATEGORY = B.GSCATEGORY and A.GIODCODE = B.GSCODE and A.GIODORG = B.GSORG) where A.GIODTYPE = '0';

CREATE VIEW "ig".RecptionGuestInfo AS
SELECT a.rid,
          b.rname,
          b.rapporgid,
          b.retime,
          b.rstime,
          b.rpporg,
          b.rdescription FROM  "ig".RECPTIONGUEST  a,"ig".RECPTION b where a.rid=b.rid;