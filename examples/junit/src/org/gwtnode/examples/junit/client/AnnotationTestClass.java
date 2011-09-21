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
package org.gwtnode.examples.junit.client;

import org.gwtnode.dev.junit.NodeJsTestRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(NodeJsTestRunner.class)
public class AnnotationTestClass extends AnnotationBaseTestClass {

    protected static boolean afterClassRan = false;
    protected static boolean afterRan = false;
    
    protected static boolean beforeClassRan = false;
    protected static boolean beforeRan = false;
    
    @BeforeClass
    public static void setupOnce() {
        beforeClassRan = true;
    }
    
    @AfterClass
    public static void teardownOnce() {
        afterClassRan = true;
    }
    
    @Before
    public void setup() {
        beforeRan = true;
    }
    
    @After
    public void teardown() {
        baseAfterRan = true;
    }
    
    @Test
    public void test() {
        Assert.assertTrue(baseBeforeClassRan);
        Assert.assertTrue(baseBeforeRan);
        Assert.assertTrue(beforeClassRan);
        Assert.assertTrue(beforeRan);
    }
}