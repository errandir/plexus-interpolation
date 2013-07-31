package org.codehaus.plexus.interpolation.os;

/*
 * The MIT License
 *
 * Copyright (c) 2004, The Codehaus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * <b>NOTE:</b> This class was copied from plexus-utils, to allow this library
 * to stand completely self-contained.
 * <br/>
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l </a>
 * @version $Id$
 */
public final class OperatingSystemUtils
{

    private OperatingSystemUtils()
    {
    }

    public static Properties getSystemEnvVars()
        throws IOException
    {
        return getSystemEnvVars( true );
    }

    /**
     * Return the shell environment variables. If <code>caseSensitive == true</code>, then envar
     * keys will all be upper-case.
     *
     * @param caseSensitive Whether environment variable keys should be treated case-sensitively.
     * @return Properties object of (possibly modified) envar keys mapped to their values.
     * @throws IOException
     */

    public static Properties getSystemEnvVars( boolean caseSensitive )
        throws IOException
    {
        Properties envVars = new Properties();
        Map<String, String> envs = System.getenv();
        for ( String key : envs.keySet() )
        {
            String value = envs.get( key );
            if ( !caseSensitive)
            {
                key = key.toUpperCase( Locale.ENGLISH );
            }
            envVars.put( key, value );
        }
        return envVars;
    }
}
