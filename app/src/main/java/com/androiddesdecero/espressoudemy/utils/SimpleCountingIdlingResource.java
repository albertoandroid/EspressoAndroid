package com.androiddesdecero.espressoudemy.utils;

import java.util.concurrent.atomic.AtomicInteger;

import androidx.test.espresso.IdlingResource;

import static androidx.core.util.Preconditions.checkNotNull;

public class SimpleCountingIdlingResource implements IdlingResource {

    private final String resourceName;

    private final AtomicInteger counter = new AtomicInteger(0);

    private volatile ResourceCallback resourceCallback;

    public SimpleCountingIdlingResource(String resourceName) {
        this.resourceName = checkNotNull(resourceName);
    }

    @Override
    public String getName() {
        return resourceName;
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    public void increment() {
        counter.getAndIncrement();
    }

    public void decrement() {
        int counterVal = counter.decrementAndGet();
        if (counterVal == 0) {
            if (null != resourceCallback) {
                resourceCallback.onTransitionToIdle();
            }
        }

        if (counterVal < 0) {
            throw new IllegalArgumentException("Counter has been corrupted!");
        }
    }
}
