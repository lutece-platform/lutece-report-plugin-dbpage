--
-- The database structure of dbpage which is used in dbpage plugin
--


--
-- Table structure for table dbpage_page
--

DROP TABLE IF EXISTS dbpage_page;
CREATE TABLE dbpage_page (
  id_page int DEFAULT '0' NOT NULL,
  param_name varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  workgroup_key varchar(50) DEFAULT 'all' NOT NULL,
  PRIMARY KEY  (id_page)
);


--
-- Table structure for table dbpage_section
--

DROP TABLE IF EXISTS dbpage_section;
CREATE TABLE dbpage_section (
  id_section int DEFAULT '0' NOT NULL,
  id_page int DEFAULT NULL,
  id_type varchar(255) DEFAULT NULL,
  template varchar(255) DEFAULT NULL,
  desc_column varchar(255) DEFAULT NULL,
  desc_sql long varchar NOT NULL,
  pool varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  id_order int DEFAULT '0' NOT NULL,
  role varchar(255) DEFAULT 'none' NOT NULL,
  PRIMARY KEY  (id_section)
);
