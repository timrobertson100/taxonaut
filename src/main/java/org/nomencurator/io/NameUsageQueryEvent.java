/*
 * NameUsageQueryEvent.java: Event encapsulating a query parater
 *
 * Copyright (c) 2006, 2014, 2016 Nozomi `James' Ytow
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

package org.nomencurator.io;

import java.util.Collection;
import java.util.EventObject;

import lombok.Getter;

import org.nomencurator.model.NameUsage;

/**
 * {@code NameUsageQueryEvent} provides an event to manage a query parameter.
 *
 * @version 	29 June 2016
 * @author 	Nozomi `James' Ytow
 */
public class NameUsageQueryEvent<N extends NameUsage<?, ?>, T extends N>
    extends QueryEvent<N, T>
{
    private static final long serialVersionUID = -9023331710074208932L;

    public NameUsageQueryEvent(Object source, NameUsageQueryParameter<N, T> queryParameter)
    {
	super(source, queryParameter);
    }


    public NameUsageQueryParameter<?, ?> getNameUsageQueryParameter()
    {
	return (NameUsageQueryParameter<?, ?>)getQueryParameter();
    }
}