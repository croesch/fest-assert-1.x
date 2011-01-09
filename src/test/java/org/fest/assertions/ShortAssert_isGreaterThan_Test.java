/*
 * Created on Jun 18, 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2007-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ExpectedException.none;

import org.junit.*;

/**
 * Tests for <code>{@link ShortAssert#isGreaterThan(short)}</code>.
 *
 * @author Yvonne Wang
 * @author David DIDIER
 * @author Alex Ruiz
 */
public class ShortAssert_isGreaterThan_Test implements Assert_isGreaterThan_TestCase {

  @Rule public ExpectedException thrown = none();

  private static short actual;
  private static short greaterThanActual;

  @BeforeClass public static void setUpOnce() {
    actual = 6;
    greaterThanActual = 8;
  }

  @Test public void should_pass_if_actual_is_greater_than_expected() {
    new ShortAssert(actual).isGreaterThan((short)2);
  }

  @Test public void should_fail_if_actual_is_equal_to_expected() {
    thrown.expectAssertionError("actual value:<6> should be greater than:<6>");
    new ShortAssert(actual).isGreaterThan(actual);
  }

  @Test public void should_fail_and_display_description_if_actual_is_equal_to_expected() {
    thrown.expectAssertionError("[A Test] actual value:<6> should be greater than:<6>");
    new ShortAssert(actual).as("A Test")
                           .isGreaterThan(actual);
  }

  @Test public void should_fail_with_custom_message_if_actual_is_equal_to_expected() {
    thrown.expectAssertionError("My custom message");
    new ShortAssert(actual).overridingErrorMessage("My custom message")
                           .isGreaterThan(actual);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_equal_to_expected() {
    thrown.expectAssertionError("My custom message");
    new ShortAssert(actual).as("A Test")
                           .overridingErrorMessage("My custom message")
                           .isGreaterThan(actual);
  }

  @Test public void should_fail_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("actual value:<6> should be greater than:<8>");
    new ShortAssert(actual).isGreaterThan(greaterThanActual);
  }

  @Test public void should_fail_and_display_description_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("[A Test] actual value:<6> should be greater than:<8>");
    new ShortAssert(actual).as("A Test")
                           .isGreaterThan(greaterThanActual);
  }

  @Test public void should_fail_with_custom_message_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("My custom message");
    new ShortAssert(actual).overridingErrorMessage("My custom message")
                           .isGreaterThan(greaterThanActual);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("My custom message");
    new ShortAssert(actual).as("A Test")
                           .overridingErrorMessage("My custom message")
                           .isGreaterThan(greaterThanActual);
  }
}
