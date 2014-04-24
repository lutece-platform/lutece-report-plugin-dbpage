/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.dbpage.business.section;

import fr.paris.lutece.plugins.dbpage.business.DbPageHome;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.html.HtmlTemplate;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * This class represents business object DbPageSectionTable
 */
public class DbPageSectionTable extends DbPageSection
{
    private static final long serialVersionUID = 3589380186475889829L;
    private static final String MARK_RESULT_DATASET = "result_dataset";
    private static final String MARK_SECTION_TITLE = "section_title";
    private static final String MARK_COLUMN_NAMES = "column_names";
    private static final String PROPERTY_FILES_PATH = "dbpage.files.path";
    private static final String TEMPLATE_DEFAULT_TABLE = "skin/plugins/dbpage/default_table.html";
    private static final String TEMPLATE_CREATION_TABLE = "admin/plugins/dbpage/create_section_table.html";
    private static final String TEMPLATE_MODIFICATION_TABLE = "admin/plugins/dbpage/modify_section_table.html";

    /**
     * Creates a section which of type table
     * @param strDescType The description of the type of the section
     */
    public DbPageSectionTable( String strDescType )
    {
        this.setIdTypeSignature( serialVersionUID );
        this.setDescType( strDescType );
    }

    /**
     * Returns the Html Section Table form
     * @return the html code of the html Section Table form
     * @param request The request
     * @param listValues the list of id values substitute in the SQL request
     */
    public String getHtmlSection( List listValues, HttpServletRequest request )
    {
        HashMap rootModel = new HashMap(  );

        rootModel.put( MARK_SECTION_TITLE, getTitle(  ) );
        rootModel.put( MARK_COLUMN_NAMES, getTableHeader(  ) );
        rootModel.put( MARK_RESULT_DATASET, getTableDataset( getValuatedQuery( listValues ) ) );

        if ( getTemplatePath(  ).equals( "" ) )
        {
            HtmlTemplate tTable = AppTemplateService.getTemplate( TEMPLATE_DEFAULT_TABLE, request.getLocale(  ),
                    rootModel );

            return tTable.getHtml(  );
        }
        else
        {
            String strFilePath = AppPropertiesService.getProperty( PROPERTY_FILES_PATH );
            HtmlTemplate tSelect = AppTemplateService.getTemplate( getTemplatePath(  ), strFilePath,
                    ( request == null ) ? null : request.getLocale(  ), rootModel );

            return tSelect.getHtml(  );
        }
    }

    /**
     *  Returns the table headers as a list of string values
     * @return The table headers
     */
    private List<String> getTableHeader(  )
    {
        List<String> listColumnNames = new ArrayList<String>(  );

        for ( String strColumnName : getColumnNames(  ) )
        {
            listColumnNames.add( strColumnName );
        }

        return listColumnNames;
    }

    /**
     * Returns the table dataset
     * @param strRequest The request
     * @return A list of list of string values
     */
    private List<List<String>> getTableDataset( String strRequest )
    {
        List<List<String>> listDataset = null;

        try
        {
            listDataset = DbPageHome.selectRows( strRequest, getConnectionService( getDbPool(  ) ) );
        }
        catch ( SQLException e )
        {
            AppLogService.error( e );
        }

        return listDataset;
    }

    /**
     * The type of the section
     * @return The type of the section
     */
    public long getIdType(  )
    {
        return getIdTypeSignature(  );
    }

    /**
     * The description of the section type
     * @return The description of the section type
     */
    public String getTypeDescription(  )
    {
        return getDescType(  );
    }

    /**
     * The path of the template for creation
     * @return the path of the creation template
     */
    public String getCreationTemplate(  )
    {
        return TEMPLATE_CREATION_TABLE;
    }

    /**
     * The path of the template for modification
     * @return the path of the modification template
     */
    public String getModificationTemplate(  )
    {
        return TEMPLATE_MODIFICATION_TABLE;
    }

    /**
     * Returns a map with additional markers
     */
    public Map<String, Object> getMarkMap(  )
    {
        Map map = new HashMap(  );

        return map;
    }
}
