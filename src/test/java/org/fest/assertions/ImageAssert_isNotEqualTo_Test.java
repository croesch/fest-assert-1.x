/*
 * Created on Jun 9, 2007
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
 * Copyright @2007-2013 the original author or authors.
 */
package org.fest.assertions;

import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static java.awt.Color.BLUE;
import static org.fest.assertions.Images.*;

/**
 * Tests for {@link ImageAssert#isNotEqualTo(BufferedImage)}.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ImageAssert_isNotEqualTo_Test extends GenericAssert_isNotEqualTo_TestCase<ImageAssert, BufferedImage> {
  private static BufferedImage notNullValue;
  private static BufferedImage notEqualValue;

  @BeforeClass
  public static void setUpOnce() {
    notNullValue = fivePixelBlueImage();
    notEqualValue = image(3, 5, BLUE);
  }

  @Override
  protected ImageAssert assertionsFor(BufferedImage actual) {
    return new ImageAssert(actual);
  }

  @Override
  protected BufferedImage notNullValue() {
    return notNullValue;
  }

  @Override
  protected BufferedImage notEqualValue() {
    return notEqualValue;
  }

  @Test
  public void should_pass_if_other_is_null() {
    assertionsFor(notNullValue).isNotEqualTo(null);
  }

  @Test
  public void should_pass_if_other_has_equal_size_but_different_color() {
    assertionsFor(notNullValue).isNotEqualTo(fivePixelYellowImage());
  }

  @Test
  public void should_fail_if_images_have_equal_size_and_color() {
    BufferedImage other = fivePixelBlueImage();
    thrown.expect(AssertionError.class, "images are equal");
    assertionsFor(notNullValue).isNotEqualTo(other);
  }
}
