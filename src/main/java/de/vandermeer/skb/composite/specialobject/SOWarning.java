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

import java.util.List;

import de.vandermeer.skb.base.message.EMessageType;
import de.vandermeer.skb.base.message.Message5WH;
import de.vandermeer.skb.composite.SpecialObjectTypes;

/**
 * Special object for a warnings.
 * This special object can carry a list of warning messages. It allows a class or method to return or maintain detailed
 * descriptions about things that potentially went wrong, as compared to a boolean return or a single warning message or a thrown exception.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 150618 (18-Jun-15) for Java 1.8
 */
public final class SOWarning extends SOObject {
	/**
	 * Creates a new DefaultWarning w/o any warning messages.
	 */
	public SOWarning(){
		super();
	}

	/**
	 * Creates a new DefaultWarning with a list of warning messages.
	 * @param list warning list for initialisation
	 */
	public SOWarning(List<Message5WH> list){
		super(list);
	}

	/**
	 * Creates a new DefaultWarning with a single warning.
	 * @param warn warning for initialisation
	 */
	public SOWarning(Message5WH warn){
		super(warn);
	}

	/**
	 * Adds a single warning message.
	 * @param add warning to be added, null is ignored
	 * @return this to allow concatenation
	 */
	@Override
	public SOWarning add(Message5WH add){
		if(add!=null){
			super.add(add.setType(EMessageType.WARNING));
		}
		return this;
	}

	/**
	 * Adds another warning.
	 * @param add warning to be added, null is ignored
	 * @return this to allow concatenation
	 */
	public SOWarning add(SOWarning add){
		if(add!=null){
			this.msglist.addAll(add.msglist);
		}
		return this;
	}

	@Override
	public SpecialObjectTypes getType(){
		return SpecialObjectTypes.SO_WARNING;
	}

	@Override
	public SOWarning getCopy() {
		return new SOWarning(this.msglist);
	}
}
