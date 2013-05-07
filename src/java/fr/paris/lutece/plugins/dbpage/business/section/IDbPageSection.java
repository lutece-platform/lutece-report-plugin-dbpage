/*
 * Copyright (c) 2002-2013, Mairie de Paris
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

import javax.servlet.http.HttpServletRequest;


/**
 * An interface describing the sections
 */
public interface IDbPageSection
{
    /**
     * The identifier of the type of a section
     * @return The type of the section
     */
    long getIdType(  );

    /**
     * The description of the type of the section
     * @return The description of the section
     */
    String getTypeDescription(  );

    /**
     * The html content of the section
     * @param listValues The list of values
     * @param request The http request
     *  @return The html rendering of the section
     */
    String getHtmlSection( List<String> listValues, HttpServletRequest request );

    /**
     * The path for the creation of the section
     * @return The path of the template needed to create the section
     */
    String getCreationTemplate(  );

    /**
     * The path for the modification of the section
     * @return The path of the template needed to modify the section
     */
    String getModificationTemplate(  );

    /**
     * A map with additional parameters
     * @return An additional map with markers and corresponding objects
     */
    Map<String, Object> getMarkMap(  );
}
