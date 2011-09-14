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
public class Value<T> {

    private final ValueType type;
    private final T value;
    private final int length;
    
    Value(ValueType type, T value, int length) {
        this.type = type;
        this.value = value;
        this.length = length;
    }
    
    public ValueType getType() {
        return type;
    }
    
    public T getValue() {
        return value;
    }
    
    public int getLength() {
        return length;
    }
    
    @Override
    public String toString() {
        return type + "(" + value + ")";
    }
}
