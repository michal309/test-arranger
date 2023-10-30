/*
 * Copyright © 2020 Ocado (marian.jureczko@ocado.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocadotechnology.gembus.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.ocadotechnology.gembus.test.Arranger.some;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrangerTestEnumSet {

    @Test
    @DisplayName("SHOULD not try to initialize file WHEN an override is delivered")
    void skipEnumSet() {
        //when
        Map<String, Supplier<?>> overrides = new HashMap<String, Supplier<?>>(){{
            put("enumeration", () -> null);
        }};
        ClassWithEnumSetField some = some(ClassWithEnumSetField.class, overrides);

        //then
        assertThat(some.txt).isNotBlank();
        assertThat(some.enumeration).isNull();
    }
}

class ClassWithEnumSetField {
    String txt;
    EnumSet<SomeEnum> enumeration;
}

enum SomeEnum {
    ONE,
    TWO,
    THREE
}