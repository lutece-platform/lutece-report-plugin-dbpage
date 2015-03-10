
#Plugin dbpage

##Introduction

The dbpage plugin allows to create online reports by extracting data from any database and presenting it with the help of simple HTML templates.

##Prerequisites

In order to follow this tutorial, a knowledge of SQL and HTML is needed.

#Overview of plugin dbpage

##Choose your datasource(s)

The datasource is declared as a pool in the `db.properties` .The datasource may be any database accessible by JDBC (i.e MySQL,PostgreSQL,Oracle,Microsoft SQL Server etc ...). The code snippet below shows how a pool may be declared


```

#mypool.poolservice is not a mandatory property
mypool.poolservice=fr.paris.lutece.util.pool.service.LuteceConnectionService
mypool.driver=org.gjt.mm.mysql.Driver
mypool.url=jdbc:mysql://localhost/mydatabase?autoReconnect=true&useUnicode=yes&characterEncoding=utf8
mypool.user=
mypool.password=
mypool.initconns=2
mypool.maxconns=5
mypool.logintimeout=2000
mypool.checkvalidconnectionsql=SELECT 1
                
```


Each section can be branched to a different or same pool as shown on the diagram below. The DbPage is composed of all the sections as follows. This allows data synthesis by combination of many sections.![Image](http://dev.lutece.paris.fr/plugins/plugin-dbpage/images/dbpage_manual_002.gif)

##Choose parameters to target the appropriate data

The variables of a report may be a date, a project or any data. The choice of these parameters as variables in order to allow the user to scroll through the report depends on your user requirements.Please consult the usage section to see a simple usage of dbpage in a concrete example(e.g MyHelloWorld Report).

##Create the templates or use provided templates for rendering

Each DbPage has a title and sections. The sections are of type form,table and selects. The choice of a template depends on the dataset that is collected by the sql query. Any esthetic concerns will be expressed into the template(colors,styles,size). The DbPage can be declareddirectly in the Back Office or as text files that are uploaded on the server.This issue is treated in more details in the Usage section.

![Image](http://dev.lutece.paris.fr/plugins/plugin-dbpage/images/dbpage_manual_001.gif)

#Publish in a few clicks

The dbpage can be published as a portlet so that it can marry completely the general design of the Lutece CMS or as an XPage which will be accessed by a specific Url. In general a combination of the two can be used in order to handle form submission to enhance interactionwhile navigation through the data.

#MyHelloWorld Report

##

The goal of this tutorial is to explain the different steps in order to use the DbPage. Let's take a simple SQL structure of some project attributes in a table.


```
                
CREATE TABLE `project` (
  `project_name` varchar(255) default NULL,
  `project_date_begin` date default NULL,
  `project_budget` varchar(255) default NULL,
  `project_manager` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

INSERT  INTO `project`(`project_name`,`project_date_begin`,`project_budget`,`project_manager`) VALUES ('Project Dev UI','2008-12-12','10000','bob'),
('Integration Project','2009-01-05','12000','bob'),
('Financial Software Update','2008-06-09','15000','john'),
('Marketing Project','2009-11-06','30000','mary');

```


 **The aim of the report is to publish online the sum of the budgets allocated to each project manager.** . The SQL query to obtain the values is given below.
```

SELECT project_manager,SUM(project_budget) FROM project GROUP BY project_manager 
                
```


##Create a DbPage directly with web user interface

Create a DbPage

Create a section
 
* Choose the section type
* Choose a standard table template
* Choose the pool
* Put in the SQL Query


##The Dbpage from a file

The attributes of a dbpage are defined in a file which is named pour nom `"mydbpage.properties"` and which is found in `"WEB-INF/plugins/dbpage"` .


| Attribute of the page| Mandatory| Description|
|-----------------|-----------------|-----------------|
| page.paramname| Oui| Name of the dbpage who is used in the request URL: `Portal.jsp?page=dbpage&dbpage=dbpage_name` .|
| page.title| Oui| Name of the page which will be title in the web browser and the navigation tree.|
| page.nbsections| Yes| Number of sections defined for the dbpage.|



| Attribute de section| Mandatory| Description|
|-----------------|-----------------|-----------------|
| sectionN.title| No| Title of the section|
| sectionN.type| No| The section types provided are declared in the "/WEB-INF/conf/plugins/dbpage.properties" file.The base type are "form and "table"|
| sectionN.template| Oui| Relative path of the Html template from "WEB-INF/plugins/dbpage/".|
| sectionN.column| Yes if SQL query| For a table section, the field to be defined in the template is the list of titles of the column of the tablefor the sql result. For the "form" section,the field defines thebookmarks from the template to be substituted by order of the columns in the sql query.|
| sectionN.sql| Yes for "table"| SQL Query which will fill the table.|
| sectionN.pool| No| Connection pool. The default value is that used by the plugin but can be changed.|
| sectionN.role| No| The rendering of the section is done when the authenticated user has sufficient right defined by the role variable.|


Here is a small example of the file :
 `
```

page.paramname=mydbpage
page.title=My DbPage Title
page.nbsections=2

# section #1
section1.title=header
section1.type=form
section1.template=mydbpage/hearder.html

# section #2
section2.title=Liste of users
section2.type=table
section2.template=mydbpage/table.html
section2.column=First name , Last name
section2.sql=SELECT first_name , last_name FROM core_admin_user ORDER BY last_name;
                    
```
` 
##The database management of the dbpage

This mode has user interfaces to complete the details used to access the different databases for each section. The function can be accessed by the link "Management of DbPages".The attributes are the same but the templates are stored on the web application. And the SQL query is verified before stored, this reduces runtime errors.


[Maven documentation and reports](http://dev.lutece.paris.fr/plugins/plugin-dbpage/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*