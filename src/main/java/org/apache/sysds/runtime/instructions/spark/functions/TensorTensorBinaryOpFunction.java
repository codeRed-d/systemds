/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysds.runtime.instructions.spark.functions;

import org.apache.spark.api.java.function.Function;
import org.apache.sysds.runtime.data.TensorBlock;
import org.apache.sysds.runtime.matrix.operators.BinaryOperator;
import scala.Tuple2;

public class TensorTensorBinaryOpFunction implements Function<Tuple2<TensorBlock,TensorBlock>, TensorBlock>
{
	private static final long serialVersionUID = 4204525225937988112L;

	private BinaryOperator _bop;

	public TensorTensorBinaryOpFunction(BinaryOperator op) {
		_bop = op;
	}

	@Override
	public TensorBlock call(Tuple2<TensorBlock, TensorBlock> arg0) throws Exception {
		return arg0._1().binaryOperations(_bop, arg0._2(), null);
	}
}