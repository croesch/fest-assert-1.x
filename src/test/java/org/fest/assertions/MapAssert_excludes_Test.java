/*
 * Created on Jan 24, 2008
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

import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;
import static org.fest.assertions.MapAssert.entry;
import static org.fest.assertions.MapFactory.map;

import java.util.Map;

import org.fest.assertions.MapAssert.Entry;
import org.junit.*;

/**
 * Tests for <code>{@link MapAssert#excludes(Entry...)}</code>.
 *
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class MapAssert_excludes_Test {

  @Rule public ExpectedException thrown = none();

  private static Map<Object, Object> map;

  @BeforeClass public static void setUpOnce() {
    map = map(entry("key1", 1), entry("key2", 2));
  }

  @Test public void should_pass_if_actual_excludes_entries() {
    new MapAssert(map).excludes(entry("key6", 6), entry("key8", 8));
  }

  @Test public void should_throw_error_if_entry_is_null() {
    thrown.expectNullPointerException("Entries to check should not contain null");
    Entry[] entries = { entry("key6", 6), null };
    new MapAssert(map).excludes(entries);
  }

  @Test public void should_throw_error_and_display_description_if_entry_is_null() {
    thrown.expectNullPointerException("[A Test] Entries to check should not contain null");
    Entry[] entries = { entry("key6", 6), null };
    new MapAssert(map).as("A Test")
                      .excludes(entries);
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new MapAssert(null).excludes(entry("key6", 6));
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new MapAssert(null).as("A Test")
                       .excludes(entry("key6", 6));
  }

  @Test public void should_throw_error_if_expected_is_null() {
    thrown.expectNullPointerException("The given array of entries should not be null");
    Entry[] entry = null;
    new MapAssert(map).excludes(entry);
  }

  @Test public void should_throw_error_and_display_description_if_expected_is_null() {
    thrown.expectNullPointerException("[A Test] The given array of entries should not be null");
    Entry[] entry = null;
    new MapAssert(map).as("A Test")
                      .excludes(entry);
  }

  @Test public void should_fail_if_actual_contains_entry() {
    thrown.expectAssertionError("the map:<{'key1'=1, 'key2'=2}> contains the entry:<['key2'=2]>");
    new MapAssert(map).excludes(entry("key2", 2));
  }

  @Test public void should_fail_and_display_description_if_actual_contains_entry() {
    String message = "[A Test] the map:<{'key1'=1, 'key2'=2}> contains the entry:<['key2'=2]>";
    thrown.expectAssertionError(message);
    new MapAssert(map).as("A Test")
                      .excludes(entry("key2", 2));
  }

  @Test public void should_fail_with_custom_message_if_actual_contains_entry() {
    thrown.expectAssertionError("My custom message");
    new MapAssert(map).overridingErrorMessage("My custom message")
                      .excludes(entry("key2", 2));
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_contains_entry() {
    thrown.expectAssertionError("My custom message");
    new MapAssert(map).as("A Test")
                      .overridingErrorMessage("My custom message")
                      .excludes(entry("key2", 2));
  }

  @Test public void should_fail_if_actual_contains_entries() {
    String message = "the map:<{'key1'=1, 'key2'=2}> contains the entries:<['key1'=1, 'key2'=2]>";
    thrown.expectAssertionError(message);
    new MapAssert(map).excludes(entry("key1", 1), entry("key2", 2));
  }

  @Test public void should_fail_and_display_description_if_actual_contains_entries() {
    String message = "[A Test] the map:<{'key1'=1, 'key2'=2}> contains the entries:<['key1'=1, 'key2'=2]>";
    thrown.expectAssertionError(message);
    new MapAssert(map).as("A Test")
                      .excludes(entry("key1", 1), entry("key2", 2));
  }

  @Test public void should_fail_with_custom_message_if_actual_contains_entries() {
    thrown.expectAssertionError("My custom message");
    new MapAssert(map).overridingErrorMessage("My custom message")
                      .excludes(entry("key1", 1), entry("key2", 2));
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_contains_entries() {
    thrown.expectAssertionError("My custom message");
    new MapAssert(map).as("A Test")
                      .overridingErrorMessage("My custom message")
                      .excludes(entry("key1", 1), entry("key2", 2));
  }
}
