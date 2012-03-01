/*
 * Copyright (c) 2002-2012, Mairie de Paris
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

import java.util.List;
import java.util.Map;

import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

/**
 * Service fetching the declared section
 */
@SuppressWarnings( "unchecked" )
public enum DbSectionService
{INSTANCE;

 //   private Map<String,DbPageSection> _mapSections = DbPageContextService.getListSubClasses( "dbpage",IDbPageSection.class );
    
   // private static Map<String,DbPageSection> _mapSections =  
   // private static List<IDbPageSection> _listSubClasses = SpringContextService.getBeansOfType(IDbPageSection.class);


    /**
     * Finds the sections found in plugin and also in compatible modules
     * @return The list of available section
     */
    public ReferenceList findDbPageDatabaseTypesList(  )
    {
        ReferenceList typeList = new ReferenceList(  );
        List<IDbPageSection> _listSubClasses = SpringContextService.getBeansOfType(IDbPageSection.class);
        for ( IDbPageSection section : _listSubClasses )
        {
            typeList.addItem( Long.toString( section.getIdType(  ) ), section.getTypeDescription(  ) );
        }

        return typeList;
    }
    
    /**
     * Finds an empty section by its type
     * @param strIdType The type of the section
     * @return the section
     */
    public DbPageSection findById( String strIdType )
    {
        IDbPageSection sect = null;
        List<IDbPageSection> _listSubClasses = SpringContextService.getBeansOfType(IDbPageSection.class);
        for ( IDbPageSection section : _listSubClasses )
        {
            if ( Long.toString( section.getIdType(  ) ).equals( strIdType ) )
            {
                sect = section;
            }
        }

        return ((DbPageSection) sect).getDbSection(  );
    }

    /**
     * Finds the template for creation
     * @param strIdType The type of the section
     * @return The path of the template
     */
    public String findCreationTemplate( String strIdType )
    {
        return findById( strIdType ).getCreationTemplate(  );
    }

    /**
     * Finds the template for modification
     * @param strIdType The type of the section
     * @return The path of the template
     */
    public String findModificationTemplate( String strIdType )
    {
        return findById( strIdType ).getModificationTemplate(  );
    }

    /**
     * Finds the additional map
     * @param strIdType The type of the section
     * @return The additonal map
     */
    public Map findAdditionalMap( String strIdType )
    {
        return findById( strIdType ).getMarkMap(  );
    }
}
