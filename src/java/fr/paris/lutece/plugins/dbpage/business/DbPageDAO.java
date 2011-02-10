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
package fr.paris.lutece.plugins.dbpage.business;

import fr.paris.lutece.portal.service.database.PluginConnectionService;
import fr.paris.lutece.portal.service.util.AppException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


/**
 * This class provides Data Access methods for DbPage DAO objects
 */
public final class DbPageDAO implements IDbPageDAO
{
    /**
     * Returns a list of lists of String
     * @param strRequest The SQL request
     * @param connectionService The PluginConnectionService
     * @throws SQLException An exception which is related in the sql handling
     * @return a Collection of the Columns' values
     */
    public List<List<String>> selectRows( String strRequest, PluginConnectionService connectionService )
        throws SQLException
    {
        Connection connection = null;
        Statement statement = null;
        String strSQL = strRequest;

        try
        {
            connection = connectionService.getConnection(  );
            statement = connection.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY );

            ResultSet resultSet = statement.executeQuery( strSQL );
            ResultSetMetaData rsmd = resultSet.getMetaData(  );

            List<List<String>> listRow = new ArrayList<List<String>>(  );

            while ( resultSet.next(  ) )
            {
                String strValue = null;
                List<String> listLine = new ArrayList<String>(  );

                for ( int i = 1; i <= rsmd.getColumnCount(  ); i++ )
                {
                    if ( resultSet.getObject( rsmd.getColumnName( i ) ) != null )
                    {
                        strValue = resultSet.getObject( rsmd.getColumnName( i ) ).toString(  );
                    }
                    else
                    {
                        strValue = " ";
                    }

                    listLine.add( strValue );
                }

                listRow.add( listLine );
            }

            statement.close(  );
            statement = null;

            return listRow;
        }
        finally
        {
            try
            {
                if ( statement != null )
                {
                    statement.close(  );
                }
            }
            catch ( SQLException e )
            {
                throw new AppException( "SQL Error executing command : " + e.toString(  ) );
            }

            connectionService.freeConnection( connection );
        }
    }
}
