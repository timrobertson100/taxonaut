/*
 * ComparisonQueryParameter.java: a calss to specify parameters of NameUsageExchanger
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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.nomencurator.model.NameUsage;
import org.nomencurator.model.Rank;

import lombok.Getter;
import lombok.Setter;


/**
 * {@code ComparisonQueryParameter} provides query parameter container.
 *
 * @version 	29 June 2016
 * @author 	Nozomi `James' Ytow
 */
public class ComparisonQueryParameter
    extends  GenericComparisonQueryParameter<NameUsage<?, ?>>
{
    public ComparisonQueryParameter() {
	super();
    }

    public ComparisonQueryParameter(int height, int depth,  Collection<? extends NameUsage<?, ?>> nameUsages) {
	super(height, depth, nameUsages);
    }

    public ComparisonQueryParameter(int height, int depth,  Collection<? extends NameUsage<?, ?>> nameUsages, boolean pivot) {
	super(height, depth, nameUsages, pivot);
    }

    public ComparisonQueryParameter(int height, int depth,  Collection<? extends NameUsage<?, ?>> nameUsages, boolean pivot, boolean append) {
	super(height, depth, nameUsages, pivot, append);
    }
}

/**
 * {@code ComparisonQueryParameter} provides query parameter container.
 *
 * @version 	10 Sep. 2015
 * @author 	Nozomi `James' Ytow
 */
/*public*/ class GenericComparisonQueryParameter <N extends NameUsage<?, ?>>
    extends NameUsageQueryParameter<N, N>
    implements Collection<N>
{
    @Getter
    @Setter
    /** List of NameUsages to compare */
    protected List<N> nameUsages;

    @Getter
    @Setter
    /** Determines to pivot or not in creation of <tt>NameTreeModel</tt> */
    protected boolean pivot;

    @Getter
    @Setter
    /** Determines to append to or to create a <tt>NameTreeModel</tt> */
    protected boolean append;

    /*public*/ protected GenericComparisonQueryParameter() {
	this(0, 0, null, false);
    }

    /*public*/ protected GenericComparisonQueryParameter(int height, int depth,  Collection<? extends N> nameUsages) {
	this(height, depth, nameUsages, false);
    }

    /*public*/ protected GenericComparisonQueryParameter(int height, int depth,  Collection<? extends N> nameUsages, boolean pivot) {
	this(height, depth, nameUsages, false, false);
    }

    /*public*/ protected GenericComparisonQueryParameter(int height, int depth,  Collection<? extends N> nameUsages, boolean pivot, boolean append) {
	super();
	setHeight(height);
	setDepth(depth);
	if(nameUsages == null || nameUsages.size() == 0)
	    this.nameUsages = new ArrayList<N>();
	else {
	    this.nameUsages = new ArrayList<N>(nameUsages.size());
	    this.nameUsages.addAll(nameUsages);
	}
	setPivot(pivot);
	setAppend(append);
    }

    @Override
    public boolean add(N nameUsage) {
	    if(!contains(nameUsage))
		return this.nameUsages.add(nameUsage);
	    return
		false;
    }

    @Override
    public boolean addAll(Collection<? extends N> nameUsages) {
	boolean result = false;
	for(N nameUsage : nameUsages) {
	    result |= add(nameUsage);
	}
	return result;
    }

    @Override
    public void clear() {
	this.nameUsages.clear();
    }

    @Override
    public boolean contains(Object object) {
	return this.nameUsages.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
	return this.nameUsages.containsAll(collection);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object object)
    {
	if(this == object) return true;
	if(object == null) return false;
	if(getClass() != object.getClass()) return false;

	GenericComparisonQueryParameter<N> that =
	    (GenericComparisonQueryParameter<N>) object;

	return super.equals(object)
	    && Objects.equals(this.nameUsages, that.nameUsages)
	    && Objects.equals(this.pivot, that.pivot);
    }

    @Override
    public int hashCode() {
	return Objects.hash(super.hashCode(),
			    this.nameUsages,
			    this.pivot
			    );
    }

    @Override
    public boolean isEmpty() {
	return this.nameUsages.isEmpty();
    }

    @Override
    public Iterator<N> iterator() {
	return this.nameUsages.iterator();
    }

    @Override
    public boolean remove(Object nameUsage) {
	return this.nameUsages.remove(nameUsage);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
	return this.nameUsages.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
	return this.nameUsages.retainAll(collection);
    }

    @Override
    public int size() {
	return this.nameUsages.size();
    }

    @Override
    public Object[] toArray() {
	return this.nameUsages.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
	return this.nameUsages.toArray(a);
    }
}
