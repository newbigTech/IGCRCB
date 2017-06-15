CREATE TABLE IG.STOCK
(
	stockid  INTEGER  NOT NULL,
	stockorg  VARCHAR(32)  ,
	category  VARCHAR(32)  ,
	itemsname  VARCHAR(120)  ,
	seqcode  VARCHAR(32)  ,
	typecode  VARCHAR(32)  ,
	type  CHAR  ,
	status  CHAR  ,
	stocknum  INTEGER  ,
	lostnum  INTEGER  ,
	prenum  INTEGER  ,
	inamount  FLOAT  ,
	outamount  FLOAT  ,
	uptime  CHAR(16)  ,
	userid  VARCHAR(16)  ,
	username  VARCHAR(32)  ,
	fingerprint varchar(256) ,
	 PRIMARY KEY (stockid)
) TABLESPACE IG_SPACE;

CREATE TABLE IG.INSTOCK
(
	instockid  INTEGER  NOT NULL,
	instockorg  VARCHAR(32)  ,
	category  VARCHAR(32)  ,
	itemsname  VARCHAR(120)  ,
	seqcode  VARCHAR(32)  ,
	intime  CHAR(16)  ,
	seqno  VARCHAR(16)  ,
	typecode  VARCHAR(32)  ,
	type  CHAR  ,
	status  CHAR  ,
	inprice  FLOAT  ,
	inamount  FLOAT  ,
	outprice  FLOAT  ,
	outamount  FLOAT  ,
	packnum  INTEGER  ,
	bigpacknum  INTEGER  ,
	innum  INTEGER  ,
	outnum  INTEGER  ,
	lossnum  INTEGER  ,
	havocnum  INTEGER  ,
	nature  CHAR  ,
	itemversion  VARCHAR(32)  ,
	printinside  VARCHAR(32)  ,
	printexternal  VARCHAR(32)  ,
	printcompany  VARCHAR(32)  ,
	userid  VARCHAR(16)  ,
	username  VARCHAR(32)  ,
	outstockid  INTEGER  ,
	fingerprint varchar(256) ,
	 PRIMARY KEY (instockid)
) TABLESPACE IG_SPACE;

CREATE TABLE IG.OUTSTOCK
(
	outstockid  INTEGER  NOT NULL,
	instockid  INTEGER,
	outstockorg  VARCHAR(32)  ,
	category  VARCHAR(32)  ,
	itemsname  VARCHAR(120)  ,
	seqcode  VARCHAR(32)  ,
	typecode  VARCHAR(32)  ,
	seqno  VARCHAR(16)  ,
	type  CHAR  ,
	outtype  CHAR  ,
	reqorg  VARCHAR(32)  ,
	reqid  VARCHAR(16)  ,
	reqname  VARCHAR(32)  ,
	reqtime  CHAR(16)  ,
	reqnum  INTEGER  ,
	chknum  INTEGER  ,
	outnum  INTEGER  ,
	chkreason  VARCHAR(32)  ,
	pakreason  VARCHAR(32)  ,
	packno  VARCHAR(16)  ,
	chkid VARCHAR(16)  ,
	chkname  VARCHAR(16)  ,
	chktime  CHAR(16)  ,
	stockuserid  VARCHAR(16)  ,
	stockname  VARCHAR(32)  ,
	outtime  CHAR(16)  ,
	rcvid  VARCHAR(16)  ,
	rcvname  VARCHAR(32)  ,
	rcvtime  CHAR(16)  ,
	reqstatus  CHAR  ,
	accountstatus  CHAR  ,
	inprice  FLOAT  ,
	outprice  FLOAT  ,
	outamount  FLOAT  ,
	bigpacknum  INTEGER  ,
	smallpacknum  INTEGER  ,
	itemversion  VARCHAR(32)  ,
	stockid  INTEGER  ,
	stocknum  INTEGER  ,
	fingerprint varchar(256) ,
	paytime  CHAR(16)  ,
	 PRIMARY KEY (outstockid)
) TABLESPACE IG_SPACE;

CREATE TABLE IG.OutStockDetail
(
	id  INTEGER  NOT NULL,
	outstockid  INTEGER,
	instockid  INTEGER,
	outstockorg  VARCHAR(32)  ,
	category  VARCHAR(32)  ,
	itemsname  VARCHAR(120)  ,
	seqcode  VARCHAR(32)  ,
	typecode  VARCHAR(32)  ,
	seqno  VARCHAR(16)  ,
	inseqno  VARCHAR(16)  ,
	type  CHAR  ,
	outtype  CHAR  ,
	reqorg  VARCHAR(32)  ,
	reqid  VARCHAR(16)  ,
	reqname  VARCHAR(32)  ,
	reqtime  CHAR(16)  ,
	reqnum  INTEGER  ,
	chknum  INTEGER  ,
	outnum  INTEGER  ,
	chkreason  VARCHAR(32)  ,
	pakreason  VARCHAR(32)  ,
	packno  VARCHAR(16)  ,
	chkid VARCHAR(16)  ,
	chkname  VARCHAR(16)  ,
	chktime  CHAR(16)  ,
	stockuserid  VARCHAR(16)  ,
	stockname  VARCHAR(32)  ,
	outtime  CHAR(16)  ,
	rcvid  VARCHAR(16)  ,
	rcvname  VARCHAR(32)  ,
	rcvtime  CHAR(16)  ,
	reqstatus  CHAR  ,
	accountstatus  CHAR  ,
	inprice  FLOAT  ,
	outprice  FLOAT  ,
	outamount  FLOAT  ,
	bigpacknum  INTEGER  ,
	smallpacknum  INTEGER  ,
	itemversion  VARCHAR(32)  ,
	stockid  INTEGER  ,
	stocknum  INTEGER  ,
	fingerprint varchar(256) ,
	paytime  CHAR(16)  ,
	 PRIMARY KEY (id)
) TABLESPACE IG_SPACE;

CREATE TABLE IG.ITEMSCATEGORY
(
	icid  INTEGER  NOT NULL,
	category  VARCHAR(32)  ,
	seqcode  VARCHAR(32)  ,
	typecode  VARCHAR(120)  ,
	type  VARCHAR(32)  ,
	idesc  VARCHAR(128)  ,
	status  CHAR  ,
	fingerprint varchar(256) ,
	 PRIMARY KEY (icid)
) TABLESPACE IG_SPACE;

CREATE TABLE IG.ITEMSCODES
(
	icid  INTEGER  NOT NULL,
	selectid  VARCHAR(32)  ,
	selectname  VARCHAR(32)  ,
	typecode  VARCHAR(32)  ,
	typename  VARCHAR(32)  ,
    type  VARCHAR(32)  ,
	idesc  VARCHAR(128)  ,
	status  CHAR  ,
	fingerprint varchar(256) ,
	 PRIMARY KEY (icid)
) TABLESPACE IG_SPACE;

CREATE VIEW IG.OutStockVW AS
    SELECT  A.outstockid,
            A.outstockorg, 
            A.category, 
            A.seqcode, 
            A.typecode, 
            A.seqno,
            A.outtype,
            A.reqorg, 
            A.reqid,
            A.reqname, 
            A.reqtime, 
            A.reqnum, 
            A.chknum, 
            A.outnum, 
            A.chkreason, 
            A.pakreason,
            A.packno, 
            A.chkid,
            A.chkname,
            A.chktime, 
            A.stockuserid, 
            A.stockname, 
            A.outtime, 
            A.rcvid, 
            A.rcvname,
            A.rcvtime, 
            A.reqstatus, 
            A.accountstatus,
            A.inprice,
            A.outprice,    
            A.outamount,
            A.bigpacknum, 
            A.smallpacknum, 
            A.itemversion, 
            A.stockid, 
            A.itemsname, 
            A.type,
            B.stocknum,
            B.stockid as sid,
            B.stockorg
    FROM IG.OutStock A
    LEFT OUTER JOIN IG.Stock B ON(A.category = B.category and A.seqcode = B.seqcode and A.outstockorg = B.stockorg);
