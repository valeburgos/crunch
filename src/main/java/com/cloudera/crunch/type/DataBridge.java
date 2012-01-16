/**
 * Copyright (c) 2011, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */
package com.cloudera.crunch.type;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.cloudera.crunch.MapFn;

/**
 * Data structures for transitioning to the DoFns that make up a Crunch MapReduce task 
 * from the raw serialization input from the Hadoop MapReduce framework and back again.
 *
 */
public class DataBridge {
  private final Converter converter;
  private final Class<?> keyClass;
  private final Class<?> valueClass;
  private final MapFn inputMapFn;
  private final MapFn outputMapFn;
  
  public DataBridge(Class<?> keyClass, Class<?> valueClass,
      Converter converter, MapFn inputMapFn, MapFn outputMapFn) {
    this.keyClass = keyClass;
    this.valueClass = valueClass;
    this.converter = converter;
    this.inputMapFn = inputMapFn;
    this.outputMapFn = outputMapFn;
  }
  
  public Converter getConverter() {
    return converter;
  }

  public MapFn getInputMapFn() {
    return inputMapFn;
  }
  
  public MapFn getOutputMapFn() {
    return outputMapFn;
  }

  /*
  public Class<?> getKeyClass() {
    return keyClass;
  }
  
  public Class<?> getValueClass() {
    return valueClass;
  }
  */
  
  @Override
  public boolean equals(Object obj) {
	if (obj == null || !(obj instanceof DataBridge)) {
	  return false;
	}
	DataBridge that = (DataBridge) obj;
	return (keyClass.equals(that.keyClass) && valueClass.equals(that.valueClass) &&
		converter.equals(that.converter) && inputMapFn.equals(that.inputMapFn) &&
		outputMapFn.equals(that.outputMapFn));
  }
  
  @Override
  public int hashCode() {
	HashCodeBuilder hcb = new HashCodeBuilder();
	hcb.append(keyClass).append(valueClass).append(converter).append(inputMapFn);
	return hcb.append(outputMapFn).toHashCode();
  }
}
