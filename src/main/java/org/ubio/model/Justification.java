/*
 * Justification.java: provides a container of uBio Justification.
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

package org.ubio.model;

import java.io.Serializable;

import lombok.Data;

/**
 * {@code Justification} provides a container of uBio Justification.
 *
 * @version 	27 June 2016
 * @author 	Nozomi `James' Ytow
 */
@Data
public class Justification 
    implements Serializable
{
    private static final long serialVersionUID = 5241928924621778753L;

    protected String nameString;
    protected Citation citation;

    public Justification() {
	super();
    }

    public void setArticleAuthor(String aritcleAuthor)
    {
	if (citation != null)
	    citation = new Citation();
	citation.setAuthor(aritcleAuthor);
    }

    public String getArticleAuthor()
    {
	return citation == null? null : citation.getAuthor();
    }

    public void setArticlePublicationYear(int year)
    {
	if (citation != null)
	    citation = new Citation();
	citation.setPublicationYear(year);
    }

    public int getArticlePublicationYear()
    {
	return citation == null? -1 : citation.getPublicationYear();
    }

    public void setArticleTitle(String aritcleTitle)
    {
	if (citation != null)
	    citation = new Citation();
	citation.setArticleTitle(aritcleTitle);
    }

    public String getArticleTitle()
    {
	return citation == null? null : citation.getArticleTitle();
    }
}
