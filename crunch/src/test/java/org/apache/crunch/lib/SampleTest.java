/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.crunch.lib;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import org.apache.crunch.impl.mem.MemPipeline;
import com.google.common.collect.ImmutableList;

public class SampleTest {
  @Test
  public void testSampler() {
	Iterable<Integer> sample = MemPipeline.collectionOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	    .sample(0.2, 123998).materialize();
	List<Integer> sampleValues = ImmutableList.copyOf(sample);
	assertEquals(ImmutableList.of(6, 7), sampleValues);
  }
}
