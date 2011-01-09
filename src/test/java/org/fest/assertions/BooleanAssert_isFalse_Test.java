/*
 * Created on Mar 19, 2007
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

import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link BooleanAssert#isFalse()}</code>.
 *
 * @author Alex Ruiz
 * @author David DIDIER
 */
public class BooleanAssert_isFalse_Test {

  @Rule public ExpectedException thrown = none();

  @Test public void should_pass_if_actual_is_false() {
    new BooleanAssert(false).isFalse();
  }

  @Test public void should_fail_if_actual_is_true() {
    thrown.expectAssertionError("expected:<[fals]e> but was:<[tru]e>");
    new BooleanAssert(true).isFalse();
  }

  @Test public void should_fail_and_display_description_if_actual_is_true() {
    thrown.expectAssertionError("[A Test] expected:<[fals]e> but was:<[tru]e>");
    new BooleanAssert(true).as("A Test")
                           .isFalse();
  }

  @Test public void should_fail_with_custom_message_if_actual_is_true() {
    thrown.expectAssertionError("My custom message");
    new BooleanAssert(true).overridingErrorMessage("My custom message")
                           .isFalse();
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_true() {
    thrown.expectAssertionError("My custom message");
    new BooleanAssert(true).as("A Test")
                           .overridingErrorMessage("My custom message")
                           .isFalse();
  }
}
