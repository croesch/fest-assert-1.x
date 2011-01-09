/*
 * Created on Jul 1, 2010
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
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ArrayFactory.objectArray;
import static org.fest.assertions.ExpectedException.none;

import org.junit.*;

/**
 * Base class for testing implementations of <code>{@link ObjectGroupAssert#isNullOrEmpty()}</code>.
 * @param <S> used to simulate "self types." For more information please read &quot;<a
 * href="http://passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation"
 * target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>.&quot;
 * @param <A> The type supported by the implementation of the {@code ObjectGroupAssert} to test.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public abstract class ObjectGroupAssert_isNullOrEmpty_TestCase<S extends ObjectGroupAssert<S, A>, A> extends
    ObjectGroupAssert_TestCase<S, A> implements GroupAssert_isNullOrEmpty_TestCase {

  @Rule public ExpectedException thrown = none();

  private static Object[] actualValues;
  private static Object[] emptyValues;

  @BeforeClass public static void setUpOnce() {
    actualValues = objectArray(8);
    emptyValues = new Object[0];
  }

  private A actual;
  private GroupAssert<S, A> assertions;

  @Before public final void setUp() {
    actual = actualFrom(actualValues);
    assertions = assertionsFor(actual);
  }

  @Test public final void should_pass_if_actual_is_null() {
    assertionsFor(null).isNullOrEmpty();
  }

  @Test public final void should_pass_if_actual_is_empty() {
    assertionsFor(actualFrom(emptyValues)).isNullOrEmpty();
  }

  @Test public final void should_fail_if_actual_has_content() {
    thrown.expectAssertionError("expecting null or empty, but was:<[8]>");
    assertions.isNullOrEmpty();
  }

  @Test public final void should_fail_and_display_description_if_actual_has_content() {
    thrown.expectAssertionError("[A Test] expecting null or empty, but was:<[8]>");
    assertions.as("A Test")
              .isNullOrEmpty();
  }

  @Test public final void should_fail_with_custom_message_if_actual_has_content() {
    thrown.expectAssertionError("My custom message");
    assertions.overridingErrorMessage("My custom message")
              .isNullOrEmpty();
  }

  @Test public final void should_fail_with_custom_message_ignoring_description_if_actual_has_content() {
    thrown.expectAssertionError("My custom message");
    assertions.as("A Test")
              .overridingErrorMessage("My custom message")
              .isNullOrEmpty();
  }
}