/**
 * Copyright (C) 2013-2015 Vasilis Vryniotis <bbriniotis@datumbox.com>
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
package com.datumbox.framework.mathematics.distances;

import com.datumbox.common.dataobjects.AssociativeArray;
import com.datumbox.configuration.TestConfiguration;
import com.datumbox.tests.bases.BaseTest;
import com.datumbox.tests.utilities.TestUtils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 */
public class DistanceTest extends BaseTest {
    
    private Map<Object, Object> getMap1() {
        Map<Object, Object> map = new HashMap<>();
        map.put(0, 1.0);
        map.put(1, "cat1");
        map.put(2, true);
        map.put(3, (short)7);
        map.put(4, "same");
        
        return map;
    }
    
    private Map<Object, Object> getMap2() {
        Map<Object, Object> map = new HashMap<>();
        map.put(0, 3.0);
        map.put(1, "cat2");
        map.put(2, false);
        map.put(3, (short)3);
        map.put(4, "same");
        
        return map;
    }
    
    private Map<Object, Double> getWeights() {
        Map<Object, Double> weights = new HashMap<>();
        weights.put(0, 0.5);
        weights.put(1, 1.0);
        weights.put(2, 2.0);
        weights.put(3, 1.0);
        weights.put(4, 0.0);
        
        return weights;
    }
    
    /**
     * Test of euclidean method, of class Distance.
     */
    @Test
    public void testEuclidean() {
        TestUtils.log(this.getClass(), "euclidean");
        AssociativeArray a1 = new AssociativeArray(getMap1());
        AssociativeArray a2 = new AssociativeArray(getMap2());
        double expResult = 2.6457513110645905905016157536393;
        double result = Distance.euclidean(a1, a2);
        assertEquals(expResult, result, TestConfiguration.DOUBLE_ACCURACY_HIGH);
    }

    /**
     * Test of euclideanWeighhted method, of class Distance.
     */
    @Test
    public void testEuclideanWeighhted() {
        TestUtils.log(this.getClass(), "euclideanWeighhted");
        AssociativeArray a1 = new AssociativeArray(getMap1());
        AssociativeArray a2 = new AssociativeArray(getMap2());
        Map<Object, Double> columnWeights = getWeights();
        double expResult = 2.449489742783178;
        double result = Distance.euclideanWeighhted(a1, a2, columnWeights);
        assertEquals(expResult, result, TestConfiguration.DOUBLE_ACCURACY_HIGH);
    }

    /**
     * Test of manhattan method, of class Distance.
     */
    @Test
    public void testManhattan() {
        TestUtils.log(this.getClass(), "manhattan");
        AssociativeArray a1 = new AssociativeArray(getMap1());
        AssociativeArray a2 = new AssociativeArray(getMap2());
        double expResult = 5.0;
        double result = Distance.manhattan(a1, a2);
        assertEquals(expResult, result, TestConfiguration.DOUBLE_ACCURACY_HIGH);
    }

    /**
     * Test of manhattanWeighhted method, of class Distance.
     */
    @Test
    public void testManhattanWeighhted() {
        TestUtils.log(this.getClass(), "manhattanWeighhted");
        AssociativeArray a1 = new AssociativeArray(getMap1());
        AssociativeArray a2 = new AssociativeArray(getMap2());
        Map<Object, Double> columnWeights = getWeights();
        double expResult = 5.0;
        double result = Distance.manhattanWeighhted(a1, a2, columnWeights);
        assertEquals(expResult, result, TestConfiguration.DOUBLE_ACCURACY_HIGH);
    }

    /**
     * Test of maximum method, of class Distance.
     */
    @Test
    public void testMaximum() {
        TestUtils.log(this.getClass(), "maximum");
        AssociativeArray a1 = new AssociativeArray(getMap1());
        AssociativeArray a2 = new AssociativeArray(getMap2());
        double expResult = 2.0;
        double result = Distance.maximum(a1, a2);
        assertEquals(expResult, result, TestConfiguration.DOUBLE_ACCURACY_HIGH);
    }
    
}
