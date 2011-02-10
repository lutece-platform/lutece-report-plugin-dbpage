/*
 * Copyright (c) 2002-2009, Mairie de Paris
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

import fr.paris.lutece.plugins.dbpage.service.DbPageConnectionService;
import fr.paris.lutece.portal.service.database.PluginConnectionService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.util.string.StringUtil;

import java.util.List;


/**
 * This class represents business object DbPageSection
 */
public abstract class DbPageSection implements IDbPageSection, Cloneable
{
    private static final String EMPTY_STRING = "";

    /////////////////////////////////////////////////////////////////////////////////
    // Constants
    private long _lIdType;
    private String _strDescType;
    private String _strType;
    private String _strTitle;
    private String _strTemplatePath;
    private List<String> _listColumnNames;
    private String _strSQL;
    private String _strDbPool;
    private String _strRole;

    /**
     * Returns the type of this DbPageSection.
     *
     * @return the DbPageSection type
     */
    public String getType(  )
    {
        return _strType;
    }

    /**
     * Sets the type of the DbPageSection to the specified string.
     *
     * @param strType the new type
     */
    public void setType( String strType )
    {
        _strType = ( strType == null ) ? EMPTY_STRING : strType;
    }

    /**
    * Returns the template path
    *
    * @return the relative path of the template
    */
    public String getTemplatePath(  )
    {
        return _strTemplatePath;
    }

    /**
    * Sets the template path of the DbPageSection to the specified string.
    * @param strTemplatePath The new template path
    */
    public void setTemplatePath( String strTemplatePath )
    {
        _strTemplatePath = ( strTemplatePath == null ) ? EMPTY_STRING : strTemplatePath;
    }

    /**
     * Returns the ColumnNames
     *
     * @return The list of the Columns' name
     */
    public List<String> getColumnNames(  )
    {
        return _listColumnNames;
    }

    /**
     * Sets the listColumnNames
     *
     * @param listColumnNames the list of columns names
     */
    public void setColumnNames( List listColumnNames )
    {
        _listColumnNames = listColumnNames;
    }

    /**
     * Returns the title of the section
     *
     * @return The title
     */
    public String getTitle(  )
    {
        return _strTitle;
    }

    /**
     * Sets the title of the section
     *
     * @param strTitle The new title
     */
    public void setTitle( String strTitle )
    {
        _strTitle = ( strTitle == null ) ? EMPTY_STRING : strTitle;
    }

    /**
     * Returns the sql request of the section
     *
     * @return The SQL request
     */
    public String getSql(  )
    {
        return _strSQL;
    }

    /**
     * Sets the SQL request
     *
     * @param strSql The SQL request
     */
    public void setSql( String strSql )
    {
        _strSQL = ( strSql == null ) ? EMPTY_STRING : strSql;
    }

    /**
     * Returns the DbPool of the section
     *
     * @return The DbPool
     */
    public String getDbPool(  )
    {
        return _strDbPool;
    }

    /**
     * Sets the DbPool
     *
     * @param strDbPool The DbPool
     */
    public void setDbPool( String strDbPool )
    {
        _strDbPool = ( strDbPool == null ) ? EMPTY_STRING : strDbPool;
    }

    /**
     * Get a connection service corresponding to the given poolname. If the pool
     * name is empty, the default connection service of the current plugin is returned
     * @return A Connection Service
     * @param strPoolName The Poolname
     */
    public PluginConnectionService getConnectionService( String strPoolName )
    {
        return DbPageConnectionService.getConnectionService( strPoolName );
    }

    /**
     * Returns the SQL query associated to the section filled by extra values
     * @param listValues A list of extra values to substitute in the query
     * @return The SQL query
     */
    protected String getValuatedQuery( List listValues )
    {
        return substituteValues( getSql(  ), listValues );
    }

    /**
     *
     * @param strQuery the request
     * @param listValues The list of values
     * @return the query
     */
    private String substituteValues( String strQuery, List listValues )
    {
        String strResult = strQuery;

        for ( int i = 0; i < listValues.size(  ); i++ )
        {
            String strValue = (String) listValues.get( i );
            String strBookmark = "@value" + ( i + 1 ) + "@";
            strResult = StringUtil.substitute( strResult, strValue, strBookmark );
        }

        return strResult;
    }

    /**
     * Returns the Role of the section
     *
     * @return The Role
     */
    public String getRole(  )
    {
        return _strRole;
    }

    /**
     * Sets the Role
     *
     * @param strRole The Role
     */
    public void setRole( String strRole )
    {
        _strRole = ( strRole == null ) ? EMPTY_STRING : strRole;
    }

    /**
     * A DbPageSection object is produced
     * @return Gets a section
     */
    public DbPageSection getDbSection(  )
    {
        DbPageSection sect = null;

        try
        {
            sect = (DbPageSection) this.clone(  );
        }
        catch ( CloneNotSupportedException e )
        {
            AppLogService.error( e );
        }

        return sect;
    }

    /**
     * Sets the signature of the section
     * @param lIdType The type of the section id
     */
    public void setIdTypeSignature( long lIdType )
    {
        this._lIdType = lIdType;
    }

    /**
     * Gets the signature of the section
     * @return The long value representing the type of the section
     */
    public long getIdTypeSignature(  )
    {
        return _lIdType;
    }

    /**
     * Sets the type of the section
     * @param strDescType The description of the type of the section
     */
    public void setDescType( String strDescType )
    {
        this._strDescType = strDescType;
    }

    /**
     * The type of the section
     * @return The description of the type of the section
     */
    public String getDescType(  )
    {
        return _strDescType;
    }
}
