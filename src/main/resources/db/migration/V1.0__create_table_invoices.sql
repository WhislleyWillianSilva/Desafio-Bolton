USE template;

CREATE TABLE invoices (
    id integer NOT NULL AUTO_INCREMENT,
    access_key varchar(200) NOT NULL,
    amount decimal NOT NULL,
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;
