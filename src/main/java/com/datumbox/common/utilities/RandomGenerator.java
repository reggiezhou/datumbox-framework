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
package com.datumbox.common.utilities;

import java.util.Random;

/**
 * The RandomGenerator generates Random objects that can be read and modified
 * by the same thread. The class can be configured with a globalSeed that is
 * used to initialize all the generated Random objects.
 * 
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 */
public class RandomGenerator {
    
    private static Long globalSeed;
    
    private static ThreadLocal<Random> threadLocalRandom;

    /**
     * Getter for the global seed. The global seed affects the initial seeding of
     * all the Random objects that are generated by this class.
     * 
     * @return 
     */
    public static Long getGlobalSeed() {
        return globalSeed;
    }
    
    /**
     * Setter for the global seed. The global seed affects the initial seeding of
     * all the Random objects that are generated by this class. Changing the global
     * seed does not affect the Random objects that have already been generated.
     * If you wish to change the seed of an already initialized Random object
     * use the setSeed() method of that object.
     * 
     * @param globalSeed 
     */
    public static void setGlobalSeed(Long globalSeed) {
        RandomGenerator.globalSeed = globalSeed;
    }
 
    /**
     * Returns a Random object which is stored as ThreadLocal variable and as
     * a result each Thread has an independent copy of this variable. When the
     * Random objects are initialized, they seeded with the global seed (if not 
     * null).
     * 
     * @return 
     */
    public synchronized static Random getThreadLocalRandom() {
        if(threadLocalRandom == null) {
            threadLocalRandom = new ThreadLocal<Random>() {
                @Override
                protected Random initialValue() {
                    if(globalSeed == null) {
                        return new Random();
                    }
                    else {
                        return new Random(globalSeed);
                    }
                }
            };
        }
        return threadLocalRandom.get();
    }
}
