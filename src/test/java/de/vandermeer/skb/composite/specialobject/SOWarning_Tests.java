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

import de.vandermeer.skb.base.message.EMessageType;
import de.vandermeer.skb.base.message.Message5WH;
import de.vandermeer.skb.composite.CompositeObject;
import de.vandermeer.skb.composite.SimpleObject;
import de.vandermeer.skb.composite.SpecialObject;
import de.vandermeer.skb.composite.SpecialObjectTypes;
import de.vandermeer.skb.composite.specialobject.SOWarning;

/**
 * Tests for SOWarning.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 150618 (18-Jun-15) for Java 1.8
 */
public class SOWarning_Tests {

	@Test public void testInit(){
		SOWarning warn=new SOWarning();

		assertTrue(warn instanceof SpecialObject);
		assertTrue(warn instanceof SimpleObject);
		assertTrue(warn instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.SO_WARNING, warn.getType());
		assertEquals(0, warn.size());
	}

	@Test public void testAdd(){
		SOWarning warn=new SOWarning();

		Message5WH m=new Message5WH();
		m.setType(EMessageType.ERROR);

		warn.add(m);
		assertEquals(EMessageType.WARNING, warn.getList().get(0).getType());	//type automatically changed to warning

		warn=new SOWarning(m);
		assertEquals(EMessageType.WARNING, warn.getList().get(0).getType());	//type automatically changed to warning

		m.setType(EMessageType.WARNING);
		warn=new SOWarning(m);
		assertEquals(EMessageType.WARNING, warn.getList().get(0).getType());	//type not changed

		assertEquals(1, warn.getList().size());		//size 1
		assertEquals(1, warn.size());				//size 1
		warn.add(m);
		assertEquals(2, warn.getList().size());		//size now 2
		assertEquals(2, warn.size());				//size now 2
	}
}
