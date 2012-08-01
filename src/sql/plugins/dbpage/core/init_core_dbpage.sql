--
-- data for table core_admin_right
--

INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url) VALUES 
('DBPAGE_MANAGEMENT','dbpage.adminFeature.dbpage_management.name',1,'jsp/admin/plugins/dbpage/ManageDbPages.jsp','dbpage.adminFeature.dbpage_management.description',0,'dbpage','APPLICATIONS',NULL, NULL);


--
-- data for table core_portlet_type
--

INSERT INTO core_portlet_type VALUES 
('DBPAGE_PORTLET','dbpage.portlet.name','plugins/dbpage/CreatePortletDbPage.jsp','plugins/dbpage/ModifyPortletDbPage.jsp','fr.paris.lutece.plugins.dbpage.business.portlet.DbPagePortletHome','dbpage','plugins/dbpage/DoCreatePortletDbPage.jsp','/admin/portlet/script_create_portlet.html','/admin/plugins/dbpage/portlet/portlet_dbpage_type.html','','plugins/dbpage/DoModifyPortletDbPage.jsp','/admin/portlet/script_modify_portlet.html','/admin/plugins/dbpage/portlet/portlet_dbpage_type.html','');

--
-- data for table core_style
--

INSERT INTO core_style VALUES 
(252,'Default','DBPAGE_PORTLET',0);

--
-- data for table core_style_mode_stylesheet
--

INSERT INTO core_style_mode_stylesheet VALUES (252,0,280);

--
-- data for table core_stylesheet
--

INSERT INTO core_stylesheet (id_stylesheet, description, file_name, source) VALUES (280,'Rubrique DbPage - Defaut','portlet_dbpage.xsl','<?xml version=\"1.0\"?>\r\n<xsl:stylesheet version=\"1.0\"\r\n	xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n\r\n	<xsl:template match=\"portlet\">\r\n	\r\n	<xsl:variable name=\"device_class\">\r\n	<xsl:choose>\r\n		<xsl:when test=\"string(display-on-small-device)=\'0\'\">hide-for-small</xsl:when>\r\n		<xsl:otherwise></xsl:otherwise>\r\n	</xsl:choose>\r\n	</xsl:variable>\r\n		<div class=\"portlet  {$device_class} append-bottom -lutece-border-radius\">\r\n			<xsl:choose>\r\n				<xsl:when test=\"not(string(display-portlet-title)=\'1\')\">\r\n					<h3 class=\"portlet-header \">\r\n						<xsl:value-of disable-output-escaping=\"yes\" select=\"portlet-name\" />\r\n					</h3>\r\n					<div class=\"portlet-content\">\r\n						<xsl:apply-templates select=\"dbpage-portlet\" />\r\n					</div>\r\n				</xsl:when>\r\n				<xsl:otherwise>\r\n					<div class=\"portlet-content\">\r\n						<xsl:apply-templates select=\"dbpage-portlet\" />\r\n					</div>\r\n				</xsl:otherwise>\r\n			</xsl:choose>\r\n		</div>\r\n	</xsl:template>\r\n\r\n\r\n	<xsl:template match=\"dbpage-portlet\">\r\n		<xsl:apply-templates select=\"dbpage-portlet-content\" />\r\n	</xsl:template>\r\n\r\n\r\n	<xsl:template match=\"dbpage-portlet-content\">\r\n		<xsl:value-of disable-output-escaping=\"yes\" select=\".\" />\r\n\r\n	</xsl:template>\r\n\r\n\r\n</xsl:stylesheet>\r\n');

--
-- data for table core_user_right
--

INSERT INTO core_user_right VALUES ('DBPAGE_MANAGEMENT',1);


