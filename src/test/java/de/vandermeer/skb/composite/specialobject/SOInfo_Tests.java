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
import de.vandermeer.skb.composite.specialobject.SOInfo;

/**
 * Tests for SOInfo.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 150618 (18-Jun-15) for Java 1.8
 */
public class SOInfo_Tests {

	@Test public void testInit(){
		SOInfo info=new SOInfo();

		assertTrue(info instanceof SpecialObject);
		assertTrue(info instanceof SimpleObject);
		assertTrue(info instanceof CompositeObject);

		assertEquals(SpecialObjectTypes.SO_INFO, info.getType());
		assertEquals(0, info.size());
	}

	@Test public void testAdd(){
		SOInfo info=new SOInfo();

		Message5WH m=new Message5WH();
		m.setType(EMessageType.ERROR);

		info.add(m);
		assertEquals(EMessageType.INFO, info.getList().get(0).getType());	//type automatically changed to warning

		info=new SOInfo(m);
		assertEquals(EMessageType.INFO, info.getList().get(0).getType());	//type automatically changed to warning

		m.setType(EMessageType.INFO);
		info=new SOInfo(m);
		assertEquals(EMessageType.INFO, info.getList().get(0).getType());	//type not changed

		assertEquals(1, info.getList().size());		//size 1
		assertEquals(1, info.size());				//size 1
		info.add(m);
		assertEquals(2, info.getList().size());		//size now 2
		assertEquals(2, info.size());				//size now 2
	}
}
