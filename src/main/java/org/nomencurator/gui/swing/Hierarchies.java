/*
 * Hierarchies.java:  a class provaides table to compare hierarchies
 * using Nomencurator.
 *
 * Copyright (c) 2003, 2006, 2014, 2015, 2016 Nozomi `James' Ytow
 * All rights reserved.
 */

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nomencurator.gui.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.nomencurator.io.ObjectExchanger;
import org.nomencurator.io.QueryResultEvent;
import org.nomencurator.io.QueryResultListener;
import org.nomencurator.io.MultiplexNameUsageQuery;

import org.nomencurator.io.ubio.UBio;

import org.nomencurator.model.NameUsage;

import org.nomencurator.resources.ResourceKey;

import org.nomencurator.gui.swing.table.NameTreeTableMode;
import org.nomencurator.gui.swing.table.NameTreeTableModel;

import org.nomencurator.gui.swing.tree.NameTreeModel;
import org.nomencurator.gui.swing.tree.UnitedNameTreeModel;

/**
 * {@code Hierarchies} provides a table to compare
 * hierarchies using Nomencuartor.
 *
 * @version 	29 June 2016
 * @author 	Nozomi `James' Ytow
 */
public class Hierarchies<N extends NameUsage<?, ?>>
    extends JApplet
    implements ChangeListener,
	       QueryResultListener<N, N>,
	       Runnable
{
    private static final long serialVersionUID = 4656853135577095323L;

    protected MenuBar menu;

    protected LanguageMenu languageMenu;

    /** Panel to display components for query */
    protected QueryPanel<N, N> query;

    /** Panel to show two tables representing hierarchies */
    protected HierarchiesPane<N> views;

    protected NameTreeTable<N>[] tables;

    protected UnitedNameTreeModel unitedTreeModel;

    public Hierarchies()
    {
	this(new UnitedNameTreeModel());
    }

    public Hierarchies(UnitedNameTreeModel model)
    {
	this(model, Locale.getDefault());
    }

    /**
     * Creates a <CODE>Hierarchies</CODE>
     * using VM default locale
     */
    public Hierarchies(Locale locale)
    {
	this(new UnitedNameTreeModel(), locale);
    }

    /**
     * Creates a <CODE>Hierarchies</CODE>
     * using VM default locale
     */
    public Hierarchies(UnitedNameTreeModel model, Locale locale)
    {
	super();
	setJMenuBar(createMenuBar());
	createComponents(model);
	layoutComponents();
	setComponentsSize();
	setLocale(locale);
	//query.setQueryManager(model);
    }

    protected JMenuBar createMenuBar()
    {
	menu = new MenuBar();
	languageMenu = menu.getLanguageMenu();
	languageMenu.addChangeListener(this);
	return menu;
    }

    /**
     * Create <CODE>Components</CODE>
     * of specified locale
     *
     * @param locale <CODE>Locale</CODE> to determine texts in labels and buttons
     */
    protected void createComponents(UnitedNameTreeModel model)
    {
	query = new QueryPanel<N, N>();
	views = new HierarchiesPane<N>(model);
	//FIXME 20141201
	//query.setQueryManager(table.getAlignerTree());
    }

    /** Layout <CODE>Components</CODE> */
    protected void layoutComponents()
    {
	getContentPane().setLayout(new BorderLayout());

	getContentPane().add(query, BorderLayout.NORTH);
	getContentPane().add(views, BorderLayout.CENTER);
    }

    /** Set size of <CODE>Components</CODE> */
    protected void setComponentsSize()
    {
    }

    public QueryPanel<N, N> getQueryPanel()
    {
	return query;
    }

    public HierarchiesPane<N> getHierarchiesPane()
    {
	return views;
    }

    public UnitedNameTreeModel getUnitedNameTreeModel()
    {
	return unitedTreeModel;
    }

    /**
     * Adds <CODE>table</CDODE> to <CODE>nameTab</CODE>
     * with tab <CODE>rank</CODE>
     *
     * @param rank name of rank as <CODE>String</CODE>
     * @param table 
     */
    public void addTab(String rank, Component table)
    {
	views.addTab(rank, table);
    }

    public void remove(Component table)
    {
	views.remove(table);
    }

    /**
     * Localizes components according to specified locale.
     *
     * @param locale <CODE>Locale</CODE> to be used for localization
     */
    public void setLocale(Locale locale)
    {
	/*
	if(query == null) {
	    super.setLocale(locale);
	    return;
	}

	if(locale == null)
	    locale = Locale.getDefault();
	if(locale.equals(getLocale()))
	   return;
	*/
	super.setLocale(locale);

	if(query == null)
	    return;
	menu.setLocale(locale);
	query.setLocale(locale);
	views.setLocale(locale);
	menu.revalidate();
    }

    public void stateChanged(ChangeEvent event)
    {
	if(event.getSource() != languageMenu)
	    return;
	setLocale(languageMenu.getLocale());
    }

    protected List<MultiplexNameUsageQuery<N, N>> threads = null;

    public void add(MultiplexNameUsageQuery<N, N> thread)
    {
	if(thread == null)
	    return;

	if(threads == null)
	    threads = new ArrayList<MultiplexNameUsageQuery<N, N>>();
	thread.addQueryResultListener(this);
	threads.add(thread);
    }

    public void remove(MultiplexNameUsageQuery<N, N> thread)
    {
	if(thread == null)
	    return;

	if(threads != null)
	    threads.remove(thread);
	thread.removeQueryResultListener(this);
	if(threads.isEmpty())
	    threads = null;
    }

    public void run()
    {
	/*
	if(threads == null ||
	   threads.size() == 0)
	    return;
	synchronized (threads) {
	    for(Thread query : threads) {
		if(query.getState() == Thread.State.NEW)
		    query.start();
	    }
	}
	*/
    }


    public synchronized void queryReturned(QueryResultEvent<N, N> event)
    {
	Collection<N> nodes = event.getResults();
	if(nodes == null)
	    return;
	Iterator<N> iterator = nodes.iterator();
	N node = iterator.next();
	NameTreeModel model = new NameTreeModel(node);
	model.setViewName(node.getViewName());

	unitedTreeModel.add(model);
	//threads.remove(event.getThread());
	/*
	for(NameTreeTable table : nameTreeTables) {
	    ((NameTreeTableModel)table.getModel()).getUnitedNameTreeModel().add(model);
	}
	*/
	//revalidate();
    }

}