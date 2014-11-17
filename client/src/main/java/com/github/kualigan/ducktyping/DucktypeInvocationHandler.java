/**
 * Copyright 2005-2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kualigan.ducktyping;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.util.Map;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


/**
 * Simple {@link InvocationHandler} for {@link Proxy} around a {@link Map} so that instances coming from a ReST service can
 * ducktype.
 *
 * @author Leo Przybylski
 */
public class DucktypeInvocationHandler implements InvocationHandler {

    protected Object obj;

    public DucktypeInvocationHandler(final Object obj) {
        this.obj = obj;
    }
    

    @Override
    public Object invoke(final Object proxy,
                         final Method method,
                         final Object[] args) throws Throwable {
    
        final BeanInfo beanInfo = Introspector.getBeanInfo(method.getDeclaringClass());
        for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            final Object name = descriptor.getName();
            if (descriptor.getReadMethod().equals(method)) {
                // Do something to retrieve the property
                if (obj instanceof Map) {
                    return ((Map) obj).get(name);
                }
            }
            else if (descriptor.getWriteMethod().equals(method)) {                
                if (obj instanceof Map) {
                    ((Map) obj).put(name, args != null && args.length > 0 ? args[0] : null);
                }
            }
        }
        return null;
    }

}
