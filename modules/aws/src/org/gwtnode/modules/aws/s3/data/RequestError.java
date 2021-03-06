/*
 * Copyright 2013 Maxim Dominichenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtnode.modules.aws.s3.data;

import org.gwtnode.modules.aws.core.Request;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * {@link Request} errors wrapper. 
 * 
 * @author <a href="mailto:max@dominichenko.com">Maxim Dominichenko</a>
 */
public class RequestError extends JavaScriptObject {
	
	public static RequestError create() {
		return JavaScriptObject.createObject().cast();
	} 

	public static RequestError create(String code, String message) {
		RequestError result = create();
		result.code(code);
		result.message(message);
		return result;
	}

	protected RequestError() {}
	
	public final native String code() /*-{
		return this.code;
	}-*/;
	
	public final native void code(String code) /*-{
		this.code = code;
	}-*/;

	public final native String message() /*-{
		return this.message;
	}-*/;
	
	public final native void message(String message) /*-{
		this.message = message;
	}-*/;
}
