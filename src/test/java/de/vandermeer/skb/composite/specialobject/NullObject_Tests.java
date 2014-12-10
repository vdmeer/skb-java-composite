/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.skb.composite.specialobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.vandermeer.skb.composite.CompositeObject;
import de.vandermeer.skb.composite.SimpleObject;
import de.vandermeer.skb.composite.SpecialObject;
import de.vandermeer.skb.composite.SpecialObjectTypes;
import de.vandermeer.skb.composite.specialobject.NONode;
import de.vandermeer.skb.composite.specialobject.NONone;
import de.vandermeer.skb.composite.specialobject.NONull;
import de.vandermeer.skb.composite.specialobject.NOSuccess;

/**
 * Tests for Skb Type Defaults: Success, Node, None and Null.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 141210 (10-Dec-14) for Java 1.8
 */
public class NullObject_Tests {

	@Test public void testSuccess(){
		NOSuccess td1=NOSuccess.get;

		assertTrue(td1 instanceof SpecialObject);
		assertTrue(td1 instanceof SimpleObject);
		assertTrue(td1 instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.NO_SUCCESS, td1.getType());
		assertEquals("SpecialObject(NOSuccess): IsType(SpecialObjectTypes): NO_SUCCESS", td1.toString());

		NOSuccess td2=td1.getCopy();
		assertEquals(td1, td2);
	}

	@Test public void testNone(){
		NONone td1=NONone.get;

		assertTrue(td1 instanceof SpecialObject);
		assertTrue(td1 instanceof SimpleObject);
		assertTrue(td1 instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.NO_NONE, td1.getType());
		assertEquals("SpecialObject(NONone): IsType(SpecialObjectTypes): NO_NONE", td1.toString());

		NONone td2=td1.getCopy();
		assertEquals(td1, td2);
	}

	@Test public void testNode(){
		NONode td1=NONode.get;

		assertTrue(td1 instanceof SpecialObject);
		assertTrue(td1 instanceof SimpleObject);
		assertTrue(td1 instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.NO_NODE, td1.getType());
		assertEquals("SpecialObject(NONode): IsType(SpecialObjectTypes): NO_NODE", td1.toString());

		NONode td2=td1.getCopy();
		assertEquals(td1, td2);
	}

	@Test public void testNull(){
		NONull td1=NONull.get;

		assertTrue(td1 instanceof SpecialObject);
		assertTrue(td1 instanceof SimpleObject);
		assertTrue(td1 instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.NO_NULL, td1.getType());
		assertEquals("SpecialObject(NONull): IsType(SpecialObjectTypes): NO_NULL", td1.toString());

		NONull td2=td1.getCopy();
		assertEquals(td1, td2);
	}
}
