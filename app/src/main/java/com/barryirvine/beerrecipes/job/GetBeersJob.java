package com.barryirvine.beerrecipes.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.barryirvine.beerrecipes.api.BeersAPI;
import com.barryirvine.beerrecipes.interactors.BeerData;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

public class GetBeersJob extends Job {

    private BeerData mBeerData;

    public GetBeersJob(final BeersAPI beersAPI, final int priority) {
        super(new Params(priority).requireNetwork().persist());
    }

    @Override
    public void onAdded() {
        // Job has been saved to disk.
        // This is a good place to dispatch a UI event to indicate the job will eventually run.
        // In this example, it would be good to update the UI with the newly posted tweet.
    }

    @Override
    public void onRun() throws Throwable {
        // Job logic goes here. In this example, the network call to post to Twitter is done here.
        // All work done here should be synchronous, a job is removed from the queue once
        // onRun() finishes.
        mBeerData.getBeers();
    }

    @Override
    protected void onCancel(final int cancelReason, @Nullable final Throwable throwable) {
        // An error occurred in onRun.
        // Return value determines whether this job should retry or cancel. You can further
        // specify a backoff strategy or change the job's priority. You can also apply the
        // delay to the whole group to preserve jobs' running order.
        // Job has exceeded retry attempts or shouldReRunOnThrowable() has decided to cancel.
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull final Throwable throwable, final int runCount, final int maxRunCount) {
        return null;
    }
}
