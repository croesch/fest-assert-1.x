/*
 * Created on Feb 14, 2008
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
 * Copyright @2008-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ArrayFactory.booleanArray;
import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;

import org.junit.*;

/**
 * Tests for <code>{@link BooleanArrayAssert#containsOnly(boolean...)}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class BooleanArrayAssert_containsOnly_Test implements GroupAssert_containsOnly_TestCase {

  @Rule public ExpectedException thrown = none();

  private static boolean[] actual;
  private static boolean[] empty;

  @BeforeClass public static void setUpOnce() {
    actual = booleanArray(true, false);
    empty = new boolean[0];
  }

  private BooleanArrayAssert assertions;

  @Before public void setUp() {
    assertions = new BooleanArrayAssert(actual);
  }

  @Test public void should_pass_if_actual_contains_only_given_values() {
    assertions.containsOnly(true, false);
  }

  @Test public void should_pass_if_actual_contains_only_given_values_in_different_order() {
    assertions.containsOnly(false, true);
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new BooleanArrayAssert(null).containsOnly(true);
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new BooleanArrayAssert(null).as("A Test")
                                .containsOnly(true);
  }

  @Test public void should_throw_error_if_expected_is_null() {
    thrown.expectNullPointerException("The given array should not be null");
    assertions.containsOnly(null);
  }

  @Test public void should_throw_error_and_display_description_if_expected_is_null() {
    thrown.expectNullPointerException("[A Test] The given array should not be null");
    assertions.as("A Test")
              .containsOnly(null);
  }

  @Test public void should_fail_if_actual_is_empty_and_expecting_at_least_one_element() {
    thrown.expectAssertionError("<[]> does not contain element(s):<[false]>");
    new BooleanArrayAssert(empty).containsOnly(false);
  }

  @Test public void should_fail_and_display_description_if_actual_is_empty_and_expecting_at_least_one_element() {
    thrown.expectAssertionError("[A Test] <[]> does not contain element(s):<[false]>");
    new BooleanArrayAssert(empty).as("A Test")
                                 .containsOnly(false);
  }

  @Test public void should_fail_with_custom_message_if_actual_is_empty_and_expecting_at_least_one_element() {
    thrown.expectAssertionError("My custom message");
    new BooleanArrayAssert(empty).overridingErrorMessage("My custom message")
                                 .containsOnly(false);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_empty_and_expecting_at_least_one_element() {
    thrown.expectAssertionError("My custom message");
    new BooleanArrayAssert(empty).as("A Test")
                                 .overridingErrorMessage("My custom message")
                                 .containsOnly(false);
  }

  @Test public void should_fail_if_actual_contains_unexpected_values() {
    thrown.expectAssertionError("unexpected element(s):<[false]> in <[true, false]>");
    assertions.containsOnly(true);
  }

  @Test public void should_fail_and_display_description_if_actual_contains_unexpected_values() {
    thrown.expectAssertionError("[A Test] unexpected element(s):<[false]> in <[true, false]>");
    assertions.as("A Test")
              .containsOnly(true);
  }

  @Test public void should_fail_with_custom_message_if_actual_contains_unexpected_values() {
    thrown.expectAssertionError("My custom message");
    assertions.overridingErrorMessage("My custom message")
              .containsOnly(true);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_contains_unexpected_values() {
    thrown.expectAssertionError("My custom message");
    assertions.as("A Test")
              .overridingErrorMessage("My custom message")
              .containsOnly(true);
  }

  @Test public void should_fail_if_actual_does_not_contain_all_the_expected_values() {
    thrown.expectAssertionError("<[true]> does not contain element(s):<[false]>");
    new BooleanArrayAssert(true).containsOnly(false);
  }

  @Test public void should_fail_and_display_description_if_actual_does_not_contain_all_the_expected_values() {
    thrown.expectAssertionError("[A Test] <[true]> does not contain element(s):<[false]>");
    new BooleanArrayAssert(true).as("A Test")
                                .containsOnly(false);
  }

  @Test public void should_fail_with_custom_message_if_actual_does_not_contain_all_the_expected_values() {
    thrown.expectAssertionError("My custom message");
    new BooleanArrayAssert(true).overridingErrorMessage("My custom message")
                                .containsOnly(false);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_does_not_contain_all_the_expected_values() {
    thrown.expectAssertionError("My custom message");
    new BooleanArrayAssert(true).as("A Test")
                                .overridingErrorMessage("My custom message")
                                .containsOnly(false);
  }
}
