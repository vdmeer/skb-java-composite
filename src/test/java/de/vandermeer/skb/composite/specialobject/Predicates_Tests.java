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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.vandermeer.skb.base.utils.Skb_ClassUtils;
import de.vandermeer.skb.composite.SpecialObject;
import de.vandermeer.skb.composite.specialobject.SOError;
import de.vandermeer.skb.composite.specialobject.SOObject;
import de.vandermeer.skb.composite.specialobject.SOWarning;

/**
 * Tests for Predicates.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 150618 (18-Jun-15) for Java 1.8
 */
@RunWith(JUnit4.class)
public class Predicates_Tests {

	@Test public void testIsSubClassOf(){
		SOError serr=new SOError();
		SOWarning swarn=new SOWarning();
		assertFalse(Skb_ClassUtils.IS_SUBCLASS_OF(serr).test(swarn));
		assertTrue(Skb_ClassUtils.IS_SUBCLASS_OF(SpecialObject.class).test(serr));
		assertTrue(Skb_ClassUtils.IS_SUBCLASS_OF(SpecialObject.class).test(swarn));

		assertTrue(Skb_ClassUtils.IS_SUBCLASS_OF(SOObject.class).test(serr));
		assertTrue(Skb_ClassUtils.IS_SUBCLASS_OF(SOObject.class).test(swarn));
	}

	@Test public void testIsSuperClassOf(){
		SOError serr=new SOError();
		SOWarning swarn=new SOWarning();
		assertFalse(Skb_ClassUtils.IS_SUPERCLASS_OF(serr).test(swarn));
		assertTrue(Skb_ClassUtils.IS_SUPERCLASS_OF(serr).test(SpecialObject.class));
		assertTrue(Skb_ClassUtils.IS_SUPERCLASS_OF(swarn).test(SpecialObject.class));

		assertTrue(Skb_ClassUtils.IS_SUPERCLASS_OF(serr).test(SOObject.class));
		assertTrue(Skb_ClassUtils.IS_SUPERCLASS_OF(swarn).test(SOObject.class));
	}
}
