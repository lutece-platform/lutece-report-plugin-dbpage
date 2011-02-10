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

INSERT INTO core_stylesheet (id_stylesheet, description, file_name, source) VALUES (280,'Rubrique DbPage - Defaut','portlet_dbpage.xsl',0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E30220D0A09786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A0D0A093C78736C3A74656D706C617465206D617463683D22706F72746C6574223E0D0A09093C64697620636C6173733D22706F72746C657420617070656E642D626F74746F6D202D6C75746563652D626F726465722D726164697573223E0D0A0909093C78736C3A63686F6F73653E0D0A090909093C78736C3A7768656E20746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A09090909093C683320636C6173733D22706F72746C65742D68656164657220223E0D0A0909090909093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D22706F72746C65742D6E616D6522202F3E0D0A09090909093C2F68333E0D0A09090909093C64697620636C6173733D22706F72746C65742D636F6E74656E74223E0D0A0909090909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226462706167652D706F72746C657422202F3E0D0A09090909093C2F6469763E0D0A090909093C2F78736C3A7768656E3E0D0A090909093C78736C3A6F74686572776973653E0D0A09090909093C64697620636C6173733D22706F72746C65742D636F6E74656E74223E0D0A0909090909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226462706167652D706F72746C657422202F3E0D0A09090909093C2F6469763E0D0A090909093C2F78736C3A6F74686572776973653E0D0A0909093C2F78736C3A63686F6F73653E0D0A09093C2F6469763E0D0A093C2F78736C3A74656D706C6174653E0D0A0D0A0D0A093C78736C3A74656D706C617465206D617463683D226462706167652D706F72746C6574223E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D226462706167652D706F72746C65742D636F6E74656E7422202F3E0D0A093C2F78736C3A74656D706C6174653E0D0A0D0A0D0A093C78736C3A74656D706C617465206D617463683D226462706167652D706F72746C65742D636F6E74656E74223E0D0A09093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D222E22202F3E0D0A0D0A093C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C2F78736C3A7374796C6573686565743E0D0A);

--
-- data for table core_user_right
--

INSERT INTO core_user_right VALUES ('DBPAGE_MANAGEMENT',1);


