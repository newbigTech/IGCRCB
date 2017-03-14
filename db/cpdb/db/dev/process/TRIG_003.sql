CREATE OR REPLACE TRIGGER TRIG_003
  AFTER DELETE ON IG337
  FOR EACH ROW
BEGIN
  DELETE FROM R01 WHERE R0101 = :OLD.PPID;
EXCEPTION
  WHEN OTHERS THEN
    RAISE;
END TRIG_003;
/
