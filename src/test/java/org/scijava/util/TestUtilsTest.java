/*
 * #%L
 * SciJava Common shared library for SciJava software.
 * %%
 * Copyright (C) 2009 - 2014 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package org.scijava.util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.scijava.test.TestUtils;

/**
 * Tests the {@link TestUtilsTest}.
 * 
 * @author Johannes Schindelin
 */
public class TestUtilsTest {

	@Test
	public void testCreateTemporaryDirectory() throws IOException {
		final File tmp1 = TestUtils.createTemporaryDirectory("test-utils-test-");
		assertTrue("Not in target/: " + tmp1.getAbsolutePath(), tmp1
			.getAbsolutePath().contains("/target/"));
		final File tmp2 = TestUtils.createTemporaryDirectory("test-utils-test-");
		assertTrue(!tmp1.getAbsolutePath().equals(tmp2.getAbsolutePath()));

		final File tmp3 =
			TestUtils.createTemporaryDirectory("test-utils-test-", getClass());
		assertTrue("Not in target/: " + tmp3.getAbsolutePath(), tmp3
			.getAbsolutePath().contains("/target/"));
		final File tmp4 =
			TestUtils.createTemporaryDirectory("test-utils-test-", getClass());
		assertTrue(!tmp3.getAbsolutePath().equals(tmp4.getAbsolutePath()));

	}
}