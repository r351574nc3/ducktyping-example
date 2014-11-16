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


/**
 * Service implementation for looking up {@link Organization} over ReST or JAX-WS
 *
 * @author Leo Przybylski
 */
public class OrganizationClient {

    public void run() {
        final OrganizationService orgService = (OrganizationService) 
            Proxy.newProxyInstance(OrganizationService.class.getClassLoader(),
                                   new Class[] { OrganizationService.class },
                                   new InvocationHandler() {
                                       public Object invoke(final Object proxy,
                                                            final Method method,
                                                            final Object[] args) throws Throwable {
                                           
                                           
                                       }
                                   }
                );

        final Organization org = (Organization) 
            Proxy.newProxyInstance(Organization.class.getClassLoader(),
                                   new Class[] { Organization.class },
                                   new InvocationHandler() {
                                       public Object invoke(final Object proxy,
                                                            final Method method,
                                                            final Object[] args) throws Throwable {
                                           
                                           
                                       }
                                   }
                );
    }   
}
