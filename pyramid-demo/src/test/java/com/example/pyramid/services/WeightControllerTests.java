/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.pyramid.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.pyramid.services.config.PropertyConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(PropertyConfig.class)
public class WeightControllerTests {
	
	private ObjectMapper mapper =new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRestOfPyramidEdgeWeight() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight/edge").param("level", "2")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testRestOfPyramidWeight() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "3").param("index", "2")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testJsonResponseOfPyramidEdgeWeight() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/pyramid/weight/edge").param("level", "2")).andReturn();
		String jsonResult = mvcResult.getResponse().getContentAsString();
		WeightResponse weightResponse = mapper.readValue(jsonResult, WeightResponse.class);
		validateWeightResponse(weightResponse, 37.5);

	}

	@Test
	public void testJsonResponseOfPyramidWeight() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/pyramid/weight").param("level", "5").param("index", "1"))
				.andReturn();
		String jsonResult = mvcResult.getResponse().getContentAsString();
		WeightResponse weightResponse = mapper.readValue(jsonResult, WeightResponse.class);
		validateWeightResponse(weightResponse, 135.9375);
	}

	private void validateWeightResponse(WeightResponse weightResponse, double d) {

		assertNotNull(weightResponse);
		assertEquals(d, weightResponse.getWeight(), 0.0);
		assertTrue(weightResponse.getId() > 0);
	}

	@Test
	public void testNegativeUrlIsInvalid() throws Exception {

		this.mockMvc.perform(get("")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void testWhenLevelAndIndexAreMissing() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight")).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenLevelIsValidAndIndexIsMissing() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "2")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenIndexIsValidAndLevelIsMissing() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("index", "0")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenLevelIsNotNumber() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "0a").param("index", "2")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenIndexIsNotNumber() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "1").param("index", "0a")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenLevelIsNegative() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "-1").param("index", "0")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenIndexIsNegative() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "0").param("index", "-1")).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenLevelisTooBig() throws Exception {

		this.mockMvc.perform(
				get("/pyramid/weight").param("level", Integer.toString(Integer.MAX_VALUE + 1)).param("index", "1"))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenIndexisTooBig() throws Exception {

		this.mockMvc.perform(
				get("/pyramid/weight").param("level", "5").param("index", Integer.toString(Integer.MAX_VALUE + 1)))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void testWhenIndexIsGreaterThanLevel() throws Exception {

		this.mockMvc.perform(get("/pyramid/weight").param("level", "2").param("index", "3")).andDo(print())
				.andExpect(status().isBadRequest());
	}

}
