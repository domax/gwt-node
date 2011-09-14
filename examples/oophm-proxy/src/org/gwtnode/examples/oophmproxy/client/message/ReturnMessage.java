/*
 * Copyright 2011 Chad Retz
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
package org.gwtnode.examples.oophmproxy.client.message;

/**
 * @author Chad Retz
 */
public class ReturnMessage extends Message {

    private final boolean exception;
    private final Value<?> returnValue;
    
    public ReturnMessage(MessageType type, BufferStream stream) {
        super(type);
        exception = stream.readBoolean();
        length += 1;
        returnValue = stream.readValue();
    }
    
    public boolean isException() {
        return exception;
    }
    
    public Value<?> getReturnValue() {
        return returnValue;
    }
    
    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("exception: ").
                append(exception).
                append(", returnValue: ").
                append(returnValue).toString();
    }

}
