/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.curator.x.rpc.configuration;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.airlift.units.Duration;
import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.ExponentialBackoffRetry;
import java.util.concurrent.TimeUnit;

@JsonTypeName("exponential-backoff")
public class ExponentialBackoffRetryConfiguration extends RetryPolicyConfiguration
{
    private Duration baseSleepTime = new Duration(100, TimeUnit.MILLISECONDS);
    private int maxRetries = 3;

    @Override
    public RetryPolicy build()
    {
        return new ExponentialBackoffRetry((int)baseSleepTime.toMillis(), maxRetries);
    }

    public Duration getBaseSleepTime()
    {
        return baseSleepTime;
    }

    public void setBaseSleepTime(Duration baseSleepTime)
    {
        this.baseSleepTime = baseSleepTime;
    }

    public int getMaxRetries()
    {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries)
    {
        this.maxRetries = maxRetries;
    }
}
