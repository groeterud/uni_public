CREATE Trigger friend_insert
AFTER INSERT ON Friend
FOR EACH ROW
WHEN NOT EXISTS (SELECT * FROM Friend 
                    WHERE ID1=new.ID2 AND ID2=new.ID1)
BEGIN
    INSERT INTO Friend VALUES (new.ID2,new.ID1)
END;




CREATE TRIGGER friend_delete
AFTER DELETE ON Friend
FOR EACH ROW 
WHEN EXISTS (SELECT * FROM Friend
                WHERE ID1=OLD.ID2 AND ID2=OLD.ID1)
BEGIN
    DELETE FROM Friend
    WHERE (ID1=OLD.ID2 AND ID2=OLD.ID1)
END;






--Tutorial 13--Delete table if existand create customer_log tableDROPTABLE IF EXISTScustomer_log;CREATE TABLEcustomer_log (customer_id integerNOT NULL,"O_email" character varying(50) NOT NULL,"N_email"character varying(50) NOT NULL,change_on timestamp with time zone NOT NULL,PRIMARY KEY(customer_id));--Create function CUST_EMAIL_CHANGESCREATE OR REPLACE FUNCTIONcust_email_changes()RETURNStrigger AS$BODY$BEGINIFNEW.email <> OLD.email THENINSERT INTOcustomer_log VALUES(OLD.customer_id,OLD.email,NEW.email,now());END IF;RETURN NEW;END$BODY$LANGUAGEplpgsql VOLATILECOST100;--create a trigger to bind the trigger function to “customer” tableDROP TRIGGER IF EXISTSlog_email_changes ONcustomer CASCADE;CREATETRIGGERlog_email_changesBEFOREUPDATEONcustomerFOREACHROWEXECUTEPROCEDUREcust_email_changes();--See data on customers to view itSELECT* FROMcustomer ORDERBYcustomer_id;--update statement on “customer” tablefor customer_id=1UPDATEcustomerSETemail = 'mary.smith@gmail.com'WHEREcustomer_id= 1;
--See the resultsSELECT*  FROMcustomer WHERE customer_id = 1;SELECT* FROMcustomer_log;--TUTORIAL 14--To list all the triggers in “dvdrental” databaseSELECT* FROMpg_trigger;--To list all the triggers on a particular table, for example, “customer” tableSELECTtgname FROMpg_trigger, pg_class WHEREtgrelid=pg_class.oid ANDrelname='customer';