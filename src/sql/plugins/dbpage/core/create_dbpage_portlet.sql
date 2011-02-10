--
-- Structure for table dbpage_portlet
--

DROP TABLE IF EXISTS dbpage_portlet;
CREATE TABLE dbpage_portlet (
  id_portlet int DEFAULT '0' NOT NULL,
  dbpage_name varchar(50) DEFAULT NULL,
  dbpage_values varchar(255) DEFAULT NULL,
  PRIMARY KEY  (id_portlet)
);
