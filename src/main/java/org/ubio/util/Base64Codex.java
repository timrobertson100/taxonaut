/*
 * Base64Codex.java: provides a codex for Base64 and UTF-8
 *
 * Copyright (c) 2016 Nozomi `James' Ytow
 * All rights reserved.
 */

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ubio.util;

import org.apache.axis.encoding.Base64;

/**
 * {@code Base64Codex} provides a codex for Base64 and UTF-8.
 *
 * @version 	17 June 2016
 * @author 	Nozomi `James' Ytow
 */
public class Base64Codex
{
    protected static final String UTF8="UTF-8";

    public static String encode(String text)
    {
	if(text == null)
	    return text;
	try {
	    return Base64.encode(text.getBytes());
	}
	catch (Throwable e) {
	    return null;
	}
    }

    public static String decode(String base64)
    {
	if(base64 == null)
	    return null;

	try {
	    return new String(Base64.decode(base64), UTF8);
	}
	catch (Throwable e) {
	    return null;
	}
    }
}
