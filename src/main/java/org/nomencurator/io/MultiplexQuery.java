/*
 * MultiplexQuery.java
 *
 * Copyright (c) 2014, 2015, 2016 Nozomi `James' Ytow
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.nomencurator.model.NamedObject;

import lombok.Getter;

/**
 * {@code MultiplexQuery} implements {@code ObjectExchanger}.
 *
 * @version 	02 July 2016
 * @author 	Nozomi `James' Ytow
 */
public interface MultiplexQuery<T extends NamedObject<?>>
    extends QueryResultListener<T>, ObjectQuery<T>
{
    public boolean addQuery(ObjectQuery<T> query);

    public boolean removeQuery(ObjectQuery<T> query);
}
