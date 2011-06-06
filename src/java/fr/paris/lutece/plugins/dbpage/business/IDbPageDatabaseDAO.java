/*
 * Copyright (c) 2002-2011, Mairie de Paris
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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.ReferenceList;

import java.util.List;


/**
 * IDbPageDatabaseDAO
 */
public interface IDbPageDatabaseDAO
{
    /**
     * Delete a record from the table
     * @param plugin The plugin
     * @param nDbPageDatabaseId The DbPageDatabase Id
     */
    void delete( int nDbPageDatabaseId, Plugin plugin );

    /**
     * Insert a new record in the table.
     * @param plugin The plugin
     * @param dbPageDatabase The dbPageDatabase object
     */
    void insert( DbPageDatabase dbPageDatabase, Plugin plugin );

    /**
     * Load the data of DbPageDatabase from the table
     * @param nDbPageDatabaseId The identifier of DbPageDatabase
     * @param plugin The plugin
     * @return the instance of the DbPageDatabase
     */
    DbPageDatabase load( int nDbPageDatabaseId, Plugin plugin );

    /**
     * Load the data of DbPageDatabase from the table
     * @param strDbPageName The identifier of DbPageDatabase
     * @param plugin The plugin
     * @return the instance of the DbPageDatabase
     */
    DbPageDatabase loadByName( String strDbPageName, Plugin plugin );

    /**
     * Load the list of dbPageDatabases
     * @param plugin The plugin
     * @return The List of the DbPages
     */
    List<DbPageDatabase> selectDbPageDatabaseList( Plugin plugin );

    /**
     * Load the list of dbpages
     * @param plugin The plugin
     * @return The ReferenceList of the DbPages
     */
    ReferenceList selectDbPagesList( Plugin plugin );

    /**
     * Update the record in the table
     * @param plugin The plugin
     * @param dbPageDatabase The reference of dbPageDatabase
     */
    void store( DbPageDatabase dbPageDatabase, Plugin plugin );
}
