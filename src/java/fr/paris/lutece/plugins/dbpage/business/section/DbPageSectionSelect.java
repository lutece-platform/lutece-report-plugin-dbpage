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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * This class represents business object DbPageSectionSelect
 */
public class DbPageSectionSelect extends DbPageSection
{
    /**
     *
     */
    private static final long serialVersionUID = 672960958632821828L;
    private static final String MARK_SECTION_TITLE = "section_title";
    private static final String MARK_SELECT_LIST = "list_select";
    private static final String PROPERTY_FILES_PATH = "dbpage.files.path";
    private static final String TEMPLATE_DEFAULT_SELECT = "skin/plugins/dbpage/default_select.html";
    private static final String TEMPLATE_CREATION_SELECT = "admin/plugins/dbpage/create_section_select.html";
    private static final String TEMPLATE_MODIFICATION_SELECT = "admin/plugins/dbpage/modify_section_select.html";
    private static final String MARK_VALUE = "value";

    /**
     * Constructor
     * @param strDescType The type of the section
     */
    public DbPageSectionSelect( String strDescType )
    {
        this.setIdTypeSignature( serialVersionUID );
        this.setDescType( strDescType );
    }

    /**
     * Returns the Html Section Table form
     *
     * @return the html code of the html Section Table form
     * @param request
     *            The request
     * @param listValues
     *            the list of id values substitute in the SQL request
     */
    public String getHtmlSection( List<String> listValues, HttpServletRequest request )
    {
        HashMap rootModel = new HashMap(  );
        rootModel.put( MARK_SECTION_TITLE, getTitle(  ) );

        Collection listSelects;

        try
        {
            listSelects = DbPageHome.selectRows( getValuatedQuery( listValues ), getConnectionService( getDbPool(  ) ) );
            rootModel.put( MARK_SELECT_LIST, listSelects );
            for( int i=0;i<listValues.size();i++)
            {
            	 rootModel.put( MARK_VALUE+(i+1), listValues.get(i) );
            }
        }
        catch ( SQLException e )
        {
            AppLogService.error( e );
        }

        if ( getTemplatePath(  ).equals( "" ) )
        {
          
            HtmlTemplate tSelect = AppTemplateService.getTemplate( TEMPLATE_DEFAULT_SELECT, request.getLocale(  ),
                    rootModel );

            return tSelect.getHtml(  );
        }
        else
        {
            String strFilePath = AppPropertiesService.getProperty( PROPERTY_FILES_PATH );
           
            HtmlTemplate tSelect = AppTemplateService.getTemplate( getTemplatePath(  ), strFilePath,
                    request.getLocale(  ), rootModel );

            return tSelect.getHtml(  );
        }
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
        return TEMPLATE_CREATION_SELECT;
    }

    /**
     * The path of the template for modification
     * @return the path of the modification template
     */
    public String getModificationTemplate(  )
    {
        return TEMPLATE_MODIFICATION_SELECT;
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
