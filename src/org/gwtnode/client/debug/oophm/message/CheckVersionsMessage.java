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
package org.gwtnode.client.debug.oophm.message;

import org.gwtnode.client.debug.oophm.OophmBufferBuilder;
import org.gwtnode.client.debug.oophm.OophmStream;
import org.gwtnode.client.node.buffer.Buffer;

/**
 * @author Chad Retz
 */
public class CheckVersionsMessage extends Message {

    private final int minVersion;
    private final int maxVersion;
    private final String hostedHtmlVersion;
    
    public CheckVersionsMessage(int minVersion, int maxVersion, 
            String hostedHtmlVersion) {
        super(MessageType.CHECK_VERSIONS);
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
        this.hostedHtmlVersion = hostedHtmlVersion;
        length = 8 + OophmStream.getStringByteLength(hostedHtmlVersion);
    }
    
    public CheckVersionsMessage(OophmStream stream) {
        super(MessageType.CHECK_VERSIONS);
        minVersion = stream.readInt();
        length += 4;
        maxVersion = stream.readInt();
        length += 4;
        hostedHtmlVersion = stream.readString();
        length += OophmStream.getStringByteLength(hostedHtmlVersion);
    }
    
    public int getMinVersion() {
        return minVersion;
    }
    
    public int getMaxVersion() {
        return maxVersion;
    }
    
    public String getHostedHtmlVersion() {
        return hostedHtmlVersion;
    }

    @Override
    public String toString() {
        return super.toString(new StringBuilder()).
                append("minVersion: ").
                append(minVersion).
                append(", maxVersion: ").
                append(maxVersion).
                append(", hostedHtmlVersion: ").
                append(hostedHtmlVersion).toString();
    }

    public Buffer toBuffer() {
        return new OophmBufferBuilder().
                append(type).
                append(minVersion).
                append(maxVersion).
                append(hostedHtmlVersion).toBuffer();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
                * result
                + ((hostedHtmlVersion == null) ? 0 : hostedHtmlVersion
                        .hashCode());
        result = prime * result + maxVersion;
        result = prime * result + minVersion;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CheckVersionsMessage other = (CheckVersionsMessage) obj;
        if (hostedHtmlVersion == null) {
            if (other.hostedHtmlVersion != null) {
                return false;
            }
        } else if (!hostedHtmlVersion.equals(other.hostedHtmlVersion)) {
            return false;
        }
        if (maxVersion != other.maxVersion) {
            return false;
        }
        if (minVersion != other.minVersion) {
            return false;
        }
        return true;
    }
}