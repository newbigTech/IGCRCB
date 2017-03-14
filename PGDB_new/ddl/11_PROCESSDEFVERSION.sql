-- ######################################################################
-- # 过程名称: 复制/升级流程定义信息
-- # 功能描述: 复制/升级流程定义信息（V_TYPE：0升级，1复制）
-- ######################################################################
CREATE OR REPLACE FUNCTION "ig".PRO_PROCESSDEFVERSION (V_PDID CHAR, V_PDID_NEW CHAR, V_TYPE CHAR)
	RETURNS INTEGER AS $BODY$
BEGIN
    INSERT INTO "ig".IG380
    (
    PDID,
    PTID,
    PDNAME,
    PDDESC,
	PDCRTDATE,
	PDSTATUS,
	PDXML,
	PERMISSION,
	FINGERPRINT,
	SERIALGENERATOR,
	PDACTNAME
    )
    SELECT
    V_PDID_NEW AS PDID_NEW,
    PTID,
    CASE WHEN V_TYPE = '1' THEN PDNAME||'-副本' ELSE PDNAME END,
    PDDESC,
	PDCRTDATE,
	'i',
	REPLACE(PDXML, V_PDID, V_PDID_NEW),
	PERMISSION,
	FINGERPRINT,
	SERIALGENERATOR,
	PDACTNAME
    FROM "ig".IG380 WHERE PDID = V_PDID;
    RAISE NOTICE '1.复制IG380成功。';

    INSERT INTO "ig".IG007
    (
    PIDID,
	PDID,
	PIDNAME,
	PIDLABEL,
	PIDDESC,
	PIDTYPE,
	PIDOPTION,
	PIDDEFAULT,
	PIDREQUIRED,
	FINGERPRINT,
	PIDSORTID,
	CCID,
	PIDGID,
	PIDMODE,
	PRIVATESCOPE,
	ROWWIDTH
    )
    SELECT
	REPLACE(PIDID, V_PDID, V_PDID_NEW) AS PIDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	PIDNAME,
	PIDLABEL,
	PIDDESC,
	PIDTYPE,
	PIDOPTION,
	PIDDEFAULT,
	PIDREQUIRED,
	FINGERPRINT,
	PIDSORTID,
	CCID,
	PIDGID,
	PIDMODE,
	PRIVATESCOPE,
	ROWWIDTH
    FROM "ig".IG007
    WHERE PIDID LIKE V_PDID||'%'
    ORDER BY PIDID;
    RAISE NOTICE '2.复制IG007成功。';

    INSERT INTO "ig".IG333
    (
	PSDID,
	PDID,
	PSDNAME,
	PSDDESC,
	PSDCODE,
	FINGERPRINT,
	PSDTYPE,
	PSDMODE,
	PSDFLAG,
	PSDASSIGN,
	PSDORG,
	PSDCONFIRM,
	ASSIGNPSDID,
	ASSIGNPBDID,
	ASSIGNFLAG,
	PARTICIPANTCHANGE
    )
    SELECT
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	PSDNAME,
	PSDDESC,
	PSDCODE,
	FINGERPRINT,
	PSDTYPE,
	PSDMODE,
	PSDFLAG,
	PSDASSIGN,
	PSDORG,
	PSDCONFIRM,
	REPLACE(ASSIGNPSDID, V_PDID, V_PDID_NEW) AS ASSIGNPSDID,
	ASSIGNPBDID,
	ASSIGNFLAG,
	PARTICIPANTCHANGE
    FROM "ig".IG333
    WHERE PSDID LIKE V_PDID||'%'
    ORDER BY PSDID;
    RAISE NOTICE '3.复制IG333成功。';


    INSERT INTO "ig".IG258
    (
	PSPCDID,
	PSDID,
	PSPCDPSDID,
	FINGERPRINT
    )
    SELECT
	REPLACE(PSPCDID, V_PDID, V_PDID_NEW) AS PSPCDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	REPLACE(PSPCDPSDID, V_PDID, V_PDID_NEW) AS PSPCDPSDID_NEW,
	FINGERPRINT
    FROM "ig".IG258
    WHERE PSPCDID LIKE V_PDID||'%'
    ORDER BY PSPCDID;
    RAISE NOTICE '4.复制IG258成功。';

    
    INSERT INTO "ig".IG211
    (
    PSIDID,
	PSDID,
	PIDID,
	PIDNAME,
	PIDLABEL,
	PIDDESC,
	PIDTYPE,
	PIDVALUE,	
	PIDATTKEY,
	FINGERPRINT
    )
    SELECT
	REPLACE(PSIDID, V_PDID, V_PDID_NEW) AS PSIDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	REPLACE(PIDID, V_PDID, V_PDID_NEW) AS PIDID_NEW,
	PIDNAME,
	PIDLABEL,
	PIDDESC,
	PIDTYPE,
	PIDVALUE,	
	PIDATTKEY,
	FINGERPRINT
    FROM "ig".IG211
    WHERE PSIDID LIKE V_PDID||'%'
    ORDER BY PSIDID;
    RAISE NOTICE '5.复制IG211成功。';

    
    INSERT INTO "ig".IG222
    (
	PPDID,
	PSDID,
	ROLEID,
	USERID,
	PPDSUPER,
	FINGERPRINT
    )
    SELECT
	REPLACE(PPDID, V_PDID, V_PDID_NEW) AS PPDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	ROLEID,
	USERID,
	PPDSUPER,
	FINGERPRINT
    FROM "ig".IG222
    WHERE PPDID LIKE V_PDID||'%'
    ORDER BY PPDID;
    RAISE NOTICE '6.复制IG222成功。';


    INSERT INTO "ig".IG132
    (
	PPBDID,
	PPDID,
	PBDID,
	PPBDNAME,
	PPBDDESC,
	PPBDAUTH,
	FINGERPRINT
    )
    SELECT
	REPLACE(PPBDID, V_PDID, V_PDID_NEW) AS PPBDID_NEW,
	REPLACE(PPDID, V_PDID, V_PDID_NEW) AS PPDID_NEW,
	PBDID,
	PPBDNAME,
	PPBDDESC,
	PPBDAUTH,
	FINGERPRINT
    FROM "ig".IG132
    WHERE PPBDID LIKE V_PDID||'%'
    ORDER BY PPBDID;
    RAISE NOTICE '7.复制IG132成功。';

    
    INSERT INTO "ig".IG881
    (
	PIPDID,
	PIDID,
	PSDID,
	PPDID,
	PIDACCESS,
	FINGERPRINT,
	PIDREQUIRED
    )
    SELECT
	REPLACE(PIPDID, V_PDID, V_PDID_NEW) AS PIPDID_NEW,
	REPLACE(PIDID, V_PDID, V_PDID_NEW) AS PIDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	REPLACE(PPDID, V_PDID, V_PDID_NEW) AS PPDID_NEW,
	PIDACCESS,
	FINGERPRINT,
	PIDREQUIRED
    FROM "ig".IG881
    WHERE PIPDID LIKE V_PDID||'%'
    ORDER BY PIPDID;
    RAISE NOTICE '8.复制IG881成功。';

    
    INSERT INTO "ig".IG273
    (
	PTDID,
	FPSDID,
	TPSDID,
	PTDNAME,
	PTDDESC,
	PTDTYPE,
	PTDCOND,
	FINGERPRINT
    )
    SELECT
	REPLACE(PTDID, V_PDID, V_PDID_NEW) AS PTDID_NEW,
	REPLACE(FPSDID, V_PDID, V_PDID_NEW) AS FPSDID_NEW,
	REPLACE(TPSDID, V_PDID, V_PDID_NEW) AS TPSDID_NEW,
	PTDNAME,
	PTDDESC,
	PTDTYPE,
	REPLACE(PTDCOND, V_PDID, V_PDID_NEW) AS PTDCOND,
	FINGERPRINT
    FROM "ig".IG273
    WHERE PTDID LIKE V_PDID||'%'
    ORDER BY PTDID;
    RAISE NOTICE '9.复制IG273成功。';


    INSERT INTO "ig".IG286
    (
	PLID,
	PLDPDID,
	PLDACTIONID,
	INITIATIVEPIDID,
	PASSIVITYPIDID,
	PLDESC,
	PLBLNAME,
	PLJSEVENT,
	PLJTYPE,
	INITIATIVEPIDNAME,
	PASSIVITYPIDNAME,
	FINGERPRINT
    )
    SELECT
	REPLACE(PLID, V_PDID, V_PDID_NEW) AS PLID_NEW,
	V_PDID_NEW AS PLDPDID_NEW,
	PLDACTIONID,
	REPLACE(INITIATIVEPIDID, V_PDID, V_PDID_NEW) AS INITIATIVEPIDID_NEW,
	REPLACE(PASSIVITYPIDID, V_PDID, V_PDID_NEW) AS PASSIVITYPIDID_NEW,
	PLDESC,
	PLBLNAME,
	PLJSEVENT,
	PLJTYPE,
	INITIATIVEPIDNAME,
	PASSIVITYPIDNAME,
	FINGERPRINT
    FROM "ig".IG286
    WHERE PLID LIKE V_PDID||'%'
    ORDER BY PLID;
    RAISE NOTICE '10.复制IG286成功。';


    INSERT INTO "ig".IG413
    (
	PEDID,
	PDID,
	PSDID,
	PEDACTIONID,
	PEDTYPE,
	PEDBLID,
	PEDORDER,
	PEDEC,
	FINGERPRINT
    )
    SELECT
	REPLACE(PEDID, V_PDID, V_PDID_NEW) AS PEDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PEDACTIONID,
	PEDTYPE,
	PEDBLID,
	PEDORDER,
	PEDEC,
	FINGERPRINT
    FROM "ig".IG413
    WHERE PEDID LIKE V_PDID||'%'
    ORDER BY PEDID;
    RAISE NOTICE '11.复制IG413成功。';


    INSERT INTO "ig".IG126
    (
	PJDID,
	PDID,
	PJDTYPE,
	PJDBLID,
	PJDURL,
	FINGERPRINT
    )
    SELECT
	REPLACE(PJDID, V_PDID, V_PDID_NEW) AS PJDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	PJDTYPE,
	PJDBLID,
	PJDURL,
	FINGERPRINT
    FROM "ig".IG126
    WHERE PJDID LIKE V_PDID||'%'
    ORDER BY PJDID;
    RAISE NOTICE '12.复制IG126成功。';


    INSERT INTO "ig".IG725
    (
    PDBDID,
	PSDID,
	PBDID,
	PDBDNAME,
	PDBDDESC,
	PDBDAUTH,
	FINGERPRINT
    )
    SELECT
	REPLACE(PDBDID, V_PDID, V_PDID_NEW) AS PDBDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PBDID,
	PDBDNAME,
	PDBDDESC,
	PDBDAUTH,
	FINGERPRINT
    FROM "ig".IG725
    WHERE PDBDID LIKE V_PDID||'%'
    ORDER BY PDBDID;
    RAISE NOTICE '13.复制IG725成功。';

    
    INSERT INTO "ig".IG699
    (
	PDVID,
	PIDID,
	PSDID,
	PIDACCESS,
	FINGERPRINT,
	PIDREQUIRED
    )
    SELECT
	REPLACE(PDVID, V_PDID, V_PDID_NEW) AS PDVID_NEW,
	REPLACE(PIDID, V_PDID, V_PDID_NEW) AS PIDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PIDACCESS,
	FINGERPRINT,
	PIDREQUIRED
    FROM "ig".IG699
    WHERE PDVID LIKE V_PDID||'%'
    ORDER BY PDVID;
    RAISE NOTICE '14.复制IG699成功。';


    INSERT INTO "ig".IG213
    (
	PRTDID,
	PDID,
	ROLETYPE,
	FINGERPRINT
    )
    SELECT
	REPLACE(PRTDID, V_PDID, V_PDID_NEW) AS PRTDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	ROLETYPE,
	FINGERPRINT
    FROM "ig".IG213
    WHERE PRTDID LIKE V_PDID||'%'
    ORDER BY PRTDID;
    RAISE NOTICE '15.复制IG213成功。';


    INSERT INTO "ig".IG243
    (
	PTDID,
	PDID,
	PTITLENAME,
	PTITLEACCESS,
	PDESCNAME,
	PDESCACCESS,
	FINGERPRINT
    )
    SELECT
	REPLACE(PTDID, V_PDID, V_PDID_NEW) AS PTDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	PTITLENAME,
	PTITLEACCESS,
	PDESCNAME,
	PDESCACCESS,
	FINGERPRINT
    FROM "ig".IG243
    WHERE PTDID LIKE V_PDID||'%'
    ORDER BY PTDID;
    RAISE NOTICE '16.复制IG243成功。';


    INSERT INTO "ig".IG298
    (
	PSRDID,
	PSDID,
	ROLEID,
	FINGERPRINT
    )
    SELECT
	REPLACE(PSRDID, V_PDID, V_PDID_NEW) AS PSRDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	ROLEID,
	FINGERPRINT
    FROM "ig".IG298
    WHERE PSRDID LIKE V_PDID||'%'
    ORDER BY PSRDID;
    RAISE NOTICE '17.复制IG298成功。';


    INSERT INTO "ig".IG156
    (
	PSEID, 
	PDID, 
	PSDID,
	PSEBUTTONID,
	PSEACTIONID, 
	PSEORDER, 
	PSEDEC, 
	FINGERPRINT,
	PSBDNAME
    )
    SELECT
	REPLACE(PSEID, V_PDID, V_PDID_NEW) AS PSEID_NEW,
	V_PDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PSEBUTTONID,
	PSEACTIONID, 
	PSEORDER, 
	PSEDEC, 
	FINGERPRINT,
	PSBDNAME
    FROM "ig".IG156
    WHERE PSEID LIKE V_PDID||'%'
    ORDER BY PSEID;
    RAISE NOTICE '18.复制IG156成功。';


    INSERT INTO "ig".IG212
    (
	PSDID,
	PSDCONFIRM,
	SMS,
	EMAIL,
	NOTIFYD,
	NOTIFYH,
	NOTIFYM,
	REPORTD,
	REPORTH,
	REPORTM,
	ROLEMANAGER,
	FINGERPRINT
    )
    SELECT
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PSDCONFIRM,
	SMS,
	EMAIL,
	NOTIFYD,
	NOTIFYH,
	NOTIFYM,
	REPORTD,
	REPORTH,
	REPORTM,
	ROLEMANAGER,
	FINGERPRINT
    FROM "ig".IG212
    WHERE PSDID LIKE V_PDID||'%'
    ORDER BY PSDID;
    RAISE NOTICE '19.复制IG212成功。';

    INSERT INTO "ig".IG237
    (
	PSDID,
	PSDCONFIRM,
	USERID,
	ROLEID,
	FINGERPRINT
    )
    SELECT
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PSDCONFIRM,
	USERID,
	ROLEID,
	FINGERPRINT
    FROM "ig".IG237
    WHERE PSDID LIKE V_PDID||'%'
    ORDER BY PSDID;
    RAISE NOTICE '20.复制IG237成功。';


    INSERT INTO "ig".IG373
    (
	PIIDID,
	PDID,
	PSDID,
	PIIDBLID,
	PIIDDEC,
	FINGERPRINT
    )
    SELECT
	REPLACE(PIIDID, V_PDID, V_PDID_NEW) AS PIIDID_NEW,
	V_PDID_NEW AS PDID_NEW,
	REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
	PIIDBLID,
	PIIDDEC,
	FINGERPRINT
    FROM "ig".IG373
    WHERE PSDID LIKE V_PDID||'%'
    ORDER BY PSDID;
    RAISE NOTICE '21.复制IG373成功。';


    INSERT INTO "ig".IG700
    (
	PDID, 
	ROLEID,
	FINGERPRINT
    )
    SELECT
	REPLACE(PDID, V_PDID, V_PDID_NEW) AS PDID_NEW,
	ROLEID,
	FINGERPRINT
    FROM "ig".IG700
    WHERE PDID LIKE V_PDID||'%'
    ORDER BY PDID;
    RAISE NOTICE '22.复制IG700成功。';


    INSERT INTO "ig".IG701
    (
	PDID, 
	ROLEID,
	PIDID,
	FINGERPRINT
    )
    SELECT
	REPLACE(PDID, V_PDID, V_PDID_NEW) AS PDID_NEW,
	ROLEID,
	REPLACE(PIDID, V_PDID, V_PDID_NEW) AS PIDID_NEW,
	FINGERPRINT
    FROM "ig".IG701
    WHERE PDID LIKE V_PDID||'%'
    ORDER BY PDID;
    RAISE NOTICE '23.复制IG701成功。';


    INSERT INTO "ig".IG911
    (
    PSPRPID, 
    PDID,
    PSDID,
    ROLEID,
    RELEVANTPDID,
    FINGERPRINT
    )
    SELECT
    REPLACE(PSPRPID, V_PDID, V_PDID_NEW) AS PSPRPID_NEW,
    V_PDID_NEW,
    REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
    ROLEID,
    RELEVANTPDID,
    FINGERPRINT
    FROM "ig".IG911
    WHERE PSPRPID LIKE V_PDID||'%'
    ORDER BY PSPRPID;
    RAISE NOTICE '24.复制IG911成功。';


    INSERT INTO "ig".IG931
    (
    DPSPRPID, 
    PDID,
    PSDID,
    RELEVANTPDID,
    FINGERPRINT
    )
    SELECT
    REPLACE(DPSPRPID, V_PDID, V_PDID_NEW) AS DPSPRPID_NEW,
    V_PDID_NEW,
    REPLACE(PSDID, V_PDID, V_PDID_NEW) AS PSDID_NEW,
    RELEVANTPDID,
    FINGERPRINT
    FROM "ig".IG931
    WHERE DPSPRPID LIKE V_PDID||'%'
    ORDER BY DPSPRPID;
    RAISE NOTICE '25.复制IG931成功。';

	RAISE NOTICE '=========复制流程结束=========';
	RETURN 1;
END;
$BODY$
LANGUAGE plpgsql;
