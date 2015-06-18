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
 * Special object for information.
 * This special object can carry a list of info messages. It allows a class or method to return or maintain detailed
 * descriptions about things that have been noticeable, as compared to a boolean return or a single info message or a thrown exception.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 150618 (18-Jun-15) for Java 1.8
 */
public final class SOInfo extends SOObject {
	/**
	 * Creates a new DefaultInfo w/o any information messages.
	 */
	public SOInfo(){
		super();
	}

	/**
	 * Creates a new DefaultInfo with a list of information.
	 * @param list info list
	 */
	public SOInfo(List<Message5WH> list){
		super(list);
	}

	/**
	 * Creates a new DefaultInfo with a single information.
	 * @param info info for initialisation
	 */
	public SOInfo(Message5WH info){
		super(info);
	}

	/**
	 * Adds a single info to the information list.
	 * @param add error to be added, null is ignored
	 * @return this to allow concatenation
	 */
	@Override
	public SOInfo add(Message5WH add){
		if(add!=null){
			super.add(add.setType(EMessageType.INFO));
		}
		return this;
	}

	/**
	 * Adds another information.
	 * @param add info to be added, null is ignored
	 * @return this to allow concatenation
	 */
	public SOInfo add(SOInfo add){
		if(add!=null){
			this.msglist.addAll(add.msglist);
		}
		return this;
	}

	@Override
	public SpecialObjectTypes getType(){
		return SpecialObjectTypes.SO_INFO;
	}

	@Override
	public SOInfo getCopy() {
		return new SOInfo(this.msglist);
	}
}
