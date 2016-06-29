/*
 * CollectionConstructor.java:  an interface to construct Collection
 *
 * Copyright (c) 2014, 2015 Nozomi `James' Ytow
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

package org.nomencurator.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;


/**
 * <tt>CollectionConstructor</tt> defines an interface to counstruct <tt>Collection</tt>
 *
 * @version 	16 July 2015
 * @author 	Nozomi `James' Ytow
 */
public interface CollectionConstructor<T>
{
    public Collection<T> constructCollection();

    public Collection<T> constructCollection(Collection<? extends T> collection);

    public Collection<T> constructCollection(int initialCapacity);

    public Collection<T> constructCollection(int initialCapacity, float loadFactor);

    public Collection<T> constructCollection(Comparator<? super T> comparator);

    public Collection<T> constructCollection(SortedSet<T> s);
}
