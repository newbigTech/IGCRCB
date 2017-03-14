CREATE TABLESPACE SOC_SPACE OWNER postgres LOCATION 'D:\Program Files\PostgreSQL\9.2\tablespace\SOC_SPACE';

create sequence soc0101 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0101  (
	CIID INTEGER NOT NULL DEFAULT nextval('soc0101'), 
	CID INTEGER , 
	EIID INTEGER , 
	EID INTEGER , 
	CIVALUE VARCHAR(2000) , 
	CIUPDTIME CHAR(16) , 
	ESYSCODING VARCHAR(32) , 
	CIEXPIRE CHAR(16) , 
	CISTATUS CHAR(1) , 
	CICURVER CHAR(1) , 
	CIVERINFO VARCHAR(128) , 
	CISMALLVERSION INTEGER , 
	CIVERSION INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (CIID)
)TABLESPACE SOC_SPACE;

create sequence soc0102 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0102  (
	EIID INTEGER NOT NULL DEFAULT nextval('soc0102'), 
	EID INTEGER , 
	EIDESC VARCHAR(256) , 
	EINAME VARCHAR(128) , 
	EILABEL VARCHAR(128) , 
	EIINSDATE CHAR(10) , 
	EIORGSYSCODING VARCHAR(32) , 
	ESYSCODING VARCHAR(32) , 
	EIUPDTIME CHAR(16) , 
	EISTATUS CHAR(1) , 
	EIUSERID VARCHAR(16) , 
	EIUSERNAME VARCHAR(32) , 
	EIROOTMARK INTEGER , 
	EISMALLVERSION INTEGER , 
	EIVERSION INTEGER , 
	FINGERPRINT VARCHAR(256), 
	PRIMARY KEY (EIID)
)TABLESPACE SOC_SPACE;

create sequence soc0103 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0103  (
	AURID INTEGER NOT NULL DEFAULT nextval('soc0103'), 
	AUTID INTEGER NOT NULL , 
	AUTIME CHAR(16) NOT NULL , 
	AUCMPTYPE CHAR(1) , 
	EIID INTEGER , 
	EIVERSION INTEGER , 
	EISMALLVERSION INTEGER , 
	EINAME VARCHAR(128) , 
	EIROOTMARK INTEGER , 
	ESYSCODING VARCHAR(32) , 
	CIID INTEGER , 
	CNAME VARCHAR(128) , 
	CIVALUE VARCHAR(2000) , 
	AUVALUE VARCHAR(2000) , 
	AUFLAG CHAR(1) , 
	AURESULTDESC VARCHAR(256) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (AURID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0104  (
	AUTID INTEGER NOT NULL , 
	AUTDESC VARCHAR(256) , 
	AUTTIME CHAR(16) NOT NULL , 
	AUTSTATUS CHAR(1) , 
	AUTUPDTIME VARCHAR(16) , 
	AUTCOMPTIME VARCHAR(16) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (AUTID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0105  (
	AUWTID INTEGER NOT NULL , 
	AUWTCREATETIME CHAR(16) , 
	AUWTFILENAME VARCHAR(64) , 
	AUWTTOPCI VARCHAR(128) , 
	AUWTSTATUS CHAR(1) , 
	AUWTPARSESTART CHAR(16) , 
	AUWTPARSEEND CHAR(16) , 
	AUWTCISTART CHAR(16) , 
	AUWTCIEND CHAR(16) , 
	DELETEFLAG CHAR(1) , 
	FINGERPRINT VARCHAR(256) , 
	IMPTYPEID INTEGER,
	PRIMARY KEY (AUWTID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0116 (
	EWTID INTEGER NOT NULL,
	FILENAME VARCHAR(512),
	USERID VARCHAR(256),
	EINAME VARCHAR(256),
	EITID VARCHAR(32),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (EWTID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0117  (
	EID INTEGER NOT NULL , 
	ENAME VARCHAR(128) , 
	ELABEL VARCHAR(32) , 
	EDESC VARCHAR(256) , 
	ESTATUS CHAR(1) , 
	ECATEGORY VARCHAR(16) , 
	EKEY1 VARCHAR(16) , 
	EKEY2 VARCHAR(16) , 
	EKEY3 VARCHAR(16) , 
	ESYSCODING VARCHAR(32) , 
	EPARCODING VARCHAR(32) , 
	FINGERPRINT VARCHAR(256) , 
	EMODELTYPE CHAR(1),
	PRIMARY KEY (EID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0109  (
	CID INTEGER NOT NULL , 
	EID INTEGER NOT NULL , 
	CNAME VARCHAR(128) , 
	CLABEL VARCHAR(32) , 
	CDESC VARCHAR(40) , 
	CUNIT VARCHAR(16) , 
	CSTATUS CHAR(1) , 
	CSEQ INTEGER , 
	CCATEGORY VARCHAR(16) , 
	COPTION VARCHAR(64) , 
	CATTACH CHAR(1) , 
	ESYSCODING VARCHAR(32) , 
	FINGERPRINT VARCHAR(256) , 
	CREQUIRED VARCHAR(8),
	PRIMARY KEY (CID), 
	FOREIGN KEY (EID) REFERENCES IG.SOC0117(EID) ON DELETE CASCADE
)TABLESPACE SOC_SPACE;

create sequence soc0107 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0107  (
	CIID INTEGER NOT NULL DEFAULT nextval('soc0107'), 
	CID INTEGER NOT NULL , 
	EIID INTEGER NOT NULL , 
	EID INTEGER NOT NULL , 
	CIVALUE VARCHAR(2000) , 
	CIUPDTIME CHAR(16) , 
	ESYSCODING VARCHAR(32) , 
	CIEXPIRE CHAR(16) , 
	CISTATUS CHAR(1) , 
	CICURVER CHAR(1) , 
	CIVERSION INTEGER , 
	CIVERINFO VARCHAR(128) , 
	FINGERPRINT VARCHAR(256) , 
	CISMALLVERSION INTEGER,
	PRIMARY KEY (CIID), 
	FOREIGN KEY (CID) REFERENCES IG.SOC0109(CID) ON DELETE CASCADE
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0108  (
	ciid  INTEGER NOT NULL,
	cid  INTEGER  NOT NULL,
	eiid  INTEGER  NOT NULL,
	eid  INTEGER  NOT NULL,
	civalue  VARCHAR(2000)  ,
	ciupdtime  CHAR(16)  ,
	esyscoding VARCHAR(32)  ,
	ciexpire  CHAR(16)  ,
	cistatus  CHAR  ,
	cicurver  CHAR  ,
	civersion  INTEGER  ,
	civerinfo  VARCHAR(128) ,
	fingerprint varchar(256) ,
	cismallversion INTEGER ,
	PRIMARY KEY (ciid)
)TABLESPACE SOC_SPACE;

create sequence soc0110 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0110  (
	BRID INTEGER NOT NULL DEFAULT nextval('soc0110'), 
	BRPAREIID INTEGER NOT NULL , 
	BRPARVERSION INTEGER NOT NULL , 
	BRPARSMALLVERSION INTEGER NOT NULL , 
	BRCLDEIID INTEGER NOT NULL , 
	BRCLDVERSION INTEGER NOT NULL , 
	BRCLDSMALLVERSION INTEGER NOT NULL , 
	BRTYPE CHAR(1) , 
	BRDES VARCHAR(256) , 
	BRCREATETIME CHAR(16) , 
	BRRALETIONCODE VARCHAR(32) , 
	BRASSETRELATION VARCHAR(4) , 
	EIROOTMARK INTEGER , 
	DELETEFLAG CHAR(1) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (BRID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0111  (
	EIDDID INTEGER NOT NULL , 
	VERSION INTEGER NOT NULL , 
	NAME VARCHAR(64) , 
	DESCRIPTION VARCHAR(512) , 
	CREATETIME CHAR(16) , 
	UPDATETIME CHAR(16) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (EIDDID,VERSION)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0112  (
	EIDDID INTEGER NOT NULL , 
	EIDDVERSION INTEGER NOT NULL , 
	EINAME VARCHAR(128) NOT NULL , 
	EIIMPORTVERSION INTEGER NOT NULL , 
	CREATETIME CHAR(16) , 
	DELETEFLAG CHAR(1) , 
	FINGERPRINT VARCHAR(256) , 
	MODIFYFLAG CHAR(1),
	PRIMARY KEY (EIDDID,EIDDVERSION,EINAME,EIIMPORTVERSION)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0113  (
	IMPTYPEID INTEGER NOT NULL , 
	IMPTYPENAME VARCHAR(32) , 
	IMPPROGRAMME VARCHAR(32) , 
	IMPPROGRAMMEAUDIT VARCHAR(32) , 
	IMPPROGRAMMEUPDATE VARCHAR(32) , 
	FINGERPRINT VARCHAR(256) , 
	COLLECTTYPE CHAR(1) , 
	SHELLNAME VARCHAR(64),
	PRIMARY KEY (IMPTYPEID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0114  (
	DOMAINID INTEGER NOT NULL , 
	DOMAINVERSION INTEGER NOT NULL , 
	LINKID INTEGER NOT NULL , 
	LINKORDER INTEGER NOT NULL , 
	EIID INTEGER , 
	EINAME VARCHAR(256) , 
	ESYSCODING VARCHAR(32) , 
	EIVERSION INTEGER , 
	EISMALLVERSION INTEGER , 
	CREATETIME CHAR(16) , 
	LINKFLAG CHAR(1) , 
	ENDFLAG CHAR(1) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (DOMAINID,DOMAINVERSION,LINKID,LINKORDER)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0115  (
	EITID INTEGER NOT NULL , 
	EITCREATETIME CHAR(16) , 
	EITTOPCI VARCHAR(128) , 
	EITFILENAME VARCHAR(64) , 
	EITSTATUS CHAR(1) , 
	EITPARSESTART CHAR(16) , 
	EITPARSEEND CHAR(16) , 
	EITCISTART CHAR(16) , 
	EITCIEND CHAR(16) , 
	EITRELATIONSTART CHAR(16) , 
	EITRELATIONEND CHAR(16) , 
	FINGERPRINT VARCHAR(256) , 
	DELETEFLAG CHAR(1) , 
	IMPTYPEID INTEGER,
	PRIMARY KEY (EITID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0106 (
	AWTID INTEGER NOT NULL,
	FILENAME VARCHAR(512),
	BATNAME VARCHAR(256),
	EINAME VARCHAR(256),
	AUWTID VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (AWTID)
)TABLESPACE SOC_SPACE;

create sequence soc0118 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0118  (
	EIID INTEGER NOT NULL DEFAULT nextval('soc0118'), 
	EID INTEGER NOT NULL , 
	EIDESC VARCHAR(256) , 
	EINAME VARCHAR(128) , 
	EILABEL VARCHAR(128) , 
	EIINSDATE CHAR(10) , 
	EIORGSYSCODING VARCHAR(32) , 
	ESYSCODING VARCHAR(32) , 
	EIUPDTIME CHAR(16) , 
	EISTATUS CHAR(1) , 
	EIVERSION INTEGER , 
	FINGERPRINT VARCHAR(256) , 
	EIUSERID VARCHAR(16) , 
	EIUSERNAME VARCHAR(32) , 
	EISMALLVERSION INTEGER , 
	EIROOTMARK INTEGER, 
	PRIMARY KEY (EIID), 
	FOREIGN KEY (EID) REFERENCES IG.SOC0117(EID) ON DELETE CASCADE, 
	FOREIGN KEY (EIROOTMARK) REFERENCES IG.SOC0118(EIID) ON DELETE CASCADE
)TABLESPACE SOC_SPACE;

create sequence soc0119 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0119  (
	EIRID INTEGER NOT NULL DEFAULT nextval('soc0119'), 
	PAREIID INTEGER NOT NULL , 
	PAREID INTEGER NOT NULL , 
	CLDEIID INTEGER NOT NULL , 
	CLDEID INTEGER NOT NULL , 
	EIRRELATION VARCHAR(4) , 
	EIRRELATIONCODE VARCHAR(32) , 
	EIRUPDTIME CHAR(16) , 
	EIRSTATUS CHAR(1) , 
	EIRDESC VARCHAR(256) , 
	FINGERPRINT VARCHAR(256) , 
	EIRINFO VARCHAR(32) , 
	PARVERSION INTEGER , 
	PARSMALLVERSION INTEGER , 
	CLDVERSION INTEGER , 
	CLDSMALLVERSION INTEGER , 
	DELETEFLAG CHAR(1), 
	PRIMARY KEY (EIRID)
)TABLESPACE SOC_SPACE;


CREATE INDEX CLDEIID ON IG.SOC0119 (CLDEIID ASC);

CREATE INDEX PAREIID ON IG.SOC0119 (PAREIID ASC);

CREATE TABLE IG.SOC0120  (
	IMPVERSION INTEGER NOT NULL , 
	IMPEINAME VARCHAR(128) NOT NULL , 
	IMPEIID INTEGER NOT NULL , 
	IMPCITYPE INTEGER , 
	IMPFILENAME VARCHAR(64) , 
	IMPCREATETIME CHAR(16) , 
	DELETEFLAG CHAR(1) , 
	ESYSCODING VARCHAR(32) , 
	FINGERPRINT VARCHAR(256) , 
	IMPIP VARCHAR(32) , 
	IMPUSERID VARCHAR(32) , 
	IMPPASSWORD VARCHAR(32) , 
	IMPSTATUS CHAR(1),
	PRIMARY KEY (IMPVERSION,IMPEINAME)
)TABLESPACE SOC_SPACE;

create sequence soc0121 minvalue 1 no maxvalue start with 1000 increment by 1;
CREATE TABLE IG.SOC0121  (
	SRID INTEGER NOT NULL DEFAULT nextval('soc0118'), 
	SRDOMAINID INTEGER NOT NULL , 
	SRARITHMETICTYPE CHAR(1) , 
	SRDOMAINVERSION INTEGER NOT NULL , 
	SRPAREIID INTEGER NOT NULL , 
	SRPARVERSION INTEGER NOT NULL , 
	SRPARSMALLVERSION INTEGER NOT NULL , 
	SRCLDEIID INTEGER NOT NULL , 
	SRCLDVERSION INTEGER NOT NULL , 
	SRCLDSMALLVERSION INTEGER NOT NULL , 
	SRTYPE CHAR(1) , 
	SRDES VARCHAR(256) , 
	SRCREATETIME CHAR(16) , 
	DELETEFLAG CHAR(1) , 
	SRRALETIONCODE VARCHAR(32) , 
	SRASSETRELATION VARCHAR(4) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SRID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0122  (
	MAPID INTEGER NOT NULL , 
	EIDOMAINID INTEGER NOT NULL , 
	SNAPSHOTBAT VARCHAR(32) NOT NULL , 
	EIDOMAINDESC VARCHAR(128),
	PRIMARY KEY (MAPID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0201  (
	ID INTEGER NOT NULL , 
	DATAID VARCHAR(64) NOT NULL , 
	R_CATEGORY VARCHAR(8) NOT NULL , 
	R_PATH VARCHAR(180) NOT NULL , 
	R_RCID INTEGER NOT NULL , 
	R_TIME VARCHAR(10) NOT NULL , 
	FINGERPRINT VARCHAR(256)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0202  (
	RAID INTEGER NOT NULL , 
	RANAME VARCHAR(256) , 
	RASSN VARCHAR(64) , 
	RAKPI VARCHAR(64) , 
	RACREATEDATE VARCHAR(19) , 
	RAUSERNAME VARCHAR(32) , 
	RAREALNAME VARCHAR(128) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (RAID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0203  (
	ID INTEGER NOT NULL , 
	DATAID VARCHAR(64) NOT NULL , 
	R_PATH VARCHAR(128) NOT NULL , 
	R_TITLE VARCHAR(128) NOT NULL , 
	PARA VARCHAR(64) , 
	FINGERPRINT VARCHAR(256)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0204  (
	RCLID INTEGER NOT NULL,
	RCLREPORTTYPE VARCHAR(2),
	RCLOBJNAME VARCHAR(128),
	RCLRFDTITLE VARCHAR(128),
	RCLTEMNAME VARCHAR(128),
	RCLTEMDESC VARCHAR(512),
	RCLOBJEIID INTEGER,
	RCLOBJTYPE VARCHAR(64),
	RCLMODE VARCHAR(16),
	RCLCATYPE VARCHAR(16),
	RCLMENUDEFAULT VARCHAR(64),
	RCLUSERID VARCHAR(64),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (RCLID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0205  (
	RMID INTEGER NOT NULL , 
	RMNAME VARCHAR(128) , 
	RTID INTEGER , 
	RMYEAR VARCHAR(4) , 
	RMQUARTER VARCHAR(1) , 
	RMMONTH VARCHAR(2) , 
	CREATEDATE VARCHAR(19) , 
	LASTANNEXATIONDATE VARCHAR(19) , 
	RMDATETYPE VARCHAR(1) , 
	RMLASTDAY VARCHAR(10) , 
	RASTR VARCHAR(256) , 
	RTNAME VARCHAR(128) , 
	RMSUFFIX VARCHAR(8) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (RMID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0206  (
	RTMID INTEGER NOT NULL , 
	RTNUMBER INTEGER , 
	RTMSSN VARCHAR(64) , 
	RTMKPI VARCHAR(64) , 
	RTMIMGNUMBER INTEGER , 
	RTMFLAG VARCHAR(128) , 
	RTMUSED VARCHAR(1) , 
	RTMSSNTYPE VARCHAR(32) , 
	FINGERPRINT VARCHAR(256) , 
	RTID INTEGER,
	PRIMARY KEY (RTMID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0207  (
	RTID INTEGER NOT NULL , 
	RTNAME VARCHAR(128) , 
	RTSUM INTEGER , 
	RTDATETYPE VARCHAR(1) , 
	RTREALNAME VARCHAR(128) , 
	RTUPLOADTIME VARCHAR(19) , 
	RTTYPE VARCHAR(128) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (RTID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0208  (
	PRTYPE VARCHAR(3) NOT NULL , 
	PIVARALUE VARCHAR(3000) NOT NULL , 
	EFFICIENCYTIME VARCHAR(16) NOT NULL , 
	MONTHEFFICIENCY VARCHAR(32) , 
	HISTORYEFFICIENCY VARCHAR(32) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PRTYPE,PIVARALUE,EFFICIENCYTIME)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0301  (
	ID INTEGER NOT NULL , 
	MTID INTEGER NOT NULL , 
	MTONAME VARCHAR(64) , 
	MTKPI VARCHAR(64) , 
	KPIVALUE DECIMAL(26,6) , 
	TIMESTAMP VARCHAR(20) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0302  ( 
	MTID INTEGER , 
	TIMESTAMP VARCHAR(20) , 
	IOPS DECIMAL(26,6) , 
	IO_READ DECIMAL(26,6) , 
	IO_WRITE DECIMAL(26,6) , 
	RW_HITS DECIMAL(26,6) , 
	KB_READ DECIMAL(26,6) , 
	KB_WRITE DECIMAL(26,6) 
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0303  ( 
	ID INTEGER NOT NULL , 
	MTCNAME VARCHAR(64) , 
	MTKPI VARCHAR(64) , 
	KPIINDEX INTEGER,
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0304  ( 
	MTID INTEGER NOT NULL , 
	MTSSN VARCHAR(64) , 
	MTCNAME VARCHAR(20) , 
	MTKPI VARCHAR(64) , 
	MTOBJNAMES VARCHAR(512) , 
	MTINTERVAL INTEGER , 
	MTNUM INTEGER , 
	MTSTARTTIME VARCHAR(19) , 
	MTSTOPTIME VARCHAR(19) , 
	MTPSTOPTIME VARCHAR(19) , 
	MTSTATUS CHAR(1) DEFAULT '0' , 
	MTRECORDTIME VARCHAR(19) , 
	MTUSERID VARCHAR(16) , 
	MTORGID VARCHAR(32) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MTID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0305  (
	ID serial , 
	DETECTIONTIME VARCHAR(19) NOT NULL , 
	DIR VARCHAR(32) , 
	SRC VARCHAR(32) , 
	CATEGORY VARCHAR(32) , 
	SEVERITY VARCHAR(32) , 
	ERRORNUM VARCHAR(32) , 
	ERRORDESC VARCHAR(512) , 
	EIROOTMARK VARCHAR(64) , 
	STATE VARCHAR(1) , 
	SORT VARCHAR(32) , 
	IMPTYPENAME VARCHAR(64) , 
	IMPTYPEID INTEGER , 
	LPARNAM VARCHAR(64) , 
	IP VARCHAR(32) , 
	REPORTINGMTMS VARCHAR(128) , 
	FAILINGENCLOSUREMTMS VARCHAR(128) , 
	FRU1LOC VARCHAR(128) , 
	FRU2LOC VARCHAR(128) , 
	FRU3LOC VARCHAR(128) , 
	FINGERPRINT VARCHAR(256) , 
	ALARMTYPE VARCHAR(2) , 
	STATUS VARCHAR(1) DEFAULT '0', 
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0306  (
	ID INTEGER NOT NULL , 
	SYMMID VARCHAR(64) , 
	DATAITMES VARCHAR(20) , 
	SYMTYPE VARCHAR(20) , 
	READDATE VARCHAR(10) , 
	FINGERPRINT VARCHAR(256), 
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0401  ( 
	DBID serial , 
	DBNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (DBID)
)TABLESPACE SOC_SPACE;
CREATE TABLE IG.SOC0402  ( 
	DBID serial , 
	DBNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (DBID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0403  ( 
	DBID serial , 
	DBNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (DBID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0404  ( 
	DBID serial , 
	DBNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (DBID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0405  ( 
	LVID serial , 
	HOSTNAME VARCHAR(32) , 
	VGNAME VARCHAR(32) , 
	LVTYPE VARCHAR(16) , 
	LVNAME VARCHAR(32) , 
	LVSIZE INTEGER , 
	LVSTATE VARCHAR(1) , 
	FSNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (LVID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0406  ( 
	LVID serial , 
	HOSTNAME VARCHAR(32) , 
	VGNAME VARCHAR(32) , 
	LVTYPE VARCHAR(16) , 
	LVNAME VARCHAR(32) , 
	LVSIZE INTEGER , 
	LVSTATE VARCHAR(1) , 
	FSNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (LVID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0407  ( 
	LVID serial , 
	HOSTNAME VARCHAR(32) , 
	VGNAME VARCHAR(32) , 
	LVTYPE VARCHAR(16) , 
	LVNAME VARCHAR(32) , 
	LVSIZE INTEGER , 
	LVSTATE VARCHAR(1) , 
	FSNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (LVID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0408  ( 
	LVID serial , 
	HOSTNAME VARCHAR(32) , 
	VGNAME VARCHAR(32) , 
	LVTYPE VARCHAR(16) , 
	LVNAME VARCHAR(32) , 
	LVSIZE INTEGER , 
	LVSTATE VARCHAR(1) , 
	FSNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (LVID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0409  ( 
	PHID serial , 
	SNAME VARCHAR(64) , 
	HOSTNAME VARCHAR(32) , 
	VGNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	LUNID VARCHAR(32) , 
	PVSIZE INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PHID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0410  ( 
	PSID serial , 
	SNAME VARCHAR(64) , 
	LUNID VARCHAR(32) , 
	PVSIZE INTEGER , 
	ISUSED VARCHAR(1) , 
	CREATEDATE VARCHAR(16) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0411  ( 
	SCID serial , 
	SNAME VARCHAR(64) NOT NULL , 
	CREATEDATE VARCHAR(16) , 
	RAWCAPACITY INTEGER , 
	EFFECTIVECAPACITY INTEGER , 
	REDUNDANCYCAPACITY INTEGER , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	DISKCOUNT INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SCID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0412  ( 
	SCID serial , 
	SNAME VARCHAR(64) NOT NULL , 
	CREATEDATE VARCHAR(16) , 
	RAWCAPACITY INTEGER , 
	EFFECTIVECAPACITY INTEGER , 
	REDUNDANCYCAPACITY INTEGER , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	DISKCOUNT INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SCID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0413  ( 
	SCID serial , 
	SNAME VARCHAR(64) NOT NULL , 
	CREATEDATE VARCHAR(16) , 
	RAWCAPACITY INTEGER , 
	EFFECTIVECAPACITY INTEGER , 
	REDUNDANCYCAPACITY INTEGER , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	DISKCOUNT INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SCID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0414  ( 
	SCID serial , 
	SNAME VARCHAR(64) NOT NULL , 
	CREATEDATE VARCHAR(16) , 
	RAWCAPACITY INTEGER , 
	EFFECTIVECAPACITY INTEGER , 
	REDUNDANCYCAPACITY INTEGER , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	DISKCOUNT INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (SCID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0415  ( 
	TSID serial , 
	TSNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	DBNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (TSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0416  ( 
	TSID serial , 
	TSNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	DBNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (TSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0417  ( 
	TSID serial , 
	TSNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	DBNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (TSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0418  ( 
	TSID serial , 
	TSNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	DBNAME VARCHAR(32) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (TSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0419  ( 
	VGID serial , 
	VGNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VGID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0420  ( 
	VGID serial , 
	VGNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VGID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0421  ( 
	VGID serial , 
	VGNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VGID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0422  ( 
	VGID serial , 
	VGNAME VARCHAR(32) , 
	HOSTNAME VARCHAR(32) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	FREECAPACITY INTEGER , 
	USEDCAPACITY INTEGER , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (VGID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0423  ( 
	ID serial , 
	NAME VARCHAR(64) , 
	OBJECTTYPE VARCHAR(32) , 
	OBJECTNAME VARCHAR(64) , 
	FINGERPRINT VARCHAR(256),
	ERRORNUM INTEGER ,
	WARNINGNUM INTEGER ,
	STATUS INTEGER ,
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0424  ( 
	REPORTNAME VARCHAR(64) NOT NULL , 
	RTTYPE VARCHAR(32) , 
	STORAGETYPE VARCHAR(32) , 
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (REPORTNAME)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0425  ( 
	ID serial , 
	BCID INTEGER , 
	BCNAME VARCHAR(128) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	USEDCAPACITY INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0426  ( 
	ID serial , 
	BCID INTEGER , 
	BCNAME VARCHAR(128) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER ,
	USEDCAPACITY INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0427  ( 
	ID serial , 
	BCID INTEGER , 
	BCNAME VARCHAR(128) , 
	SNAME VARCHAR(64) , 
	CREATEDATE VARCHAR(16) , 
	ALLOTTEDCAPACITY INTEGER , 
	USEDCAPACITY INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0433( 
	ID serial ,
	VIONAME VARCHAR(64),
	HOSTNAME VARCHAR(64),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0434(
	PVVID serial ,
	SN VARCHAR(64),
	PVID VARCHAR(64),
	SNAME VARCHAR(64),
	LUNID VARCHAR(32),
	PVSIZE INTEGER,
	ISUSED VARCHAR(1),
	CREATEDATE VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PVVID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0435
(
	PHID serial ,
	SNAME VARCHAR(64),
	HOSTNAME VARCHAR(32),
	VGNAME VARCHAR(32),
	CREATEDATE VARCHAR(16),
	LUNID VARCHAR(32),
	PVSIZE INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PHID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0436
(
	PSID serial ,
	SNAME VARCHAR(64),
	LUNID VARCHAR(32),
	PVSIZE INTEGER,
	ISUSED VARCHAR(1),
	CREATEDATE VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (PSID)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SOC0147(
	DETECTIONDAY CHAR(10) , 
	DETECTIONMIN CHAR(8) , 
	DIR VARCHAR(32) , 
	ERRORNUM VARCHAR(32) , 
	EIROOTMARK VARCHAR(64) , 
	FINGERPRINT VARCHAR(256) 
)TABLESPACE SOC_SPACE;

 CREATE TABLE IG.SOC0151(
	CCDID INTEGER NOT NULL , 
	CCDCATEGORY VARCHAR(3) , 
	CCDLABEL VARCHAR(32) , 
	CCDVALUE VARCHAR(32) , 
	CCDSTATUS CHAR(1) , 
	CCDTYPE CHAR(1) , 
	CCDINFO VARCHAR(64) , 
	FINGERPRINT VARCHAR(256), 
	PRIMARY KEY (CCDID)
)TABLESPACE SOC_SPACE;


CREATE TABLE IG.ERRORDESCDEF
(
	ERRORDESC VARCHAR(256) NOT NULL,
	FILTERFLAG VARCHAR(1),
	LEVEL INTEGER,
	PRIMARY KEY (ERRORDESC)
)TABLESPACE SOC_SPACE;


CREATE TABLE IG.BOMC
(
	ID INTEGER NOT NULL , 
	IMPTYPEID VARCHAR(32) , 
	SEVERITY VARCHAR(32) , 
	ERRORNUM VARCHAR(32) , 
	STATE VARCHAR(1),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE ; 

CREATE TABLE IG.PORTRELATION
(
	HBAPORT_WWN VARCHAR(32) NOT NULL,
	DEVICESNAME VARCHAR(8) NOT NULL,
	SYMMETRIXID VARCHAR(32) NOT NULL,
	FANAME VARCHAR(16) NOT NULL,
	FAPORTNAME VARCHAR(16) NOT NULL,
	HYPERTYPE VARCHAR(2),
	CREATETIME VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (HBAPORT_WWN, DEVICESNAME, SYMMETRIXID, FANAME, FAPORTNAME)
)TABLESPACE SOC_SPACE;

CREATE TABLE IG.SERVEEFFICIENCY
(
	 PRTYPE VARCHAR(3) NOT NULL , 
	 PIVARALUE VARCHAR(3000) NOT NULL , 
	 EFFICIENCYTIME VARCHAR(16) NOT NULL , 
	 MONTHEFFICIENCY VARCHAR(32) , 
	 HISTORYEFFICIENCY VARCHAR(32) , 
	 FINGERPRINT VARCHAR(256),
     PRIMARY KEY(PRTYPE,PIVARALUE,EFFICIENCYTIME)
)TABLESPACE SOC_SPACE; 