CREATE OR REPLACE  VIEW IG050 AS
    SELECT  B.CIID,
        B.CID,
        B.EIID,
        A.CNAME,
        A.CDESC,
        A.CUNIT,
        A.CSTATUS,
        A.CCATEGORY,
        A.CSEQ,
        A.CLABEL,
        A.COPTION,
        B.CIVALUE,
        B.CIUPDTIME,
        B.CIEXPIRE,
        B.CISTATUS,
        B.CIVERSION,
        B.CISMALLVERSION,
        B.CIVERINFO,
        B.CICURVER
    FROM 
        IG225 A, IG800 B
    WHERE A.CID = B.CID; 

CREATE OR REPLACE  VIEW IG601 AS
    SELECT  A.EIID AS EIID, 
    A.EID AS EID, 
    A.EILABEL AS EILABEL, 
    A.EINAME AS EINAME, 
    A.EIDESC AS EIDESC,
    A.EIVERSION AS EIVERSION, 
    A.EIINSDATE AS EIINSDATE,
    C.CIVALUE AS X_TOTAL,
    D.CIVALUE AS Y_TOTAL, 
    E.CIVALUE AS MANAGER, 
    F.CIVALUE AS TEL ,
    G.CIVALUE AS RELATEROOM,
    H.CIVALUE AS RELATEX,I.CIVALUE AS RELATEY   
    FROM IG013 A INNER JOIN IG117 B ON (A.EID = B.EID AND B.ECATEGORY = '007') 
    LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0017') 
    LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0018') 
    LEFT OUTER JOIN IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EISMALLVERSION = E.CISMALLVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0019') 
    LEFT OUTER JOIN IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EISMALLVERSION = F.CISMALLVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0020')
    LEFT OUTER JOIN IG050 G ON (A.EIVERSION = G.CIVERSION AND A.EISMALLVERSION = G.CISMALLVERSION AND A.EIID = G.EIID AND G.CLABEL = 'IG_0101') 
    LEFT OUTER JOIN IG050 H ON (A.EIVERSION = H.CIVERSION AND A.EISMALLVERSION = H.CISMALLVERSION AND A.EIID = H.EIID AND H.CLABEL = 'IG_0102') 
    LEFT OUTER JOIN IG050 I ON (A.EIVERSION = I.CIVERSION AND A.EISMALLVERSION = i.CISMALLVERSION AND A.EIID = I.EIID AND I.CLABEL = 'IG_0103');

CREATE OR REPLACE  VIEW IG778 AS
    SELECT A.EIID AS EIID,
        A.EID AS EID,
        A.EILABEL AS EILABEL,
        A.EINAME AS EINAME,
        A.EIDESC AS EIDESC,
        A.EIVERSION AS EIVERSION,
        A.EIINSDATE AS EIINSDATE,
        C.CIVALUE AS X_VALUE,
        D.CIVALUE AS Y_VALUE,
        E.CIVALUE AS U_TOTAL,
        F.CIVALUE AS X_WIDTH,
        G.CIVALUE AS Y_WIDTH,
	K.CIVALUE AS GRAPHSTATUS,
	L.CIVALUE AS GRAPHTYPEID,
	M.CIVALUE AS GRAPHTYPENAME,
	N.CIVALUE AS GRAPHINDEX,
	O.CIVALUE AS VOLTAGE,
	P.CIVALUE AS WEIGHT,
	Q.CIVALUE AS STANDARD,
        I.EIID AS ROOM_EIID,
        I.EILABEL AS ROOM_EILABEL,
        I.EINAME AS ROOM_EINAME
    FROM
        IG013 A INNER JOIN IG117 B ON (A.EID = B.EID AND B.ECATEGORY = '008')
             LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0021')
             LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0022')
             LEFT OUTER JOIN IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EISMALLVERSION = E.CISMALLVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0023')
             LEFT OUTER JOIN IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EISMALLVERSION = F.CISMALLVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0024')
             LEFT OUTER JOIN IG050 G ON (A.EIVERSION = G.CIVERSION AND A.EISMALLVERSION = G.CISMALLVERSION AND A.EIID = G.EIID AND G.CLABEL = 'IG_0025')
		     LEFT OUTER JOIN IG050 K ON (A.EIVERSION = K.CIVERSION AND A.EISMALLVERSION = K.CISMALLVERSION AND A.EIID = K.EIID AND K.CLABEL = 'IG_0031')
		     LEFT OUTER JOIN IG050 L ON (A.EIVERSION = L.CIVERSION AND A.EISMALLVERSION = L.CISMALLVERSION AND A.EIID = L.EIID AND L.CLABEL = 'IG_0032')
		     LEFT OUTER JOIN IG050 M ON (A.EIVERSION = M.CIVERSION AND A.EISMALLVERSION = M.CISMALLVERSION AND A.EIID = M.EIID AND M.CLABEL = 'IG_0033')
		     LEFT OUTER JOIN IG050 N ON (A.EIVERSION = N.CIVERSION AND A.EISMALLVERSION = N.CISMALLVERSION AND A.EIID = N.EIID AND N.CLABEL = 'IG_0030')
		     LEFT OUTER JOIN IG050 O ON (A.EIVERSION = O.CIVERSION AND A.EISMALLVERSION = O.CISMALLVERSION AND A.EIID = O.EIID AND O.CLABEL = 'IG_0034')
		     LEFT OUTER JOIN IG050 P ON (A.EIVERSION = P.CIVERSION AND A.EISMALLVERSION = P.CISMALLVERSION AND A.EIID = P.EIID AND P.CLABEL = 'IG_0035')
		     LEFT OUTER JOIN IG050 Q ON (A.EIVERSION = Q.CIVERSION AND A.EISMALLVERSION = Q.CISMALLVERSION AND A.EIID = Q.EIID AND Q.CLABEL = 'IG_0036')
             LEFT OUTER JOIN IG313 H ON (A.EIID = H.CLDEIID AND A.EIVERSION = H.CLDVERSION AND A.EISMALLVERSION = H.CLDSMALLVERSION AND H.EIRRELATION = 'A' AND H.deleteflag = '0')
             LEFT OUTER JOIN IG013 I ON (H.PAREIID = I.EIID AND H.PARVERSION = I.EIVERSION AND H.PARSMALLVERSION = I.EISMALLVERSION)
             LEFT OUTER JOIN IG117 J ON (I.EID = J.EID AND J.ECATEGORY = '007');

CREATE OR REPLACE  VIEW IG912 AS
  SELECT A.EIID AS EIID,
        A.EID AS EID,
	      A.ESYSCODING AS ESYSCODING,
        B.ENAME AS ENAME,
        A.EILABEL AS EILABEL,
        A.EINAME AS EINAME,
        A.EIDESC AS EIDESC,
        A.EIVERSION AS EIVERSION,
        A.EIINSDATE AS EIINSDATE,
        C.CIVALUE AS U_VALUE,
        D.CIVALUE AS U_WIDTH,
        F.EIID AS CONTAINER_EIID,
        F.EILABEL AS CONTAINER_EILABEL,
        F.EINAME AS CONTAINER_EINAME,
		    I.CIVALUE AS INROOMFLG,
        H.CIVALUE AS MODEL,
        A.EISTATUS
    FROM
        IG013 A INNER JOIN IG117 B ON (A.EID = B.EID AND B.ECATEGORY = '001')
        LEFT OUTER JOIN  (SELECT QA.PAREIID,QA.CLDEIID,QA.CLDVERSION,CLDSMALLVERSION FROM IG313 QA,
                (SELECT PAREIID,CLDEIID,MAX(CLDVERSION) as CLDVERSION FROM IG313 WHERE EIRRELATION = 'B' AND deleteflag = '0' GROUP BY PAREIID,CLDEIID) QB 
                 WHERE QA.PAREIID = QB.PAREIID AND QA.CLDEIID = QB.CLDEIID AND QA.CLDVERSION = QB.CLDVERSION) K ON A.EIID = K.CLDEIID
       LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0015')
       LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0016')
       LEFT OUTER JOIN IG050 I ON (A.EIVERSION = I.CIVERSION AND A.EISMALLVERSION = I.CISMALLVERSION AND A.EIID = I.EIID AND I.CLABEL = 'IG_0037')
       LEFT OUTER JOIN IG050 H ON (A.EIVERSION = H.CIVERSION AND A.EISMALLVERSION = H.CISMALLVERSION AND A.EIID = H.EIID AND H.CLABEL = 'IG_0026')
       LEFT OUTER JOIN IG313 E ON (A.EIID = E.CLDEIID AND E.CLDVERSION = K.CLDVERSION AND K.CLDSMALLVERSION = E.CLDSMALLVERSION AND  E.EIRRELATION = 'B' AND E.deleteflag = '0')
       LEFT OUTER JOIN IG013 F ON (E.PAREIID = F.EIID AND E.PARVERSION = F.EIVERSION AND E.PARSMALLVERSION = F.EISMALLVERSION)
       LEFT OUTER JOIN IG117 G ON (F.EID = G.EID AND G.ECATEGORY = '008')
WHERE D.CIVALUE IS NOT NULL;


CREATE OR REPLACE VIEW IG336 AS
select EIID, EIVERSION, EISMALLVERSION, DELETEFLAG, COUNT(1) AS EIRCOUNT
from (
SELECT EIID, max(EIVERSION) as EIVERSION, EISMALLVERSION, DELETEFLAG
FROM (
SELECT PAREIID AS EIID,PARVERSION AS EIVERSION, PARSMALLVERSION AS EISMALLVERSION, DELETEFLAG FROM IG313
WHERE DELETEFLAG = '0'
UNION ALL
SELECT CLDEIID AS EIID, CLDVERSION AS EIVERSION, CLDSMALLVERSION AS EISMALLVERSION, DELETEFLAG FROM IG313
WHERE DELETEFLAG = '0'
)  EIR
GROUP BY EIID,EISMALLVERSION,DELETEFLAG
) GROUP BY EIID,EIVERSION,EISMALLVERSION,DELETEFLAG;

CREATE OR REPLACE VIEW IG688 AS
SELECT  	A.EIID,
            A.EID,
            A.EIDESC,
            A.EINAME,
            A.EILABEL,
            A.EIUPDTIME,
            A.EISTATUS,
            A.EIINSDATE,
            A.EIORGSYSCODING,
            A.ESYSCODING,
            B.ENAME,
            B.ELABEL,
            B.EDESC,
            B.ESTATUS,
            B.ECATEGORY,
            B.EKEY1,
            B.EKEY2,
            B.EKEY3,
            B.EMODELTYPE,
            A.EIVERSION,
            A.EIUSERID,
	    	A.EIUSERNAME,
	    	A.EISMALLVERSION,
       		A.EIROOTMARK,
	    	C.CIVALUE AS SERIAL,
            D.CIVALUE AS BUYTIME,
            E.CIVALUE AS USEORGAN,
            F.CIVALUE AS WBDATE,
            nvl(G.EIRCOUNT, 0) AS EIRCOUNT
    FROM    IG013 A INNER JOIN IG117 B ON (A.EID = B.EID)
            LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0027')
            LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0028')
            LEFT OUTER JOIN IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EISMALLVERSION = E.CISMALLVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0006')
            LEFT OUTER JOIN IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EISMALLVERSION = F.CISMALLVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0029')
            LEFT OUTER JOIN IG336 G ON (a.EIID = G.eiid);
            

CREATE OR REPLACE VIEW IG749 AS
    SELECT  A.EIID, 
            A.EID, 
            A.EIDESC, 
            A.EINAME, 
            A.EILABEL, 
            A.EIUPDTIME,
            A.EISTATUS, 
            A.EIINSDATE, 
            A.EIORGSYSCODING,
            A.ESYSCODING,
            A.EIVERSION,
            A.EIUSERID,
	    A.EIUSERNAME,
	    A.EISMALLVERSION,
	    B.ENAME, 
            B.ELABEL, 
            B.ECATEGORY
    FROM    IG013 A INNER JOIN IG117 B ON (A.EID = B.EID)
;

CREATE OR REPLACE VIEW IG590 AS
	SELECT	A.PRID,A.PRTYPE,A.PRSUBTYPE,A.PRSUBSTATUS,A.PRTITLE,A.PRDESC,A.PROPENTIME,A.PRCLOSETIME,A.PRPLANTIME,A.PRDURATION,A.PRPRIORITY,
			A.PRURGENCY,A.PRIMPACT,A.PRASSETID,A.PRASSETNAME,A.PRASSETCATEGORY,A.PRBUSINESS,A.PRIMPLPLAN,A.PRBACKPLAN,A.PRVFYPLAN,A.PID,
			A.PCODE,A.PNAME,A.PRINFO,A.PRCORID,A.PRCORTYPE,A.PRCORTITLE,A.PRUSERID,A.PRUSERNAME,A.PRROLEID,A.PRROLENAME,A.PRPDID,A.PRPDNAME,
			A.PRORGID,A.PRORGNAME,A.PRSERIALNUM,A.PRFACTTIME,A.FINGERPRINT,A.PRPTDCOND,A.PRSTRATEGYVERSION,
	CASE WHEN MAX(B.PPSUBSTATUS)='1' AND A.PRTYPE='I' AND A.PRSTATUS='E'  THEN 'D' ELSE A.PRSTATUS END AS PRSTATUS
 FROM IG500 A
 LEFT JOIN IG337 B ON (A.PRID = B.PRID)
 GROUP BY A.PRID,A.PRTYPE,A.PRSUBTYPE,A.PRSUBSTATUS,A.PRTITLE,A.PRDESC,A.PROPENTIME,A.PRCLOSETIME,A.PRPLANTIME,A.PRDURATION,A.PRPRIORITY,
	A.PRURGENCY,A.PRIMPACT,A.PRASSETID,A.PRASSETNAME,A.PRASSETCATEGORY,A.PRBUSINESS,A.PRIMPLPLAN,A.PRBACKPLAN,A.PRVFYPLAN,A.PID,
	A.PCODE,A.PNAME,A.PRINFO,A.PRCORID,A.PRCORTYPE,A.PRCORTITLE,A.PRUSERID,A.PRUSERNAME,A.PRROLEID,A.PRROLENAME,A.PRPDID,A.PRPDNAME,
	A.PRORGID,A.PRORGNAME,A.PRSERIALNUM,A.PRFACTTIME,A.FINGERPRINT,A.PRPTDCOND,A.PRSTRATEGYVERSION,PRSTATUS
;

CREATE OR REPLACE VIEW IG677 AS
	SELECT	A.PRID,A.PRTYPE,A.PRSUBTYPE,A.PRSTATUS,A.PRSUBSTATUS,A.PRTITLE,A.PRDESC,A.PROPENTIME,A.PRCLOSETIME,A.PRPLANTIME,A.PRDURATION,A.PRPRIORITY,
			A.PRURGENCY,A.PRIMPACT,A.PRASSETID,A.PRASSETNAME,A.PRASSETCATEGORY,A.PRBUSINESS,A.PRIMPLPLAN,A.PRBACKPLAN,A.PRVFYPLAN,A.PID,
			A.PCODE,A.PNAME,A.PRINFO,A.PRCORID,A.PRCORTYPE,A.PRCORTITLE,A.PRUSERID,A.PRUSERNAME,A.PRROLEID,A.PRROLENAME,A.PRPDID,A.PRPDNAME,
			A.PRORGID,A.PRORGNAME,A.PRSERIALNUM,A.PRFACTTIME,A.PRSTRATEGYVERSION,
			B.PPID,B.PPROLEID,B.PPROLENAME,B.PPUSERID,B.PPUSERNAME,B.PPORGID,B.PPORGNAME,B.PPTYPE,B.PPUSERINFO,B.PPCOMMENT,B.PPATTKEY,
			B.PPINITTIME,B.PPPROCTIME,B.PPSUBSTATUS,B.PPFACTTIME,B.PPBACKTIME,
			CASE 
			WHEN A.PRTYPE='I' AND B.PPSTATUS='E' THEN 
         		CASE WHEN A.PRSTATUS='D' THEN A.PRSTATUS
				ELSE B.PPSTATUS 
				END
			ELSE B.PPSTATUS
			END AS PPSTATUS
	FROM	IG590 A ,IG337 B
	WHERE	A.PRID=B.PRID;

CREATE OR REPLACE VIEW UserRoleVW AS 
	SELECT  UserRole.urid,UserRole.userid,IGUSER.username,UserRole.roleid,UserRole.rolemanager,Role.rolename,Role.roledesc,Role.roletype,Role.roledomain,Role.assetdomain,IgUser.orgid,Organization.orgname,IgUser.deleteflag,UserRole.dutyflag 
	FROM    Role,UserRole,IGUSER,Organization 
	WHERE   UserRole.roleid = Role.roleid AND UserRole.userid = IgUser.userid AND IgUser.orgid = Organization.orgsyscoding AND IgUser.deleteflag = '0';

CREATE OR REPLACE VIEW ROLEACTIONVW AS
	SELECT	ACTION.ACTNAME,ACTION.ACTLABEL,ACTION.ACTTYPE,ACTION.ACTDESC,ACTION.ACTURL,ACTION.ACTSORTID,ACTION.ACTURLTYPE,ROLEACTION.RAID,ROLEACTION.ROLEID,ROLEACTION.RAPERM,ROLEACTION.RADESC
	FROM	ACTION,ROLEACTION
	WHERE	ACTION.ACTNAME =ROLEACTION.ACTNAME;

CREATE OR REPLACE VIEW USERINFOVW AS
	SELECT	ROLE.ROLEID AS ROLEIDA,ROLE.ROLENAME,ROLE.ROLEDESC,ROLE.ROLEINFO,ROLE.ROLETYPE,ROLE.ROLEDOMAIN,IGUSER.USERID AS USERIDA,IGUSER.USERNAME,IGUSER.PASSWORD,IGUSER.USERDESC,IGUSER.USERINFO,IGUSER.USERTYPE,IGUSER.USERSTATUS,IGUSER.USERPHONE,IGUSER.USERMOBILE,IGUSER.USEREMAIL,IGUSER.DELETEFLAG,ORGANIZATION.ORGSYSCODING AS ORGIDA,ORGANIZATION.ORGNAME,ORGANIZATION.ORGDESC,ORGANIZATION.ORGTYPE,ORGANIZATION.ORGPAR,ORGANIZATION.ORGADDR,ORGANIZATION.ORGPHONE,ORGANIZATION.ORGFAX,ORGANIZATION.ORGCONTACT,ORGANIZATION.ORGINFO,ORGANIZATION.ORGSTATUS,ORGANIZATION.ORGPARNAME,ORGANIZATION.ORGSYSCODING,ORGANIZATION.ORGUSERCODING,USERROLE.ROLEMANAGER,USERROLE.DUTYFLAG
	FROM	ROLE,USERROLE,IGUSER,ORGANIZATION
	WHERE	IGUSER.ORGID = ORGANIZATION.ORGSYSCODING AND IGUSER.USERID = USERROLE.USERID AND USERROLE.ROLEID = ROLE.ROLEID AND IGUSER.DELETEFLAG = '0';

CREATE OR REPLACE VIEW RISKAUDITDEFRESULTVW AS
    SELECT  RAD.RADID,
	    RAD.RAID,
            RAD.RADNAME, 
            RAD.RADCODE,
	    RAD.RADPARCODE,
	    RAD.RADDESC,
	    RAD.RADLEVEL,
	    RAD.RADSTATUS,
	    RAD.RADRISKLEVEL,
	    RAD.RADUSERNAME,
	    RAD.RADORG,
	    RAD.RADFREQUENCY,
	    RAD.RADMODE,
	    RAD.RADTYPE,
	    RAI.RAIID,
            RAR.RARID,
	    RAR.RARUSERID,
	    RAR.RARUSERNAME,
	    RAR.RARPLANSCORE,
	    RAR.RARPLANDESC,
	    RAR.RAREXECSCORE,
	    RAR.RAREXECDESC,
	    RAR.RAROVERALLSCORE,
	    RAR.RAROVERALLDESC
    FROM    RISKAUDITDEF RAD
    INNER JOIN RISKAUDITINS RAI ON (RAD.RAID = RAI.RAID)
    LEFT OUTER JOIN RISKAUDITRESULT RAR ON (RAD.RADID = RAR.RADID AND RAR.RAIID = RAI.RAIID);

CREATE OR REPLACE VIEW DUTYRESULTVW AS
SELECT
		F.DADID AS DADID,
		F.DADTYPE AS DADTYPE,
		F.DADNAME AS DADNAME,
		F.DATTIME AS DATTIME,
		F.DATLIMTIME AS DATLIMTIME,
		F.DADCONTENT AS DADCONTENT,
		F.DADINFO AS DADINFO,
		F.DADSTATUS AS DADSTATUS,
		C.DRCONTENT AS DRCONTENT,
		C.DRFILLTIME AS DRFILLTIME,
		C.DRRESULT AS DRRESULT,
		C.DRID AS DRID,
		C.DPID AS DPID,
		C.DRLIMDTIME AS DRLIMDTIME,
		F.DADCATEGORY AS DADCATEGORY,
		F.DADLIMTIME AS DADLIMTIME,
    	F.DADORDERBY AS DADORDERBY,
    	F.PERIODTYPE AS PERIODTYPE,
    	F.PERIODVALUE AS PERIODVALUE
		FROM (SELECT
				E.DPID AS DPID,
				D.DADID AS DADID,
				D.DADTYPE AS DADTYPE,
				D.DADNAME AS DADNAME,
				D.DATTIME AS DATTIME,
				D.DATLIMTIME AS DATLIMTIME,
				D.DADCONTENT AS DADCONTENT,
				D.DADINFO AS DADINFO,
				D.DADSTATUS AS DADSTATUS,
				D.DADCATEGORY AS DADCATEGORY,
				D.DADLIMTIME AS DADLIMTIME,
        		D.DADORDERBY AS DADORDERBY,
        		D.PERIODTYPE AS PERIODTYPE,
        		D.PERIODVALUE AS PERIODVALUE
        		FROM (SELECT
						A.DADID AS DADID,
						A.DADTYPE AS DADTYPE,
						A.DADNAME AS DADNAME,
						B.DATTIME AS DATTIME,
						B.DATLIMTIME AS DATLIMTIME,
						A.DADCONTENT AS DADCONTENT,
						A.DADINFO AS DADINFO,
						A.DADSTATUS AS DADSTATUS,
						A.DADCATEGORY AS DADCATEGORY,
						A.DADLIMTIME AS DADLIMTIME,
            			A.DADORDERBY AS DADORDERBY,
            			A.PERIODTYPE AS PERIODTYPE,
            			A.PERIODVALUE AS PERIODVALUE
						FROM DUTYAUDITDEF A LEFT OUTER JOIN DUTYAUDITTIME B ON (A.DADID = B.DADID)
						WHERE A.DADSTATUS = '1'
			 ) D,DUTYPLAN E WHERE E.DPSTATUS = '2' AND E.DADCATEGORY = D.DADCATEGORY ) F
		LEFT OUTER JOIN DUTYRESULT C ON (F.DADID = C.DADID AND F.DATTIME = C.DATTIME AND F.DPID = C.DPID);

CREATE OR REPLACE VIEW HWORKVW AS  
SELECT PRUSERID,PROPENTIME,PRTYPE,COUNT(PRID) AS HCOUNT 
FROM (
	SELECT H.PRUSERID,SUBSTR(C.PRTYPE,1,1) AS PRTYPE,H.PRID,SUBSTR(C.PROPENTIME,1,7) AS PROPENTIME
		FROM ( 
			SELECT  A.PRID AS PRID,A.PPUSERID AS PRUSERID 
			FROM IG337  A,IG500  B 
			WHERE A.PRID=B.PRID AND B.PRSTATUS='C' AND (A.PPUSERID IS NOT NULL ) GROUP BY A.PPUSERID,A.PRID )  H ,IG500  C
	WHERE H.PRID = C.PRID
)  D
GROUP BY PRUSERID,PROPENTIME,PRTYPE;

CREATE OR REPLACE VIEW KNOWLEDGEVW AS SELECT A.* FROM KNOWLEDGE A WHERE A.KNSTATUS = '1';

CREATE OR REPLACE VIEW USERNOTROLEVW AS 
	SELECT A.USERID , A.USERNAME , A.USERPHONE , A.USERMOBILE , A.USEREMAIL , A.ORGID , A.ORGNAME ,A.USERSTATUS, B.ROLEID FROM  IGUSER A , 
	ROLE B WHERE (A.USERID , B.ROLEID) NOT IN (SELECT A.USERID , A.ROLEID FROM USERROLE A) AND A.DELETEFLAG = '0' AND A.USERID != 'ADMIN';
	
CREATE OR REPLACE VIEW IG778
    ( "EIID", "EID", "EILABEL", "EINAME", "EIDESC",
    "EIVERSION", "EIINSDATE", "X_VALUE", "Y_VALUE", "U_VALUE",
    "U_TOTAL", "X_WIDTH", "Y_WIDTH", "GRAPHSTATUS", "GRAPHTYPEID",
    "GRAPHTYPENAME", "GRAPHINDEX", "VOLTAGE", "WEIGHT", "WIDTH",
    "STANDARD", "ROOM_EIID", "ROOM_EILABEL", "ROOM_EINAME", "CONTAINERTYPE", "EITYPE")
AS
SELECT A.EIID AS EIID, A.EID AS EID, A.EILABEL AS EILABEL, A.EINAME AS EINAME, 
A.EIDESC AS EIDESC, A.EIVERSION AS EIVERSION, A.EIINSDATE AS EIINSDATE, 
C.CIVALUE AS X_VALUE, D.CIVALUE AS Y_VALUE, 
T.CIVALUE AS U_VALUE, 
E.CIVALUE AS U_TOTAL, F.CIVALUE AS X_WIDTH, G.CIVALUE AS Y_WIDTH, K.CIVALUE AS GRAPHSTATUS, 
L.CIVALUE AS GRAPHTYPEID, M.CIVALUE AS GRAPHTYPENAME, N.CIVALUE AS GRAPHINDEX, 
O.CIVALUE AS VOLTAGE, P.CIVALUE AS WEIGHT, S.CIVALUE AS WIDTH,  Q.CIVALUE AS STANDARD, 
I.EIID AS ROOM_EIID, I.EILABEL AS ROOM_EILABEL, I.EINAME AS ROOM_EINAME, 
R.CIVALUE AS CONTAINERTYPE, U.CIVALUE AS EITYPE
FROM IG013 A INNER JOIN IG117 B ON (A.EID = B.EID AND B.ECATEGORY = '008') 
LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0021') 
LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0022') 
LEFT OUTER JOIN IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0023') 
LEFT OUTER JOIN IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0024') 
LEFT OUTER JOIN IG050 G ON (A.EIVERSION = G.CIVERSION AND A.EIID = G.EIID AND G.CLABEL = 'IG_0025') 
LEFT OUTER JOIN IG050 K ON (A.EIVERSION = K.CIVERSION AND A.EIID = K.EIID AND K.CLABEL = 'IG_0031') 
LEFT OUTER JOIN IG050 L ON (A.EIVERSION = L.CIVERSION AND A.EIID = L.EIID AND L.CLABEL = 'IG_0032') 
LEFT OUTER JOIN IG050 M ON (A.EIVERSION = M.CIVERSION AND A.EIID = M.EIID AND M.CLABEL = 'IG_0033') 
LEFT OUTER JOIN IG050 N ON (A.EIVERSION = N.CIVERSION AND A.EIID = N.EIID AND N.CLABEL = 'IG_0030') 
LEFT OUTER JOIN IG050 O ON (A.EIVERSION = O.CIVERSION AND A.EIID = O.EIID AND O.CLABEL = 'IG_0034') 
LEFT OUTER JOIN IG050 P ON (A.EIVERSION = P.CIVERSION AND A.EIID = P.EIID AND P.CLABEL = 'IG_0035') 
LEFT OUTER JOIN IG050 S ON (A.EIVERSION = S.CIVERSION AND A.EIID = S.EIID AND S.CLABEL = 'IG_0104') 
LEFT OUTER JOIN IG050 Q ON (A.EIVERSION = Q.CIVERSION AND A.EIID = Q.EIID AND Q.CLABEL = 'IG_0036') 
LEFT OUTER JOIN IG050 R ON (A.EIVERSION = R.CIVERSION AND A.EIID = R.EIID AND R.CLABEL = 'IG_0105') 
LEFT OUTER JOIN IG050 T ON (A.EIVERSION = T.CIVERSION AND A.EIID = T.EIID AND T.CLABEL = 'IG_0106') 
LEFT OUTER JOIN IG050 U ON (A.EIVERSION = U.CIVERSION AND A.EIID = U.EIID AND U.CLABEL = 'IG_0108') 
LEFT OUTER JOIN IG313 H ON (A.EIID = H.CLDEIID AND H.EIRRELATION = 'A' AND deleteflag!='1')
LEFT OUTER JOIN IG013 I ON (H.PAREIID = I.EIID) 
LEFT OUTER JOIN IG117 J ON (I.EID = J.EID AND J.ECATEGORY = '007');

CREATE OR REPLACE VIEW IG912 AS
SELECT A.EIID AS EIID,
        A.EID AS EID,
	A.ESYSCODING AS ESYSCODING,
        B.ENAME AS ENAME,
        A.EILABEL AS EILABEL,
        A.EINAME AS EINAME,
        A.EIDESC AS EIDESC,
        A.EIVERSION AS EIVERSION,
        A.EIINSDATE AS EIINSDATE,
        C.CIVALUE AS U_VALUE,
        D.CIVALUE AS U_WIDTH,
        F.EIID AS CONTAINER_EIID,
        F.EILABEL AS CONTAINER_EILABEL,
        F.EINAME AS CONTAINER_EINAME,
		I.CIVALUE AS INROOMFLG,
        H.CIVALUE AS MODEL,
        A.EISTATUS
    FROM
        IG013 A INNER JOIN IG117 B ON (A.EID = B.EID AND B.ECATEGORY = '001')
                     LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0015')
                     LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0016')
		     LEFT OUTER JOIN IG050 I ON (A.EIVERSION = I.CIVERSION AND A.EISMALLVERSION = I.CISMALLVERSION AND A.EIID = I.EIID AND I.CLABEL = 'IG_0037')
                     LEFT OUTER JOIN IG050 H ON (A.EIVERSION = H.CIVERSION AND A.EISMALLVERSION = H.CISMALLVERSION AND A.EIID = H.EIID AND H.CLABEL = 'IG_0026')
                     LEFT OUTER JOIN IG313 E ON (A.EIID = E.CLDEIID AND A.EIVERSION = E.CLDVERSION AND A.EISMALLVERSION = E.CLDSMALLVERSION AND E.EIRRELATION = 'B' AND E.deleteflag = '0')
                     LEFT OUTER JOIN IG013 F ON (E.PAREIID = F.EIID AND E.PARVERSION = F.EIVERSION AND E.PARSMALLVERSION = F.EISMALLVERSION)
                     LEFT OUTER JOIN IG117 G ON (F.EID = G.EID AND G.ECATEGORY = '008')
WHERE D.CIVALUE IS NOT NULL;	

CREATE OR REPLACE VIEW IG499 AS
SELECT      A.EIID,
            A.EID,
            A.EIDESC,
            A.EINAME,
            A.EILABEL,
            A.EIUPDTIME,
            A.EISTATUS,
            A.EIINSDATE,
            A.EIORGSYSCODING,
            A.ESYSCODING,
            B.ENAME,
            B.ELABEL,
            B.EDESC,
            B.ESTATUS,
            B.ECATEGORY,
            B.EKEY1,
            B.EKEY2,
            B.EKEY3,
            B.EMODELTYPE,
            A.EIVERSION,
            A.EIUSERID,
	    A.EIUSERNAME,
	    A.EISMALLVERSION,
	    A.EIROOTMARK,
            C.CIVALUE AS CONDUDETIME,
            D.CIVALUE AS FACILITATOR,
	    E.CIVALUE AS OPERATOR,
	    F.CIVALUE AS COMPACTTYPE,
	    G.CIVALUE AS CONTRACTPAYMENT,
	    H.CIVALUE AS COUNTMONEY,
	    I.CIVALUE AS LASTDATETIME,
	    0 AS IMPREST
    FROM    IG013 A INNER JOIN IG117 B ON (A.EID = B.EID)
            LEFT OUTER JOIN IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CID=1683)
            LEFT OUTER JOIN IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CID=1685)
	    LEFT OUTER JOIN IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EISMALLVERSION = E.CISMALLVERSION AND A.EIID = E.EIID AND E.CID=1684)
	    LEFT OUTER JOIN IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EISMALLVERSION = F.CISMALLVERSION AND A.EIID = F.EIID AND F.CID=1681)
	    LEFT OUTER JOIN IG050 G ON (A.EIVERSION = G.CIVERSION AND A.EISMALLVERSION = G.CISMALLVERSION AND A.EIID = G.EIID AND G.CID=1688)
	    LEFT OUTER JOIN IG050 H ON (A.EIVERSION = H.CIVERSION AND A.EISMALLVERSION = H.CISMALLVERSION AND A.EIID = H.EIID AND H.CID=1726)
 	    LEFT OUTER JOIN IG050 I ON (A.EIVERSION = I.CIVERSION AND A.EISMALLVERSION = I.CISMALLVERSION AND A.EIID = I.EIID AND I.CID=1710)
WHERE A.EID=11;


CREATE OR REPLACE VIEW EIBELONGRELATIONVW AS
       SELECT A.BRID,
              A.BRPAREIID,
              A.BRPARVERSION,
              A.BRPARSMALLVERSION,
              A.BRCLDEIID,
              A.BRCLDVERSION,
              A.BRCLDSMALLVERSION,
              A.BRTYPE,
              A.BRDES,
              A.BRCREATETIME,
              A.BRRALETIONCODE,
              A.BRASSETRELATION,
              A.EIROOTMARK,
              A.DELETEFLAG
       FROM EIBELONGRELATION  A
            INNER JOIN 
            (
              SELECT BRPAREIID,
                     MAX(BRPARVERSION) AS BRPARVERSION,
                     MAX(BRPARSMALLVERSION) AS BRPARSMALLVERSION,
                     BRCLDEIID,
                     MAX(BRCLDVERSION) AS BRCLDVERSION,
                     MAX(BRCLDSMALLVERSION) AS BRCLDSMALLVERSION
              FROM EIBELONGRELATION
              WHERE DELETEFLAG = '0'
              GROUP BY BRPAREIID,
                       BRCLDEIID
            )  B ON (A.BRPAREIID = B.BRPAREIID AND A.BRPARVERSION =
            B.BRPARVERSION AND A.BRPARSMALLVERSION = B.BRPARSMALLVERSION AND
            A.BRCLDEIID = B.BRCLDEIID AND A.BRCLDVERSION = B.BRCLDVERSION AND
            A.BRCLDSMALLVERSION = B.BRCLDSMALLVERSION)
;

CREATE VIEW PBSUMMARYVW AS 
select rownum as pbrid,
 bid,btype,bstatus,btitle,bdesc,byear,bamount,pquality,pstorecode,pneeddispart,pbuggetform,puse,remark,
 case when total1 is not null then total1 else 0 end as total1 ,
 case when total2 is not null then total2 else 0 end as total2 ,
 case when total3 is not null then total3 else 0 end as total3 ,
 case when total4 is not null then total4 else 0 end as total4 ,
 case when total5 is not null then total5 else 0 end as total5 ,
 case when total6 is not null then total6 else 0 end as total6 ,
 case when total7 is not null then total7 else 0 end as total7 ,
 case when totaluse1 is not null then totaluse1 else 0 end as totaluse1 ,
 case when totaluse2 is not null then totaluse2 else 0 end as totaluse2 ,
 case when totaluse3 is not null then totaluse3 else 0 end as totaluse3 ,
 case when totaluse4 is not null then totaluse4 else 0 end as totaluse4 ,
 case when totaluse5 is not null then totaluse5 else 0 end as totaluse5 ,
 case when totaluse6 is not null then totaluse6 else 0 end as totaluse6 ,  
 case when totaluse7 is not null then totaluse7 else 0 end as totaluse7 ,
 case when (total1 - totaluse1) is not null then (total1 - totaluse1) else total1 end as sub1,
 case when (total2 - totaluse2) is not null then (total2 - totaluse2) else total2 end as sub2,
 case when (total3 - totaluse3) is not null then (total3 - totaluse3) else total3 end as sub3,
 case when (total4 - totaluse4) is not null then (total4 - totaluse4) else total4 end as sub4,
 case when (total5 - totaluse5) is not null then (total5 - totaluse5) else total5 end as sub5,
 case when (total6 - totaluse6) is not null then (total6 - totaluse6) else total6 end as sub6,
 case when (total7 - totaluse7) is not null then (total7 - totaluse7) else total7 end as sub7,
 case when use1 is not null then use1 else 0 end as use1 ,
 case when use2 is not null then use2 else 0 end as use2 ,
 case when use3 is not null then use3 else 0 end as use3 ,
 case when use4 is not null then use4 else 0 end as use4 ,
 case when use5 is not null then use5 else 0 end as use5 ,
 case when use6 is not null then use6 else 0 end as use6 ,
 case when use7 is not null then use7 else 0 end as use7 ,
 pid,pbid
from (
select a.bid,a.btype,a.bstatus,a.btitle,a.bdesc,a.byear,a.bamount,a.pquality,a.pstorecode,a.pneeddispart,a.pbuggetform,
a.puse,a.remark,a.bzdevelop as total1,a.bzhardware as total2,a.bzsoftware as total3,a.bzproject as total4,a.bzelse as total5,
a.bcimplement as total6,a.bcelse as total7,
(select sum(bzdevelop) from ProjectBudgetRelation where bid=a.bid) as totaluse1,
(select sum(bzhardware) from ProjectBudgetRelation where bid=a.bid) as totaluse2,
(select sum(bzsoftware) from ProjectBudgetRelation where bid=a.bid) as totaluse3,
(select sum(bzproject) from ProjectBudgetRelation where bid=a.bid) as totaluse4,
(select sum(bzelse) from ProjectBudgetRelation where bid=a.bid) as totaluse5,
(select sum(bcimplement) from ProjectBudgetRelation where bid=a.bid) as totaluse6,
(select sum(bcelse) from ProjectBudgetRelation where bid=a.bid) as totaluse7,
b.bzdevelop as use1,b.bzhardware as use2,b.bzsoftware as use3,b.bzproject as use4,
b.bzelse as use5,b.bcimplement as use6,b.bcelse as use7,b.pbid,c.pid 
from Budget a left join ProjectBudgetRelation b on a.bid = b.bid left join project c on b.pid =  c.pid );