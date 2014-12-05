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
 * Special object for errors.
 * This special object can carry a list of error messages. It allows a class or method to return or maintain detailed
 * descriptions about things that went wrong, as compared to a boolean return or a single error message or a thrown exception.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 140626 (26-Jun-14) with Java 1.8
 */
public final class SOError extends SOObject {

	/**
	 * Creates a new Error w/o any error messages.
	 */
	public SOError(){
		super();
	}

	/**
	 * Creates a new Error with a list of errors.
	 * @param list error list
	 */
	public SOError(List<Message5WH> list){
		super(list);
	}

	/**
	 * Creates a newError with a single error.
	 * @param err error for initialisation
	 */
	public SOError(Message5WH err){
		super(err);
	}

	/**
	 * Adds a single error to the error list.
	 * @param add error to be added, null is ignored
	 * @return this to allow concatenation
	 */
	@Override
	public SOError add(Message5WH add){
		if(add!=null){
			super.add(add.setType(EMessageType.ERROR));
		}
		return this;
	}

	/**
	 * Adds another error.
	 * @param add error to be added, null is ignored
	 * @return this to allow concatenation
	 */
	public SOError add(SOError add){
		if(add!=null){
			this.msglist.addAll(add.msglist);
		}
		return this;
	}

	@Override
	public SpecialObjectTypes getType(){
		return SpecialObjectTypes.SO_ERROR;
	}

	@Override
	public SOError getCopy() {
		return new SOError(this.msglist);
	}
}
