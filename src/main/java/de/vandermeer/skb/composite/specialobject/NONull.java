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

import de.vandermeer.skb.base.Skb_ToStringStyle;
import de.vandermeer.skb.composite.SpecialObject;
import de.vandermeer.skb.composite.SpecialObjectTypes;

/**
 * Null object for null results.
 * This null object can be used to express that the result of a request is 'null', as is done in many SKB types.
 * It is build as an Enumerate, so that only one instantiation exists at runtime. This implies that
 * this type should only be used to express a 'null' result, but not to identify a specific 'null' result.
 * 
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4 build 150619 (19-Jun-15) for Java 1.8
 */
public enum NONull implements NullObject {
	/** The only instance for SkbTypeDefNull */
	get;

	@Override
	public SpecialObjectTypes getType() {
		return SpecialObjectTypes.NO_NULL;
	}

	@Override
	public NONull getCopy() {
		return this;
	}

	@Override
	public String toString() {
		return Skb_ToStringStyle.parentKV(SpecialObject.class, this.getClass(), this.getType()).toString();
	}
}
