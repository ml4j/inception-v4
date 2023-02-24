/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ml4j.nn.models.inceptionv4;

import java.io.IOException;

import org.ml4j.nn.FeedForwardNeuralNetworkContext;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.supervised.SupervisedFeedForwardNeuralNetwork;


/**
 * Interface for a factory for a Inception V4 Network
 * 
 * @author Michael Lavelle
 *
 */
public interface InceptionV4Factory {

	/**
	 * Create a new Inception V4 Network.
	 * 
	 * @param context The training or prediction context with which to construct
	 *                this network. This method may perform additional
	 *                configurations of this config during execution.
	 * @param regularisationLambda The regularisation used in the final dense layer.
	 * @param dropoutKeepProbability The input dropout keep probability used in the final dense layer.       
	 * @return An inception V4 Network
	 * @throws IOException In the event that the network cannot be loaded
	 */
	SupervisedFeedForwardNeuralNetwork createInceptionV4(FeedForwardNeuralNetworkContext context, float regularisationLambda, float dropoutKeepProbability) throws IOException;
	
	/**
	 * Create a new Inception V4 Network.
	 * 
	 * @param context The training or prediction context with which to construct
	 *                this network. This method may perform additional
	 *                configurations of this config during execution.
	 * @return An inception V4 Network
	 * @throws IOException In the event that the network cannot be loaded
	 */
	SupervisedFeedForwardNeuralNetwork createInceptionV4(FeedForwardNeuralNetworkContext context) throws IOException;
	
	/**
	 * Create a new Inception V4 Network with a custom tail
	 * 
	 * @param context The training or prediction context with which to construct
	 *                this network. This method may perform additional
	 *                configurations of this config during execution.
	 * @param outputFeatures The number of output features of the tail.
	 * @param weights The dense weights
	 * @param biases The dense biases
	 * @param regularisationLambda The regularisation used in the final dense layer.
	 * @param dropoutKeepProbability The input dropout keep probability used in the final dense layer. 
	 * @return An inception V4 Network
	 * @throws IOException In the event that the network cannot be loaded
	 */
	SupervisedFeedForwardNeuralNetwork createInceptionV4WithCustomTail(FeedForwardNeuralNetworkContext context, int outputFeatures, WeightsMatrix weights, BiasVector biases,
			float regularisationLambda, float dropoutKeepProbability) throws IOException;
	
	
	/**
	 * Create a custom tail of the Inception V4 Network, with custom output neuron count, weights and biases
	 * 
	 * @param context The training or prediction context with which to construct
	 *                this network. This method may perform additional
	 *                configurations of this config during execution.
	 * @param outputNeuronsCount The number of output neurons of this custom tail
	 * @param weights The dense weights
	 * @param biases The dense biases
	 * @param regularisationLambda The regularisation used in the final dense layer.
	 * @param dropoutKeepProbability The input dropout keep probability used in the final dense layer. 
	 * @return An inception V4 Network
	 * @throws IOException In the event that the network cannot be loaded
	 */
	SupervisedFeedForwardNeuralNetwork createInceptionV4Tail(FeedForwardNeuralNetworkContext context, int outputNeuronCount, WeightsMatrix weights, BiasVector biases,
			float regularisationLambda, float dropoutKeepProbability) throws IOException;
	
	
	/**
	 * Create a new Inception V4 Network, without the tail component.
	 * 
	 * @param context The training or prediction context with which to construct
	 *                this network. This method may perform additional
	 *                configurations of this config during execution.
	 * @return An inception V4 Network
	 * @throws IOException In the event that the network cannot be loaded
	 */
	SupervisedFeedForwardNeuralNetwork createInceptionV4WithoutTail(FeedForwardNeuralNetworkContext context) throws IOException;


	/**
	 * @return The labels for the InceptionV4 instances generated by this factory.
	 * @throws IOException In the event that the labels cannot be loaded
	 */
	InceptionV4Labels createInceptionV4Labels() throws IOException;
}