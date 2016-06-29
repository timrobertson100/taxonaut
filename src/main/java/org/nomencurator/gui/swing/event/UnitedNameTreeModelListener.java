/*
 * UnitedNameTreeModelEvent.java:  an EventObject
 * telling addition or removal of a TreeModelto an 
 * UnitedNameTreeModel.
 *
 * Copyright (c) 2006, 2015 Nozomi `James' Ytow
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

package org.nomencurator.gui.swing.event;

import java.util.EventListener;

/**
 * <CODE>UnitedNameTreeModelEvent</code> is an <CODE>EventObject</CODE>
 * telling addition or removal of a <CODE>TreeModel</CODE> to an 
 * <CODE>UnitedNameTreeModel</CODE>.
 *
 * @version 	15 July 2015
 * @author 	Nozomi `James' Ytow
 */
public interface UnitedNameTreeModelListener
    extends EventListener
{
    public void treeAdded(UnitedNameTreeModelEvent event);
    public void treeRemoved(UnitedNameTreeModelEvent event);
    public void treeMoved(UnitedNameTreeModelEvent event);
}
